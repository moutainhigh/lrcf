package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.util.Date;

public class BannerManage implements Serializable {
    private Integer id;

    private Byte type;

    private String logo;

    private String img;

    private String url;

    private Integer order;

    private Byte state;

    private Date createTime;

    private String emk1;

    private String emk2;

    private String emk3;

    private String emk4;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmk1() {
        return emk1;
    }

    public void setEmk1(String emk1) {
        this.emk1 = emk1;
    }

    public String getEmk2() {
        return emk2;
    }

    public void setEmk2(String emk2) {
        this.emk2 = emk2;
    }

    public String getEmk3() {
        return emk3;
    }

    public void setEmk3(String emk3) {
        this.emk3 = emk3;
    }

    public String getEmk4() {
        return emk4;
    }

    public void setEmk4(String emk4) {
        this.emk4 = emk4;
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
        BannerManage other = (BannerManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getOrder() == null ? other.getOrder() == null : this.getOrder().equals(other.getOrder()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEmk1() == null ? other.getEmk1() == null : this.getEmk1().equals(other.getEmk1()))
            && (this.getEmk2() == null ? other.getEmk2() == null : this.getEmk2().equals(other.getEmk2()))
            && (this.getEmk3() == null ? other.getEmk3() == null : this.getEmk3().equals(other.getEmk3()))
            && (this.getEmk4() == null ? other.getEmk4() == null : this.getEmk4().equals(other.getEmk4()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getEmk1() == null) ? 0 : getEmk1().hashCode());
        result = prime * result + ((getEmk2() == null) ? 0 : getEmk2().hashCode());
        result = prime * result + ((getEmk3() == null) ? 0 : getEmk3().hashCode());
        result = prime * result + ((getEmk4() == null) ? 0 : getEmk4().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", logo=").append(logo);
        sb.append(", img=").append(img);
        sb.append(", url=").append(url);
        sb.append(", order=").append(order);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", emk1=").append(emk1);
        sb.append(", emk2=").append(emk2);
        sb.append(", emk3=").append(emk3);
        sb.append(", emk4=").append(emk4);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}