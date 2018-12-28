package com.pologames.hcmb.server.pojo;

import com.pologames.hcmb.server.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlayerUtilsTest {
    private final static Logger LOG = LoggerFactory.getLogger(PlayerUtilsTest.class);

    @Test
    public void createRandomGTest() {
        for (int j = 0; j < 5; j++) {
            LOG.info("j = {}", j);
            for (int i = 40; i < 100; i += 10) {
                final int max = i + 10;

                final Player playerG = PlayerUtils.createRandomG(i, max);
                LOG.info("min = {}, max = {}, Player.OVR = {}", i, max, playerG.getOvr());
                assertTrue(playerG.getOvr() >= i, playerG.toString());
                assertTrue(playerG.getOvr() <= max, playerG.toString());
            }
        }
    }

    @Test
    public void createRandomDTest() {
        for (int j = 0; j < 5; j++) {
            LOG.info("j = {}", j);
            for (int i = 40; i < 100; i += 10) {
                final int max = i + 10;

                final Player playerD = PlayerUtils.createRandomD(i, max);
                LOG.info("min = {}, max = {}, Player.OVR = {}", i, max, playerD.getOvr());
                assertTrue(playerD.getOvr() >= i, playerD.toString());
                assertTrue(playerD.getOvr() <= max, playerD.toString());
            }
        }
    }

    @Test
    public void createRandomCTest() {
        for (int j = 0; j < 5; j++) {
            LOG.info("j = {}", j);
            for (int i = 40; i < 100; i += 10) {
                final int max = i + 10;

                final Player playerC = PlayerUtils.createRandomC(i, max);
                LOG.info("min = {}, max = {}, Player.OVR = {}", i, max, playerC.getOvr());
                assertTrue(playerC.getOvr() >= i, playerC.toString());
                assertTrue(playerC.getOvr() <= max, playerC.toString());
            }
        }
    }
}