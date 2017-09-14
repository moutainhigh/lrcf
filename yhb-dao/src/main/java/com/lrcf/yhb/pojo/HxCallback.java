package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.util.Date;

public class HxCallback implements Serializable {
    private Integer id;

    private String hxTrxId;

    private Date addTime;

    private String returnParams;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHxTrxId() {
        return hxTrxId;
    }

    public void setHxTrxId(String hxTrxId) {
        this.hxTrxId = hxTrxId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getReturnParams() {
        return returnParams;
    }

    public void setReturnParams(String returnParams) {
        this.returnParams = returnParams;
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
        HxCallback other = (HxCallback) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHxTrxId() == null ? other.getHxTrxId() == null : this.getHxTrxId().equals(other.getHxTrxId()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getReturnParams() == null ? other.getReturnParams() == null : this.getReturnParams().equals(other.getReturnParams()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHxTrxId() == null) ? 0 : getHxTrxId().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getReturnParams() == null) ? 0 : getReturnParams().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hxTrxId=").append(hxTrxId);
        sb.append(", addTime=").append(addTime);
        sb.append(", returnParams=").append(returnParams);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}