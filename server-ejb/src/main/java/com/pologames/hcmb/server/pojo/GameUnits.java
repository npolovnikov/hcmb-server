package com.pologames.hcmb.server.pojo;

import com.pologames.hcmb.server.entity.Gamer;
import com.pologames.hcmb.server.entity.PlayerBase;
import com.pologames.hcmb.server.entity.PlayerCard;
import com.pologames.hcmb.server.entity.TimeTactic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class GameUnits {
    private static final Logger LOG = LoggerFactory.getLogger(GameUnits.class);

    public static GameResult calcGame(Gamer first, Gamer second) {
        final GameResult result = new GameResult();

        for (int startTime = 0; startTime < 90; startTime+=10) {
            final TimeTactic firstTactic = first.getTactic().getTimeTacticByStartTime(startTime);
            final List<PlayerCard> firstList = first.getPlayerCardsByUnit(firstTactic.getUnit());

            final TimeTactic secondTactic = second.getTactic().getTimeTacticByStartTime(startTime);
            final List<PlayerCard> secondList = second.getPlayerCardsByUnit(secondTactic.getUnit());

//            LOG.info("{}, {}", firstTactic.getUnit(), secondTactic.getUnit());
//            LOG.info("{}, {}",
//                    firstList.stream().mapToInt(PlayerCard::getOvr).average().orElse(0),
//                    secondList.stream().mapToInt(PlayerCard::getOvr).average().orElse(0));
            final GameResult timeResult = calcGame(firstList, secondList, 10);
//            LOG.info("first {} vs Second {}. Time from {} to {}", timeResult.getT1Coals(), timeResult.getT2Coals(), startTime, startTime + 10);
            result.calculate(timeResult);
        }

        return result;
    }

    /**
     * Расчет противостояния состава 1 и состава 2, в течение некоторого времени
     * @param team1 Состав Хозяев
     * @param team2 Состав Гостей
     * @param time Время уделенное на их противостояние (90, 30, 15, 5 минут)
     * @return Результат их игры
     */
    public static GameResult calcGame(List<PlayerCard> team1, List<PlayerCard> team2, int time) {
        final double t1DefOvr = getAvr(team1, playerCard -> !playerCard.getPlayer().getPosition().isAttack());
        final double t1AttOvr = getAvr(team1, playerCard -> playerCard.getPlayer().getPosition().isAttack());

        final double t2DefOvr = getAvr(team2, playerCard -> !playerCard.getPlayer().getPosition().isAttack());
        final double t2AttOvr = getAvr(team2, playerCard -> playerCard.getPlayer().getPosition().isAttack());

        final int t1Goals = getGoals(t1AttOvr, t2DefOvr, time);
        final int t2Goals = getGoals(t2AttOvr, t1DefOvr, time);

        //Усталость после игры
        team1.forEach(pc -> pc.addFatigue(time));
        team2.forEach(pc -> pc.addFatigue(time));
        return new GameResult(t1Goals, t2Goals);
    }

    /**
     * Колличество голов, которые могут забить
     * @param attAvr ОВР атакующей команды
     * @param defAvr ОВР защищающей команды
     * @param time Время на их игру
     * @return количество забитых голов
     */
    private static int getGoals(double attAvr, double defAvr, int time) {
        final double goals = ((attAvr * getChance() - defAvr * getChance()) / getTimeScore(time));
        return goals < 0 ? 0 : (int) goals;
    }

    /**
     * Чем меньше времени на протиовстояние, тем сильнее должны отличаться составы по ОВР, для забития гола
     * @param time Время отведенное на их игру
     * @return Необходимая разница ОВР для гола
     */
    private static int getTimeScore(int time) {
        return 100 / time;
    }

    /**
     * Любая игра связана с везением.
     * @return Множитель для ОВР от 0,9 до 1,1
     */
    private static double getChance() {
        return new Random().nextDouble() * 0.2 + 0.9;
    }

    /**
     * Расчет среднего ОВР состава
     * @param team состав
     * @param filter условие, для фильтра состава
     * @return средний ОВР
     */
    private static double getAvr(List<PlayerCard> team, Predicate<PlayerCard> filter) {
        return team.stream()
                .filter(filter)
                .mapToInt(PlayerBase::getOvr)
                .average().orElse(0D);
    }

}
