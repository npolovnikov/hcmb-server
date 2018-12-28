package com.pologames.hcmb.server.entity;

import com.pologames.hcmb.server.pojo.PositionEnum;

import javax.persistence.*;

/**
 * Описание игрока
 */
@Entity
public class Player extends PlayerBase {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Полсное имя
     */
    @Column
    private String fullName;

    /**
     * Короткое имя (на майке)
     */
    @Column
    private String shortName;

    /**
     * Позиция
     */
    @Column(nullable = false, length = 1)
    private PositionEnum position;

    /**
     * Талант
     */
    @Column(nullable = false)
    private int talent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public void setPosition(PositionEnum position) {
        this.position = position;
    }

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }

    @Override
    public String toString() {
        return "Player{" +
                super.toString() +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", position=" + position +
                ", talent=" + talent +
                '}';
    }
}
