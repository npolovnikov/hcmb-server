package com.pologames.hcmb.server.entity;

import com.pologames.hcmb.server.pojo.UnitEnum;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "PlayerCard{" +
                "id=" + id +
                ", player=" + player +
                ", gamer=" + gamer +
                ", statistics=" + statistics +
                ", latestPrice=" + latestPrice +
                ", unit=" + unit +
                "} " + super.toString();
    }
}
