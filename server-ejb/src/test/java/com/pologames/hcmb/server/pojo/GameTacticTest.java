package com.pologames.hcmb.server.pojo;

import com.pologames.hcmb.server.entity.Gamer;
import com.pologames.hcmb.server.entity.PlayerCard;
import com.pologames.hcmb.server.entity.Tactic;
import com.pologames.hcmb.server.entity.TimeTactic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTacticTest {
    private static final Logger LOG = LoggerFactory.getLogger(GameTacticTest.class);

    private Gamer first;
    private Gamer second;

    @Test
    public void initEqualsGamers() {
        first = initGamer(90, 90);
        first.setTactic(initTactic1());
        second = initGamer(70, 90);
        second.setTactic(initTactic2());
    }

    @Test(dependsOnMethods = "initEqualsGamers")
    public void equalsGameTest() {
        LOG.info("First Game");

        LOG.info("OVR {} vs OVR {}",
                first.getPlayerCards().stream().mapToInt(PlayerCard::getOvr).average().orElse(0),
                second.getPlayerCards().stream().mapToInt(PlayerCard::getOvr).average().orElse(0));
        final GameResult result = GameUnits.calcGame(first, second);
        LOG.info("OVR {} {} : {} OVR {}",
                first.getPlayerCards().stream().mapToInt(PlayerCard::getOvr).average().orElse(0),
                result.getT1Coals(), result.getT2Coals(),
                second.getPlayerCards().stream().mapToInt(PlayerCard::getOvr).average().orElse(0));
        Assert.assertEquals(result.getWinner(), 1);
    }

    @Test(dependsOnMethods = "equalsGameTest")
    public void initOtherGamers() {
        first = initGamer(90, 20);
        first.setTactic(initTactic1());
        second = initGamer(90, 90);
        second.setTactic(initTactic2());
    }

    @Test(dependsOnMethods = "initOtherGamers")
    public void equalsOtherTest() {
        LOG.info("\nSecond Game");
        LOG.info("OVR {} vs OVR {}",
                first.getPlayerCards().stream().mapToInt(PlayerCard::getOvr).average().orElse(0),
                second.getPlayerCards().stream().mapToInt(PlayerCard::getOvr).average().orElse(0));
        final GameResult result = GameUnits.calcGame(first, second);
        LOG.info("OVR {} {} : {} OVR {}",
                first.getPlayerCards().stream().mapToInt(PlayerCard::getOvr).average().orElse(0),
                result.getT1Coals(), result.getT2Coals(),
                second.getPlayerCards().stream().mapToInt(PlayerCard::getOvr).average().orElse(0));
        Assert.assertEquals(result.getWinner(), 2);
    }



    private Gamer initGamer(int ovr, int endurance) {
        final Gamer gamer = new Gamer();
        final List<PositionEnum> positions = new ArrayList<>(Arrays.asList(PositionEnum.values()));
        positions.add(PositionEnum.D);

        final List<UnitEnum> units = Arrays.asList(UnitEnum.FIRST, UnitEnum.SECOND, UnitEnum.THIRD);

        for (UnitEnum unit: units) {
            for (PositionEnum position : positions) {
                final PlayerCard card = PlayerCardUtils.createPlayerCard(gamer, PlayerUtils.createRandom(position, ovr - 10, ovr + 10));
                card.setUnit(unit);
                card.setEndurance(endurance);
                gamer.getPlayerCards().add(card);
            }
        }
        return gamer;
    }

    private Tactic initTactic1() {
        final Tactic tactic = new Tactic();
        tactic.getTimeTacticList().addAll(Arrays.asList(
                new TimeTactic(UnitEnum.FIRST, 0, 30),
                new TimeTactic(UnitEnum.SECOND, 30, 60),
                new TimeTactic(UnitEnum.THIRD, 60, 90)
        ));
        return tactic;
    }

    private Tactic initTactic2() {
        final Tactic tactic = new Tactic();
        tactic.getTimeTacticList().addAll(Arrays.asList(
                new TimeTactic(UnitEnum.FIRST, 0, 10),
                new TimeTactic(UnitEnum.SECOND, 10, 20),
                new TimeTactic(UnitEnum.THIRD, 20, 30)
                ,
                new TimeTactic(UnitEnum.FIRST, 30, 40),
                new TimeTactic(UnitEnum.SECOND, 40, 50),
                new TimeTactic(UnitEnum.THIRD, 50, 60),

                new TimeTactic(UnitEnum.FIRST, 60, 70),
                new TimeTactic(UnitEnum.SECOND, 70, 80),
                new TimeTactic(UnitEnum.THIRD, 80, 90)
        ));
        return tactic;
    }
}
