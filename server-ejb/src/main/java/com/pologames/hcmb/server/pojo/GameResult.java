package com.pologames.hcmb.server.pojo;

public class GameResult {
    private int winner;
    private int t1Coals;
    private int t2Coals;

    public GameResult(int t1Coals, int t2Coals) {
        while (t1Coals < 0 || t2Coals < 0){
            t1Coals++;
            t2Coals++;
        }

        this.winner = t1Coals > t2Coals ? 1 : t2Coals > t1Coals ? 2 : 0;
        this.t1Coals = t1Coals;
        this.t2Coals = t2Coals;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getT1Coals() {
        return t1Coals;
    }

    public void setT1Coals(int t1Coals) {
        this.t1Coals = t1Coals;
    }

    public int getT2Coals() {
        return t2Coals;
    }

    public void setT2Coals(int t2Coals) {
        this.t2Coals = t2Coals;
    }
}
