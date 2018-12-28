package com.pologames.hcmb.server.entity;

import javax.persistence.*;

@Entity
public class GamerStatistic {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Всего игр
     */
    @Column
    private int totalGames;

    /**
     * Игр выйграно
     */
    @Column
    private int winGames;

    /**
     * Игр проиграно
     */
    @Column
    private int looseGames;

    /**
     * Голов забиты
     */
    @Column
    private int goalsClogged;

    /**
     * Голов пропущено
     */
    @Column
    private int goalsMissed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getWinGames() {
        return winGames;
    }

    public void setWinGames(int winGames) {
        this.winGames = winGames;
    }

    public int getLooseGames() {
        return looseGames;
    }

    public void setLooseGames(int looseGames) {
        this.looseGames = looseGames;
    }

    public int getGoalsClogged() {
        return goalsClogged;
    }

    public void setGoalsClogged(int goalsClogged) {
        this.goalsClogged = goalsClogged;
    }

    public int getGoalsMissed() {
        return goalsMissed;
    }

    public void setGoalsMissed(int goalsMissed) {
        this.goalsMissed = goalsMissed;
    }

    @Override
    public String toString() {
        return "GamerStatistic{" +
                "id=" + id +
                ", totalGames=" + totalGames +
                ", winGames=" + winGames +
                ", looseGames=" + looseGames +
                ", goalsClogged=" + goalsClogged +
                ", goalsMissed=" + goalsMissed +
                '}';
    }
}
