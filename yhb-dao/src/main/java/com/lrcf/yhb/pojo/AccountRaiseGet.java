package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.util.Date;

public class AccountRaiseGet implements Serializable {
    private Integer raiseid;

    private String userid;

    private String productid;

    private String raiseno;

    private Double raisesize;

    private String raisename;

    private Date raisegettime;

    private Date raiseovertime;

    private String raiseusetime;

    private String raisemark;

    private Integer raisestate;

    private Long raiseoldmoney;

    private Integer raisedatenum;

    private Integer raisedatepast;

    private String changecode;

    private static final long serialVersionUID = 1L;

    public AccountRaiseGet(){

    }

    /**
     * @Function: AccountRaiseGet.java
     * @Description: 默认构造函数
     *
     * @param:参数描述
     * @version: v1.0.0
     * @author: Krx
     * @date: 2017年5月8日 下午12:00:26
     */
    public AccountRaiseGet( String userid, String raisename,String productid, String raiseno,String raisemark,Double raisesize,
                            Date raiseovertime,Date raisegettime,Integer raisedatenum) {
        super();
        this.userid = userid;
        this.raisename = raisename;
        this.productid = productid;
        this.raiseno = raiseno;
        this.raisemark = raisemark;
        this.raisesize = raisesize;
        this.raiseovertime = raiseovertime;
        this.raisegettime = raisegettime;
        this.raisedatenum = raisedatenum;
    }

    public Integer getRaiseid() {
        return raiseid;
    }

    public void setRaiseid(Integer raiseid) {
        this.raiseid = raiseid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getRaiseno() {
        return raiseno;
    }

    public void setRaiseno(String raiseno) {
        this.raiseno = raiseno;
    }

    public Double getRaisesize() {
        return raisesize;
    }

    public void setRaisesize(Double raisesize) {
        this.raisesize = raisesize;
    }

    public String getRaisename() {
        return raisename;
    }

    public void setRaisename(String raisename) {
        this.raisename = raisename;
    }

    public Date getRaisegettime() {
        return raisegettime;
    }

    public void setRaisegettime(Date raisegettime) {
        this.raisegettime = raisegettime;
    }

    public Date getRaiseovertime() {
        return raiseovertime;
    }

    public void setRaiseovertime(Date raiseovertime) {
        this.raiseovertime = raiseovertime;
    }

    public String getRaiseusetime() {
        return raiseusetime;
    }

    public void setRaiseusetime(String raiseusetime) {
        this.raiseusetime = raiseusetime;
    }

    public String getRaisemark() {
        return raisemark;
    }

    public void setRaisemark(String raisemark) {
        this.raisemark = raisemark;
    }

    public Integer getRaisestate() {
        return raisestate;
    }

    public void setRaisestate(Integer raisestate) {
        this.raisestate = raisestate;
    }

    public Long getRaiseoldmoney() {
        return raiseoldmoney;
    }

    public void setRaiseoldmoney(Long raiseoldmoney) {
        this.raiseoldmoney = raiseoldmoney;
    }

    public Integer getRaisedatenum() {
        return raisedatenum;
    }

    public void setRaisedatenum(Integer raisedatenum) {
        this.raisedatenum = raisedatenum;
    }

    public Integer getRaisedatepast() {
        return raisedatepast;
    }

    public void setRaisedatepast(Integer raisedatepast) {
        this.raisedatepast = raisedatepast;
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
        AccountRaiseGet other = (AccountRaiseGet) that;
        return (this.getRaiseid() == null ? other.getRaiseid() == null : this.getRaiseid().equals(other.getRaiseid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getRaiseno() == null ? other.getRaiseno() == null : this.getRaiseno().equals(other.getRaiseno()))
            && (this.getRaisesize() == null ? other.getRaisesize() == null : this.getRaisesize().equals(other.getRaisesize()))
            && (this.getRaisename() == null ? other.getRaisename() == null : this.getRaisename().equals(other.getRaisename()))
            && (this.getRaisegettime() == null ? other.getRaisegettime() == null : this.getRaisegettime().equals(other.getRaisegettime()))
            && (this.getRaiseovertime() == null ? other.getRaiseovertime() == null : this.getRaiseovertime().equals(other.getRaiseovertime()))
            && (this.getRaiseusetime() == null ? other.getRaiseusetime() == null : this.getRaiseusetime().equals(other.getRaiseusetime()))
            && (this.getRaisemark() == null ? other.getRaisemark() == null : this.getRaisemark().equals(other.getRaisemark()))
            && (this.getRaisestate() == null ? other.getRaisestate() == null : this.getRaisestate().equals(other.getRaisestate()))
            && (this.getRaiseoldmoney() == null ? other.getRaiseoldmoney() == null : this.getRaiseoldmoney().equals(other.getRaiseoldmoney()))
            && (this.getRaisedatenum() == null ? other.getRaisedatenum() == null : this.getRaisedatenum().equals(other.getRaisedatenum()))
            && (this.getRaisedatepast() == null ? other.getRaisedatepast() == null : this.getRaisedatepast().equals(other.getRaisedatepast()))
            && (this.getChangecode() == null ? other.getChangecode() == null : this.getChangecode().equals(other.getChangecode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRaiseid() == null) ? 0 : getRaiseid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getRaiseno() == null) ? 0 : getRaiseno().hashCode());
        result = prime * result + ((getRaisesize() == null) ? 0 : getRaisesize().hashCode());
        result = prime * result + ((getRaisename() == null) ? 0 : getRaisename().hashCode());
        result = prime * result + ((getRaisegettime() == null) ? 0 : getRaisegettime().hashCode());
        result = prime * result + ((getRaiseovertime() == null) ? 0 : getRaiseovertime().hashCode());
        result = prime * result + ((getRaiseusetime() == null) ? 0 : getRaiseusetime().hashCode());
        result = prime * result + ((getRaisemark() == null) ? 0 : getRaisemark().hashCode());
        result = prime * result + ((getRaisestate() == null) ? 0 : getRaisestate().hashCode());
        result = prime * result + ((getRaiseoldmoney() == null) ? 0 : getRaiseoldmoney().hashCode());
        result = prime * result + ((getRaisedatenum() == null) ? 0 : getRaisedatenum().hashCode());
        result = prime * result + ((getRaisedatepast() == null) ? 0 : getRaisedatepast().hashCode());
        result = prime * result + ((getChangecode() == null) ? 0 : getChangecode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", raiseid=").append(raiseid);
        sb.append(", userid=").append(userid);
        sb.append(", productid=").append(productid);
        sb.append(", raiseno=").append(raiseno);
        sb.append(", raisesize=").append(raisesize);
        sb.append(", raisename=").append(raisename);
        sb.append(", raisegettime=").append(raisegettime);
        sb.append(", raiseovertime=").append(raiseovertime);
        sb.append(", raiseusetime=").append(raiseusetime);
        sb.append(", raisemark=").append(raisemark);
        sb.append(", raisestate=").append(raisestate);
        sb.append(", raiseoldmoney=").append(raiseoldmoney);
        sb.append(", raisedatenum=").append(raisedatenum);
        sb.append(", raisedatepast=").append(raisedatepast);
        sb.append(", changecode=").append(changecode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}