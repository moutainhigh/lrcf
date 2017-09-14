package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DailyRevenue implements Serializable {
    private Integer id;

    private BigDecimal revenue;

    private Date recedate;

    private String mangetype;

    private String manageid;

    private Integer mnglevel;

    private String remark;

    private String lastrevenue;

    private String lastrecedate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public Date getRecedate() {
        return recedate;
    }

    public void setRecedate(Date recedate) {
        this.recedate = recedate;
    }

    public String getMangetype() {
        return mangetype;
    }

    public void setMangetype(String mangetype) {
        this.mangetype = mangetype;
    }

    public String getManageid() {
        return manageid;
    }

    public void setManageid(String manageid) {
        this.manageid = manageid;
    }

    public Integer getMnglevel() {
        return mnglevel;
    }

    public void setMnglevel(Integer mnglevel) {
        this.mnglevel = mnglevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLastrevenue() {
        return lastrevenue;
    }

    public void setLastrevenue(String lastrevenue) {
        this.lastrevenue = lastrevenue;
    }

    public String getLastrecedate() {
        return lastrecedate;
    }

    public void setLastrecedate(String lastrecedate) {
        this.lastrecedate = lastrecedate;
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
        DailyRevenue other = (DailyRevenue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRevenue() == null ? other.getRevenue() == null : this.getRevenue().equals(other.getRevenue()))
            && (this.getRecedate() == null ? other.getRecedate() == null : this.getRecedate().equals(other.getRecedate()))
            && (this.getMangetype() == null ? other.getMangetype() == null : this.getMangetype().equals(other.getMangetype()))
            && (this.getManageid() == null ? other.getManageid() == null : this.getManageid().equals(other.getManageid()))
            && (this.getMnglevel() == null ? other.getMnglevel() == null : this.getMnglevel().equals(other.getMnglevel()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getLastrevenue() == null ? other.getLastrevenue() == null : this.getLastrevenue().equals(other.getLastrevenue()))
            && (this.getLastrecedate() == null ? other.getLastrecedate() == null : this.getLastrecedate().equals(other.getLastrecedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRevenue() == null) ? 0 : getRevenue().hashCode());
        result = prime * result + ((getRecedate() == null) ? 0 : getRecedate().hashCode());
        result = prime * result + ((getMangetype() == null) ? 0 : getMangetype().hashCode());
        result = prime * result + ((getManageid() == null) ? 0 : getManageid().hashCode());
        result = prime * result + ((getMnglevel() == null) ? 0 : getMnglevel().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getLastrevenue() == null) ? 0 : getLastrevenue().hashCode());
        result = prime * result + ((getLastrecedate() == null) ? 0 : getLastrecedate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", revenue=").append(revenue);
        sb.append(", recedate=").append(recedate);
        sb.append(", mangetype=").append(mangetype);
        sb.append(", manageid=").append(manageid);
        sb.append(", mnglevel=").append(mnglevel);
        sb.append(", remark=").append(remark);
        sb.append(", lastrevenue=").append(lastrevenue);
        sb.append(", lastrecedate=").append(lastrecedate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}