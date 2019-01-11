package com.pologames.hcmb.server.entity;

import com.pologames.hcmb.server.pojo.UnitEnum;

public class TimeTactic {

    private UnitEnum unit;

    private int startTime;
    private int endTime;

    public TimeTactic() {
    }

    public TimeTactic(UnitEnum unit, int startTime, int endTime) {
        this.unit = unit;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
