package com.lrcf.yhb.common.vo;

import com.lrcf.yhb.common.config.BaseEntity;

import java.math.BigDecimal;

/**
 * 产品详情投资记录Vo
 *
 * @author KRX
 *
 */
public class UserInvestRecordListVo extends BaseEntity{

    private String name;  //真实姓名

    private String phone;  //电话号码

    private BigDecimal money; //投资金额

    private String time; //购买时间

    public UserInvestRecordListVo(){};

    public UserInvestRecordListVo(String name, String phone, BigDecimal money, String time) {
        this.name = name;
        this.phone = phone;
        this.money = money;
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
