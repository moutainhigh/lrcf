package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LogMoneyChange implements Serializable {
	public static final String add="+";
	public static final String remove="-";
	
    private Integer moneychangeid;

    private String userid;

    private String username;

    private BigDecimal changemoney;

    private BigDecimal poundage;

    private BigDecimal userbalance;

    private String addorremove;

    private String explaindes;

    private Date submitdate;

    private String transactionurl;
    
    
    public LogMoneyChange(){
    	
    }

    

    /**   
	* @Function: LogMoneyChange.java
	* @Description: 默认构造函数
	*
	* @param:参数描述
	* @version: v1.0.0
	* @author: Krx
	* @date: 2017年5月11日 下午2:15:01 
	*/
	public LogMoneyChange(String userid, String username, BigDecimal changemoney,
			BigDecimal poundage, BigDecimal userbalance, String addorremove, String explaindes, Date submitdate){
		super();
		this.userid = userid;
		this.username = username;
		this.changemoney = changemoney;
		this.poundage = poundage;
		this.userbalance = userbalance;
		this.addorremove = addorremove;
		this.explaindes = explaindes;
		this.submitdate = submitdate;
	}



	private static final long serialVersionUID = 1L;

    public Integer getMoneychangeid() {
        return moneychangeid;
    }

    public void setMoneychangeid(Integer moneychangeid) {
        this.moneychangeid = moneychangeid;
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

    public BigDecimal getChangemoney() {
        return changemoney;
    }

    public void setChangemoney(BigDecimal changemoney) {
        this.changemoney = changemoney;
    }

    public BigDecimal getPoundage() {
        return poundage;
    }

    public void setPoundage(BigDecimal poundage) {
        this.poundage = poundage;
    }

    public BigDecimal getUserbalance() {
        return userbalance;
    }

    public void setUserbalance(BigDecimal userbalance) {
        this.userbalance = userbalance;
    }

    public String getAddorremove() {
        return addorremove;
    }

    public void setAddorremove(String addorremove) {
        this.addorremove = addorremove;
    }

    public String getExplaindes() {
        return explaindes;
    }

    public void setExplaindes(String explaindes) {
        this.explaindes = explaindes;
    }

    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

    public String getTransactionurl() {
        return transactionurl;
    }

    public void setTransactionurl(String transactionurl) {
        this.transactionurl = transactionurl;
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
        LogMoneyChange other = (LogMoneyChange) that;
        return (this.getMoneychangeid() == null ? other.getMoneychangeid() == null : this.getMoneychangeid().equals(other.getMoneychangeid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getChangemoney() == null ? other.getChangemoney() == null : this.getChangemoney().equals(other.getChangemoney()))
            && (this.getPoundage() == null ? other.getPoundage() == null : this.getPoundage().equals(other.getPoundage()))
            && (this.getUserbalance() == null ? other.getUserbalance() == null : this.getUserbalance().equals(other.getUserbalance()))
            && (this.getAddorremove() == null ? other.getAddorremove() == null : this.getAddorremove().equals(other.getAddorremove()))
            && (this.getExplaindes() == null ? other.getExplaindes() == null : this.getExplaindes().equals(other.getExplaindes()))
            && (this.getSubmitdate() == null ? other.getSubmitdate() == null : this.getSubmitdate().equals(other.getSubmitdate()))
            && (this.getTransactionurl() == null ? other.getTransactionurl() == null : this.getTransactionurl().equals(other.getTransactionurl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMoneychangeid() == null) ? 0 : getMoneychangeid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getChangemoney() == null) ? 0 : getChangemoney().hashCode());
        result = prime * result + ((getPoundage() == null) ? 0 : getPoundage().hashCode());
        result = prime * result + ((getUserbalance() == null) ? 0 : getUserbalance().hashCode());
        result = prime * result + ((getAddorremove() == null) ? 0 : getAddorremove().hashCode());
        result = prime * result + ((getExplaindes() == null) ? 0 : getExplaindes().hashCode());
        result = prime * result + ((getSubmitdate() == null) ? 0 : getSubmitdate().hashCode());
        result = prime * result + ((getTransactionurl() == null) ? 0 : getTransactionurl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moneychangeid=").append(moneychangeid);
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", changemoney=").append(changemoney);
        sb.append(", poundage=").append(poundage);
        sb.append(", userbalance=").append(userbalance);
        sb.append(", addorremove=").append(addorremove);
        sb.append(", explaindes=").append(explaindes);
        sb.append(", submitdate=").append(submitdate);
        sb.append(", transactionurl=").append(transactionurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}