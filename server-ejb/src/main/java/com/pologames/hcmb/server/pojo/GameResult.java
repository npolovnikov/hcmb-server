package com.pologames.hcmb.server.pojo;

/**
 * Результаты матча\переода\отрезка времени
 */
public class GameResult {

    /**
     * Команда победитель <br>
     *     0 - Ничья<br>
     *     1 - Победа хозяев (t1) <br>
     *     2 - Победа гостей (t2)
     */
    private int winner;

    /**
     * Количество голов, которые забили хозяева (t1)
     */
    private int t1Coals;

    /**
     * Количество голов, которые забили гости (t2)
     */
    private int t2Coals;

    public GameResult() {
    }

    public GameResult(int t1Coals, int t2Coals) {
        this.winner = t1Coals > t2Coals ? 1 : t2Coals > t1Coals ? 2 : 0;
        this.t1Coals = t1Coals;
        this.t2Coals = t2Coals;
    }

    public void calculate(GameResult timeResult) {
        calculate(timeResult.getT1Coals(), timeResult.getT2Coals());
    }

    public void calculate(int t1Coals, int t2Coals) {
        this.t1Coals += t1Coals;
        this.t2Coals += t2Coals;

        this.winner = this.t1Coals > this.t2Coals ? 1 : this.t2Coals > this.t1Coals ? 2 : 0;
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

    @Override
    public String toString() {
        return "GameResult{" +
                "winner=" + winner +
                ", t1Coals=" + t1Coals +
                ", t2Coals=" + t2Coals +
                '}';
    }
}
