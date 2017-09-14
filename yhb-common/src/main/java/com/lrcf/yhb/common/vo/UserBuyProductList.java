package com.lrcf.yhb.common.vo;


import com.lrcf.yhb.common.config.BaseEntity;

import java.math.BigDecimal;

/**
 * @Description 用户购买理财产品的记录
 * Created by Administrator on 2017/6/5 0005.
 */
public class UserBuyProductList extends BaseEntity {

    private Integer tapType; //1：秒杀，普通产品：0
    private String name; //产品名称
    private BigDecimal profit; //收益金额
    private BigDecimal rate; //年化利率
    private BigDecimal freeze; //冻结金额
    private String bTime; //购买时间
    private String eTime; //过期时间
    private Integer day;//产品期限
    private BigDecimal money; //购买金额
    private Integer fpid; //产品Id
    private Integer fpuId; //购买产品id

    public UserBuyProductList(){

    }

    public UserBuyProductList(Integer tapType, String name, BigDecimal profit, BigDecimal rate, BigDecimal freeze, String bTime, String eTime, Integer day, BigDecimal money, Integer fpid, Integer fpuId) {
        this.tapType = tapType;
        this.name = name;
        this.profit = profit;
        this.rate = rate;
        this.freeze = freeze;
        this.bTime = bTime;
        this.eTime = eTime;
        this.day = day;
        this.money = money;
        this.fpid = fpid;
        this.fpuId = fpuId;
    }

    public Integer getFpid() {
        return fpid;
    }

    public void setFpid(Integer fpid) {
        this.fpid = fpid;
    }

    public Integer getFpuId() {
        return fpuId;
    }

    public void setFpuId(Integer fpuId) {
        this.fpuId = fpuId;
    }

    public Integer getTapType() {
        return tapType;
    }

    public void setTapType(Integer tapType) {
        this.tapType = tapType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getFreeze() {
        return freeze;
    }

    public void setFreeze(BigDecimal freeze) {
        this.freeze = freeze;
    }

    public String getbTime() {
        return bTime;
    }

    public void setbTime(String bTime) {
        this.bTime = bTime;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
