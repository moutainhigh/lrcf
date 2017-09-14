package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExperienceCP implements Serializable {
    private Integer experiencecpid;

    private String productid;

    private BigDecimal experiencecprate;

    private Date experiencecpaddtime;

    private Integer experiencecptimes;

    private BigDecimal experiencecpcountmoeny;

    private BigDecimal experiencecpcountrate;

    private String experiencecpname;

    private String experiencecpimg;

    private String experiencecpdes;

    private String experiencecpemK1;

    private String experiencecpemK2;

    private String experiencecpemK3;

    private static final long serialVersionUID = 1L;

    public Integer getExperiencecpid() {
        return experiencecpid;
    }

    public void setExperiencecpid(Integer experiencecpid) {
        this.experiencecpid = experiencecpid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public BigDecimal getExperiencecprate() {
        return experiencecprate;
    }

    public void setExperiencecprate(BigDecimal experiencecprate) {
        this.experiencecprate = experiencecprate;
    }

    public Date getExperiencecpaddtime() {
        return experiencecpaddtime;
    }

    public void setExperiencecpaddtime(Date experiencecpaddtime) {
        this.experiencecpaddtime = experiencecpaddtime;
    }

    public Integer getExperiencecptimes() {
        return experiencecptimes;
    }

    public void setExperiencecptimes(Integer experiencecptimes) {
        this.experiencecptimes = experiencecptimes;
    }

    public BigDecimal getExperiencecpcountmoeny() {
        return experiencecpcountmoeny;
    }

    public void setExperiencecpcountmoeny(BigDecimal experiencecpcountmoeny) {
        this.experiencecpcountmoeny = experiencecpcountmoeny;
    }

    public BigDecimal getExperiencecpcountrate() {
        return experiencecpcountrate;
    }

    public void setExperiencecpcountrate(BigDecimal experiencecpcountrate) {
        this.experiencecpcountrate = experiencecpcountrate;
    }

    public String getExperiencecpname() {
        return experiencecpname;
    }

    public void setExperiencecpname(String experiencecpname) {
        this.experiencecpname = experiencecpname;
    }

    public String getExperiencecpimg() {
        return experiencecpimg;
    }

    public void setExperiencecpimg(String experiencecpimg) {
        this.experiencecpimg = experiencecpimg;
    }

    public String getExperiencecpdes() {
        return experiencecpdes;
    }

    public void setExperiencecpdes(String experiencecpdes) {
        this.experiencecpdes = experiencecpdes;
    }

    public String getExperiencecpemK1() {
        return experiencecpemK1;
    }

    public void setExperiencecpemK1(String experiencecpemK1) {
        this.experiencecpemK1 = experiencecpemK1;
    }

    public String getExperiencecpemK2() {
        return experiencecpemK2;
    }

    public void setExperiencecpemK2(String experiencecpemK2) {
        this.experiencecpemK2 = experiencecpemK2;
    }

    public String getExperiencecpemK3() {
        return experiencecpemK3;
    }

    public void setExperiencecpemK3(String experiencecpemK3) {
        this.experiencecpemK3 = experiencecpemK3;
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
        ExperienceCP other = (ExperienceCP) that;
        return (this.getExperiencecpid() == null ? other.getExperiencecpid() == null : this.getExperiencecpid().equals(other.getExperiencecpid()))
            && (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getExperiencecprate() == null ? other.getExperiencecprate() == null : this.getExperiencecprate().equals(other.getExperiencecprate()))
            && (this.getExperiencecpaddtime() == null ? other.getExperiencecpaddtime() == null : this.getExperiencecpaddtime().equals(other.getExperiencecpaddtime()))
            && (this.getExperiencecptimes() == null ? other.getExperiencecptimes() == null : this.getExperiencecptimes().equals(other.getExperiencecptimes()))
            && (this.getExperiencecpcountmoeny() == null ? other.getExperiencecpcountmoeny() == null : this.getExperiencecpcountmoeny().equals(other.getExperiencecpcountmoeny()))
            && (this.getExperiencecpcountrate() == null ? other.getExperiencecpcountrate() == null : this.getExperiencecpcountrate().equals(other.getExperiencecpcountrate()))
            && (this.getExperiencecpname() == null ? other.getExperiencecpname() == null : this.getExperiencecpname().equals(other.getExperiencecpname()))
            && (this.getExperiencecpimg() == null ? other.getExperiencecpimg() == null : this.getExperiencecpimg().equals(other.getExperiencecpimg()))
            && (this.getExperiencecpdes() == null ? other.getExperiencecpdes() == null : this.getExperiencecpdes().equals(other.getExperiencecpdes()))
            && (this.getExperiencecpemK1() == null ? other.getExperiencecpemK1() == null : this.getExperiencecpemK1().equals(other.getExperiencecpemK1()))
            && (this.getExperiencecpemK2() == null ? other.getExperiencecpemK2() == null : this.getExperiencecpemK2().equals(other.getExperiencecpemK2()))
            && (this.getExperiencecpemK3() == null ? other.getExperiencecpemK3() == null : this.getExperiencecpemK3().equals(other.getExperiencecpemK3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExperiencecpid() == null) ? 0 : getExperiencecpid().hashCode());
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getExperiencecprate() == null) ? 0 : getExperiencecprate().hashCode());
        result = prime * result + ((getExperiencecpaddtime() == null) ? 0 : getExperiencecpaddtime().hashCode());
        result = prime * result + ((getExperiencecptimes() == null) ? 0 : getExperiencecptimes().hashCode());
        result = prime * result + ((getExperiencecpcountmoeny() == null) ? 0 : getExperiencecpcountmoeny().hashCode());
        result = prime * result + ((getExperiencecpcountrate() == null) ? 0 : getExperiencecpcountrate().hashCode());
        result = prime * result + ((getExperiencecpname() == null) ? 0 : getExperiencecpname().hashCode());
        result = prime * result + ((getExperiencecpimg() == null) ? 0 : getExperiencecpimg().hashCode());
        result = prime * result + ((getExperiencecpdes() == null) ? 0 : getExperiencecpdes().hashCode());
        result = prime * result + ((getExperiencecpemK1() == null) ? 0 : getExperiencecpemK1().hashCode());
        result = prime * result + ((getExperiencecpemK2() == null) ? 0 : getExperiencecpemK2().hashCode());
        result = prime * result + ((getExperiencecpemK3() == null) ? 0 : getExperiencecpemK3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", experiencecpid=").append(experiencecpid);
        sb.append(", productid=").append(productid);
        sb.append(", experiencecprate=").append(experiencecprate);
        sb.append(", experiencecpaddtime=").append(experiencecpaddtime);
        sb.append(", experiencecptimes=").append(experiencecptimes);
        sb.append(", experiencecpcountmoeny=").append(experiencecpcountmoeny);
        sb.append(", experiencecpcountrate=").append(experiencecpcountrate);
        sb.append(", experiencecpname=").append(experiencecpname);
        sb.append(", experiencecpimg=").append(experiencecpimg);
        sb.append(", experiencecpdes=").append(experiencecpdes);
        sb.append(", experiencecpemK1=").append(experiencecpemK1);
        sb.append(", experiencecpemK2=").append(experiencecpemK2);
        sb.append(", experiencecpemK3=").append(experiencecpemK3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}