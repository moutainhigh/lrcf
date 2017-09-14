package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DealCheck implements Serializable {
    private String checkid;

    private String checknumber;

    private Integer checktype;

    private String userid;

    private String adminid;

    private String payname;

    private String paybank;

    private String paybanknumber;

    private BigDecimal payfeeinitial;

    private BigDecimal paymoney;

    private BigDecimal payfee;

    private BigDecimal othermoney;

    private String interfacename;

    private String channelname;

    private Integer checkstate;

    private Date createtime;

    private Date checktime;

    private String remark;

    private static final long serialVersionUID = 1L;

    public String getCheckid() {
        return checkid;
    }

    public void setCheckid(String checkid) {
        this.checkid = checkid;
    }

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }

    public Integer getChecktype() {
        return checktype;
    }

    public void setChecktype(Integer checktype) {
        this.checktype = checktype;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname;
    }

    public String getPaybank() {
        return paybank;
    }

    public void setPaybank(String paybank) {
        this.paybank = paybank;
    }

    public String getPaybanknumber() {
        return paybanknumber;
    }

    public void setPaybanknumber(String paybanknumber) {
        this.paybanknumber = paybanknumber;
    }

    public BigDecimal getPayfeeinitial() {
        return payfeeinitial;
    }

    public void setPayfeeinitial(BigDecimal payfeeinitial) {
        this.payfeeinitial = payfeeinitial;
    }

    public BigDecimal getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }

    public BigDecimal getPayfee() {
        return payfee;
    }

    public void setPayfee(BigDecimal payfee) {
        this.payfee = payfee;
    }

    public BigDecimal getOthermoney() {
        return othermoney;
    }

    public void setOthermoney(BigDecimal othermoney) {
        this.othermoney = othermoney;
    }

    public String getInterfacename() {
        return interfacename;
    }

    public void setInterfacename(String interfacename) {
        this.interfacename = interfacename;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public Integer getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(Integer checkstate) {
        this.checkstate = checkstate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        DealCheck other = (DealCheck) that;
        return (this.getCheckid() == null ? other.getCheckid() == null : this.getCheckid().equals(other.getCheckid()))
            && (this.getChecknumber() == null ? other.getChecknumber() == null : this.getChecknumber().equals(other.getChecknumber()))
            && (this.getChecktype() == null ? other.getChecktype() == null : this.getChecktype().equals(other.getChecktype()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getAdminid() == null ? other.getAdminid() == null : this.getAdminid().equals(other.getAdminid()))
            && (this.getPayname() == null ? other.getPayname() == null : this.getPayname().equals(other.getPayname()))
            && (this.getPaybank() == null ? other.getPaybank() == null : this.getPaybank().equals(other.getPaybank()))
            && (this.getPaybanknumber() == null ? other.getPaybanknumber() == null : this.getPaybanknumber().equals(other.getPaybanknumber()))
            && (this.getPayfeeinitial() == null ? other.getPayfeeinitial() == null : this.getPayfeeinitial().equals(other.getPayfeeinitial()))
            && (this.getPaymoney() == null ? other.getPaymoney() == null : this.getPaymoney().equals(other.getPaymoney()))
            && (this.getPayfee() == null ? other.getPayfee() == null : this.getPayfee().equals(other.getPayfee()))
            && (this.getOthermoney() == null ? other.getOthermoney() == null : this.getOthermoney().equals(other.getOthermoney()))
            && (this.getInterfacename() == null ? other.getInterfacename() == null : this.getInterfacename().equals(other.getInterfacename()))
            && (this.getChannelname() == null ? other.getChannelname() == null : this.getChannelname().equals(other.getChannelname()))
            && (this.getCheckstate() == null ? other.getCheckstate() == null : this.getCheckstate().equals(other.getCheckstate()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getChecktime() == null ? other.getChecktime() == null : this.getChecktime().equals(other.getChecktime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCheckid() == null) ? 0 : getCheckid().hashCode());
        result = prime * result + ((getChecknumber() == null) ? 0 : getChecknumber().hashCode());
        result = prime * result + ((getChecktype() == null) ? 0 : getChecktype().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getAdminid() == null) ? 0 : getAdminid().hashCode());
        result = prime * result + ((getPayname() == null) ? 0 : getPayname().hashCode());
        result = prime * result + ((getPaybank() == null) ? 0 : getPaybank().hashCode());
        result = prime * result + ((getPaybanknumber() == null) ? 0 : getPaybanknumber().hashCode());
        result = prime * result + ((getPayfeeinitial() == null) ? 0 : getPayfeeinitial().hashCode());
        result = prime * result + ((getPaymoney() == null) ? 0 : getPaymoney().hashCode());
        result = prime * result + ((getPayfee() == null) ? 0 : getPayfee().hashCode());
        result = prime * result + ((getOthermoney() == null) ? 0 : getOthermoney().hashCode());
        result = prime * result + ((getInterfacename() == null) ? 0 : getInterfacename().hashCode());
        result = prime * result + ((getChannelname() == null) ? 0 : getChannelname().hashCode());
        result = prime * result + ((getCheckstate() == null) ? 0 : getCheckstate().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkid=").append(checkid);
        sb.append(", checknumber=").append(checknumber);
        sb.append(", checktype=").append(checktype);
        sb.append(", userid=").append(userid);
        sb.append(", adminid=").append(adminid);
        sb.append(", payname=").append(payname);
        sb.append(", paybank=").append(paybank);
        sb.append(", paybanknumber=").append(paybanknumber);
        sb.append(", payfeeinitial=").append(payfeeinitial);
        sb.append(", paymoney=").append(paymoney);
        sb.append(", payfee=").append(payfee);
        sb.append(", othermoney=").append(othermoney);
        sb.append(", interfacename=").append(interfacename);
        sb.append(", channelname=").append(channelname);
        sb.append(", checkstate=").append(checkstate);
        sb.append(", createtime=").append(createtime);
        sb.append(", checktime=").append(checktime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}