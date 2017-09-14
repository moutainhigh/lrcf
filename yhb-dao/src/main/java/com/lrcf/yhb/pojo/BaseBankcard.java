package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.util.Date;

public class BaseBankcard implements Serializable {
    private Integer bankcardid;

    private String userid;

    private String username;

    private String bankname;

    private String bankaddress;

    private String bankcardnumber;

    private String province;

    private String city;

    private Date createtime;

    private Integer ispass;

    private Boolean isused;

    private String remark;

    private Integer belong;

    private String bankaddress2;

    private byte[] cardfront;

    private byte[] cardback;

    private byte[] usercardfront;

    private byte[] usercardback;

    private byte[] userbankcard;

    private byte[] userbankaccount;

    private static final long serialVersionUID = 1L;

    public Integer getBankcardid() {
        return bankcardid;
    }

    public void setBankcardid(Integer bankcardid) {
        this.bankcardid = bankcardid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaddress() {
        return bankaddress;
    }

    public void setBankaddress(String bankaddress) {
        this.bankaddress = bankaddress;
    }

    public String getBankcardnumber() {
        return bankcardnumber;
    }

    public void setBankcardnumber(String bankcardnumber) {
        this.bankcardnumber = bankcardnumber;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getIspass() {
        return ispass;
    }

    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }

    public Boolean getIsused() {
        return isused;
    }

    public void setIsused(Boolean isused) {
        this.isused = isused;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBelong() {
        return belong;
    }

    public void setBelong(Integer belong) {
        this.belong = belong;
    }

    public String getBankaddress2() {
        return bankaddress2;
    }

    public void setBankaddress2(String bankaddress2) {
        this.bankaddress2 = bankaddress2;
    }

    public byte[] getCardfront() {
        return cardfront;
    }

    public void setCardfront(byte[] cardfront) {
        this.cardfront = cardfront;
    }

    public byte[] getCardback() {
        return cardback;
    }

    public void setCardback(byte[] cardback) {
        this.cardback = cardback;
    }

    public byte[] getUsercardfront() {
        return usercardfront;
    }

    public void setUsercardfront(byte[] usercardfront) {
        this.usercardfront = usercardfront;
    }

    public byte[] getUsercardback() {
        return usercardback;
    }

    public void setUsercardback(byte[] usercardback) {
        this.usercardback = usercardback;
    }

    public byte[] getUserbankcard() {
        return userbankcard;
    }

    public void setUserbankcard(byte[] userbankcard) {
        this.userbankcard = userbankcard;
    }

    public byte[] getUserbankaccount() {
        return userbankaccount;
    }

    public void setUserbankaccount(byte[] userbankaccount) {
        this.userbankaccount = userbankaccount;
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
        BaseBankcard other = (BaseBankcard) that;
        return (this.getBankcardid() == null ? other.getBankcardid() == null : this.getBankcardid().equals(other.getBankcardid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getBankname() == null ? other.getBankname() == null : this.getBankname().equals(other.getBankname()))
            && (this.getBankaddress() == null ? other.getBankaddress() == null : this.getBankaddress().equals(other.getBankaddress()))
            && (this.getBankcardnumber() == null ? other.getBankcardnumber() == null : this.getBankcardnumber().equals(other.getBankcardnumber()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getIspass() == null ? other.getIspass() == null : this.getIspass().equals(other.getIspass()))
            && (this.getIsused() == null ? other.getIsused() == null : this.getIsused().equals(other.getIsused()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBelong() == null ? other.getBelong() == null : this.getBelong().equals(other.getBelong()))
            && (this.getBankaddress2() == null ? other.getBankaddress2() == null : this.getBankaddress2().equals(other.getBankaddress2()))
            && (this.getCardfront() == null ? other.getCardfront() == null : this.getCardfront().equals(other.getCardfront()))
            && (this.getCardback() == null ? other.getCardback() == null : this.getCardback().equals(other.getCardback()))
            && (this.getUsercardfront() == null ? other.getUsercardfront() == null : this.getUsercardfront().equals(other.getUsercardfront()))
            && (this.getUsercardback() == null ? other.getUsercardback() == null : this.getUsercardback().equals(other.getUsercardback()))
            && (this.getUserbankcard() == null ? other.getUserbankcard() == null : this.getUserbankcard().equals(other.getUserbankcard()))
            && (this.getUserbankaccount() == null ? other.getUserbankaccount() == null : this.getUserbankaccount().equals(other.getUserbankaccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBankcardid() == null) ? 0 : getBankcardid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getBankname() == null) ? 0 : getBankname().hashCode());
        result = prime * result + ((getBankaddress() == null) ? 0 : getBankaddress().hashCode());
        result = prime * result + ((getBankcardnumber() == null) ? 0 : getBankcardnumber().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getIspass() == null) ? 0 : getIspass().hashCode());
        result = prime * result + ((getIsused() == null) ? 0 : getIsused().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBelong() == null) ? 0 : getBelong().hashCode());
        result = prime * result + ((getBankaddress2() == null) ? 0 : getBankaddress2().hashCode());
        result = prime * result + ((getCardfront() == null) ? 0 : getCardfront().hashCode());
        result = prime * result + ((getCardback() == null) ? 0 : getCardback().hashCode());
        result = prime * result + ((getUsercardfront() == null) ? 0 : getUsercardfront().hashCode());
        result = prime * result + ((getUsercardback() == null) ? 0 : getUsercardback().hashCode());
        result = prime * result + ((getUserbankcard() == null) ? 0 : getUserbankcard().hashCode());
        result = prime * result + ((getUserbankaccount() == null) ? 0 : getUserbankaccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bankcardid=").append(bankcardid);
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", bankname=").append(bankname);
        sb.append(", bankaddress=").append(bankaddress);
        sb.append(", bankcardnumber=").append(bankcardnumber);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", createtime=").append(createtime);
        sb.append(", ispass=").append(ispass);
        sb.append(", isused=").append(isused);
        sb.append(", remark=").append(remark);
        sb.append(", belong=").append(belong);
        sb.append(", bankaddress2=").append(bankaddress2);
        sb.append(", cardfront=").append(cardfront);
        sb.append(", cardback=").append(cardback);
        sb.append(", usercardfront=").append(usercardfront);
        sb.append(", usercardback=").append(usercardback);
        sb.append(", userbankcard=").append(userbankcard);
        sb.append(", userbankaccount=").append(userbankaccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}