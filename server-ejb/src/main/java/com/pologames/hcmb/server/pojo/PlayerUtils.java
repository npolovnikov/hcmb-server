package com.pologames.hcmb.server.pojo;

import com.pologames.hcmb.server.entity.Player;
import com.pologames.hcmb.server.entity.PlayerBase;

import java.util.Random;

public class PlayerUtils {

    public static int ovr(PlayerBase playerBase, PositionEnum positionEnum) {
        switch (positionEnum) {
            case G: return ovrG(playerBase);
            case D: return ovrD(playerBase);
            case L:
            case R:
            case C: return ovrС(playerBase);
        }
        return 0;
    }

    /**
     * Генерация рандомного вратаря
     * @param minOvr минимальный оvr
     * @param maxOvr максимальный оvr
     * @return
     */
    public static Player createRandomG(int minOvr, int maxOvr) {
        final Player playerG = new Player();
        playerG.setPosition(PositionEnum.G);
        playerG.setTalent(randomInt(0, 10));

        //Главное для вратаря
        playerG.setAgility(randomInt(minOvr - 5, maxOvr + 5));
        playerG.setEndurance(randomInt(minOvr - 5, maxOvr + 5));

        playerG.setAngles(randomInt(minOvr - 5, maxOvr + 5));
        playerG.setBreakaway(randomInt(minOvr - 5, maxOvr + 5));
        playerG.setGlove(randomInt(minOvr - 5, maxOvr + 5));
        playerG.setStick(randomInt(minOvr - 5, maxOvr + 5));

        playerG.setReboundControl(randomInt(minOvr - 5, maxOvr + 5));
        playerG.setRecover(randomInt(minOvr - 5, maxOvr + 5));
        playerG.setPokeCkech(randomInt(minOvr - 5, maxOvr + 5));

        //Второстепенное
        playerG.setBalance(randomInt(minOvr - 15, maxOvr + 15));
        playerG.setSpeed(randomInt(minOvr - 15, maxOvr + 15));

        playerG.setDiscipline(randomInt(minOvr - 15, maxOvr + 15));
        playerG.setOffAwareness(randomInt(minOvr - 15, maxOvr + 15));
        playerG.setPoise(randomInt(minOvr - 15, maxOvr + 15));

        playerG.setAggressiveness(randomInt(minOvr - 15, maxOvr + 15));
        playerG.setBodyChecking(randomInt(minOvr - 15, maxOvr + 15));
        playerG.setDurability(randomInt(minOvr - 15, maxOvr + 15));
        playerG.setFightingSkill(randomInt(minOvr - 15, maxOvr + 15));
        playerG.setStrength(randomInt(minOvr - 15, maxOvr + 15));

        playerG.setHandEye(randomInt(minOvr - 15, maxOvr + 15));
        playerG.setPassing(randomInt(minOvr - 15, maxOvr + 15));
        playerG.setPuckControl(randomInt(minOvr - 15, maxOvr + 15));

        //Ненужное для вратаря
        playerG.setStapShotAccuracy(randomInt(0, 70));
        playerG.setStapShotPower(randomInt(0, 70));
        playerG.setWristShotAccuracy(randomInt(0, 70));
        playerG.setWristShotPower(randomInt(0, 70));

        playerG.setAcceleration(randomInt(0, 70));

        playerG.setDefAwareness(randomInt(0, 70));
        playerG.setFaceOff(randomInt(0, 70));
        playerG.setShotBlocking(randomInt(0, 70));
        playerG.setStickChecking(randomInt(0, 70));
        return playerG;
    }

