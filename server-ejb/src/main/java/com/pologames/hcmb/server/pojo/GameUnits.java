package com.pologames.hcmb.server.pojo;

import com.pologames.hcmb.server.entity.PlayerBase;
import com.pologames.hcmb.server.entity.PlayerCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;

public class GameUnits {
    private static final Logger LOG = LoggerFactory.getLogger(GameUnits.class);

    public static GameResult calcGame(List<PlayerCard> team1, List<PlayerCard> team2){
        final double t1DefOvr = getAvr(team1, playerCard -> !playerCard.getPlayer().getPosition().isAttack());
        final double t1AttOvr = getAvr(team1, playerCard -> playerCard.getPlayer().getPosition().isAttack());

        final double t2DefOvr = getAvr(team2, playerCard -> !playerCard.getPlayer().getPosition().isAttack());
        final double t2AttOvr = getAvr(team2, playerCard -> playerCard.getPlayer().getPosition().isAttack());

        LOG.debug("t1AttOvr = {}, t2DefOvr = {}", (int) t1AttOvr, (int) t2DefOvr);
        final int t1Goals = (int) (t1AttOvr - t2DefOvr) / 3;

        LOG.debug("t2AttOvr = {}, t1DefOvr = {}", (int) t2AttOvr, (int) t1DefOvr);
        final int t2Goals = (int) (t2AttOvr - t1DefOvr) / 3;

        return new GameResult(t1Goals, t2Goals);
    }

    private static double getAvr(List<PlayerCard> team, Predicate<PlayerCard> filter) {
        return team.stream()
                .filter(filter)
                .mapToInt(PlayerBase::getOvr)
                .average().orElse(0D);
    }

}
