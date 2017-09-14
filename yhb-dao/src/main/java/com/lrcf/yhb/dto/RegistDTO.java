package com.lrcf.yhb.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/10.
 * 注册实体类
 */
public class RegistDTO implements Serializable{
    String phone;//账号
    String inviteCode;// 密码
    String pwd;//密码
    String type;//注册来源
    String phoneCode;//短信验证码
    String calcRst;//图形验证码
    String timesTamp;//时间戳
    String registStep;//注册步骤

    String name;//姓名
    String cardId;//身份证号码

    public String getPhone() {
        return phone;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public String getPwd() {
        return pwd;
    }

    public String getType() {
        return type;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public String getCalcRst() {
        return calcRst;
    }

    public String getTimesTamp() {
        return timesTamp;
    }

    public String getRegistStep() {
        return registStep;
    }

    public String getName() {
        return name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public void setCalcRst(String calcRst) {
        this.calcRst = calcRst;
    }

    public void setTimesTamp(String timesTamp) {
        this.timesTamp = timesTamp;
    }

    public void setRegistStep(String registStep) {
        this.registStep = registStep;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
