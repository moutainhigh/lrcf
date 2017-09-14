package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.util.Date;

public class BaseNews implements Serializable {
    private Integer newsid;

    private Integer newstype;

    private String newstitle;

    private Date createtime;

    private Integer hitstimes;

    private String adminid;

    private Integer state;

    private String platid;

    private Boolean visible;

    private Boolean ispass;

    private String newscontent;

    private static final long serialVersionUID = 1L;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public Integer getNewstype() {
        return newstype;
    }

    public void setNewstype(Integer newstype) {
        this.newstype = newstype;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getHitstimes() {
        return hitstimes;
    }

    public void setHitstimes(Integer hitstimes) {
        this.hitstimes = hitstimes;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPlatid() {
        return platid;
    }

    public void setPlatid(String platid) {
        this.platid = platid;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getIspass() {
        return ispass;
    }

    public void setIspass(Boolean ispass) {
        this.ispass = ispass;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent;
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
        BaseNews other = (BaseNews) that;
        return (this.getNewsid() == null ? other.getNewsid() == null : this.getNewsid().equals(other.getNewsid()))
            && (this.getNewstype() == null ? other.getNewstype() == null : this.getNewstype().equals(other.getNewstype()))
            && (this.getNewstitle() == null ? other.getNewstitle() == null : this.getNewstitle().equals(other.getNewstitle()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getHitstimes() == null ? other.getHitstimes() == null : this.getHitstimes().equals(other.getHitstimes()))
            && (this.getAdminid() == null ? other.getAdminid() == null : this.getAdminid().equals(other.getAdminid()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getPlatid() == null ? other.getPlatid() == null : this.getPlatid().equals(other.getPlatid()))
            && (this.getVisible() == null ? other.getVisible() == null : this.getVisible().equals(other.getVisible()))
            && (this.getIspass() == null ? other.getIspass() == null : this.getIspass().equals(other.getIspass()))
            && (this.getNewscontent() == null ? other.getNewscontent() == null : this.getNewscontent().equals(other.getNewscontent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNewsid() == null) ? 0 : getNewsid().hashCode());
        result = prime * result + ((getNewstype() == null) ? 0 : getNewstype().hashCode());
        result = prime * result + ((getNewstitle() == null) ? 0 : getNewstitle().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getHitstimes() == null) ? 0 : getHitstimes().hashCode());
        result = prime * result + ((getAdminid() == null) ? 0 : getAdminid().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getPlatid() == null) ? 0 : getPlatid().hashCode());
        result = prime * result + ((getVisible() == null) ? 0 : getVisible().hashCode());
        result = prime * result + ((getIspass() == null) ? 0 : getIspass().hashCode());
        result = prime * result + ((getNewscontent() == null) ? 0 : getNewscontent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsid=").append(newsid);
        sb.append(", newstype=").append(newstype);
        sb.append(", newstitle=").append(newstitle);
        sb.append(", createtime=").append(createtime);
        sb.append(", hitstimes=").append(hitstimes);
        sb.append(", adminid=").append(adminid);
        sb.append(", state=").append(state);
        sb.append(", platid=").append(platid);
        sb.append(", visible=").append(visible);
        sb.append(", ispass=").append(ispass);
        sb.append(", newscontent=").append(newscontent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}