package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExperienceuserBuycp implements Serializable {
    private Integer experienceusercpid;

    private String userid;

    private Integer experiencesendid;

    private String fproductscpid;

    private Integer experienceid;

    private Float experiencerate;

    private BigDecimal experiencemoney;

    private Integer experiencecountnum;

    private Integer experienceinnum;

    private BigDecimal experienceratemoney;

    private Date experienceratetime;

    private Date experienceemK5;

    private Integer experiencePastday;

    private BigDecimal experiencecountmoney;

    private String experienceusercpname;

    private String experienceemK1;

    private String experienceemK3;

    private String experienceemK4;

    private String experienceemK2;

    private static final long serialVersionUID = 1L;

    public Integer getExperienceusercpid() {
        return experienceusercpid;
    }

    public void setExperienceusercpid(Integer experienceusercpid) {
        this.experienceusercpid = experienceusercpid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getExperiencesendid() {
        return experiencesendid;
    }

    public void setExperiencesendid(Integer experiencesendid) {
        this.experiencesendid = experiencesendid;
    }

    public String getFproductscpid() {
        return fproductscpid;
    }

    public void setFproductscpid(String fproductscpid) {
        this.fproductscpid = fproductscpid;
    }

    public Integer getExperienceid() {
        return experienceid;
    }

    public void setExperienceid(Integer experienceid) {
        this.experienceid = experienceid;
    }

    public Float getExperiencerate() {
        return experiencerate;
    }

    public void setExperiencerate(Float experiencerate) {
        this.experiencerate = experiencerate;
    }

    public BigDecimal getExperiencemoney() {
        return experiencemoney;
    }

    public void setExperiencemoney(BigDecimal experiencemoney) {
        this.experiencemoney = experiencemoney;
    }

    public Integer getExperiencecountnum() {
        return experiencecountnum;
    }

    public void setExperiencecountnum(Integer experiencecountnum) {
        this.experiencecountnum = experiencecountnum;
    }

    public Integer getExperienceinnum() {
        return experienceinnum;
    }

    public void setExperienceinnum(Integer experienceinnum) {
        this.experienceinnum = experienceinnum;
    }

    public BigDecimal getExperienceratemoney() {
        return experienceratemoney;
    }

    public void setExperienceratemoney(BigDecimal experienceratemoney) {
        this.experienceratemoney = experienceratemoney;
    }

    public Date getExperienceratetime() {
        return experienceratetime;
    }

    public void setExperienceratetime(Date experienceratetime) {
        this.experienceratetime = experienceratetime;
    }

    public Date getExperienceemK5() {
        return experienceemK5;
    }

    public void setExperienceemK5(Date experienceemK5) {
        this.experienceemK5 = experienceemK5;
    }

    public Integer getExperiencePastday() {
        return experiencePastday;
    }

    public void setExperiencePastday(Integer experiencePastday) {
        this.experiencePastday = experiencePastday;
    }

    public BigDecimal getExperiencecountmoney() {
        return experiencecountmoney;
    }

    public void setExperiencecountmoney(BigDecimal experiencecountmoney) {
        this.experiencecountmoney = experiencecountmoney;
    }

    public String getExperienceusercpname() {
        return experienceusercpname;
    }

    public void setExperienceusercpname(String experienceusercpname) {
        this.experienceusercpname = experienceusercpname;
    }

    public String getExperienceemK1() {
        return experienceemK1;
    }

    public void setExperienceemK1(String experienceemK1) {
        this.experienceemK1 = experienceemK1;
    }

    public String getExperienceemK3() {
        return experienceemK3;
    }

    public void setExperienceemK3(String experienceemK3) {
        this.experienceemK3 = experienceemK3;
    }

    public String getExperienceemK4() {
        return experienceemK4;
    }

    public void setExperienceemK4(String experienceemK4) {
        this.experienceemK4 = experienceemK4;
    }

    public String getExperienceemK2() {
        return experienceemK2;
    }

    public void setExperienceemK2(String experienceemK2) {
        this.experienceemK2 = experienceemK2;
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
        ExperienceuserBuycp other = (ExperienceuserBuycp) that;
        return (this.getExperienceusercpid() == null ? other.getExperienceusercpid() == null : this.getExperienceusercpid().equals(other.getExperienceusercpid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getExperiencesendid() == null ? other.getExperiencesendid() == null : this.getExperiencesendid().equals(other.getExperiencesendid()))
            && (this.getFproductscpid() == null ? other.getFproductscpid() == null : this.getFproductscpid().equals(other.getFproductscpid()))
            && (this.getExperienceid() == null ? other.getExperienceid() == null : this.getExperienceid().equals(other.getExperienceid()))
            && (this.getExperiencerate() == null ? other.getExperiencerate() == null : this.getExperiencerate().equals(other.getExperiencerate()))
            && (this.getExperiencemoney() == null ? other.getExperiencemoney() == null : this.getExperiencemoney().equals(other.getExperiencemoney()))
            && (this.getExperiencecountnum() == null ? other.getExperiencecountnum() == null : this.getExperiencecountnum().equals(other.getExperiencecountnum()))
            && (this.getExperienceinnum() == null ? other.getExperienceinnum() == null : this.getExperienceinnum().equals(other.getExperienceinnum()))
            && (this.getExperienceratemoney() == null ? other.getExperienceratemoney() == null : this.getExperienceratemoney().equals(other.getExperienceratemoney()))
            && (this.getExperienceratetime() == null ? other.getExperienceratetime() == null : this.getExperienceratetime().equals(other.getExperienceratetime()))
            && (this.getExperienceemK5() == null ? other.getExperienceemK5() == null : this.getExperienceemK5().equals(other.getExperienceemK5()))
            && (this.getExperiencePastday() == null ? other.getExperiencePastday() == null : this.getExperiencePastday().equals(other.getExperiencePastday()))
            && (this.getExperiencecountmoney() == null ? other.getExperiencecountmoney() == null : this.getExperiencecountmoney().equals(other.getExperiencecountmoney()))
            && (this.getExperienceusercpname() == null ? other.getExperienceusercpname() == null : this.getExperienceusercpname().equals(other.getExperienceusercpname()))
            && (this.getExperienceemK1() == null ? other.getExperienceemK1() == null : this.getExperienceemK1().equals(other.getExperienceemK1()))
            && (this.getExperienceemK3() == null ? other.getExperienceemK3() == null : this.getExperienceemK3().equals(other.getExperienceemK3()))
            && (this.getExperienceemK4() == null ? other.getExperienceemK4() == null : this.getExperienceemK4().equals(other.getExperienceemK4()))
            && (this.getExperienceemK2() == null ? other.getExperienceemK2() == null : this.getExperienceemK2().equals(other.getExperienceemK2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExperienceusercpid() == null) ? 0 : getExperienceusercpid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getExperiencesendid() == null) ? 0 : getExperiencesendid().hashCode());
        result = prime * result + ((getFproductscpid() == null) ? 0 : getFproductscpid().hashCode());
        result = prime * result + ((getExperienceid() == null) ? 0 : getExperienceid().hashCode());
        result = prime * result + ((getExperiencerate() == null) ? 0 : getExperiencerate().hashCode());
        result = prime * result + ((getExperiencemoney() == null) ? 0 : getExperiencemoney().hashCode());
        result = prime * result + ((getExperiencecountnum() == null) ? 0 : getExperiencecountnum().hashCode());
        result = prime * result + ((getExperienceinnum() == null) ? 0 : getExperienceinnum().hashCode());
        result = prime * result + ((getExperienceratemoney() == null) ? 0 : getExperienceratemoney().hashCode());
        result = prime * result + ((getExperienceratetime() == null) ? 0 : getExperienceratetime().hashCode());
        result = prime * result + ((getExperienceemK5() == null) ? 0 : getExperienceemK5().hashCode());
        result = prime * result + ((getExperiencePastday() == null) ? 0 : getExperiencePastday().hashCode());
        result = prime * result + ((getExperiencecountmoney() == null) ? 0 : getExperiencecountmoney().hashCode());
        result = prime * result + ((getExperienceusercpname() == null) ? 0 : getExperienceusercpname().hashCode());
        result = prime * result + ((getExperienceemK1() == null) ? 0 : getExperienceemK1().hashCode());
        result = prime * result + ((getExperienceemK3() == null) ? 0 : getExperienceemK3().hashCode());
        result = prime * result + ((getExperienceemK4() == null) ? 0 : getExperienceemK4().hashCode());
        result = prime * result + ((getExperienceemK2() == null) ? 0 : getExperienceemK2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", experienceusercpid=").append(experienceusercpid);
        sb.append(", userid=").append(userid);
        sb.append(", experiencesendid=").append(experiencesendid);
        sb.append(", fproductscpid=").append(fproductscpid);
        sb.append(", experienceid=").append(experienceid);
        sb.append(", experiencerate=").append(experiencerate);
        sb.append(", experiencemoney=").append(experiencemoney);
        sb.append(", experiencecountnum=").append(experiencecountnum);
        sb.append(", experienceinnum=").append(experienceinnum);
        sb.append(", experienceratemoney=").append(experienceratemoney);
        sb.append(", experienceratetime=").append(experienceratetime);
        sb.append(", experienceemK5=").append(experienceemK5);
        sb.append(", experiencePastday=").append(experiencePastday);
        sb.append(", experiencecountmoney=").append(experiencecountmoney);
        sb.append(", experienceusercpname=").append(experienceusercpname);
        sb.append(", experienceemK1=").append(experienceemK1);
        sb.append(", experienceemK3=").append(experienceemK3);
        sb.append(", experienceemK4=").append(experienceemK4);
        sb.append(", experienceemK2=").append(experienceemK2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}