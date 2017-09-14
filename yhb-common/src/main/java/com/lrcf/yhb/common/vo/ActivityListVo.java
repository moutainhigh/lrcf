package com.lrcf.yhb.common.vo;

import com.lrcf.yhb.common.config.BaseEntity;

import java.math.BigDecimal;

/**
 * 活动礼券vo
 * Created by Administrator on 2017/6/7 0007.
 */
public class ActivityListVo  extends BaseEntity {

    private Integer state;  // 0：未使用，1：已使用，2：已过期
    private BigDecimal value; //金额或加息点数
    private String name; //礼券名称
    private String remarks;//备注
    private String getTime;//获得时间
    private String overdueTime; //结束时间
    private String day;//剩余多少天过期
    private String unuse; //过期原因，已使用或已过期


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    public String getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(String overdueTime) {
        this.overdueTime = overdueTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getUnuse() {
        return unuse;
    }

    public void setUnuse(String unuse) {
        this.unuse = unuse;
    }
}
