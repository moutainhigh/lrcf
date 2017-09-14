package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProfitTable implements Serializable {
    private Integer id;

    private String userid;

    private BigDecimal producttotal;

    private BigDecimal experiencetotal;

    private BigDecimal raisetotal;

    private BigDecimal hbtotal;

    private BigDecimal sharingtotal;

    private BigDecimal profittotal;

    private BigDecimal todayProducttotal;

    private BigDecimal todayExperiencetotal;

    private BigDecimal todayRaisetotal;

    private BigDecimal todayHbtotal;

    private BigDecimal todaySharingtotal;

    private BigDecimal totayProfittotal;

    private Date lastupdatetime;

    private BigDecimal shareAwardstotal;

    private BigDecimal todayShareAwardstotal;

    private BigDecimal redtotal;

    private BigDecimal todayRedtotal;

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

    public BigDecimal getProducttotal() {
        return producttotal;
    }

    public void setProducttotal(BigDecimal producttotal) {
        this.producttotal = producttotal;
    }

    public BigDecimal getExperiencetotal() {
        return experiencetotal;
    }

    public void setExperiencetotal(BigDecimal experiencetotal) {
        this.experiencetotal = experiencetotal;
    }

    public BigDecimal getRaisetotal() {
        return raisetotal;
    }

    public void setRaisetotal(BigDecimal raisetotal) {
        this.raisetotal = raisetotal;
    }

    public BigDecimal getHbtotal() {
        return hbtotal;
    }

    public void setHbtotal(BigDecimal hbtotal) {
        this.hbtotal = hbtotal;
    }

    public BigDecimal getSharingtotal() {
        return sharingtotal;
    }

    public void setSharingtotal(BigDecimal sharingtotal) {
        this.sharingtotal = sharingtotal;
    }

    public BigDecimal getProfittotal() {
        return profittotal;
    }

    public void setProfittotal(BigDecimal profittotal) {
        this.profittotal = profittotal;
    }

    public BigDecimal getTodayProducttotal() {
        return todayProducttotal;
    }

    public void setTodayProducttotal(BigDecimal todayProducttotal) {
        this.todayProducttotal = todayProducttotal;
    }

    public BigDecimal getTodayExperiencetotal() {
        return todayExperiencetotal;
    }

    public void setTodayExperiencetotal(BigDecimal todayExperiencetotal) {
        this.todayExperiencetotal = todayExperiencetotal;
    }

    public BigDecimal getTodayRaisetotal() {
        return todayRaisetotal;
    }

    public void setTodayRaisetotal(BigDecimal todayRaisetotal) {
        this.todayRaisetotal = todayRaisetotal;
    }

    public BigDecimal getTodayHbtotal() {
        return todayHbtotal;
    }

    public void setTodayHbtotal(BigDecimal todayHbtotal) {
        this.todayHbtotal = todayHbtotal;
    }

    public BigDecimal getTodaySharingtotal() {
        return todaySharingtotal;
    }

    public void setTodaySharingtotal(BigDecimal todaySharingtotal) {
        this.todaySharingtotal = todaySharingtotal;
    }

    public BigDecimal getTotayProfittotal() {
        return totayProfittotal;
    }

    public void setTotayProfittotal(BigDecimal totayProfittotal) {
        this.totayProfittotal = totayProfittotal;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public BigDecimal getShareAwardstotal() {
        return shareAwardstotal;
    }

    public void setShareAwardstotal(BigDecimal shareAwardstotal) {
        this.shareAwardstotal = shareAwardstotal;
    }

    public BigDecimal getTodayShareAwardstotal() {
        return todayShareAwardstotal;
    }

    public void setTodayShareAwardstotal(BigDecimal todayShareAwardstotal) {
        this.todayShareAwardstotal = todayShareAwardstotal;
    }

    public BigDecimal getRedtotal() {
        return redtotal;
    }

    public void setRedtotal(BigDecimal redtotal) {
        this.redtotal = redtotal;
    }

    public BigDecimal getTodayRedtotal() {
        return todayRedtotal;
    }

    public void setTodayRedtotal(BigDecimal todayRedtotal) {
        this.todayRedtotal = todayRedtotal;
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
        ProfitTable other = (ProfitTable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getProducttotal() == null ? other.getProducttotal() == null : this.getProducttotal().equals(other.getProducttotal()))
            && (this.getExperiencetotal() == null ? other.getExperiencetotal() == null : this.getExperiencetotal().equals(other.getExperiencetotal()))
            && (this.getRaisetotal() == null ? other.getRaisetotal() == null : this.getRaisetotal().equals(other.getRaisetotal()))
            && (this.getHbtotal() == null ? other.getHbtotal() == null : this.getHbtotal().equals(other.getHbtotal()))
            && (this.getSharingtotal() == null ? other.getSharingtotal() == null : this.getSharingtotal().equals(other.getSharingtotal()))
            && (this.getProfittotal() == null ? other.getProfittotal() == null : this.getProfittotal().equals(other.getProfittotal()))
            && (this.getTodayProducttotal() == null ? other.getTodayProducttotal() == null : this.getTodayProducttotal().equals(other.getTodayProducttotal()))
            && (this.getTodayExperiencetotal() == null ? other.getTodayExperiencetotal() == null : this.getTodayExperiencetotal().equals(other.getTodayExperiencetotal()))
            && (this.getTodayRaisetotal() == null ? other.getTodayRaisetotal() == null : this.getTodayRaisetotal().equals(other.getTodayRaisetotal()))
            && (this.getTodayHbtotal() == null ? other.getTodayHbtotal() == null : this.getTodayHbtotal().equals(other.getTodayHbtotal()))
            && (this.getTodaySharingtotal() == null ? other.getTodaySharingtotal() == null : this.getTodaySharingtotal().equals(other.getTodaySharingtotal()))
            && (this.getTotayProfittotal() == null ? other.getTotayProfittotal() == null : this.getTotayProfittotal().equals(other.getTotayProfittotal()))
            && (this.getLastupdatetime() == null ? other.getLastupdatetime() == null : this.getLastupdatetime().equals(other.getLastupdatetime()))
            && (this.getShareAwardstotal() == null ? other.getShareAwardstotal() == null : this.getShareAwardstotal().equals(other.getShareAwardstotal()))
            && (this.getTodayShareAwardstotal() == null ? other.getTodayShareAwardstotal() == null : this.getTodayShareAwardstotal().equals(other.getTodayShareAwardstotal()))
            && (this.getRedtotal() == null ? other.getRedtotal() == null : this.getRedtotal().equals(other.getRedtotal()))
            && (this.getTodayRedtotal() == null ? other.getTodayRedtotal() == null : this.getTodayRedtotal().equals(other.getTodayRedtotal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getProducttotal() == null) ? 0 : getProducttotal().hashCode());
        result = prime * result + ((getExperiencetotal() == null) ? 0 : getExperiencetotal().hashCode());
        result = prime * result + ((getRaisetotal() == null) ? 0 : getRaisetotal().hashCode());
        result = prime * result + ((getHbtotal() == null) ? 0 : getHbtotal().hashCode());
        result = prime * result + ((getSharingtotal() == null) ? 0 : getSharingtotal().hashCode());
        result = prime * result + ((getProfittotal() == null) ? 0 : getProfittotal().hashCode());
        result = prime * result + ((getTodayProducttotal() == null) ? 0 : getTodayProducttotal().hashCode());
        result = prime * result + ((getTodayExperiencetotal() == null) ? 0 : getTodayExperiencetotal().hashCode());
        result = prime * result + ((getTodayRaisetotal() == null) ? 0 : getTodayRaisetotal().hashCode());
        result = prime * result + ((getTodayHbtotal() == null) ? 0 : getTodayHbtotal().hashCode());
        result = prime * result + ((getTodaySharingtotal() == null) ? 0 : getTodaySharingtotal().hashCode());
        result = prime * result + ((getTotayProfittotal() == null) ? 0 : getTotayProfittotal().hashCode());
        result = prime * result + ((getLastupdatetime() == null) ? 0 : getLastupdatetime().hashCode());
        result = prime * result + ((getShareAwardstotal() == null) ? 0 : getShareAwardstotal().hashCode());
        result = prime * result + ((getTodayShareAwardstotal() == null) ? 0 : getTodayShareAwardstotal().hashCode());
        result = prime * result + ((getRedtotal() == null) ? 0 : getRedtotal().hashCode());
        result = prime * result + ((getTodayRedtotal() == null) ? 0 : getTodayRedtotal().hashCode());
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
        sb.append(", producttotal=").append(producttotal);
        sb.append(", experiencetotal=").append(experiencetotal);
        sb.append(", raisetotal=").append(raisetotal);
        sb.append(", hbtotal=").append(hbtotal);
        sb.append(", sharingtotal=").append(sharingtotal);
        sb.append(", profittotal=").append(profittotal);
        sb.append(", todayProducttotal=").append(todayProducttotal);
        sb.append(", todayExperiencetotal=").append(todayExperiencetotal);
        sb.append(", todayRaisetotal=").append(todayRaisetotal);
        sb.append(", todayHbtotal=").append(todayHbtotal);
        sb.append(", todaySharingtotal=").append(todaySharingtotal);
        sb.append(", totayProfittotal=").append(totayProfittotal);
        sb.append(", lastupdatetime=").append(lastupdatetime);
        sb.append(", shareAwardstotal=").append(shareAwardstotal);
        sb.append(", todayShareAwardstotal=").append(todayShareAwardstotal);
        sb.append(", redtotal=").append(redtotal);
        sb.append(", todayRedtotal=").append(todayRedtotal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}