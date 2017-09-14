package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RedBuyPro implements Serializable {
    private Integer redbuyid;

    private String redname;

    private Integer profpuid;

    private Date redusetime;

    private String userid;

    private Integer redsendid;

    private BigDecimal redmoney;

    private String res1;

    private String res2;

    private static final long serialVersionUID = 1L;

    public Integer getRedbuyid() {
        return redbuyid;
    }

    public void setRedbuyid(Integer redbuyid) {
        this.redbuyid = redbuyid;
    }

    public String getRedname() {
        return redname;
    }

    public void setRedname(String redname) {
        this.redname = redname;
    }

    public Integer getProfpuid() {
        return profpuid;
    }

    public void setProfpuid(Integer profpuid) {
        this.profpuid = profpuid;
    }

    public Date getRedusetime() {
        return redusetime;
    }

    public void setRedusetime(Date redusetime) {
        this.redusetime = redusetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getRedsendid() {
        return redsendid;
    }

    public void setRedsendid(Integer redsendid) {
        this.redsendid = redsendid;
    }

    public BigDecimal getRedmoney() {
        return redmoney;
    }

    public void setRedmoney(BigDecimal redmoney) {
        this.redmoney = redmoney;
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
        RedBuyPro other = (RedBuyPro) that;
        return (this.getRedbuyid() == null ? other.getRedbuyid() == null : this.getRedbuyid().equals(other.getRedbuyid()))
            && (this.getRedname() == null ? other.getRedname() == null : this.getRedname().equals(other.getRedname()))
            && (this.getProfpuid() == null ? other.getProfpuid() == null : this.getProfpuid().equals(other.getProfpuid()))
            && (this.getRedusetime() == null ? other.getRedusetime() == null : this.getRedusetime().equals(other.getRedusetime()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getRedsendid() == null ? other.getRedsendid() == null : this.getRedsendid().equals(other.getRedsendid()))
            && (this.getRedmoney() == null ? other.getRedmoney() == null : this.getRedmoney().equals(other.getRedmoney()))
            && (this.getRes1() == null ? other.getRes1() == null : this.getRes1().equals(other.getRes1()))
            && (this.getRes2() == null ? other.getRes2() == null : this.getRes2().equals(other.getRes2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRedbuyid() == null) ? 0 : getRedbuyid().hashCode());
        result = prime * result + ((getRedname() == null) ? 0 : getRedname().hashCode());
        result = prime * result + ((getProfpuid() == null) ? 0 : getProfpuid().hashCode());
        result = prime * result + ((getRedusetime() == null) ? 0 : getRedusetime().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getRedsendid() == null) ? 0 : getRedsendid().hashCode());
        result = prime * result + ((getRedmoney() == null) ? 0 : getRedmoney().hashCode());
        result = prime * result + ((getRes1() == null) ? 0 : getRes1().hashCode());
        result = prime * result + ((getRes2() == null) ? 0 : getRes2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", redbuyid=").append(redbuyid);
        sb.append(", redname=").append(redname);
        sb.append(", profpuid=").append(profpuid);
        sb.append(", redusetime=").append(redusetime);
        sb.append(", userid=").append(userid);
        sb.append(", redsendid=").append(redsendid);
        sb.append(", redmoney=").append(redmoney);
        sb.append(", res1=").append(res1);
        sb.append(", res2=").append(res2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}