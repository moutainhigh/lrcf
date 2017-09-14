package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ActivityAdminSend implements Serializable {
	private Integer id;

	private String productid;

	private Integer redrule;

	private String redname;

	private BigDecimal redmoney;

	private Date redlasttime;

	private String redmark;

	private Date redcreatetime;

	private Integer redsendcount;

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

	public Integer getRedrule() {
		return redrule;
	}

	public void setRedrule(Integer redrule) {
		this.redrule = redrule;
	}

	public String getRedname() {
		return redname;
	}

	public void setRedname(String redname) {
		this.redname = redname;
	}

	public BigDecimal getRedmoney() {
		return redmoney;
	}

	public void setRedmoney(BigDecimal redmoney) {
		this.redmoney = redmoney;
	}

	public Date getRedlasttime() {
		return redlasttime;
	}

	public void setRedlasttime(Date redlasttime) {
		this.redlasttime = redlasttime;
	}

	public String getRedmark() {
		return redmark;
	}

	public void setRedmark(String redmark) {
		this.redmark = redmark;
	}

	public Date getRedcreatetime() {
		return redcreatetime;
	}

	public void setRedcreatetime(Date redcreatetime) {
		this.redcreatetime = redcreatetime;
	}

	public Integer getRedsendcount() {
		return redsendcount;
	}

	public void setRedsendcount(Integer redsendcount) {
		this.redsendcount = redsendcount;
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
		ActivityAdminSend other = (ActivityAdminSend) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getProductid() == null ? other.getProductid() == null
						: this.getProductid().equals(other.getProductid()))
				&& (this.getRedrule() == null ? other.getRedrule() == null
						: this.getRedrule().equals(other.getRedrule()))
				&& (this.getRedname() == null ? other.getRedname() == null
						: this.getRedname().equals(other.getRedname()))
				&& (this.getRedmoney() == null ? other.getRedmoney() == null
						: this.getRedmoney().equals(other.getRedmoney()))
				&& (this.getRedlasttime() == null ? other.getRedlasttime() == null
						: this.getRedlasttime().equals(other.getRedlasttime()))
				&& (this.getRedmark() == null ? other.getRedmark() == null
						: this.getRedmark().equals(other.getRedmark()))
				&& (this.getRedcreatetime() == null ? other.getRedcreatetime() == null
						: this.getRedcreatetime().equals(other.getRedcreatetime()))
				&& (this.getRedsendcount() == null ? other.getRedsendcount() == null
						: this.getRedsendcount().equals(other.getRedsendcount()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
		result = prime * result + ((getRedrule() == null) ? 0 : getRedrule().hashCode());
		result = prime * result + ((getRedname() == null) ? 0 : getRedname().hashCode());
		result = prime * result + ((getRedmoney() == null) ? 0 : getRedmoney().hashCode());
		result = prime * result + ((getRedlasttime() == null) ? 0 : getRedlasttime().hashCode());
		result = prime * result + ((getRedmark() == null) ? 0 : getRedmark().hashCode());
		result = prime * result + ((getRedcreatetime() == null) ? 0 : getRedcreatetime().hashCode());
		result = prime * result + ((getRedsendcount() == null) ? 0 : getRedsendcount().hashCode());
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
		sb.append(", redrule=").append(redrule);
		sb.append(", redname=").append(redname);
		sb.append(", redmoney=").append(redmoney);
		sb.append(", redlasttime=").append(redlasttime);
		sb.append(", redmark=").append(redmark);
		sb.append(", redcreatetime=").append(redcreatetime);
		sb.append(", redsendcount=").append(redsendcount);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}