package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountChangeinfo implements Serializable {
    private Integer id;

    private String userid;

    private BigDecimal accountchange;

    private BigDecimal changevalue;

    private Date changedate;

    private BigDecimal lastbalance;

    private String accounttype;

    private String remark;

    private String platid;

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

    public BigDecimal getAccountchange() {
        return accountchange;
    }

    public void setAccountchange(BigDecimal accountchange) {
        this.accountchange = accountchange;
    }

    public BigDecimal getChangevalue() {
        return changevalue;
    }

    public void setChangevalue(BigDecimal changevalue) {
        this.changevalue = changevalue;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public BigDecimal getLastbalance() {
        return lastbalance;
    }

    public void setLastbalance(BigDecimal lastbalance) {
        this.lastbalance = lastbalance;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPlatid() {
        return platid;
    }

    public void setPlatid(String platid) {
        this.platid = platid;
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
        AccountChangeinfo other = (AccountChangeinfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getAccountchange() == null ? other.getAccountchange() == null : this.getAccountchange().equals(other.getAccountchange()))
            && (this.getChangevalue() == null ? other.getChangevalue() == null : this.getChangevalue().equals(other.getChangevalue()))
            && (this.getChangedate() == null ? other.getChangedate() == null : this.getChangedate().equals(other.getChangedate()))
            && (this.getLastbalance() == null ? other.getLastbalance() == null : this.getLastbalance().equals(other.getLastbalance()))
            && (this.getAccounttype() == null ? other.getAccounttype() == null : this.getAccounttype().equals(other.getAccounttype()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getPlatid() == null ? other.getPlatid() == null : this.getPlatid().equals(other.getPlatid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getAccountchange() == null) ? 0 : getAccountchange().hashCode());
        result = prime * result + ((getChangevalue() == null) ? 0 : getChangevalue().hashCode());
        result = prime * result + ((getChangedate() == null) ? 0 : getChangedate().hashCode());
        result = prime * result + ((getLastbalance() == null) ? 0 : getLastbalance().hashCode());
        result = prime * result + ((getAccounttype() == null) ? 0 : getAccounttype().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getPlatid() == null) ? 0 : getPlatid().hashCode());
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
        sb.append(", accountchange=").append(accountchange);
        sb.append(", changevalue=").append(changevalue);
        sb.append(", changedate=").append(changedate);
        sb.append(", lastbalance=").append(lastbalance);
        sb.append(", accounttype=").append(accounttype);
        sb.append(", remark=").append(remark);
        sb.append(", platid=").append(platid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}