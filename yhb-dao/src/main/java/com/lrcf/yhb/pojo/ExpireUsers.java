package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/12.
 */
public class ExpireUsers  implements Serializable{
    private String FProductsName;
    private String userName;
    private String TrueName;
    private Date time;
    private BigDecimal PayMoney;
    private BigDecimal PayFee;
    private Integer CheckState;//'1 表示待审核\r\n2 表示等待支付\r\n3 表示已结算\r\n-1 表示支付失败\r\n',
    private Integer CheckType;//1表示余额结算 2表示分润结算' 3 代理商余额提现  4福利提现
    private String PayBank;
    private String  ChannelName;  //充值通道
    private Integer duringTime;
    private String UUID;

    public Integer getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(Integer duringTime) {
        this.duringTime = duringTime;
    }

    public String getFProductsName() {
        return FProductsName;
    }

    public void setFProductsName(String FProductsName) {
        this.FProductsName = FProductsName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return TrueName;
    }

    public void setTrueName(String trueName) {
        TrueName = trueName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigDecimal getPayMoney() {
        return PayMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        PayMoney = payMoney;
    }

    public BigDecimal getPayFee() {
        return PayFee;
    }

    public void setPayFee(BigDecimal payFee) {
        PayFee = payFee;
    }

    public Integer getCheckState() {
        return CheckState;
    }

    public void setCheckState(Integer checkState) {
        CheckState = checkState;
    }

    public Integer getCheckType() {
        return CheckType;
    }

    public void setCheckType(Integer checkType) {
        CheckType = checkType;
    }

    public String getPayBank() {
        return PayBank;
    }

    public void setPayBank(String payBank) {
        PayBank = payBank;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    @Override
    public String toString() {
        return "ExpireUsers{" +
                "FProductsName='" + FProductsName + '\'' +
                ", userName='" + userName + '\'' +
                ", TrueName='" + TrueName + '\'' +
                ", time=" + time +
                ", PayMoney=" + PayMoney +
                ", PayFee=" + PayFee +
                ", CheckState=" + CheckState +
                ", CheckType=" + CheckType +
                ", PayBank='" + PayBank + '\'' +
                ", ChannelName='" + ChannelName + '\'' +
                ", duringTime=" + duringTime +
                ", UUID='" + UUID + '\'' +
                '}';
    }
}
