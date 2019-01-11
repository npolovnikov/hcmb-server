package com.pologames.hcmb.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tactic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private List<TimeTactic> timeTacticList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TimeTactic> getTimeTacticList() {
        if (timeTacticList == null) {
            timeTacticList = new ArrayList<>();
        }
        return timeTacticList;
    }

    public TimeTactic getTimeTacticByStartTime(int startTime){
        return timeTacticList.stream()
                .filter(timeTactic -> startTime >= timeTactic.getStartTime() && startTime < timeTactic.getEndTime())
                .findFirst()
                .orElse(null);
    }

}
