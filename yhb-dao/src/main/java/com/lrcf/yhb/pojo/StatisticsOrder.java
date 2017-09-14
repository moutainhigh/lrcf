package com.lrcf.yhb.pojo;

import java.io.Serializable;

public class StatisticsOrder implements Serializable {
    private Integer id;

    private Integer start;

    private Integer sequence;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public StatisticsOrder(Integer id, Integer start, Integer sequence) {
        this.id = id;
        this.start = start;
        this.sequence = sequence;
    }

    public StatisticsOrder() {
    }
}