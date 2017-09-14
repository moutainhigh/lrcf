package com.lrcf.yhb.pojo;

import java.io.Serializable;

public class BaseInterfaceBank implements Serializable {
    private Integer id;

    private String interfaceid;

    private String banknum;

    private Boolean isopen;

    private Integer sort;

    private String remark;

    private Integer channelid;

    private String cardtype;

    private String cardbankcolorimg;

    private String cradbanklogimg;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterfaceid() {
        return interfaceid;
    }

    public void setInterfaceid(String interfaceid) {
        this.interfaceid = interfaceid;
    }

    public String getBanknum() {
        return banknum;
    }

    public void setBanknum(String banknum) {
        this.banknum = banknum;
    }

    public Boolean getIsopen() {
        return isopen;
    }

    public void setIsopen(Boolean isopen) {
        this.isopen = isopen;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getChannelid() {
        return channelid;
    }

    public void setChannelid(Integer channelid) {
        this.channelid = channelid;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardbankcolorimg() {
        return cardbankcolorimg;
    }

    public void setCardbankcolorimg(String cardbankcolorimg) {
        this.cardbankcolorimg = cardbankcolorimg;
    }

    public String getCradbanklogimg() {
        return cradbanklogimg;
    }

    public void setCradbanklogimg(String cradbanklogimg) {
        this.cradbanklogimg = cradbanklogimg;
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
        BaseInterfaceBank other = (BaseInterfaceBank) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInterfaceid() == null ? other.getInterfaceid() == null : this.getInterfaceid().equals(other.getInterfaceid()))
            && (this.getBanknum() == null ? other.getBanknum() == null : this.getBanknum().equals(other.getBanknum()))
            && (this.getIsopen() == null ? other.getIsopen() == null : this.getIsopen().equals(other.getIsopen()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getChannelid() == null ? other.getChannelid() == null : this.getChannelid().equals(other.getChannelid()))
            && (this.getCardtype() == null ? other.getCardtype() == null : this.getCardtype().equals(other.getCardtype()))
            && (this.getCardbankcolorimg() == null ? other.getCardbankcolorimg() == null : this.getCardbankcolorimg().equals(other.getCardbankcolorimg()))
            && (this.getCradbanklogimg() == null ? other.getCradbanklogimg() == null : this.getCradbanklogimg().equals(other.getCradbanklogimg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInterfaceid() == null) ? 0 : getInterfaceid().hashCode());
        result = prime * result + ((getBanknum() == null) ? 0 : getBanknum().hashCode());
        result = prime * result + ((getIsopen() == null) ? 0 : getIsopen().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getChannelid() == null) ? 0 : getChannelid().hashCode());
        result = prime * result + ((getCardtype() == null) ? 0 : getCardtype().hashCode());
        result = prime * result + ((getCardbankcolorimg() == null) ? 0 : getCardbankcolorimg().hashCode());
        result = prime * result + ((getCradbanklogimg() == null) ? 0 : getCradbanklogimg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", interfaceid=").append(interfaceid);
        sb.append(", banknum=").append(banknum);
        sb.append(", isopen=").append(isopen);
        sb.append(", sort=").append(sort);
        sb.append(", remark=").append(remark);
        sb.append(", channelid=").append(channelid);
        sb.append(", cardtype=").append(cardtype);
        sb.append(", cardbankcolorimg=").append(cardbankcolorimg);
        sb.append(", cradbanklogimg=").append(cradbanklogimg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}