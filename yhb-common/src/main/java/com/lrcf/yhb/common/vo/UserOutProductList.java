package com.lrcf.yhb.common.vo;

import com.lrcf.yhb.common.config.BaseEntity;

import java.math.BigDecimal;

/**
 * @Description 用户转出产品记录
 * Created by Administrator on 2017/6/5 0005.
 */
public class UserOutProductList extends BaseEntity {

    private Integer state; // 0:未审核,1:审核通过，2：审核失败
    private String name; //产品名称
    private String time; //申请时间
    private BigDecimal outMoney; //转出金额
    private BigDecimal getMoney; //到手金额
    private BigDecimal breachMoney; //违约金额
    private BigDecimal profit; //违约利息

    public UserOutProductList(){}


    public UserOutProductList(Integer state, String name, String time, BigDecimal outMoney, BigDecimal getMoney, BigDecimal breachMoney, BigDecimal profit) {
        this.state = state;
        this.name = name;
        this.time = time;
        this.outMoney = outMoney;
        this.getMoney = getMoney;
        this.breachMoney = breachMoney;
        this.profit = profit;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getOutMoney() {
        return outMoney;
    }

    public void setOutMoney(BigDecimal outMoney) {
        this.outMoney = outMoney;
    }

    public BigDecimal getGetMoney() {
        return getMoney;
    }

    public void setGetMoney(BigDecimal getMoney) {
        this.getMoney = getMoney;
    }

    public BigDecimal getBreachMoney() {
        return breachMoney;
    }

    public void setBreachMoney(BigDecimal breachMoney) {
        this.breachMoney = breachMoney;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }
}
