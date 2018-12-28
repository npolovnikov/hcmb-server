package com.pologames.hcmb.server.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PlayerBase {

    @Column
    private int ovr;

    //GK
    //Reflex
    /**
     * Контроль углов
     */
    @Column
    private int angles;

    /**
     * 1 на 1
     */
    @Column
    private int breakaway;

    /**
     * Работа ловушкой
     */
    @Column
    private int glove;

    /**
     * Работа клюшкой
     */
    @Column
    private int stick;

    //Pick Control
    /**
     * Выбивание шайбы
     */
    @Column
    private int pokeCkech;

    /**
     * Контроль отскока
     */
    @Column
    private int reboundControl;

    /**
     * Восстановление
     */
    @Column
    private int recover;

    //Player
    // PuckSkills
    /**
     * Виденье
     */
    @Column
    private int handEye;

    /**
     * Пасы
     */
    @Column
    private int passing;

    /**
     * Контроль шайбы
     */
    @Column
    private int puckControl;

    // Shooting
    /**
     * Точность броска
     */
    @Column
    private int stapShotAccuracy;

    /**
     * Сила броска
     */
    @Column
    private int stapShotPower;

    /**
     * Точность удара
     */
    @Column
    private int wristShotAccuracy;

    /**
     * Сила удара
     */
    @Column
    private int wristShotPower;

    //Skating
    /**
     * Ускорение
     */
    @Column
    private int acceleration;

    /**
     * Ловкость
     */
    @Column
    private int agility;

    /**
     * Балансировка
     */
    @Column
    private int balance;

    /**
     * Выносливость
     */
    @Column
    private int endurance;

    /**
     * Скорость
     */
    @Column
    private int speed;

    //Senses
    /**
     * Дисциплина
     */
    @Column
    private int discipline;

    /**
     * Осознаность
     */
    @Column
    private int offAwareness;

    /**
     * Уравновешиность
     */
    @Column
    private int poise;


    //defense
    /**
     * Защита
     */
    @Column
    private int defAwareness;

    /**
     * Вбрасывание
     */
    @Column
    private int faceOff;

    /**
     * Перехват
     */
    @Column
    private int shotBlocking;

    /**
     * Отбор
     */
    @Column
    private int stickChecking;

    //Physical
    /**
     * Агрессивность
     */
    @Column
    private int aggressiveness;

    /**
     * Силовой прием
     */
    @Column
    private int bodyChecking;

    /**
     * Стойкость
     */
    @Column
    private int durability;

    /**
     * Боевой навык
     */
    @Column
    private int fightingSkill;

    /**
     * Сила
     */
    @Column
    private int strength;

    public int getOvr() {
        return ovr;
    }

    public void setOvr(int ovr) {
        this.ovr = ovr;
    }

    public int getAngles() {
        return angles;
    }

    public void setAngles(int angles) {
        this.angles = angles;
    }

    public int getBreakaway() {
        return breakaway;
    }

    public void setBreakaway(int breakaway) {
        this.breakaway = breakaway;
    }

    public int getGlove() {
        return glove;
    }

    public void setGlove(int glove) {
        this.glove = glove;
    }

    public int getStick() {
        return stick;
    }

    public void setStick(int stick) {
        this.stick = stick;
    }

    public int getPokeCkech() {
        return pokeCkech;
    }

    public void setPokeCkech(int pokeCkech) {
        this.pokeCkech = pokeCkech;
    }

    public int getReboundControl() {
        return reboundControl;
    }

    public void setReboundControl(int reboundControl) {
        this.reboundControl = reboundControl;
    }

    public int getRecover() {
        return recover;
    }

    public void setRecover(int recover) {
        this.recover = recover;
    }

    public int getHandEye() {
        return handEye;
    }

    public void setHandEye(int handEye) {
        this.handEye = handEye;
    }

    public int getPassing() {
        return passing;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public int getPuckControl() {
        return puckControl;
    }

    public void setPuckControl(int puckControl) {
        this.puckControl = puckControl;
    }

    public int getStapShotAccuracy() {
        return stapShotAccuracy;
    }

    public void setStapShotAccuracy(int stapShotAccuracy) {
        this.stapShotAccuracy = stapShotAccuracy;
    }

    public int getStapShotPower() {
        return stapShotPower;
    }

    public void setStapShotPower(int stapShotPower) {
        this.stapShotPower = stapShotPower;
    }

    public int getWristShotAccuracy() {
        return wristShotAccuracy;
    }

    public void setWristShotAccuracy(int wristShotAccuracy) {
        this.wristShotAccuracy = wristShotAccuracy;
    }

    public int getWristShotPower() {
        return wristShotPower;
    }

    public void setWristShotPower(int wristShotPower) {
        this.wristShotPower = wristShotPower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDiscipline() {
        return discipline;
    }

    public void setDiscipline(int discipline) {
        this.discipline = discipline;
    }

    public int getOffAwareness() {
        return offAwareness;
    }

    public void setOffAwareness(int offAwareness) {
        this.offAwareness = offAwareness;
    }

    public int getPoise() {
        return poise;
    }

    public void setPoise(int poise) {
        this.poise = poise;
    }

    public int getDefAwareness() {
        return defAwareness;
    }

    public void setDefAwareness(int defAwareness) {
        this.defAwareness = defAwareness;
    }

    public int getFaceOff() {
        return faceOff;
    }

    public void setFaceOff(int faceOff) {
        this.faceOff = faceOff;
    }

    public int getShotBlocking() {
        return shotBlocking;
    }

    public void setShotBlocking(int shotBlocking) {
        this.shotBlocking = shotBlocking;
    }

    public int getStickChecking() {
        return stickChecking;
    }

    public void setStickChecking(int stickChecking) {
        this.stickChecking = stickChecking;
    }

    public int getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(int aggressiveness) {
        this.aggressiveness = aggressiveness;
    }

    public int getBodyChecking() {
        return bodyChecking;
    }

    public void setBodyChecking(int bodyChecking) {
        this.bodyChecking = bodyChecking;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getFightingSkill() {
        return fightingSkill;
    }

    public void setFightingSkill(int fightingSkill) {
        this.fightingSkill = fightingSkill;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "PlayerBase{" +
                "ovr=" + ovr +
                ", angles=" + angles +
                ", breakaway=" + breakaway +
                ", glove=" + glove +
                ", stick=" + stick +
                ", pokeCkech=" + pokeCkech +
                ", reboundControl=" + reboundControl +
                ", recover=" + recover +
                ", handEye=" + handEye +
                ", passing=" + passing +
                ", puckControl=" + puckControl +
                ", stapShotAccuracy=" + stapShotAccuracy +
                ", stapShotPower=" + stapShotPower +
                ", wristShotAccuracy=" + wristShotAccuracy +
                ", wristShotPower=" + wristShotPower +
                ", acceleration=" + acceleration +
                ", agility=" + agility +
                ", balance=" + balance +
                ", endurance=" + endurance +
                ", speed=" + speed +
                ", discipline=" + discipline +
                ", offAwareness=" + offAwareness +
                ", poise=" + poise +
                ", defAwareness=" + defAwareness +
                ", faceOff=" + faceOff +
                ", shotBlocking=" + shotBlocking +
                ", stickChecking=" + stickChecking +
                ", aggressiveness=" + aggressiveness +
                ", bodyChecking=" + bodyChecking +
                ", durability=" + durability +
                ", fightingSkill=" + fightingSkill +
                ", strength=" + strength +
                '}';
    }
}
