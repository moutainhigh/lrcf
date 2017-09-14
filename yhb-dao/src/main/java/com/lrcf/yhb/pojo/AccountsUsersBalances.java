package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountsUsersBalances implements Serializable {
    private Integer balanceid;

    private String userid;

    private BigDecimal userpayment;

    private Integer userjifen;

    private BigDecimal usersignsharemoney;

    private BigDecimal userbalance;

    private BigDecimal userfreeze;

    private BigDecimal usercurrent;

    private BigDecimal userother;

    private BigDecimal agnetpayment;

    private BigDecimal agnetbalance;

    private BigDecimal agnetfreeze;

    private BigDecimal agnetother;

    private Integer settlementtype;

    private Integer settlementlife;

    private Integer settlementfeetype;

    private BigDecimal settlementfee;

    private Integer settlementtimes;

    private BigDecimal settlementmaxprice;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public Integer getBalanceid() {
        return balanceid;
    }

    public void setBalanceid(Integer balanceid) {
        this.balanceid = balanceid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BigDecimal getUserpayment() {
        return userpayment;
    }

    public void setUserpayment(BigDecimal userpayment) {
        this.userpayment = userpayment;
    }

    public Integer getUserjifen() {
        return userjifen;
    }

    public void setUserjifen(Integer userjifen) {
        this.userjifen = userjifen;
    }

    public BigDecimal getUsersignsharemoney() {
        return usersignsharemoney;
    }

    public void setUsersignsharemoney(BigDecimal usersignsharemoney) {
        this.usersignsharemoney = usersignsharemoney;
    }

    public BigDecimal getUserbalance() {
        return userbalance;
    }

    public void setUserbalance(BigDecimal userbalance) {
        this.userbalance = userbalance;
    }

    public BigDecimal getUserfreeze() {
        return userfreeze;
    }

    public void setUserfreeze(BigDecimal userfreeze) {
        this.userfreeze = userfreeze;
    }

    public BigDecimal getUsercurrent() {
        return usercurrent;
    }

    public void setUsercurrent(BigDecimal usercurrent) {
        this.usercurrent = usercurrent;
    }

    public BigDecimal getUserother() {
        return userother;
    }

    public void setUserother(BigDecimal userother) {
        this.userother = userother;
    }

    public BigDecimal getAgnetpayment() {
        return agnetpayment;
    }

    public void setAgnetpayment(BigDecimal agnetpayment) {
        this.agnetpayment = agnetpayment;
    }

    public BigDecimal getAgnetbalance() {
        return agnetbalance;
    }

    public void setAgnetbalance(BigDecimal agnetbalance) {
        this.agnetbalance = agnetbalance;
    }

    public BigDecimal getAgnetfreeze() {
        return agnetfreeze;
    }

    public void setAgnetfreeze(BigDecimal agnetfreeze) {
        this.agnetfreeze = agnetfreeze;
    }

    public BigDecimal getAgnetother() {
        return agnetother;
    }

    public void setAgnetother(BigDecimal agnetother) {
        this.agnetother = agnetother;
    }

    public Integer getSettlementtype() {
        return settlementtype;
    }

    public void setSettlementtype(Integer settlementtype) {
        this.settlementtype = settlementtype;
    }

    public Integer getSettlementlife() {
        return settlementlife;
    }

    public void setSettlementlife(Integer settlementlife) {
        this.settlementlife = settlementlife;
    }

    public Integer getSettlementfeetype() {
        return settlementfeetype;
    }

    public void setSettlementfeetype(Integer settlementfeetype) {
        this.settlementfeetype = settlementfeetype;
    }

    public BigDecimal getSettlementfee() {
        return settlementfee;
    }

    public void setSettlementfee(BigDecimal settlementfee) {
        this.settlementfee = settlementfee;
    }

    public Integer getSettlementtimes() {
        return settlementtimes;
    }

    public void setSettlementtimes(Integer settlementtimes) {
        this.settlementtimes = settlementtimes;
    }

    public BigDecimal getSettlementmaxprice() {
        return settlementmaxprice;
    }

    public void setSettlementmaxprice(BigDecimal settlementmaxprice) {
        this.settlementmaxprice = settlementmaxprice;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
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
        AccountsUsersBalances other = (AccountsUsersBalances) that;
        return (this.getBalanceid() == null ? other.getBalanceid() == null : this.getBalanceid().equals(other.getBalanceid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUserpayment() == null ? other.getUserpayment() == null : this.getUserpayment().equals(other.getUserpayment()))
            && (this.getUserjifen() == null ? other.getUserjifen() == null : this.getUserjifen().equals(other.getUserjifen()))
            && (this.getUsersignsharemoney() == null ? other.getUsersignsharemoney() == null : this.getUsersignsharemoney().equals(other.getUsersignsharemoney()))
            && (this.getUserbalance() == null ? other.getUserbalance() == null : this.getUserbalance().equals(other.getUserbalance()))
            && (this.getUserfreeze() == null ? other.getUserfreeze() == null : this.getUserfreeze().equals(other.getUserfreeze()))
            && (this.getUsercurrent() == null ? other.getUsercurrent() == null : this.getUsercurrent().equals(other.getUsercurrent()))
            && (this.getUserother() == null ? other.getUserother() == null : this.getUserother().equals(other.getUserother()))
            && (this.getAgnetpayment() == null ? other.getAgnetpayment() == null : this.getAgnetpayment().equals(other.getAgnetpayment()))
            && (this.getAgnetbalance() == null ? other.getAgnetbalance() == null : this.getAgnetbalance().equals(other.getAgnetbalance()))
            && (this.getAgnetfreeze() == null ? other.getAgnetfreeze() == null : this.getAgnetfreeze().equals(other.getAgnetfreeze()))
            && (this.getAgnetother() == null ? other.getAgnetother() == null : this.getAgnetother().equals(other.getAgnetother()))
            && (this.getSettlementtype() == null ? other.getSettlementtype() == null : this.getSettlementtype().equals(other.getSettlementtype()))
            && (this.getSettlementlife() == null ? other.getSettlementlife() == null : this.getSettlementlife().equals(other.getSettlementlife()))
            && (this.getSettlementfeetype() == null ? other.getSettlementfeetype() == null : this.getSettlementfeetype().equals(other.getSettlementfeetype()))
            && (this.getSettlementfee() == null ? other.getSettlementfee() == null : this.getSettlementfee().equals(other.getSettlementfee()))
            && (this.getSettlementtimes() == null ? other.getSettlementtimes() == null : this.getSettlementtimes().equals(other.getSettlementtimes()))
            && (this.getSettlementmaxprice() == null ? other.getSettlementmaxprice() == null : this.getSettlementmaxprice().equals(other.getSettlementmaxprice()))
            && (this.getModifytime() == null ? other.getModifytime() == null : this.getModifytime().equals(other.getModifytime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBalanceid() == null) ? 0 : getBalanceid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUserpayment() == null) ? 0 : getUserpayment().hashCode());
        result = prime * result + ((getUserjifen() == null) ? 0 : getUserjifen().hashCode());
        result = prime * result + ((getUsersignsharemoney() == null) ? 0 : getUsersignsharemoney().hashCode());
        result = prime * result + ((getUserbalance() == null) ? 0 : getUserbalance().hashCode());
        result = prime * result + ((getUserfreeze() == null) ? 0 : getUserfreeze().hashCode());
        result = prime * result + ((getUsercurrent() == null) ? 0 : getUsercurrent().hashCode());
        result = prime * result + ((getUserother() == null) ? 0 : getUserother().hashCode());
        result = prime * result + ((getAgnetpayment() == null) ? 0 : getAgnetpayment().hashCode());
        result = prime * result + ((getAgnetbalance() == null) ? 0 : getAgnetbalance().hashCode());
        result = prime * result + ((getAgnetfreeze() == null) ? 0 : getAgnetfreeze().hashCode());
        result = prime * result + ((getAgnetother() == null) ? 0 : getAgnetother().hashCode());
        result = prime * result + ((getSettlementtype() == null) ? 0 : getSettlementtype().hashCode());
        result = prime * result + ((getSettlementlife() == null) ? 0 : getSettlementlife().hashCode());
        result = prime * result + ((getSettlementfeetype() == null) ? 0 : getSettlementfeetype().hashCode());
        result = prime * result + ((getSettlementfee() == null) ? 0 : getSettlementfee().hashCode());
        result = prime * result + ((getSettlementtimes() == null) ? 0 : getSettlementtimes().hashCode());
        result = prime * result + ((getSettlementmaxprice() == null) ? 0 : getSettlementmaxprice().hashCode());
        result = prime * result + ((getModifytime() == null) ? 0 : getModifytime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", balanceid=").append(balanceid);
        sb.append(", userid=").append(userid);
        sb.append(", userpayment=").append(userpayment);
        sb.append(", userjifen=").append(userjifen);
        sb.append(", usersignsharemoney=").append(usersignsharemoney);
        sb.append(", userbalance=").append(userbalance);
        sb.append(", userfreeze=").append(userfreeze);
        sb.append(", usercurrent=").append(usercurrent);
        sb.append(", userother=").append(userother);
        sb.append(", agnetpayment=").append(agnetpayment);
        sb.append(", agnetbalance=").append(agnetbalance);
        sb.append(", agnetfreeze=").append(agnetfreeze);
        sb.append(", agnetother=").append(agnetother);
        sb.append(", settlementtype=").append(settlementtype);
        sb.append(", settlementlife=").append(settlementlife);
        sb.append(", settlementfeetype=").append(settlementfeetype);
        sb.append(", settlementfee=").append(settlementfee);
        sb.append(", settlementtimes=").append(settlementtimes);
        sb.append(", settlementmaxprice=").append(settlementmaxprice);
        sb.append(", modifytime=").append(modifytime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}