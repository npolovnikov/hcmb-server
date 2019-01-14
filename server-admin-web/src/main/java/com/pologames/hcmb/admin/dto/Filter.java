package com.pologames.hcmb.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Filter {

    @JsonProperty
    private String nameFilter;

    @JsonProperty
    private String countryFilter;

    @JsonProperty
    private MinMaxFilter ovrFilter;

    @JsonProperty
    private Map<String, MinMaxFilter> statsFilter;

    public String getNameFilter() {
        return nameFilter;
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    public String getCountry() {
        return countryFilter;
    }

    public void setCountry(String countryFilter) {
        this.countryFilter = countryFilter;
    }

    public MinMaxFilter getOvrFilter() {
        return ovrFilter;
    }

    public void setOvrFilter(MinMaxFilter ovrFilter) {
        this.ovrFilter = ovrFilter;
    }

    public Map<String, MinMaxFilter> getStatsFilter() {
        return statsFilter;
    }

    public void setStatsFilter(Map<String, MinMaxFilter> statsFilter) {
        this.statsFilter = statsFilter;
    }
}
