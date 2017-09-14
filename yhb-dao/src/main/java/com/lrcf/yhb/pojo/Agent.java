package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Agent implements Serializable {
    private String userid;

    private String username;

    private String parentid;

    private String cardid;

    private Integer activity;

    private String password;

    private Date createtime;

    private Integer userstate;

    private Date losttime;

    private Integer cityid;

    private Integer lvlid;

    private BigDecimal commissionBalance;

    private BigDecimal notreceivedcommission;

    private BigDecimal receivedcommission;

    private BigDecimal signshare;

    private Integer signstate;

    private String winxinimg;

    private String emk1;

    private String emk2;

    private String emk3;

    private String emk4;

    private static final long serialVersionUID = 1L;

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

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUserstate() {
        return userstate;
    }

    public void setUserstate(Integer userstate) {
        this.userstate = userstate;
    }

    public Date getLosttime() {
        return losttime;
    }

    public void setLosttime(Date losttime) {
        this.losttime = losttime;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getLvlid() {
        return lvlid;
    }

    public void setLvlid(Integer lvlid) {
        this.lvlid = lvlid;
    }

    public BigDecimal getCommissionBalance() {
        return commissionBalance;
    }

    public void setCommissionBalance(BigDecimal commissionBalance) {
        this.commissionBalance = commissionBalance;
    }

    public BigDecimal getNotreceivedcommission() {
        return notreceivedcommission;
    }

    public void setNotreceivedcommission(BigDecimal notreceivedcommission) {
        this.notreceivedcommission = notreceivedcommission;
    }

    public BigDecimal getReceivedcommission() {
        return receivedcommission;
    }

    public void setReceivedcommission(BigDecimal receivedcommission) {
        this.receivedcommission = receivedcommission;
    }

    public BigDecimal getSignshare() {
        return signshare;
    }

    public void setSignshare(BigDecimal signshare) {
        this.signshare = signshare;
    }

    public Integer getSignstate() {
        return signstate;
    }

    public void setSignstate(Integer signstate) {
        this.signstate = signstate;
    }

    public String getWinxinimg() {
        return winxinimg;
    }

    public void setWinxinimg(String winxinimg) {
        this.winxinimg = winxinimg;
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
        Agent other = (Agent) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getCardid() == null ? other.getCardid() == null : this.getCardid().equals(other.getCardid()))
            && (this.getActivity() == null ? other.getActivity() == null : this.getActivity().equals(other.getActivity()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUserstate() == null ? other.getUserstate() == null : this.getUserstate().equals(other.getUserstate()))
            && (this.getLosttime() == null ? other.getLosttime() == null : this.getLosttime().equals(other.getLosttime()))
            && (this.getCityid() == null ? other.getCityid() == null : this.getCityid().equals(other.getCityid()))
            && (this.getLvlid() == null ? other.getLvlid() == null : this.getLvlid().equals(other.getLvlid()))
            && (this.getCommissionBalance() == null ? other.getCommissionBalance() == null : this.getCommissionBalance().equals(other.getCommissionBalance()))
            && (this.getNotreceivedcommission() == null ? other.getNotreceivedcommission() == null : this.getNotreceivedcommission().equals(other.getNotreceivedcommission()))
            && (this.getReceivedcommission() == null ? other.getReceivedcommission() == null : this.getReceivedcommission().equals(other.getReceivedcommission()))
            && (this.getSignshare() == null ? other.getSignshare() == null : this.getSignshare().equals(other.getSignshare()))
            && (this.getSignstate() == null ? other.getSignstate() == null : this.getSignstate().equals(other.getSignstate()))
            && (this.getWinxinimg() == null ? other.getWinxinimg() == null : this.getWinxinimg().equals(other.getWinxinimg()))
            && (this.getEmk1() == null ? other.getEmk1() == null : this.getEmk1().equals(other.getEmk1()))
            && (this.getEmk2() == null ? other.getEmk2() == null : this.getEmk2().equals(other.getEmk2()))
            && (this.getEmk3() == null ? other.getEmk3() == null : this.getEmk3().equals(other.getEmk3()))
            && (this.getEmk4() == null ? other.getEmk4() == null : this.getEmk4().equals(other.getEmk4()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getCardid() == null) ? 0 : getCardid().hashCode());
        result = prime * result + ((getActivity() == null) ? 0 : getActivity().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUserstate() == null) ? 0 : getUserstate().hashCode());
        result = prime * result + ((getLosttime() == null) ? 0 : getLosttime().hashCode());
        result = prime * result + ((getCityid() == null) ? 0 : getCityid().hashCode());
        result = prime * result + ((getLvlid() == null) ? 0 : getLvlid().hashCode());
        result = prime * result + ((getCommissionBalance() == null) ? 0 : getCommissionBalance().hashCode());
        result = prime * result + ((getNotreceivedcommission() == null) ? 0 : getNotreceivedcommission().hashCode());
        result = prime * result + ((getReceivedcommission() == null) ? 0 : getReceivedcommission().hashCode());
        result = prime * result + ((getSignshare() == null) ? 0 : getSignshare().hashCode());
        result = prime * result + ((getSignstate() == null) ? 0 : getSignstate().hashCode());
        result = prime * result + ((getWinxinimg() == null) ? 0 : getWinxinimg().hashCode());
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
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", parentid=").append(parentid);
        sb.append(", cardid=").append(cardid);
        sb.append(", activity=").append(activity);
        sb.append(", password=").append(password);
        sb.append(", createtime=").append(createtime);
        sb.append(", userstate=").append(userstate);
        sb.append(", losttime=").append(losttime);
        sb.append(", cityid=").append(cityid);
        sb.append(", lvlid=").append(lvlid);
        sb.append(", commissionBalance=").append(commissionBalance);
        sb.append(", notreceivedcommission=").append(notreceivedcommission);
        sb.append(", receivedcommission=").append(receivedcommission);
        sb.append(", signshare=").append(signshare);
        sb.append(", signstate=").append(signstate);
        sb.append(", winxinimg=").append(winxinimg);
        sb.append(", emk1=").append(emk1);
        sb.append(", emk2=").append(emk2);
        sb.append(", emk3=").append(emk3);
        sb.append(", emk4=").append(emk4);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}