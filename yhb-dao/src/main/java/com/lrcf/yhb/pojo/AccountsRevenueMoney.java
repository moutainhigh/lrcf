package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountsRevenueMoney implements Serializable {
    private Integer id;

    private String userid;

    private String platid;

    private BigDecimal accountmoney;

    private BigDecimal revenuemoney;

    private Date createtime;

    private String des;

    private String emK1;

    private BigDecimal emK2;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPlatid() {
        return platid;
    }

    public void setPlatid(String platid) {
        this.platid = platid;
    }

    public BigDecimal getAccountmoney() {
        return accountmoney;
    }

    public void setAccountmoney(BigDecimal accountmoney) {
        this.accountmoney = accountmoney;
    }

    public BigDecimal getRevenuemoney() {
        return revenuemoney;
    }

    public void setRevenuemoney(BigDecimal revenuemoney) {
        this.revenuemoney = revenuemoney;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getEmK1() {
        return emK1;
    }

    public void setEmK1(String emK1) {
        this.emK1 = emK1;
    }

    public BigDecimal getEmK2() {
        return emK2;
    }

    public void setEmK2(BigDecimal emK2) {
        this.emK2 = emK2;
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
        AccountsRevenueMoney other = (AccountsRevenueMoney) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getPlatid() == null ? other.getPlatid() == null : this.getPlatid().equals(other.getPlatid()))
            && (this.getAccountmoney() == null ? other.getAccountmoney() == null : this.getAccountmoney().equals(other.getAccountmoney()))
            && (this.getRevenuemoney() == null ? other.getRevenuemoney() == null : this.getRevenuemoney().equals(other.getRevenuemoney()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getDes() == null ? other.getDes() == null : this.getDes().equals(other.getDes()))
            && (this.getEmK1() == null ? other.getEmK1() == null : this.getEmK1().equals(other.getEmK1()))
            && (this.getEmK2() == null ? other.getEmK2() == null : this.getEmK2().equals(other.getEmK2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPlatid() == null) ? 0 : getPlatid().hashCode());
        result = prime * result + ((getAccountmoney() == null) ? 0 : getAccountmoney().hashCode());
        result = prime * result + ((getRevenuemoney() == null) ? 0 : getRevenuemoney().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getDes() == null) ? 0 : getDes().hashCode());
        result = prime * result + ((getEmK1() == null) ? 0 : getEmK1().hashCode());
        result = prime * result + ((getEmK2() == null) ? 0 : getEmK2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", platid=").append(platid);
        sb.append(", accountmoney=").append(accountmoney);
        sb.append(", revenuemoney=").append(revenuemoney);
        sb.append(", createtime=").append(createtime);
        sb.append(", des=").append(des);
        sb.append(", emK1=").append(emK1);
        sb.append(", emK2=").append(emK2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}