    /**
     * Генерация рандомного защитника
     * @param minOvr
     * @param maxOvr
     * @return
     */
    public static Player createRandomD(int minOvr, int maxOvr) {
        final Player playerD = new Player();
        playerD.setPosition(PositionEnum.D);
        playerD.setTalent(randomInt(0, 10));

        //Главное для защитника
        playerD.setAcceleration(randomInt(minOvr - 5, maxOvr + 5));
        playerD.setAgility(randomInt(minOvr - 5, maxOvr + 5));
        playerD.setBalance(randomInt(minOvr - 5, maxOvr + 5));
        playerD.setEndurance(randomInt(minOvr - 5, maxOvr + 5));
        playerD.setSpeed(randomInt(minOvr - 5, maxOvr + 5));

        playerD.setDefAwareness(randomInt(minOvr - 5, maxOvr + 5));
        playerD.setFaceOff(randomInt(minOvr - 5, maxOvr + 5));
        playerD.setShotBlocking(randomInt(minOvr - 5, maxOvr + 5));
        playerD.setStickChecking(randomInt(minOvr - 5, maxOvr + 5));

        //Второстепенное для защитника
        playerD.setStapShotAccuracy(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setStapShotPower(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setWristShotAccuracy(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setWristShotPower(randomInt(minOvr - 15, maxOvr + 15));

        playerD.setDiscipline(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setOffAwareness(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setPoise(randomInt(minOvr - 15, maxOvr + 15));

        playerD.setAggressiveness(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setBodyChecking(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setDurability(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setFightingSkill(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setStrength(randomInt(minOvr - 15, maxOvr + 15));

        playerD.setHandEye(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setPassing(randomInt(minOvr - 15, maxOvr + 15));
        playerD.setPuckControl(randomInt(minOvr - 15, maxOvr + 15));

        //Ненужное для защитника
        playerD.setAngles(randomInt(0, 70));
        playerD.setBreakaway(randomInt(0, 70));
        playerD.setGlove(randomInt(0, 70));
        playerD.setStick(randomInt(0, 70));

        playerD.setReboundControl(randomInt(0, 70));
        playerD.setRecover(randomInt(0, 70));
        playerD.setPokeCkech(randomInt(0, 70));

        return playerD;
    }

    /**
     * Генерация рандомного правого вингера
     * @param minOvr
     * @param maxOvr
     * @return
     */
    public static  Player createRandomR(int minOvr, int maxOvr) {
        final Player playerR = createRandomC(minOvr, maxOvr);
        playerR.setPosition(PositionEnum.R);
        return playerR;
    }

    /**
     * Генерация рандомного левого вингера
     * @param minOvr
     * @param maxOvr
     * @return
     */
    public static  Player createRandomL(int minOvr, int maxOvr) {
        final Player playerL = createRandomC(minOvr, maxOvr);
        playerL.setPosition(PositionEnum.L);
        return playerL;
    }

    /**
     * Генерация рандомного центр форварда
     * @param minOvr
     * @param maxOvr
     * @return
     */
    public static Player createRandomC(int minOvr, int maxOvr) {
        final Player playerC = new Player();
        playerC.setPosition(PositionEnum.C);
        playerC.setTalent(randomInt(0, 10));

        //Главное для напа
        playerC.setStapShotAccuracy(randomInt(minOvr - 5, maxOvr + 5));
        playerC.setStapShotPower(randomInt(minOvr - 5, maxOvr + 5));
        playerC.setWristShotAccuracy(randomInt(minOvr - 5, maxOvr + 5));
        playerC.setWristShotPower(randomInt(minOvr - 5, maxOvr + 5));

        playerC.setAcceleration(randomInt(minOvr - 5, maxOvr + 5));
        playerC.setAgility(randomInt(minOvr - 5, maxOvr + 5));
        playerC.setBalance(randomInt(minOvr - 5, maxOvr + 5));
        playerC.setEndurance(randomInt(minOvr - 5, maxOvr + 5));
        playerC.setSpeed(randomInt(minOvr - 5, maxOvr + 5));

        //Второстепенное для напа
        playerC.setDiscipline(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setOffAwareness(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setPoise(randomInt(minOvr - 15, maxOvr + 15));

        playerC.setDefAwareness(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setFaceOff(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setShotBlocking(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setStickChecking(randomInt(minOvr - 15, maxOvr + 15));

        playerC.setAggressiveness(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setBodyChecking(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setDurability(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setFightingSkill(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setStrength(randomInt(minOvr - 15, maxOvr + 15));

        playerC.setHandEye(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setPassing(randomInt(minOvr - 15, maxOvr + 15));
        playerC.setPuckControl(randomInt(minOvr - 15, maxOvr + 15));

        //Ненужное для Напа
        playerC.setAngles(randomInt(0, 70));
        playerC.setBreakaway(randomInt(0, 70));
        playerC.setGlove(randomInt(0, 70));
        playerC.setStick(randomInt(0, 70));

        playerC.setReboundControl(randomInt(0, 70));
        playerC.setRecover(randomInt(0, 70));
        playerC.setPokeCkech(randomInt(0, 70));

        return playerC;
    }

    private static int randomInt(int minOvr, int maxOvr) {
        return new Random().nextInt(maxOvr - minOvr) + minOvr;
    }

    private static int ovrG(PlayerBase player) {
        int sum_1 = player.getAgility() + player.getEndurance() + player.getAngles() + player.getBreakaway()
                + player.getGlove() + player.getStick() + player.getReboundControl() + player.getRecover() + player.getPokeCkech();
        sum_1 *= 1.1;

        int sum_2 = player.getBalance() + player.getSpeed() + player.getDiscipline() + player.getOffAwareness() + player.getPoise()
                + player.getAggressiveness() + player.getBodyChecking() + player.getDurability() + player.getFightingSkill() + player.getStrength()
                + player.getHandEye() + player.getPassing() + player.getPuckControl();
        sum_2 *= 0.9;

        return ((sum_1 / 9) + (sum_2 / 13)) / 2;
    }

    private static int ovrD(PlayerBase player) {
        int sum_1 = player.getAcceleration() + player.getAgility() + player.getBalance() + player.getEndurance() + player.getSpeed()
                + player.getDefAwareness() + player.getFaceOff() + player.getShotBlocking() + player.getStickChecking();
        sum_1 *= 1.1;

        int sum_2 = player.getStapShotAccuracy() + player.getStapShotPower() + player.getWristShotAccuracy() + player.getWristShotPower()
                + player.getDiscipline() + player.getOffAwareness() + player.getPoise() + player.getAggressiveness()
                + player.getBodyChecking() + player.getDurability() + player.getFightingSkill() + player.getStrength()
                + player.getHandEye() + player.getPassing() + player.getPuckControl();
        sum_2 *= 0.9;

        return ((sum_1 / 9) + (sum_2 / 15)) / 2;
    }

    private static int ovrС(PlayerBase player) {
        int sum_1 = player.getStapShotAccuracy() + player.getStapShotPower() + player.getWristShotAccuracy() + player.getWristShotPower()
                + player.getAcceleration() + player.getAgility() + player.getBalance() + player.getEndurance() + player.getSpeed();
        sum_1 *= 1.1;

        int sum_2 = player.getDefAwareness() + player.getFaceOff() + player.getShotBlocking() + player.getStickChecking() +
                + player.getDiscipline() + player.getOffAwareness() + player.getPoise() + player.getAggressiveness()
                + player.getBodyChecking() + player.getDurability() + player.getFightingSkill() + player.getStrength()
                + player.getHandEye() + player.getPassing() + player.getPuckControl();
        sum_2 *= 0.9;

        return ((sum_1 / 9) + (sum_2 / 15)) / 2;
    }
}
