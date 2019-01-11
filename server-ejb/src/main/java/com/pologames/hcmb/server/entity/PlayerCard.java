package com.pologames.hcmb.server.entity;

import com.pologames.hcmb.server.pojo.UnitEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PlayerCard extends PlayerBase {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Ссылка на игрока
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAYER_ID", nullable = false)
    private Player player;

    /**
     * Ссылка на владельца карточки
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GAMER_ID", nullable = false)
    private Gamer gamer;

    /**
     * Ссылка на статистику карточки
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_STATISTIC_ID", nullable = false)
    private PlayerStatistic statistics;

    /**
     * Стоимость игрока, за которую заплатил владелец
     */
    @Column
    private long latestPrice;

    /**
     * Звено
     */
    @Column(nullable = false)
    private UnitEnum unit;

    @Transient
    private int fatigue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }

    public PlayerStatistic getStatistics() {
        if (statistics == null) {
            statistics = new PlayerStatistic();
        }
        return statistics;
    }

    public void setStatistics(PlayerStatistic statistics) {
        this.statistics = statistics;
    }

    public long getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(long latestPrice) {
        this.latestPrice = latestPrice;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }


    public void addFatigue(int fatigue) {
        this.fatigue += fatigue / ((getEndurance() + 10) / 20);

        if (this.fatigue > 50) {
            this.fatigue = 50;
        }
    }

    @Override
    public int getOvr() {
        return super.getOvr() - fatigue;
    }

    @Override
    public String toString() {
        return "PlayerCard{" +
                "id=" + id +
                ", gamer=" + gamer +
                ", statistics=" + statistics +
                ", latestPrice=" + latestPrice +
                ", unit=" + unit +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCard that = (PlayerCard) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
