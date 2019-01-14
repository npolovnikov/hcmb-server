package com.pologames.hcmb.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MinMaxFilter {

    @JsonProperty
    private int min;

    @JsonProperty
    private int max;

    public MinMaxFilter() {
    }

    public MinMaxFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
