package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FinanceproductsUsers implements Serializable {
    private Integer fpuid;

    private String userid;

    private Integer fpid;

    private String fproductsname;

    private Float fproductsrates;

    private BigDecimal fproductsbuymoney;

    private Date fproductsbuytime;

    private Integer fproductsrateinnum;

    private Integer fproductsextractnum;

    private Float fproductsoutmoney;

    private Integer fproductscountnum;

    private BigDecimal fproductsratemoney;

    private BigDecimal fproductscountratemoney;

    private Float memberrates;

    private String fproductsemK1;

    private String fproductsemK2;

    private String fproductsemK3;

    private String fproductsemK4;

    private String fproductsemK5;

    private byte[] fproductsimgs;

    private String trueName; //真实姓名

    private String userName;  //手机号码

    private static final long serialVersionUID = 1L;

    public Integer getFpuid() {
        return fpuid;
    }

    public void setFpuid(Integer fpuid) {
        this.fpuid = fpuid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getFpid() {
        return fpid;
    }

    public void setFpid(Integer fpid) {
        this.fpid = fpid;
    }

    public String getFproductsname() {
        return fproductsname;
    }

    public void setFproductsname(String fproductsname) {
        this.fproductsname = fproductsname;
    }

    public Float getFproductsrates() {
        return fproductsrates;
    }

    public void setFproductsrates(Float fproductsrates) {
        this.fproductsrates = fproductsrates;
    }

    public BigDecimal getFproductsbuymoney() {
        return fproductsbuymoney;
    }

    public void setFproductsbuymoney(BigDecimal fproductsbuymoney) {
        this.fproductsbuymoney = fproductsbuymoney;
    }

    public Date getFproductsbuytime() {
        return fproductsbuytime;
    }

    public void setFproductsbuytime(Date fproductsbuytime) {
        this.fproductsbuytime = fproductsbuytime;
    }

    public Integer getFproductsrateinnum() {
        return fproductsrateinnum;
    }

    public void setFproductsrateinnum(Integer fproductsrateinnum) {
        this.fproductsrateinnum = fproductsrateinnum;
    }

    public Integer getFproductsextractnum() {
        return fproductsextractnum;
    }

    public void setFproductsextractnum(Integer fproductsextractnum) {
        this.fproductsextractnum = fproductsextractnum;
    }

    public Float getFproductsoutmoney() {
        return fproductsoutmoney;
    }

    public void setFproductsoutmoney(Float fproductsoutmoney) {
        this.fproductsoutmoney = fproductsoutmoney;
    }

    public Integer getFproductscountnum() {
        return fproductscountnum;
    }

    public void setFproductscountnum(Integer fproductscountnum) {
        this.fproductscountnum = fproductscountnum;
    }

    public BigDecimal getFproductsratemoney() {
        return fproductsratemoney;
    }

    public void setFproductsratemoney(BigDecimal fproductsratemoney) {
        this.fproductsratemoney = fproductsratemoney;
    }

    public BigDecimal getFproductscountratemoney() {
        return fproductscountratemoney;
    }

    public void setFproductscountratemoney(BigDecimal fproductscountratemoney) {
        this.fproductscountratemoney = fproductscountratemoney;
    }

    public Float getMemberrates() {
        return memberrates;
    }

    public void setMemberrates(Float memberrates) {
        this.memberrates = memberrates;
    }

    public String getFproductsemK1() {
        return fproductsemK1;
    }

    public void setFproductsemK1(String fproductsemK1) {
        this.fproductsemK1 = fproductsemK1;
    }

    public String getFproductsemK2() {
        return fproductsemK2;
    }

    public void setFproductsemK2(String fproductsemK2) {
        this.fproductsemK2 = fproductsemK2;
    }

    public String getFproductsemK3() {
        return fproductsemK3;
    }

    public void setFproductsemK3(String fproductsemK3) {
        this.fproductsemK3 = fproductsemK3;
    }

    public String getFproductsemK4() {
        return fproductsemK4;
    }

    public void setFproductsemK4(String fproductsemK4) {
        this.fproductsemK4 = fproductsemK4;
    }

    public String getFproductsemK5() {
        return fproductsemK5;
    }

    public void setFproductsemK5(String fproductsemK5) {
        this.fproductsemK5 = fproductsemK5;
    }

    public byte[] getFproductsimgs() {
        return fproductsimgs;
    }

    public void setFproductsimgs(byte[] fproductsimgs) {
        this.fproductsimgs = fproductsimgs;
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
        FinanceproductsUsers other = (FinanceproductsUsers) that;
        return (this.getFpuid() == null ? other.getFpuid() == null : this.getFpuid().equals(other.getFpuid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getFpid() == null ? other.getFpid() == null : this.getFpid().equals(other.getFpid()))
            && (this.getFproductsname() == null ? other.getFproductsname() == null : this.getFproductsname().equals(other.getFproductsname()))
            && (this.getFproductsrates() == null ? other.getFproductsrates() == null : this.getFproductsrates().equals(other.getFproductsrates()))
            && (this.getFproductsbuymoney() == null ? other.getFproductsbuymoney() == null : this.getFproductsbuymoney().equals(other.getFproductsbuymoney()))
            && (this.getFproductsbuytime() == null ? other.getFproductsbuytime() == null : this.getFproductsbuytime().equals(other.getFproductsbuytime()))
            && (this.getFproductsrateinnum() == null ? other.getFproductsrateinnum() == null : this.getFproductsrateinnum().equals(other.getFproductsrateinnum()))
            && (this.getFproductsextractnum() == null ? other.getFproductsextractnum() == null : this.getFproductsextractnum().equals(other.getFproductsextractnum()))
            && (this.getFproductsoutmoney() == null ? other.getFproductsoutmoney() == null : this.getFproductsoutmoney().equals(other.getFproductsoutmoney()))
            && (this.getFproductscountnum() == null ? other.getFproductscountnum() == null : this.getFproductscountnum().equals(other.getFproductscountnum()))
            && (this.getFproductsratemoney() == null ? other.getFproductsratemoney() == null : this.getFproductsratemoney().equals(other.getFproductsratemoney()))
            && (this.getFproductscountratemoney() == null ? other.getFproductscountratemoney() == null : this.getFproductscountratemoney().equals(other.getFproductscountratemoney()))
            && (this.getMemberrates() == null ? other.getMemberrates() == null : this.getMemberrates().equals(other.getMemberrates()))
            && (this.getFproductsemK1() == null ? other.getFproductsemK1() == null : this.getFproductsemK1().equals(other.getFproductsemK1()))
            && (this.getFproductsemK2() == null ? other.getFproductsemK2() == null : this.getFproductsemK2().equals(other.getFproductsemK2()))
            && (this.getFproductsemK3() == null ? other.getFproductsemK3() == null : this.getFproductsemK3().equals(other.getFproductsemK3()))
            && (this.getFproductsemK4() == null ? other.getFproductsemK4() == null : this.getFproductsemK4().equals(other.getFproductsemK4()))
            && (this.getFproductsemK5() == null ? other.getFproductsemK5() == null : this.getFproductsemK5().equals(other.getFproductsemK5()))
            && (this.getFproductsimgs() == null ? other.getFproductsimgs() == null : this.getFproductsimgs().equals(other.getFproductsimgs()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFpuid() == null) ? 0 : getFpuid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getFpid() == null) ? 0 : getFpid().hashCode());
        result = prime * result + ((getFproductsname() == null) ? 0 : getFproductsname().hashCode());
        result = prime * result + ((getFproductsrates() == null) ? 0 : getFproductsrates().hashCode());
        result = prime * result + ((getFproductsbuymoney() == null) ? 0 : getFproductsbuymoney().hashCode());
        result = prime * result + ((getFproductsbuytime() == null) ? 0 : getFproductsbuytime().hashCode());
        result = prime * result + ((getFproductsrateinnum() == null) ? 0 : getFproductsrateinnum().hashCode());
        result = prime * result + ((getFproductsextractnum() == null) ? 0 : getFproductsextractnum().hashCode());
        result = prime * result + ((getFproductsoutmoney() == null) ? 0 : getFproductsoutmoney().hashCode());
        result = prime * result + ((getFproductscountnum() == null) ? 0 : getFproductscountnum().hashCode());
        result = prime * result + ((getFproductsratemoney() == null) ? 0 : getFproductsratemoney().hashCode());
        result = prime * result + ((getFproductscountratemoney() == null) ? 0 : getFproductscountratemoney().hashCode());
        result = prime * result + ((getMemberrates() == null) ? 0 : getMemberrates().hashCode());
        result = prime * result + ((getFproductsemK1() == null) ? 0 : getFproductsemK1().hashCode());
        result = prime * result + ((getFproductsemK2() == null) ? 0 : getFproductsemK2().hashCode());
        result = prime * result + ((getFproductsemK3() == null) ? 0 : getFproductsemK3().hashCode());
        result = prime * result + ((getFproductsemK4() == null) ? 0 : getFproductsemK4().hashCode());
        result = prime * result + ((getFproductsemK5() == null) ? 0 : getFproductsemK5().hashCode());
        result = prime * result + ((getFproductsimgs() == null) ? 0 : getFproductsimgs().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fpuid=").append(fpuid);
        sb.append(", userid=").append(userid);
        sb.append(", fpid=").append(fpid);
        sb.append(", fproductsname=").append(fproductsname);
        sb.append(", fproductsrates=").append(fproductsrates);
        sb.append(", fproductsbuymoney=").append(fproductsbuymoney);
        sb.append(", fproductsbuytime=").append(fproductsbuytime);
        sb.append(", fproductsrateinnum=").append(fproductsrateinnum);
        sb.append(", fproductsextractnum=").append(fproductsextractnum);
        sb.append(", fproductsoutmoney=").append(fproductsoutmoney);
        sb.append(", fproductscountnum=").append(fproductscountnum);
        sb.append(", fproductsratemoney=").append(fproductsratemoney);
        sb.append(", fproductscountratemoney=").append(fproductscountratemoney);
        sb.append(", memberrates=").append(memberrates);
        sb.append(", fproductsemK1=").append(fproductsemK1);
        sb.append(", fproductsemK2=").append(fproductsemK2);
        sb.append(", fproductsemK3=").append(fproductsemK3);
        sb.append(", fproductsemK4=").append(fproductsemK4);
        sb.append(", fproductsemK5=").append(fproductsemK5);
        sb.append(", fproductsimgs=").append(fproductsimgs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}