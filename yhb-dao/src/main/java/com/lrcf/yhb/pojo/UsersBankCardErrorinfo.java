package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.util.Date;

public class UsersBankCardErrorinfo implements Serializable {
    private Integer id;

    private String userId;

    private String trueName;

    private String idCard;

    private String bankCard;

    private String telphone;

    private String bankName;

    private String province;

    private String city;

    private String bankAddress;

    private String bankAddress2;

    private Date createTime;

    private String describ;

    private String operator;

    private String res1;

    private String res2;

    private String res3;

    private String res4;

    private String res5;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankAddress2() {
        return bankAddress2;
    }

    public void setBankAddress2(String bankAddress2) {
        this.bankAddress2 = bankAddress2;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }

    public String getRes4() {
        return res4;
    }

    public void setRes4(String res4) {
        this.res4 = res4;
    }

    public String getRes5() {
        return res5;
    }

    public void setRes5(String res5) {
        this.res5 = res5;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UsersBankCardErrorinfo other = (UsersBankCardErrorinfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTrueName() == null ? other.getTrueName() == null : this.getTrueName().equals(other.getTrueName()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getTelphone() == null ? other.getTelphone() == null : this.getTelphone().equals(other.getTelphone()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getBankAddress() == null ? other.getBankAddress() == null : this.getBankAddress().equals(other.getBankAddress()))
            && (this.getBankAddress2() == null ? other.getBankAddress2() == null : this.getBankAddress2().equals(other.getBankAddress2()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDescrib() == null ? other.getDescrib() == null : this.getDescrib().equals(other.getDescrib()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getRes1() == null ? other.getRes1() == null : this.getRes1().equals(other.getRes1()))
            && (this.getRes2() == null ? other.getRes2() == null : this.getRes2().equals(other.getRes2()))
            && (this.getRes3() == null ? other.getRes3() == null : this.getRes3().equals(other.getRes3()))
            && (this.getRes4() == null ? other.getRes4() == null : this.getRes4().equals(other.getRes4()))
            && (this.getRes5() == null ? other.getRes5() == null : this.getRes5().equals(other.getRes5()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTrueName() == null) ? 0 : getTrueName().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getTelphone() == null) ? 0 : getTelphone().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getBankAddress() == null) ? 0 : getBankAddress().hashCode());
        result = prime * result + ((getBankAddress2() == null) ? 0 : getBankAddress2().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDescrib() == null) ? 0 : getDescrib().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getRes1() == null) ? 0 : getRes1().hashCode());
        result = prime * result + ((getRes2() == null) ? 0 : getRes2().hashCode());
        result = prime * result + ((getRes3() == null) ? 0 : getRes3().hashCode());
        result = prime * result + ((getRes4() == null) ? 0 : getRes4().hashCode());
        result = prime * result + ((getRes5() == null) ? 0 : getRes5().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", trueName=").append(trueName);
        sb.append(", idCard=").append(idCard);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", telphone=").append(telphone);
        sb.append(", bankName=").append(bankName);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", bankAddress=").append(bankAddress);
        sb.append(", bankAddress2=").append(bankAddress2);
        sb.append(", createTime=").append(createTime);
        sb.append(", describ=").append(describ);
        sb.append(", operator=").append(operator);
        sb.append(", res1=").append(res1);
        sb.append(", res2=").append(res2);
        sb.append(", res3=").append(res3);
        sb.append(", res4=").append(res4);
        sb.append(", res5=").append(res5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}