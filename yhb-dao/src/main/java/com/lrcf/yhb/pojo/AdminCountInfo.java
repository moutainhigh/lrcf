package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/12.
 */
public class AdminCountInfo implements Serializable{
    private static final long serialVersionUID = -4582414557803240242L;
    private String province ;
    private String city;
    private BigDecimal inMoney;
    private BigDecimal outMoney;
    private BigDecimal freezeMoney;
    private BigDecimal  jieSuanMoney;
    private BigDecimal otherMoney;
    private Date day1;
    private String fBuyNum;//产品购买人数
    private String fProductsMaxday;//产品期限
    private String UUID;

    private UsersDistributionVO usersDistributionVO;
    private ExpireUsers expireUsers;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getInMoney() {
        return inMoney;
    }

    public void setInMoney(BigDecimal inMoney) {
        this.inMoney = inMoney;
    }

    public BigDecimal getOutMoney() {
        return outMoney;
    }

    public void setOutMoney(BigDecimal outMoney) {
        this.outMoney = outMoney;
    }

    public BigDecimal getFreezeMoney() {
        return freezeMoney;
    }

    public void setFreezeMoney(BigDecimal freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public BigDecimal getJieSuanMoney() {
        return jieSuanMoney;
    }

    public void setJieSuanMoney(BigDecimal jieSuanMoney) {
        this.jieSuanMoney = jieSuanMoney;
    }

    public BigDecimal getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(BigDecimal otherMoney) {
        this.otherMoney = otherMoney;
    }

    public Date getDay1() {
        return day1;
    }

    public void setDay1(Date day1) {
        this.day1 = day1;
    }

    public String getfBuyNum() {
        return fBuyNum;
    }

    public void setfBuyNum(String fBuyNum) {
        this.fBuyNum = fBuyNum;
    }

    public String getfProductsMaxday() {
        return fProductsMaxday;
    }

    public void setfProductsMaxday(String fProductsMaxday) {
        this.fProductsMaxday = fProductsMaxday;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public UsersDistributionVO getUsersDistributionVO() {
        return usersDistributionVO;
    }

    public void setUsersDistributionVO(UsersDistributionVO usersDistributionVO) {
        this.usersDistributionVO = usersDistributionVO;
    }

    public ExpireUsers getExpireUsers() {
        return expireUsers;
    }

    public void setExpireUsers(ExpireUsers expireUsers) {
        this.expireUsers = expireUsers;
    }
}
