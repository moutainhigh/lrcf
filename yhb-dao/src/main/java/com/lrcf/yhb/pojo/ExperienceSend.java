package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExperienceSend implements Serializable {
    private Integer experiencesendid;

    private String fpid;

    private String userid;

    private Integer experienceid;

    private Date experiencesendtime;

    private Integer experiencesendisuse;

    private Date experiencesendusetime;

    private BigDecimal experiencerate;

    private BigDecimal experiencesendmoney;

    private String changecode;

    private String experiencesendemK1;

    private String experiencesendemK2;

    private static final long serialVersionUID = 1L;


    public ExperienceSend() {

    }

    /**
     * @Function: ExperienceSend.java
     * @Description:默认构造函数
     *
     * @param:参数描述
     * @version: v1.0.0
     * @author: Krx
     * @date: 2017年5月8日 下午12:08:01
     */
    public ExperienceSend(String fpid, String userid, Integer experienceid, Date experiencesendtime,
                          Integer experiencesendisuse, BigDecimal experiencerate,
                          BigDecimal experiencesendmoney,  String experiencesendemK1, String experiencesendemK2) {
        super();
        this.fpid = fpid;
        this.userid = userid;
        this.experienceid = experienceid;
        this.experiencesendtime = experiencesendtime;
        this.experiencesendisuse = experiencesendisuse;
        this.experiencerate = experiencerate;
        this.experiencesendmoney = experiencesendmoney;
        this.experiencesendemK1 = experiencesendemK1;
        this.experiencesendemK2 = experiencesendemK2;
    }

    public Integer getExperiencesendid() {
        return experiencesendid;
    }

    public void setExperiencesendid(Integer experiencesendid) {
        this.experiencesendid = experiencesendid;
    }

    public String getFpid() {
        return fpid;
    }

    public void setFpid(String fpid) {
        this.fpid = fpid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getExperienceid() {
        return experienceid;
    }

    public void setExperienceid(Integer experienceid) {
        this.experienceid = experienceid;
    }

    public Date getExperiencesendtime() {
        return experiencesendtime;
    }

    public void setExperiencesendtime(Date experiencesendtime) {
        this.experiencesendtime = experiencesendtime;
    }

    public Integer getExperiencesendisuse() {
        return experiencesendisuse;
    }

    public void setExperiencesendisuse(Integer experiencesendisuse) {
        this.experiencesendisuse = experiencesendisuse;
    }

    public Date getExperiencesendusetime() {
        return experiencesendusetime;
    }

    public void setExperiencesendusetime(Date experiencesendusetime) {
        this.experiencesendusetime = experiencesendusetime;
    }

    public BigDecimal getExperiencerate() {
        return experiencerate;
    }

    public void setExperiencerate(BigDecimal experiencerate) {
        this.experiencerate = experiencerate;
    }

    public BigDecimal getExperiencesendmoney() {
        return experiencesendmoney;
    }

    public void setExperiencesendmoney(BigDecimal experiencesendmoney) {
        this.experiencesendmoney = experiencesendmoney;
    }

    public String getChangecode() {
        return changecode;
    }

    public void setChangecode(String changecode) {
        this.changecode = changecode;
    }

    public String getExperiencesendemK1() {
        return experiencesendemK1;
    }

    public void setExperiencesendemK1(String experiencesendemK1) {
        this.experiencesendemK1 = experiencesendemK1;
    }

    public String getExperiencesendemK2() {
        return experiencesendemK2;
    }

    public void setExperiencesendemK2(String experiencesendemK2) {
        this.experiencesendemK2 = experiencesendemK2;
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
        ExperienceSend other = (ExperienceSend) that;
        return (this.getExperiencesendid() == null ? other.getExperiencesendid() == null : this.getExperiencesendid().equals(other.getExperiencesendid()))
            && (this.getFpid() == null ? other.getFpid() == null : this.getFpid().equals(other.getFpid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getExperienceid() == null ? other.getExperienceid() == null : this.getExperienceid().equals(other.getExperienceid()))
            && (this.getExperiencesendtime() == null ? other.getExperiencesendtime() == null : this.getExperiencesendtime().equals(other.getExperiencesendtime()))
            && (this.getExperiencesendisuse() == null ? other.getExperiencesendisuse() == null : this.getExperiencesendisuse().equals(other.getExperiencesendisuse()))
            && (this.getExperiencesendusetime() == null ? other.getExperiencesendusetime() == null : this.getExperiencesendusetime().equals(other.getExperiencesendusetime()))
            && (this.getExperiencerate() == null ? other.getExperiencerate() == null : this.getExperiencerate().equals(other.getExperiencerate()))
            && (this.getExperiencesendmoney() == null ? other.getExperiencesendmoney() == null : this.getExperiencesendmoney().equals(other.getExperiencesendmoney()))
            && (this.getChangecode() == null ? other.getChangecode() == null : this.getChangecode().equals(other.getChangecode()))
            && (this.getExperiencesendemK1() == null ? other.getExperiencesendemK1() == null : this.getExperiencesendemK1().equals(other.getExperiencesendemK1()))
            && (this.getExperiencesendemK2() == null ? other.getExperiencesendemK2() == null : this.getExperiencesendemK2().equals(other.getExperiencesendemK2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExperiencesendid() == null) ? 0 : getExperiencesendid().hashCode());
        result = prime * result + ((getFpid() == null) ? 0 : getFpid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getExperienceid() == null) ? 0 : getExperienceid().hashCode());
        result = prime * result + ((getExperiencesendtime() == null) ? 0 : getExperiencesendtime().hashCode());
        result = prime * result + ((getExperiencesendisuse() == null) ? 0 : getExperiencesendisuse().hashCode());
        result = prime * result + ((getExperiencesendusetime() == null) ? 0 : getExperiencesendusetime().hashCode());
        result = prime * result + ((getExperiencerate() == null) ? 0 : getExperiencerate().hashCode());
        result = prime * result + ((getExperiencesendmoney() == null) ? 0 : getExperiencesendmoney().hashCode());
        result = prime * result + ((getChangecode() == null) ? 0 : getChangecode().hashCode());
        result = prime * result + ((getExperiencesendemK1() == null) ? 0 : getExperiencesendemK1().hashCode());
        result = prime * result + ((getExperiencesendemK2() == null) ? 0 : getExperiencesendemK2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", experiencesendid=").append(experiencesendid);
        sb.append(", fpid=").append(fpid);
        sb.append(", userid=").append(userid);
        sb.append(", experienceid=").append(experienceid);
        sb.append(", experiencesendtime=").append(experiencesendtime);
        sb.append(", experiencesendisuse=").append(experiencesendisuse);
        sb.append(", experiencesendusetime=").append(experiencesendusetime);
        sb.append(", experiencerate=").append(experiencerate);
        sb.append(", experiencesendmoney=").append(experiencesendmoney);
        sb.append(", changecode=").append(changecode);
        sb.append(", experiencesendemK1=").append(experiencesendemK1);
        sb.append(", experiencesendemK2=").append(experiencesendemK2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}