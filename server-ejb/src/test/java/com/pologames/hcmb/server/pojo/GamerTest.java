package com.pologames.hcmb.server.pojo;

import com.pologames.hcmb.server.entity.Gamer;
import com.pologames.hcmb.server.entity.PlayerCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class GamerTest {
    private static final Logger LOG = LoggerFactory.getLogger(GamerTest.class);


    private Gamer gamer;

    @Test
    public void createGamerTest() {
        gamer = new Gamer();

        gamer.setNickname("Tast Gamer");
        for (UnitEnum unit: UnitEnum.values()) {
            List<PositionEnum> positions = new ArrayList<>(Arrays.asList(PositionEnum.values()));
            positions.add(PositionEnum.D);
            for (PositionEnum position: positions) {
                final PlayerCard card = PlayerCardUtils.createPlayerCard(gamer, PlayerUtils.createRandom(position, 50, 100));
                card.setUnit(unit);
                gamer.getPlayerCards().add(card);
            }

            LOG.info("Unit {}, PlayersCard={}", unit, gamer.getPlayerCardsByUnit(unit).stream()
                    .map(cp -> cp.getPlayer().getPosition() + " "+ cp.getOvr()).collect(Collectors.joining(", ")));
            Assert.assertEquals(gamer.getPlayerCardsByUnit(unit).size(), 6);
        }
    }

    @Test(dependsOnMethods = "createGamerTest")
    public void calcGameTest() {
        LOG.info("GAMETAB " + Arrays.stream(UnitEnum.values())
                .map(unitEnum -> String.format("%1$7s", unitEnum.toString()))
                .collect(Collectors.joining("|")));
        for (UnitEnum preview: UnitEnum.values()) {
            final StringBuilder resultStr = new StringBuilder();
            resultStr.append(String.format("%1$7s", preview));
            resultStr.append("|");

            for (UnitEnum unit: UnitEnum.values()) {
                if (unit == preview){
                    resultStr.append(String.format("%1$8s", "X|"));
                } else {
                    final GameResult result = GameUnits.calcGame(gamer.getPlayerCardsByUnit(preview), gamer.getPlayerCardsByUnit(unit));
                    resultStr.append(String.format("%1$7s|", result.getT1Coals() + " - " + result.getT2Coals()));
                }
            }

            LOG.info(resultStr.toString());
        }
    }
}
