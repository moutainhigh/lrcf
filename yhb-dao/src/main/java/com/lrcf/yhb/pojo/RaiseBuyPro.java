package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RaiseBuyPro implements Serializable {
    private Integer raisebuyid;

    private String raisename;

    private Integer raisesendid;

    private Integer raisebuyfpuid;

    private Date raiseusetime;

    private String userid;

    private BigDecimal raisesize;

    private Integer raisecountnum;

    private Integer raiserateinnum;

    private Date raiseovertime;

    private Integer raiseisover;

    private BigDecimal raisecountmoney;

    private static final long serialVersionUID = 1L;

    public Integer getRaisebuyid() {
        return raisebuyid;
    }

    public void setRaisebuyid(Integer raisebuyid) {
        this.raisebuyid = raisebuyid;
    }

    public String getRaisename() {
        return raisename;
    }

    public void setRaisename(String raisename) {
        this.raisename = raisename;
    }

    public Integer getRaisesendid() {
        return raisesendid;
    }

    public void setRaisesendid(Integer raisesendid) {
        this.raisesendid = raisesendid;
    }

    public Integer getRaisebuyfpuid() {
        return raisebuyfpuid;
    }

    public void setRaisebuyfpuid(Integer raisebuyfpuid) {
        this.raisebuyfpuid = raisebuyfpuid;
    }

    public Date getRaiseusetime() {
        return raiseusetime;
    }

    public void setRaiseusetime(Date raiseusetime) {
        this.raiseusetime = raiseusetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BigDecimal getRaisesize() {
        return raisesize;
    }

    public void setRaisesize(BigDecimal raisesize) {
        this.raisesize = raisesize;
    }

    public Integer getRaisecountnum() {
        return raisecountnum;
    }

    public void setRaisecountnum(Integer raisecountnum) {
        this.raisecountnum = raisecountnum;
    }

    public Integer getRaiserateinnum() {
        return raiserateinnum;
    }

    public void setRaiserateinnum(Integer raiserateinnum) {
        this.raiserateinnum = raiserateinnum;
    }

    public Date getRaiseovertime() {
        return raiseovertime;
    }

    public void setRaiseovertime(Date raiseovertime) {
        this.raiseovertime = raiseovertime;
    }

    public Integer getRaiseisover() {
        return raiseisover;
    }

    public void setRaiseisover(Integer raiseisover) {
        this.raiseisover = raiseisover;
    }

    public BigDecimal getRaisecountmoney() {
        return raisecountmoney;
    }

    public void setRaisecountmoney(BigDecimal raisecountmoney) {
        this.raisecountmoney = raisecountmoney;
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
        RaiseBuyPro other = (RaiseBuyPro) that;
        return (this.getRaisebuyid() == null ? other.getRaisebuyid() == null : this.getRaisebuyid().equals(other.getRaisebuyid()))
            && (this.getRaisename() == null ? other.getRaisename() == null : this.getRaisename().equals(other.getRaisename()))
            && (this.getRaisesendid() == null ? other.getRaisesendid() == null : this.getRaisesendid().equals(other.getRaisesendid()))
            && (this.getRaisebuyfpuid() == null ? other.getRaisebuyfpuid() == null : this.getRaisebuyfpuid().equals(other.getRaisebuyfpuid()))
            && (this.getRaiseusetime() == null ? other.getRaiseusetime() == null : this.getRaiseusetime().equals(other.getRaiseusetime()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getRaisesize() == null ? other.getRaisesize() == null : this.getRaisesize().equals(other.getRaisesize()))
            && (this.getRaisecountnum() == null ? other.getRaisecountnum() == null : this.getRaisecountnum().equals(other.getRaisecountnum()))
            && (this.getRaiserateinnum() == null ? other.getRaiserateinnum() == null : this.getRaiserateinnum().equals(other.getRaiserateinnum()))
            && (this.getRaiseovertime() == null ? other.getRaiseovertime() == null : this.getRaiseovertime().equals(other.getRaiseovertime()))
            && (this.getRaiseisover() == null ? other.getRaiseisover() == null : this.getRaiseisover().equals(other.getRaiseisover()))
            && (this.getRaisecountmoney() == null ? other.getRaisecountmoney() == null : this.getRaisecountmoney().equals(other.getRaisecountmoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRaisebuyid() == null) ? 0 : getRaisebuyid().hashCode());
        result = prime * result + ((getRaisename() == null) ? 0 : getRaisename().hashCode());
        result = prime * result + ((getRaisesendid() == null) ? 0 : getRaisesendid().hashCode());
        result = prime * result + ((getRaisebuyfpuid() == null) ? 0 : getRaisebuyfpuid().hashCode());
        result = prime * result + ((getRaiseusetime() == null) ? 0 : getRaiseusetime().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getRaisesize() == null) ? 0 : getRaisesize().hashCode());
        result = prime * result + ((getRaisecountnum() == null) ? 0 : getRaisecountnum().hashCode());
        result = prime * result + ((getRaiserateinnum() == null) ? 0 : getRaiserateinnum().hashCode());
        result = prime * result + ((getRaiseovertime() == null) ? 0 : getRaiseovertime().hashCode());
        result = prime * result + ((getRaiseisover() == null) ? 0 : getRaiseisover().hashCode());
        result = prime * result + ((getRaisecountmoney() == null) ? 0 : getRaisecountmoney().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", raisebuyid=").append(raisebuyid);
        sb.append(", raisename=").append(raisename);
        sb.append(", raisesendid=").append(raisesendid);
        sb.append(", raisebuyfpuid=").append(raisebuyfpuid);
        sb.append(", raiseusetime=").append(raiseusetime);
        sb.append(", userid=").append(userid);
        sb.append(", raisesize=").append(raisesize);
        sb.append(", raisecountnum=").append(raisecountnum);
        sb.append(", raiserateinnum=").append(raiserateinnum);
        sb.append(", raiseovertime=").append(raiseovertime);
        sb.append(", raiseisover=").append(raiseisover);
        sb.append(", raisecountmoney=").append(raisecountmoney);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}