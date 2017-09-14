package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FinanceproductsExtract implements Serializable {
    private Integer fpeid;

    private BigDecimal extractmoney;

    private BigDecimal extractxmoney;

    private BigDecimal fproductsbuymoney;

    private Integer extractstate;

    private Date extracttimes;

    private Integer fpuid;

    private String fproductsname;

    private String userid;

    private Integer fproductsextractnum;

    private String extractemK1;

    private String extractemK2;

    private Integer extractdownnum;

    private Integer fpid;

    private static final long serialVersionUID = 1L;

    public Integer getFpeid() {
        return fpeid;
    }

    public void setFpeid(Integer fpeid) {
        this.fpeid = fpeid;
    }

    public BigDecimal getExtractmoney() {
        return extractmoney;
    }

    public void setExtractmoney(BigDecimal extractmoney) {
        this.extractmoney = extractmoney;
    }

    public BigDecimal getExtractxmoney() {
        return extractxmoney;
    }

    public void setExtractxmoney(BigDecimal extractxmoney) {
        this.extractxmoney = extractxmoney;
    }

    public BigDecimal getFproductsbuymoney() {
        return fproductsbuymoney;
    }

    public void setFproductsbuymoney(BigDecimal fproductsbuymoney) {
        this.fproductsbuymoney = fproductsbuymoney;
    }

    public Integer getExtractstate() {
        return extractstate;
    }

    public void setExtractstate(Integer extractstate) {
        this.extractstate = extractstate;
    }

    public Date getExtracttimes() {
        return extracttimes;
    }

    public void setExtracttimes(Date extracttimes) {
        this.extracttimes = extracttimes;
    }

    public Integer getFpuid() {
        return fpuid;
    }

    public void setFpuid(Integer fpuid) {
        this.fpuid = fpuid;
    }

    public String getFproductsname() {
        return fproductsname;
    }

    public void setFproductsname(String fproductsname) {
        this.fproductsname = fproductsname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getFproductsextractnum() {
        return fproductsextractnum;
    }

    public void setFproductsextractnum(Integer fproductsextractnum) {
        this.fproductsextractnum = fproductsextractnum;
    }

    public String getExtractemK1() {
        return extractemK1;
    }

    public void setExtractemK1(String extractemK1) {
        this.extractemK1 = extractemK1;
    }

    public String getExtractemK2() {
        return extractemK2;
    }

    public void setExtractemK2(String extractemK2) {
        this.extractemK2 = extractemK2;
    }

    public Integer getExtractdownnum() {
        return extractdownnum;
    }

    public void setExtractdownnum(Integer extractdownnum) {
        this.extractdownnum = extractdownnum;
    }

    public Integer getFpid() {
        return fpid;
    }

    public void setFpid(Integer fpid) {
        this.fpid = fpid;
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
        FinanceproductsExtract other = (FinanceproductsExtract) that;
        return (this.getFpeid() == null ? other.getFpeid() == null : this.getFpeid().equals(other.getFpeid()))
            && (this.getExtractmoney() == null ? other.getExtractmoney() == null : this.getExtractmoney().equals(other.getExtractmoney()))
            && (this.getExtractxmoney() == null ? other.getExtractxmoney() == null : this.getExtractxmoney().equals(other.getExtractxmoney()))
            && (this.getFproductsbuymoney() == null ? other.getFproductsbuymoney() == null : this.getFproductsbuymoney().equals(other.getFproductsbuymoney()))
            && (this.getExtractstate() == null ? other.getExtractstate() == null : this.getExtractstate().equals(other.getExtractstate()))
            && (this.getExtracttimes() == null ? other.getExtracttimes() == null : this.getExtracttimes().equals(other.getExtracttimes()))
            && (this.getFpuid() == null ? other.getFpuid() == null : this.getFpuid().equals(other.getFpuid()))
            && (this.getFproductsname() == null ? other.getFproductsname() == null : this.getFproductsname().equals(other.getFproductsname()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getFproductsextractnum() == null ? other.getFproductsextractnum() == null : this.getFproductsextractnum().equals(other.getFproductsextractnum()))
            && (this.getExtractemK1() == null ? other.getExtractemK1() == null : this.getExtractemK1().equals(other.getExtractemK1()))
            && (this.getExtractemK2() == null ? other.getExtractemK2() == null : this.getExtractemK2().equals(other.getExtractemK2()))
            && (this.getExtractdownnum() == null ? other.getExtractdownnum() == null : this.getExtractdownnum().equals(other.getExtractdownnum()))
            && (this.getFpid() == null ? other.getFpid() == null : this.getFpid().equals(other.getFpid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFpeid() == null) ? 0 : getFpeid().hashCode());
        result = prime * result + ((getExtractmoney() == null) ? 0 : getExtractmoney().hashCode());
        result = prime * result + ((getExtractxmoney() == null) ? 0 : getExtractxmoney().hashCode());
        result = prime * result + ((getFproductsbuymoney() == null) ? 0 : getFproductsbuymoney().hashCode());
        result = prime * result + ((getExtractstate() == null) ? 0 : getExtractstate().hashCode());
        result = prime * result + ((getExtracttimes() == null) ? 0 : getExtracttimes().hashCode());
        result = prime * result + ((getFpuid() == null) ? 0 : getFpuid().hashCode());
        result = prime * result + ((getFproductsname() == null) ? 0 : getFproductsname().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getFproductsextractnum() == null) ? 0 : getFproductsextractnum().hashCode());
        result = prime * result + ((getExtractemK1() == null) ? 0 : getExtractemK1().hashCode());
        result = prime * result + ((getExtractemK2() == null) ? 0 : getExtractemK2().hashCode());
        result = prime * result + ((getExtractdownnum() == null) ? 0 : getExtractdownnum().hashCode());
        result = prime * result + ((getFpid() == null) ? 0 : getFpid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fpeid=").append(fpeid);
        sb.append(", extractmoney=").append(extractmoney);
        sb.append(", extractxmoney=").append(extractxmoney);
        sb.append(", fproductsbuymoney=").append(fproductsbuymoney);
        sb.append(", extractstate=").append(extractstate);
        sb.append(", extracttimes=").append(extracttimes);
        sb.append(", fpuid=").append(fpuid);
        sb.append(", fproductsname=").append(fproductsname);
        sb.append(", userid=").append(userid);
        sb.append(", fproductsextractnum=").append(fproductsextractnum);
        sb.append(", extractemK1=").append(extractemK1);
        sb.append(", extractemK2=").append(extractemK2);
        sb.append(", extractdownnum=").append(extractdownnum);
        sb.append(", fpid=").append(fpid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}