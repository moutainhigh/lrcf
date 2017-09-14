package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.util.Date;

public class HxOrderInfo implements Serializable {
	private Integer id;

	private String usrCustid;

	private String ipsBillno;

	private String actName;

	private String extendField;

	private Date createTime;

	private Date returnTime;

	private Date notifyTime;

	private String reqInfo;

	private String returnInfo;

	private String notifyInfo;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsrCustid() {
		return usrCustid;
	}

	public void setUsrCustid(String usrCustid) {
		this.usrCustid = usrCustid;
	}

	public String getIpsBillno() {
		return ipsBillno;
	}

	public void setIpsBillno(String ipsBillno) {
		this.ipsBillno = ipsBillno;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getExtendField() {
		return extendField;
	}

	public void setExtendField(String extendField) {
		this.extendField = extendField;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public Date getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(Date notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getReqInfo() {
		return reqInfo;
	}

	public void setReqInfo(String reqInfo) {
		this.reqInfo = reqInfo;
	}

	public String getReturnInfo() {
		return returnInfo;
	}

	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}

	public String getNotifyInfo() {
		return notifyInfo;
	}

	public void setNotifyInfo(String notifyInfo) {
		this.notifyInfo = notifyInfo;
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
		HxOrderInfo other = (HxOrderInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUsrCustid() == null ? other.getUsrCustid() == null
						: this.getUsrCustid().equals(other.getUsrCustid()))
				&& (this.getIpsBillno() == null ? other.getIpsBillno() == null
						: this.getIpsBillno().equals(other.getIpsBillno()))
				&& (this.getActName() == null ? other.getActName() == null
						: this.getActName().equals(other.getActName()))
				&& (this.getExtendField() == null ? other.getExtendField() == null
						: this.getExtendField().equals(other.getExtendField()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null
						: this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getReturnTime() == null ? other.getReturnTime() == null
						: this.getReturnTime().equals(other.getReturnTime()))
				&& (this.getNotifyTime() == null ? other.getNotifyTime() == null
						: this.getNotifyTime().equals(other.getNotifyTime()))
				&& (this.getReqInfo() == null ? other.getReqInfo() == null
						: this.getReqInfo().equals(other.getReqInfo()))
				&& (this.getReturnInfo() == null ? other.getReturnInfo() == null
						: this.getReturnInfo().equals(other.getReturnInfo()))
				&& (this.getNotifyInfo() == null ? other.getNotifyInfo() == null
						: this.getNotifyInfo().equals(other.getNotifyInfo()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUsrCustid() == null) ? 0 : getUsrCustid().hashCode());
		result = prime * result + ((getIpsBillno() == null) ? 0 : getIpsBillno().hashCode());
		result = prime * result + ((getActName() == null) ? 0 : getActName().hashCode());
		result = prime * result + ((getExtendField() == null) ? 0 : getExtendField().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getReturnTime() == null) ? 0 : getReturnTime().hashCode());
		result = prime * result + ((getNotifyTime() == null) ? 0 : getNotifyTime().hashCode());
		result = prime * result + ((getReqInfo() == null) ? 0 : getReqInfo().hashCode());
		result = prime * result + ((getReturnInfo() == null) ? 0 : getReturnInfo().hashCode());
		result = prime * result + ((getNotifyInfo() == null) ? 0 : getNotifyInfo().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", usrCustid=").append(usrCustid);
		sb.append(", ipsBillno=").append(ipsBillno);
		sb.append(", actName=").append(actName);
		sb.append(", extendField=").append(extendField);
		sb.append(", createTime=").append(createTime);
		sb.append(", returnTime=").append(returnTime);
		sb.append(", notifyTime=").append(notifyTime);
		sb.append(", reqInfo=").append(reqInfo);
		sb.append(", returnInfo=").append(returnInfo);
		sb.append(", notifyInfo=").append(notifyInfo);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}