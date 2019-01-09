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
            case C: return ovrC(playerBase);
        }
        return 0;
    }

    public static Player createRandom(PositionEnum position, int minOvr, int maxOvr) {
        switch (position){
            case C: return createRandomC(minOvr, maxOvr);
            case D: return createRandomD(minOvr, maxOvr);
            case G: return createRandomG(minOvr, maxOvr);
            case L: return createRandomC(minOvr, maxOvr);
            case R: return createRandomR(minOvr, maxOvr);
            default: return null;
        }
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
        playerG.setAgility(randomPrimary(minOvr, maxOvr));
        playerG.setEndurance(randomPrimary(minOvr, maxOvr));

        playerG.setAngles(randomPrimary(minOvr, maxOvr));
        playerG.setBreakaway(randomPrimary(minOvr, maxOvr));
        playerG.setGlove(randomPrimary(minOvr, maxOvr));
        playerG.setStick(randomPrimary(minOvr, maxOvr));

        playerG.setReboundControl(randomPrimary(minOvr, maxOvr));
        playerG.setRecover(randomPrimary(minOvr, maxOvr));
        playerG.setPokeCkech(randomPrimary(minOvr, maxOvr));

        //Второстепенное
        playerG.setBalance(randomSecondary(minOvr, maxOvr));
        playerG.setSpeed(randomSecondary(minOvr, maxOvr));

        playerG.setDiscipline(randomSecondary(minOvr, maxOvr));
        playerG.setOffAwareness(randomSecondary(minOvr, maxOvr));
        playerG.setPoise(randomSecondary(minOvr, maxOvr));

        playerG.setAggressiveness(randomSecondary(minOvr, maxOvr));
        playerG.setBodyChecking(randomSecondary(minOvr, maxOvr));
        playerG.setDurability(randomSecondary(minOvr, maxOvr));
        playerG.setFightingSkill(randomSecondary(minOvr, maxOvr));
        playerG.setStrength(randomSecondary(minOvr, maxOvr));

        playerG.setHandEye(randomSecondary(minOvr, maxOvr));
        playerG.setPassing(randomSecondary(minOvr, maxOvr));
        playerG.setPuckControl(randomSecondary(minOvr, maxOvr));

        //Ненужное для вратаря
        playerG.setStapShotAccuracy(randomOther());
        playerG.setStapShotPower(randomOther());
        playerG.setWristShotAccuracy(randomOther());
        playerG.setWristShotPower(randomOther());

        playerG.setAcceleration(randomOther());

        playerG.setDefAwareness(randomOther());
        playerG.setFaceOff(randomOther());
        playerG.setShotBlocking(randomOther());
        playerG.setStickChecking(randomOther());
        playerG.setOvr(ovr(playerG, PositionEnum.G));
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
        playerD.setAcceleration(randomPrimary(minOvr, maxOvr));
        playerD.setAgility(randomPrimary(minOvr, maxOvr));
        playerD.setBalance(randomPrimary(minOvr, maxOvr));
        playerD.setEndurance(randomPrimary(minOvr, maxOvr));
        playerD.setSpeed(randomPrimary(minOvr, maxOvr));

        playerD.setDefAwareness(randomPrimary(minOvr, maxOvr));
        playerD.setFaceOff(randomPrimary(minOvr, maxOvr));
        playerD.setShotBlocking(randomPrimary(minOvr, maxOvr));
        playerD.setStickChecking(randomPrimary(minOvr, maxOvr));

        //Второстепенное для защитника
        playerD.setStapShotAccuracy(randomSecondary(minOvr, maxOvr));
        playerD.setStapShotPower(randomSecondary(minOvr, maxOvr));
        playerD.setWristShotAccuracy(randomSecondary(minOvr, maxOvr));
        playerD.setWristShotPower(randomSecondary(minOvr, maxOvr));

        playerD.setDiscipline(randomSecondary(minOvr, maxOvr));
        playerD.setOffAwareness(randomSecondary(minOvr, maxOvr));
        playerD.setPoise(randomSecondary(minOvr, maxOvr));

        playerD.setAggressiveness(randomSecondary(minOvr, maxOvr));
        playerD.setBodyChecking(randomSecondary(minOvr, maxOvr));
        playerD.setDurability(randomSecondary(minOvr, maxOvr));
        playerD.setFightingSkill(randomSecondary(minOvr, maxOvr));
        playerD.setStrength(randomSecondary(minOvr, maxOvr));

        playerD.setHandEye(randomSecondary(minOvr, maxOvr));
        playerD.setPassing(randomSecondary(minOvr, maxOvr));
        playerD.setPuckControl(randomSecondary(minOvr, maxOvr));

        //Ненужное для защитника
        playerD.setAngles(randomOther());
        playerD.setBreakaway(randomOther());
        playerD.setGlove(randomOther());
        playerD.setStick(randomOther());

        playerD.setReboundControl(randomOther());
        playerD.setRecover(randomOther());
        playerD.setPokeCkech(randomOther());

        playerD.setOvr(ovr(playerD, PositionEnum.D));
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
        playerC.setStapShotAccuracy(randomPrimary(minOvr, maxOvr));
        playerC.setStapShotPower(randomPrimary(minOvr, maxOvr));
        playerC.setWristShotAccuracy(randomPrimary(minOvr, maxOvr));
        playerC.setWristShotPower(randomPrimary(minOvr, maxOvr));

        playerC.setAcceleration(randomPrimary(minOvr, maxOvr));
        playerC.setAgility(randomPrimary(minOvr, maxOvr));
        playerC.setBalance(randomPrimary(minOvr, maxOvr));
        playerC.setEndurance(randomPrimary(minOvr, maxOvr));
        playerC.setSpeed(randomPrimary(minOvr, maxOvr));

        //Второстепенное для напа
        playerC.setDiscipline(randomSecondary(minOvr, maxOvr));
        playerC.setOffAwareness(randomSecondary(minOvr, maxOvr));
        playerC.setPoise(randomSecondary(minOvr, maxOvr));

        playerC.setDefAwareness(randomSecondary(minOvr, maxOvr));
        playerC.setFaceOff(randomSecondary(minOvr, maxOvr));
        playerC.setShotBlocking(randomSecondary(minOvr, maxOvr));
        playerC.setStickChecking(randomSecondary(minOvr, maxOvr));

        playerC.setAggressiveness(randomSecondary(minOvr, maxOvr));
        playerC.setBodyChecking(randomSecondary(minOvr, maxOvr));
        playerC.setDurability(randomSecondary(minOvr, maxOvr));
        playerC.setFightingSkill(randomSecondary(minOvr, maxOvr));
        playerC.setStrength(randomSecondary(minOvr, maxOvr));

        playerC.setHandEye(randomSecondary(minOvr, maxOvr));
        playerC.setPassing(randomSecondary(minOvr, maxOvr));
        playerC.setPuckControl(randomSecondary(minOvr, maxOvr));

        //Ненужное для Напа
        playerC.setAngles(randomOther());
        playerC.setBreakaway(randomOther());
        playerC.setGlove(randomOther());
        playerC.setStick(randomOther());

        playerC.setReboundControl(randomOther());
        playerC.setRecover(randomOther());
        playerC.setPokeCkech(randomOther());

        playerC.setOvr(ovr(playerC, PositionEnum.C));
        return playerC;
    }

    private static int randomInt(int minOvr, int maxOvr) {
        return new Random().nextInt(maxOvr - minOvr) + minOvr;
    }

    private static int randomPrimary(int minOvr, int maxOvr) {
        return randomInt(minOvr - 5, maxOvr + 5);
    }

    private static int randomSecondary(int minOvr, int maxOvr) {
        return randomInt(minOvr - 14, maxOvr + 18);
    }

    private static int randomOther() {
        return randomInt(0, 70);
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

    private static int ovrC(PlayerBase player) {
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
