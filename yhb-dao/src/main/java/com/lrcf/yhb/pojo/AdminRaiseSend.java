package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminRaiseSend implements Serializable {
    private Integer id;

    private String productid;

    private String raisename;

    private Date raisecreatetime;

    private Date raiseovertime;

    private String raisemark;

    private Double raisesize;

    private BigDecimal raisecountrate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getRaisename() {
        return raisename;
    }

    public void setRaisename(String raisename) {
        this.raisename = raisename;
    }

    public Date getRaisecreatetime() {
        return raisecreatetime;
    }

    public void setRaisecreatetime(Date raisecreatetime) {
        this.raisecreatetime = raisecreatetime;
    }

    public Date getRaiseovertime() {
        return raiseovertime;
    }

    public void setRaiseovertime(Date raiseovertime) {
        this.raiseovertime = raiseovertime;
    }

    public String getRaisemark() {
        return raisemark;
    }

    public void setRaisemark(String raisemark) {
        this.raisemark = raisemark;
    }

    public Double getRaisesize() {
        return raisesize;
    }

    public void setRaisesize(Double raisesize) {
        this.raisesize = raisesize;
    }

    public BigDecimal getRaisecountrate() {
        return raisecountrate;
    }

    public void setRaisecountrate(BigDecimal raisecountrate) {
        this.raisecountrate = raisecountrate;
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
        AdminRaiseSend other = (AdminRaiseSend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getRaisename() == null ? other.getRaisename() == null : this.getRaisename().equals(other.getRaisename()))
            && (this.getRaisecreatetime() == null ? other.getRaisecreatetime() == null : this.getRaisecreatetime().equals(other.getRaisecreatetime()))
            && (this.getRaiseovertime() == null ? other.getRaiseovertime() == null : this.getRaiseovertime().equals(other.getRaiseovertime()))
            && (this.getRaisemark() == null ? other.getRaisemark() == null : this.getRaisemark().equals(other.getRaisemark()))
            && (this.getRaisesize() == null ? other.getRaisesize() == null : this.getRaisesize().equals(other.getRaisesize()))
            && (this.getRaisecountrate() == null ? other.getRaisecountrate() == null : this.getRaisecountrate().equals(other.getRaisecountrate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getRaisename() == null) ? 0 : getRaisename().hashCode());
        result = prime * result + ((getRaisecreatetime() == null) ? 0 : getRaisecreatetime().hashCode());
        result = prime * result + ((getRaiseovertime() == null) ? 0 : getRaiseovertime().hashCode());
        result = prime * result + ((getRaisemark() == null) ? 0 : getRaisemark().hashCode());
        result = prime * result + ((getRaisesize() == null) ? 0 : getRaisesize().hashCode());
        result = prime * result + ((getRaisecountrate() == null) ? 0 : getRaisecountrate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productid=").append(productid);
        sb.append(", raisename=").append(raisename);
        sb.append(", raisecreatetime=").append(raisecreatetime);
        sb.append(", raiseovertime=").append(raiseovertime);
        sb.append(", raisemark=").append(raisemark);
        sb.append(", raisesize=").append(raisesize);
        sb.append(", raisecountrate=").append(raisecountrate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}