package com.lrcf.yhb.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/20.
 */
public class S_BuyProductsDto implements  Serializable{

    private Integer target;
    private String type;
    private Integer pageSize;
    private String startTime;
    private String endTime ;

    private Integer order;
    private Integer state;

    public S_BuyProductsDto() {
    }

    public S_BuyProductsDto(Integer target, String type, Integer pageSize, String startTime, String endTime, Integer order, Integer state) {
        this.target = target;
        this.type = type;
        this.pageSize = pageSize;
        this.startTime = startTime;
        this.endTime = endTime;
        this.order = order;
        this.state = state;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {

        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
