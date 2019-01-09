package com.pologames.hcmb.server.entity;

import com.pologames.hcmb.server.pojo.UnitEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Gamer {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Ник
     */
    @Column
    private String nickname;

    /**
     * Количество серебрянных монет
     */
    @Column
    private long moneySilver;

    /**
     * Количество золотых монет
     */
    @Column
    private long moneyGold;

    /**
     * Стадион
     */
    @Column
    private int stadiumId;

    /**
     * Карточки, которые есть у игрока
     */
    @OneToMany(mappedBy = "gamer", fetch = FetchType.LAZY)
    private List<PlayerCard> playerCards;

    /**
     * Статистика матчей
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "GAMER_STATISTIC_ID", nullable = false)
    private GamerStatistic statistics;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getMoneySilver() {
        return moneySilver;
    }

    public void setMoneySilver(long moneySilver) {
        this.moneySilver = moneySilver;
    }

    public long getMoneyGold() {
        return moneyGold;
    }

    public void setMoneyGold(long moneyGold) {
        this.moneyGold = moneyGold;
    }

    public int getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(int stadiumId) {
        this.stadiumId = stadiumId;
    }

    public List<PlayerCard> getPlayerCards() {
        if (playerCards == null) {
            playerCards = new ArrayList<>();
        }
        return playerCards;
    }

    public List<PlayerCard> getPlayerCardsByUnit(UnitEnum unit) {
        return getPlayerCards().stream().filter(playerCard -> playerCard.getUnit() == unit).collect(Collectors.toList());
    }

    public GamerStatistic getStatistics() {
        if (statistics == null){
            statistics = new GamerStatistic();
        }
        return statistics;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "id=" + id +
                ", nickname=" + nickname +
                ", moneySilver=" + moneySilver +
                ", moneyGold=" + moneyGold +
                ", stadiumId=" + stadiumId +
                ", statistics=" + statistics +
                '}';
    }
}
