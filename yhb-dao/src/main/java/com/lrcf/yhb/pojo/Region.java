package com.lrcf.yhb.pojo;

import java.io.Serializable;

public class Region implements Serializable {
    private Double regionId;

    private String regionCode;

    private String regionName;

    private Double parentId;

    private Double regionLevel;

    private Double regionOrder;

    private String regionNameEn;

    private String regionShortnameEn;

    private Integer level;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Double getRegionId() {
        return regionId;
    }

    public void setRegionId(Double regionId) {
        this.regionId = regionId;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Double getParentId() {
        return parentId;
    }

    public void setParentId(Double parentId) {
        this.parentId = parentId;
    }

    public Double getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Double regionLevel) {
        this.regionLevel = regionLevel;
    }

    public Double getRegionOrder() {
        return regionOrder;
    }

    public void setRegionOrder(Double regionOrder) {
        this.regionOrder = regionOrder;
    }

    public String getRegionNameEn() {
        return regionNameEn;
    }

    public void setRegionNameEn(String regionNameEn) {
        this.regionNameEn = regionNameEn;
    }

    public String getRegionShortnameEn() {
        return regionShortnameEn;
    }

    public void setRegionShortnameEn(String regionShortnameEn) {
        this.regionShortnameEn = regionShortnameEn;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        Region other = (Region) that;
        return (this.getRegionId() == null ? other.getRegionId() == null : this.getRegionId().equals(other.getRegionId()))
            && (this.getRegionCode() == null ? other.getRegionCode() == null : this.getRegionCode().equals(other.getRegionCode()))
            && (this.getRegionName() == null ? other.getRegionName() == null : this.getRegionName().equals(other.getRegionName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getRegionLevel() == null ? other.getRegionLevel() == null : this.getRegionLevel().equals(other.getRegionLevel()))
            && (this.getRegionOrder() == null ? other.getRegionOrder() == null : this.getRegionOrder().equals(other.getRegionOrder()))
            && (this.getRegionNameEn() == null ? other.getRegionNameEn() == null : this.getRegionNameEn().equals(other.getRegionNameEn()))
            && (this.getRegionShortnameEn() == null ? other.getRegionShortnameEn() == null : this.getRegionShortnameEn().equals(other.getRegionShortnameEn()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRegionId() == null) ? 0 : getRegionId().hashCode());
        result = prime * result + ((getRegionCode() == null) ? 0 : getRegionCode().hashCode());
        result = prime * result + ((getRegionName() == null) ? 0 : getRegionName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getRegionLevel() == null) ? 0 : getRegionLevel().hashCode());
        result = prime * result + ((getRegionOrder() == null) ? 0 : getRegionOrder().hashCode());
        result = prime * result + ((getRegionNameEn() == null) ? 0 : getRegionNameEn().hashCode());
        result = prime * result + ((getRegionShortnameEn() == null) ? 0 : getRegionShortnameEn().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", regionId=").append(regionId);
        sb.append(", regionCode=").append(regionCode);
        sb.append(", regionName=").append(regionName);
        sb.append(", parentId=").append(parentId);
        sb.append(", regionLevel=").append(regionLevel);
        sb.append(", regionOrder=").append(regionOrder);
        sb.append(", regionNameEn=").append(regionNameEn);
        sb.append(", regionShortnameEn=").append(regionShortnameEn);
        sb.append(", level=").append(level);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}