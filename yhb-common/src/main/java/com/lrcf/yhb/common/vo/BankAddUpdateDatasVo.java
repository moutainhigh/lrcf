package com.lrcf.yhb.common.vo;

/**
 * Created by wangxf on 2017/5/18.
 */

import com.lrcf.yhb.common.config.BaseEntity;

/**
 *
 * @Function: AccountsUsersCenterController.java
 * @Description: 添加与更换银行卡Vo对象类
 *
 * @version: v1.0.0
 * @author: wangxf
 * @date: 2017年5月13日 下午3:33:53
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2017年5月13日     wangxf           v1.0.0               修改原因
 */
public class BankAddUpdateDatasVo extends BaseEntity{

    private String trueName = "";		// 获取用户的真实姓名
    private String idCard = "";			// 身份证号
    private String bankId = "";			// 所属银行的id
    private String proId = "";			// 省id
    private String cityId = "";			// 市id
    private String branch = "";			// 分行信息
    private String subbranch = "";		// 支行信息
    private String cardId = "";			// 银行卡号
    private String telPhone = "";		// 银行预留手机号码
    private String phoneCode = "";		// 手机验证码
    private String type = "";           // 绑卡类型 0：新增 1：修改

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}
