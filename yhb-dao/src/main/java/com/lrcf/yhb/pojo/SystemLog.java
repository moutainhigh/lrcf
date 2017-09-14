package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SystemLog implements Serializable {
    private Integer id;

    private String userid;

    private String username;

    private String truename;

    private Date createtime;

    private Date endtime;

    private Integer isfallorok;

    private BigDecimal oldmoney;

    private BigDecimal changemoney;

    private BigDecimal newmoney;

    private String describee;

    private String emk1;

    private String emk2;

    private String emk3;

    private String classname;

    private String methodname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getIsfallorok() {
        return isfallorok;
    }

    public void setIsfallorok(Integer isfallorok) {
        this.isfallorok = isfallorok;
    }

    public BigDecimal getOldmoney() {
        return oldmoney;
    }

    public void setOldmoney(BigDecimal oldmoney) {
        this.oldmoney = oldmoney;
    }

    public BigDecimal getChangemoney() {
        return changemoney;
    }

    public void setChangemoney(BigDecimal changemoney) {
        this.changemoney = changemoney;
    }

    public BigDecimal getNewmoney() {
        return newmoney;
    }

    public void setNewmoney(BigDecimal newmoney) {
        this.newmoney = newmoney;
    }

    public String getDescribee() {
        return describee;
    }

    public void setDescribee(String describee) {
        this.describee = describee;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
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
        SystemLog other = (SystemLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getTruename() == null ? other.getTruename() == null : this.getTruename().equals(other.getTruename()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getIsfallorok() == null ? other.getIsfallorok() == null : this.getIsfallorok().equals(other.getIsfallorok()))
            && (this.getOldmoney() == null ? other.getOldmoney() == null : this.getOldmoney().equals(other.getOldmoney()))
            && (this.getChangemoney() == null ? other.getChangemoney() == null : this.getChangemoney().equals(other.getChangemoney()))
            && (this.getNewmoney() == null ? other.getNewmoney() == null : this.getNewmoney().equals(other.getNewmoney()))
            && (this.getDescribee() == null ? other.getDescribee() == null : this.getDescribee().equals(other.getDescribee()))
            && (this.getEmk1() == null ? other.getEmk1() == null : this.getEmk1().equals(other.getEmk1()))
            && (this.getEmk2() == null ? other.getEmk2() == null : this.getEmk2().equals(other.getEmk2()))
            && (this.getEmk3() == null ? other.getEmk3() == null : this.getEmk3().equals(other.getEmk3()))
            && (this.getClassname() == null ? other.getClassname() == null : this.getClassname().equals(other.getClassname()))
            && (this.getMethodname() == null ? other.getMethodname() == null : this.getMethodname().equals(other.getMethodname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getTruename() == null) ? 0 : getTruename().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getIsfallorok() == null) ? 0 : getIsfallorok().hashCode());
        result = prime * result + ((getOldmoney() == null) ? 0 : getOldmoney().hashCode());
        result = prime * result + ((getChangemoney() == null) ? 0 : getChangemoney().hashCode());
        result = prime * result + ((getNewmoney() == null) ? 0 : getNewmoney().hashCode());
        result = prime * result + ((getDescribee() == null) ? 0 : getDescribee().hashCode());
        result = prime * result + ((getEmk1() == null) ? 0 : getEmk1().hashCode());
        result = prime * result + ((getEmk2() == null) ? 0 : getEmk2().hashCode());
        result = prime * result + ((getEmk3() == null) ? 0 : getEmk3().hashCode());
        result = prime * result + ((getClassname() == null) ? 0 : getClassname().hashCode());
        result = prime * result + ((getMethodname() == null) ? 0 : getMethodname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", truename=").append(truename);
        sb.append(", createtime=").append(createtime);
        sb.append(", endtime=").append(endtime);
        sb.append(", isfallorok=").append(isfallorok);
        sb.append(", oldmoney=").append(oldmoney);
        sb.append(", changemoney=").append(changemoney);
        sb.append(", newmoney=").append(newmoney);
        sb.append(", describee=").append(describee);
        sb.append(", emk1=").append(emk1);
        sb.append(", emk2=").append(emk2);
        sb.append(", emk3=").append(emk3);
        sb.append(", classname=").append(classname);
        sb.append(", methodname=").append(methodname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}