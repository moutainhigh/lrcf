package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DealOrder implements Serializable {
    private String ordernumber;

    private String orderid;

    private BigDecimal ordermoney;

    private Integer orderstate;

    private Integer channelid;

    private BigDecimal interfacepercentage;

    private String interfacename;

    private BigDecimal channelpercentage;

    private String channelname;

    private String payitem;

    private String employeeid;

    private BigDecimal employeepercentage;

    private BigDecimal othermoney;

    private Date createtime;

    private String userid;

    private Date checktime;

    private String checkid;

    private String checkorderid;

    private String remark;

    private Date returntime;

    private String returninterfaceordernumber;

    private String returnbankordernumber;

    private String returnmessage;

    private String platid;

    private String liftcycle;

    private String lifttime;
    
    private String userName;

    private static final long serialVersionUID = 1L;

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public BigDecimal getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(BigDecimal ordermoney) {
        this.ordermoney = ordermoney;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    public Integer getChannelid() {
        return channelid;
    }

    public void setChannelid(Integer channelid) {
        this.channelid = channelid;
    }

    public BigDecimal getInterfacepercentage() {
        return interfacepercentage;
    }

    public void setInterfacepercentage(BigDecimal interfacepercentage) {
        this.interfacepercentage = interfacepercentage;
    }

    public String getInterfacename() {
        return interfacename;
    }

    public void setInterfacename(String interfacename) {
        this.interfacename = interfacename;
    }

    public BigDecimal getChannelpercentage() {
        return channelpercentage;
    }

    public void setChannelpercentage(BigDecimal channelpercentage) {
        this.channelpercentage = channelpercentage;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public String getPayitem() {
        return payitem;
    }

    public void setPayitem(String payitem) {
        this.payitem = payitem;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public BigDecimal getEmployeepercentage() {
        return employeepercentage;
    }

    public void setEmployeepercentage(BigDecimal employeepercentage) {
        this.employeepercentage = employeepercentage;
    }

    public BigDecimal getOthermoney() {
        return othermoney;
    }

    public void setOthermoney(BigDecimal othermoney) {
        this.othermoney = othermoney;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public String getCheckid() {
        return checkid;
    }

    public void setCheckid(String checkid) {
        this.checkid = checkid;
    }

    public String getCheckorderid() {
        return checkorderid;
    }

    public void setCheckorderid(String checkorderid) {
        this.checkorderid = checkorderid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public String getReturninterfaceordernumber() {
        return returninterfaceordernumber;
    }

    public void setReturninterfaceordernumber(String returninterfaceordernumber) {
        this.returninterfaceordernumber = returninterfaceordernumber;
    }

    public String getReturnbankordernumber() {
        return returnbankordernumber;
    }

    public void setReturnbankordernumber(String returnbankordernumber) {
        this.returnbankordernumber = returnbankordernumber;
    }

    public String getReturnmessage() {
        return returnmessage;
    }

    public void setReturnmessage(String returnmessage) {
        this.returnmessage = returnmessage;
    }

    public String getPlatid() {
        return platid;
    }

    public void setPlatid(String platid) {
        this.platid = platid;
    }

    public String getLiftcycle() {
        return liftcycle;
    }

    public void setLiftcycle(String liftcycle) {
        this.liftcycle = liftcycle;
    }

    public String getLifttime() {
        return lifttime;
    }

    public void setLifttime(String lifttime) {
        this.lifttime = lifttime;
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
        DealOrder other = (DealOrder) that;
        return (this.getOrdernumber() == null ? other.getOrdernumber() == null : this.getOrdernumber().equals(other.getOrdernumber()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getOrdermoney() == null ? other.getOrdermoney() == null : this.getOrdermoney().equals(other.getOrdermoney()))
            && (this.getOrderstate() == null ? other.getOrderstate() == null : this.getOrderstate().equals(other.getOrderstate()))
            && (this.getChannelid() == null ? other.getChannelid() == null : this.getChannelid().equals(other.getChannelid()))
            && (this.getInterfacepercentage() == null ? other.getInterfacepercentage() == null : this.getInterfacepercentage().equals(other.getInterfacepercentage()))
            && (this.getInterfacename() == null ? other.getInterfacename() == null : this.getInterfacename().equals(other.getInterfacename()))
            && (this.getChannelpercentage() == null ? other.getChannelpercentage() == null : this.getChannelpercentage().equals(other.getChannelpercentage()))
            && (this.getChannelname() == null ? other.getChannelname() == null : this.getChannelname().equals(other.getChannelname()))
            && (this.getPayitem() == null ? other.getPayitem() == null : this.getPayitem().equals(other.getPayitem()))
            && (this.getEmployeeid() == null ? other.getEmployeeid() == null : this.getEmployeeid().equals(other.getEmployeeid()))
            && (this.getEmployeepercentage() == null ? other.getEmployeepercentage() == null : this.getEmployeepercentage().equals(other.getEmployeepercentage()))
            && (this.getOthermoney() == null ? other.getOthermoney() == null : this.getOthermoney().equals(other.getOthermoney()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getChecktime() == null ? other.getChecktime() == null : this.getChecktime().equals(other.getChecktime()))
            && (this.getCheckid() == null ? other.getCheckid() == null : this.getCheckid().equals(other.getCheckid()))
            && (this.getCheckorderid() == null ? other.getCheckorderid() == null : this.getCheckorderid().equals(other.getCheckorderid()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getReturntime() == null ? other.getReturntime() == null : this.getReturntime().equals(other.getReturntime()))
            && (this.getReturninterfaceordernumber() == null ? other.getReturninterfaceordernumber() == null : this.getReturninterfaceordernumber().equals(other.getReturninterfaceordernumber()))
            && (this.getReturnbankordernumber() == null ? other.getReturnbankordernumber() == null : this.getReturnbankordernumber().equals(other.getReturnbankordernumber()))
            && (this.getReturnmessage() == null ? other.getReturnmessage() == null : this.getReturnmessage().equals(other.getReturnmessage()))
            && (this.getPlatid() == null ? other.getPlatid() == null : this.getPlatid().equals(other.getPlatid()))
            && (this.getLiftcycle() == null ? other.getLiftcycle() == null : this.getLiftcycle().equals(other.getLiftcycle()))
            && (this.getLifttime() == null ? other.getLifttime() == null : this.getLifttime().equals(other.getLifttime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrdernumber() == null) ? 0 : getOrdernumber().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getOrdermoney() == null) ? 0 : getOrdermoney().hashCode());
        result = prime * result + ((getOrderstate() == null) ? 0 : getOrderstate().hashCode());
        result = prime * result + ((getChannelid() == null) ? 0 : getChannelid().hashCode());
        result = prime * result + ((getInterfacepercentage() == null) ? 0 : getInterfacepercentage().hashCode());
        result = prime * result + ((getInterfacename() == null) ? 0 : getInterfacename().hashCode());
        result = prime * result + ((getChannelpercentage() == null) ? 0 : getChannelpercentage().hashCode());
        result = prime * result + ((getChannelname() == null) ? 0 : getChannelname().hashCode());
        result = prime * result + ((getPayitem() == null) ? 0 : getPayitem().hashCode());
        result = prime * result + ((getEmployeeid() == null) ? 0 : getEmployeeid().hashCode());
        result = prime * result + ((getEmployeepercentage() == null) ? 0 : getEmployeepercentage().hashCode());
        result = prime * result + ((getOthermoney() == null) ? 0 : getOthermoney().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
        result = prime * result + ((getCheckid() == null) ? 0 : getCheckid().hashCode());
        result = prime * result + ((getCheckorderid() == null) ? 0 : getCheckorderid().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getReturntime() == null) ? 0 : getReturntime().hashCode());
        result = prime * result + ((getReturninterfaceordernumber() == null) ? 0 : getReturninterfaceordernumber().hashCode());
        result = prime * result + ((getReturnbankordernumber() == null) ? 0 : getReturnbankordernumber().hashCode());
        result = prime * result + ((getReturnmessage() == null) ? 0 : getReturnmessage().hashCode());
        result = prime * result + ((getPlatid() == null) ? 0 : getPlatid().hashCode());
        result = prime * result + ((getLiftcycle() == null) ? 0 : getLiftcycle().hashCode());
        result = prime * result + ((getLifttime() == null) ? 0 : getLifttime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ordernumber=").append(ordernumber);
        sb.append(", orderid=").append(orderid);
        sb.append(", ordermoney=").append(ordermoney);
        sb.append(", orderstate=").append(orderstate);
        sb.append(", channelid=").append(channelid);
        sb.append(", interfacepercentage=").append(interfacepercentage);
        sb.append(", interfacename=").append(interfacename);
        sb.append(", channelpercentage=").append(channelpercentage);
        sb.append(", channelname=").append(channelname);
        sb.append(", payitem=").append(payitem);
        sb.append(", employeeid=").append(employeeid);
        sb.append(", employeepercentage=").append(employeepercentage);
        sb.append(", othermoney=").append(othermoney);
        sb.append(", createtime=").append(createtime);
        sb.append(", userid=").append(userid);
        sb.append(", checktime=").append(checktime);
        sb.append(", checkid=").append(checkid);
        sb.append(", checkorderid=").append(checkorderid);
        sb.append(", remark=").append(remark);
        sb.append(", returntime=").append(returntime);
        sb.append(", returninterfaceordernumber=").append(returninterfaceordernumber);
        sb.append(", returnbankordernumber=").append(returnbankordernumber);
        sb.append(", returnmessage=").append(returnmessage);
        sb.append(", platid=").append(platid);
        sb.append(", liftcycle=").append(liftcycle);
        sb.append(", lifttime=").append(lifttime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}