package com.pologames.hcmb.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayerStatistic {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int totalGoal;

    private int totalAssist;

    private int totalGame;

    private int totalSaves;

    private int totalMissing;

    private int gamerGoal;

    private int gamerAssist;

    private int gamerGame;

    private int gamerSaves;

    private int gamerMissing;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTotalGoal() {
        return totalGoal;
    }

    public void setTotalGoal(int totalGoal) {
        this.totalGoal = totalGoal;
    }

    public int getTotalAssist() {
        return totalAssist;
    }

    public void setTotalAssist(int totalAssist) {
        this.totalAssist = totalAssist;
    }

    public int getTotalGame() {
        return totalGame;
    }

    public void setTotalGame(int totalGame) {
        this.totalGame = totalGame;
    }

    public int getTotalSaves() {
        return totalSaves;
    }

    public void setTotalSaves(int totalSaves) {
        this.totalSaves = totalSaves;
    }

    public int getTotalMissing() {
        return totalMissing;
    }

    public void setTotalMissing(int totalMissing) {
        this.totalMissing = totalMissing;
    }

    public int getGamerGoal() {
        return gamerGoal;
    }

    public void setGamerGoal(int gamerGoal) {
        this.gamerGoal = gamerGoal;
    }

    public int getGamerAssist() {
        return gamerAssist;
    }

    public void setGamerAssist(int gamerAssist) {
        this.gamerAssist = gamerAssist;
    }

    public int getGamerGame() {
        return gamerGame;
    }

    public void setGamerGame(int gamerGame) {
        this.gamerGame = gamerGame;
    }

    public int getGamerSaves() {
        return gamerSaves;
    }

    public void setGamerSaves(int gamerSaves) {
        this.gamerSaves = gamerSaves;
    }

    public int getGamerMissing() {
        return gamerMissing;
    }

    public void setGamerMissing(int gamerMissing) {
        this.gamerMissing = gamerMissing;
    }

    @Override
    public String toString() {
        return "PlayerStatistic{" +
                "id=" + id +
                ", totalGoal=" + totalGoal +
                ", totalAssist=" + totalAssist +
                ", totalGame=" + totalGame +
                ", totalSaves=" + totalSaves +
                ", totalMissing=" + totalMissing +
                ", gamerGoal=" + gamerGoal +
                ", gamerAssist=" + gamerAssist +
                ", gamerGame=" + gamerGame +
                ", gamerSaves=" + gamerSaves +
                ", gamerMissing=" + gamerMissing +
                '}';
    }
}
