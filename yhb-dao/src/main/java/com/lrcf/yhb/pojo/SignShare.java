package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SignShare implements Serializable {

	public SignShare() {

	}

	/**
	 * @Function: SignShare.java
	 * @Description: 构造函数
	 *
	 * @param:参数描述
	 * @version: v1.0.0
	 * @author: Krx
	 * @date: 2017年5月8日 上午11:28:56
	 */
	public SignShare(Integer id, String userid, String username, BigDecimal sharemoney, Date signtime, Integer type,
			String sharename, Integer fpuid, String childuserid, BigDecimal buymoney, Date registtime,
			String childusername, String emk1, String emk2, String emk3) {
		super();
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.sharemoney = sharemoney;
		this.signtime = signtime;
		this.type = type;
		this.sharename = sharename;
		this.fpuid = fpuid;
		this.childuserid = childuserid;
		this.buymoney = buymoney;
		this.registtime = registtime;
		this.childusername = childusername;
		this.emk1 = emk1;
		this.emk2 = emk2;
		this.emk3 = emk3;
	}

	/**
	 * @Function: SignShare.java
	 * @Description: 自定义构造函数
	 *
	 * @param:参数描述
	 * @version: v1.0.0
	 * @author: Krx
	 * @date: 2017年5月8日 上午11:28:56
	 */
	public SignShare(String userid, String username,  Date registtime, Integer type,
			String childuserid,String childusername, String sharename, String emk1) {
		super();
		this.userid = userid;
		this.username = username;
		this.registtime = registtime;
		this.type = type;
		this.childuserid = childuserid;
		this.childusername = childusername;
		this.sharename = sharename;
		this.emk1 = emk1;
	}

	private Integer id;

	private String userid;

	private String username;

	private BigDecimal sharemoney;

	private Date signtime;

	private Integer type;

	private String sharename;

	private Integer fpuid;

	private String childuserid;

	private BigDecimal buymoney;

	private Date registtime;

	private String childusername;

	private String emk1;

	private String emk2;

	private String emk3;

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

	public BigDecimal getSharemoney() {
		return sharemoney;
	}

	public void setSharemoney(BigDecimal sharemoney) {
		this.sharemoney = sharemoney;
	}

	public Date getSigntime() {
		return signtime;
	}

	public void setSigntime(Date signtime) {
		this.signtime = signtime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSharename() {
		return sharename;
	}

	public void setSharename(String sharename) {
		this.sharename = sharename;
	}

	public Integer getFpuid() {
		return fpuid;
	}

	public void setFpuid(Integer fpuid) {
		this.fpuid = fpuid;
	}

	public String getChilduserid() {
		return childuserid;
	}

	public void setChilduserid(String childuserid) {
		this.childuserid = childuserid;
	}

	public BigDecimal getBuymoney() {
		return buymoney;
	}

	public void setBuymoney(BigDecimal buymoney) {
		this.buymoney = buymoney;
	}

	public Date getRegisttime() {
		return registtime;
	}

	public void setRegisttime(Date registtime) {
		this.registtime = registtime;
	}

	public String getChildusername() {
		return childusername;
	}

	public void setChildusername(String childusername) {
		this.childusername = childusername;
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
		SignShare other = (SignShare) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
				&& (this.getUsername() == null ? other.getUsername() == null
						: this.getUsername().equals(other.getUsername()))
				&& (this.getSharemoney() == null ? other.getSharemoney() == null
						: this.getSharemoney().equals(other.getSharemoney()))
				&& (this.getSigntime() == null ? other.getSigntime() == null
						: this.getSigntime().equals(other.getSigntime()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getSharename() == null ? other.getSharename() == null
						: this.getSharename().equals(other.getSharename()))
				&& (this.getFpuid() == null ? other.getFpuid() == null : this.getFpuid().equals(other.getFpuid()))
				&& (this.getChilduserid() == null ? other.getChilduserid() == null
						: this.getChilduserid().equals(other.getChilduserid()))
				&& (this.getBuymoney() == null ? other.getBuymoney() == null
						: this.getBuymoney().equals(other.getBuymoney()))
				&& (this.getRegisttime() == null ? other.getRegisttime() == null
						: this.getRegisttime().equals(other.getRegisttime()))
				&& (this.getChildusername() == null ? other.getChildusername() == null
						: this.getChildusername().equals(other.getChildusername()))
				&& (this.getEmk1() == null ? other.getEmk1() == null : this.getEmk1().equals(other.getEmk1()))
				&& (this.getEmk2() == null ? other.getEmk2() == null : this.getEmk2().equals(other.getEmk2()))
				&& (this.getEmk3() == null ? other.getEmk3() == null : this.getEmk3().equals(other.getEmk3()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		result = prime * result + ((getSharemoney() == null) ? 0 : getSharemoney().hashCode());
		result = prime * result + ((getSigntime() == null) ? 0 : getSigntime().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getSharename() == null) ? 0 : getSharename().hashCode());
		result = prime * result + ((getFpuid() == null) ? 0 : getFpuid().hashCode());
		result = prime * result + ((getChilduserid() == null) ? 0 : getChilduserid().hashCode());
		result = prime * result + ((getBuymoney() == null) ? 0 : getBuymoney().hashCode());
		result = prime * result + ((getRegisttime() == null) ? 0 : getRegisttime().hashCode());
		result = prime * result + ((getChildusername() == null) ? 0 : getChildusername().hashCode());
		result = prime * result + ((getEmk1() == null) ? 0 : getEmk1().hashCode());
		result = prime * result + ((getEmk2() == null) ? 0 : getEmk2().hashCode());
		result = prime * result + ((getEmk3() == null) ? 0 : getEmk3().hashCode());
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
		sb.append(", sharemoney=").append(sharemoney);
		sb.append(", signtime=").append(signtime);
		sb.append(", type=").append(type);
		sb.append(", sharename=").append(sharename);
		sb.append(", fpuid=").append(fpuid);
		sb.append(", childuserid=").append(childuserid);
		sb.append(", buymoney=").append(buymoney);
		sb.append(", registtime=").append(registtime);
		sb.append(", childusername=").append(childusername);
		sb.append(", emk1=").append(emk1);
		sb.append(", emk2=").append(emk2);
		sb.append(", emk3=").append(emk3);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}