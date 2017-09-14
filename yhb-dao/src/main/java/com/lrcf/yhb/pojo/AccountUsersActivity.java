package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountUsersActivity implements Serializable {
    private Integer redid;

    private String fpid;

    private String userid;

    private String activityno;

    private String activityid;

    private String activityname;

    private BigDecimal activitymoney;

    private String activitycount;

    private Date gaintime;

    private Date overdutime;

    private Integer activitystate;

    private String usetime;

    private Integer redrule;

    private String changecode;

    private Integer day;

    private static final long serialVersionUID = 1L;

    public AccountUsersActivity() {

    }

    /**
     * @Function: AccountUsersActivity.java
     * @Description: 默认构造函数
     *
     * @param:参数描述
     * @version: v1.0.0
     * @author: Krx
     * @date: 2017年5月8日 上午11:48:13
     */
    public AccountUsersActivity(Integer redid, String fpid, String userid, String activityno, String activityid,
                               String activityname, BigDecimal activitymoney, String activitycount, Date gaintime, Date overdutime,
                               Integer activitystate, String usetime, Integer redrule, String changecode) {
        super();
        this.redid = redid;
        this.fpid = fpid;
        this.userid = userid;
        this.activityno = activityno;
        this.activityid = activityid;
        this.activityname = activityname;
        this.activitymoney = activitymoney;
        this.activitycount = activitycount;
        this.gaintime = gaintime;
        this.overdutime = overdutime;
        this.activitystate = activitystate;
        this.usetime = usetime;
        this.redrule = redrule;
        this.changecode = changecode;
    }

    /**
     * @Function: AccountUsersActivity.java
     * @Description: 自定义构造函数
     *
     * @param:参数描述
     * @version: v1.0.0
     * @author: Krx
     * @date: 2017年5月8日 上午11:48:13
     */
    public AccountUsersActivity(String fpid, String userid, String activityno, String activityid, String activityname,
                               BigDecimal activitymoney, Date gaintime, Date overdutime,  Integer redrule) {
        super();
        this.fpid = fpid;
        this.userid = userid;
        this.activityno = activityno;
        this.activityid = activityid;
        this.activityname = activityname;
        this.activitymoney = activitymoney;
        this.gaintime = gaintime;
        this.overdutime = overdutime;
        this.redrule = redrule;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getRedid() {
        return redid;
    }

    public void setRedid(Integer redid) {
        this.redid = redid;
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

    public String getActivityno() {
        return activityno;
    }

    public void setActivityno(String activityno) {
        this.activityno = activityno;
    }

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public BigDecimal getActivitymoney() {
        return activitymoney;
    }

    public void setActivitymoney(BigDecimal activitymoney) {
        this.activitymoney = activitymoney;
    }

    public String getActivitycount() {
        return activitycount;
    }

    public void setActivitycount(String activitycount) {
        this.activitycount = activitycount;
    }

    public Date getGaintime() {
        return gaintime;
    }

    public void setGaintime(Date gaintime) {
        this.gaintime = gaintime;
    }

    public Date getOverdutime() {
        return overdutime;
    }

    public void setOverdutime(Date overdutime) {
        this.overdutime = overdutime;
    }

    public Integer getActivitystate() {
        return activitystate;
    }

    public void setActivitystate(Integer activitystate) {
        this.activitystate = activitystate;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    public Integer getRedrule() {
        return redrule;
    }

    public void setRedrule(Integer redrule) {
        this.redrule = redrule;
    }

    public String getChangecode() {
        return changecode;
    }

    public void setChangecode(String changecode) {
        this.changecode = changecode;
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
        AccountUsersActivity other = (AccountUsersActivity) that;
        return (this.getRedid() == null ? other.getRedid() == null : this.getRedid().equals(other.getRedid()))
            && (this.getFpid() == null ? other.getFpid() == null : this.getFpid().equals(other.getFpid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getActivityno() == null ? other.getActivityno() == null : this.getActivityno().equals(other.getActivityno()))
            && (this.getActivityid() == null ? other.getActivityid() == null : this.getActivityid().equals(other.getActivityid()))
            && (this.getActivityname() == null ? other.getActivityname() == null : this.getActivityname().equals(other.getActivityname()))
            && (this.getActivitymoney() == null ? other.getActivitymoney() == null : this.getActivitymoney().equals(other.getActivitymoney()))
            && (this.getActivitycount() == null ? other.getActivitycount() == null : this.getActivitycount().equals(other.getActivitycount()))
            && (this.getGaintime() == null ? other.getGaintime() == null : this.getGaintime().equals(other.getGaintime()))
            && (this.getOverdutime() == null ? other.getOverdutime() == null : this.getOverdutime().equals(other.getOverdutime()))
            && (this.getActivitystate() == null ? other.getActivitystate() == null : this.getActivitystate().equals(other.getActivitystate()))
            && (this.getUsetime() == null ? other.getUsetime() == null : this.getUsetime().equals(other.getUsetime()))
            && (this.getRedrule() == null ? other.getRedrule() == null : this.getRedrule().equals(other.getRedrule()))
            && (this.getChangecode() == null ? other.getChangecode() == null : this.getChangecode().equals(other.getChangecode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRedid() == null) ? 0 : getRedid().hashCode());
        result = prime * result + ((getFpid() == null) ? 0 : getFpid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getActivityno() == null) ? 0 : getActivityno().hashCode());
        result = prime * result + ((getActivityid() == null) ? 0 : getActivityid().hashCode());
        result = prime * result + ((getActivityname() == null) ? 0 : getActivityname().hashCode());
        result = prime * result + ((getActivitymoney() == null) ? 0 : getActivitymoney().hashCode());
        result = prime * result + ((getActivitycount() == null) ? 0 : getActivitycount().hashCode());
        result = prime * result + ((getGaintime() == null) ? 0 : getGaintime().hashCode());
        result = prime * result + ((getOverdutime() == null) ? 0 : getOverdutime().hashCode());
        result = prime * result + ((getActivitystate() == null) ? 0 : getActivitystate().hashCode());
        result = prime * result + ((getUsetime() == null) ? 0 : getUsetime().hashCode());
        result = prime * result + ((getRedrule() == null) ? 0 : getRedrule().hashCode());
        result = prime * result + ((getChangecode() == null) ? 0 : getChangecode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", redid=").append(redid);
        sb.append(", fpid=").append(fpid);
        sb.append(", userid=").append(userid);
        sb.append(", activityno=").append(activityno);
        sb.append(", activityid=").append(activityid);
        sb.append(", activityname=").append(activityname);
        sb.append(", activitymoney=").append(activitymoney);
        sb.append(", activitycount=").append(activitycount);
        sb.append(", gaintime=").append(gaintime);
        sb.append(", overdutime=").append(overdutime);
        sb.append(", activitystate=").append(activitystate);
        sb.append(", usetime=").append(usetime);
        sb.append(", redrule=").append(redrule);
        sb.append(", changecode=").append(changecode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}