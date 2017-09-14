package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountsUsers implements Serializable {
	private String userid;

	private String username;

	private String userpassword;

	private String checkpassword;

	private String truename;

	private String cardid;

	private String companyname;

	private String companyaddress;

	private Boolean activity;

	private String parentid;

	private Boolean isagent;

	private Integer linecount;

	private Boolean isaudituser;

	private Integer style;

	private Integer userlevel;

	private String payname;

	private String paybank;

	private String paybankaddress;

	private String paybankcardnumber;

	private String userquestion;

	private String useranswer;

	private String qq;

	private String telphone;

	private String email;

	private Date createtime;

	private String platid;

	private BigDecimal openmoney;

	private BigDecimal payfeeuserin;

	private BigDecimal maxmoney;

	private String rptemail;

	private Integer idntfcode;

	private Date idntfcodecrtime;

	private BigDecimal ybalance;

	private Boolean ismember;

	private String ipsId;

	private String ipsUsrcustid;

	private String devicetoken;

	private String logo;

	private String headimg;

	private String userEk1;

	private String userEk2;

	private String userEk3;

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

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getCheckpassword() {
		return checkpassword;
	}

	public void setCheckpassword(String checkpassword) {
		this.checkpassword = checkpassword;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public Boolean getActivity() {
		return activity;
	}

	public void setActivity(Boolean activity) {
		this.activity = activity;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public Boolean getIsagent() {
		return isagent;
	}

	public void setIsagent(Boolean isagent) {
		this.isagent = isagent;
	}

	public Integer getLinecount() {
		return linecount;
	}

	public void setLinecount(Integer linecount) {
		this.linecount = linecount;
	}

	public Boolean getIsaudituser() {
		return isaudituser;
	}

	public void setIsaudituser(Boolean isaudituser) {
		this.isaudituser = isaudituser;
	}

	public Integer getStyle() {
		return style;
	}

	public void setStyle(Integer style) {
		this.style = style;
	}

	public Integer getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(Integer userlevel) {
		this.userlevel = userlevel;
	}

	public String getPayname() {
		return payname;
	}

	public void setPayname(String payname) {
		this.payname = payname;
	}

	public String getPaybank() {
		return paybank;
	}

	public void setPaybank(String paybank) {
		this.paybank = paybank;
	}

	public String getPaybankaddress() {
		return paybankaddress;
	}

	public void setPaybankaddress(String paybankaddress) {
		this.paybankaddress = paybankaddress;
	}

	public String getPaybankcardnumber() {
		return paybankcardnumber;
	}

	public void setPaybankcardnumber(String paybankcardnumber) {
		this.paybankcardnumber = paybankcardnumber;
	}

	public String getUserquestion() {
		return userquestion;
	}

	public void setUserquestion(String userquestion) {
		this.userquestion = userquestion;
	}

	public String getUseranswer() {
		return useranswer;
	}

	public void setUseranswer(String useranswer) {
		this.useranswer = useranswer;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getPlatid() {
		return platid;
	}

	public void setPlatid(String platid) {
		this.platid = platid;
	}

	public BigDecimal getOpenmoney() {
		return openmoney;
	}

	public void setOpenmoney(BigDecimal openmoney) {
		this.openmoney = openmoney;
	}

	public BigDecimal getPayfeeuserin() {
		return payfeeuserin;
	}

	public void setPayfeeuserin(BigDecimal payfeeuserin) {
		this.payfeeuserin = payfeeuserin;
	}

	public BigDecimal getMaxmoney() {
		return maxmoney;
	}

	public void setMaxmoney(BigDecimal maxmoney) {
		this.maxmoney = maxmoney;
	}

	public String getRptemail() {
		return rptemail;
	}

	public void setRptemail(String rptemail) {
		this.rptemail = rptemail;
	}

	public Integer getIdntfcode() {
		return idntfcode;
	}

	public void setIdntfcode(Integer idntfcode) {
		this.idntfcode = idntfcode;
	}

	public Date getIdntfcodecrtime() {
		return idntfcodecrtime;
	}

	public void setIdntfcodecrtime(Date idntfcodecrtime) {
		this.idntfcodecrtime = idntfcodecrtime;
	}

	public BigDecimal getYbalance() {
		return ybalance;
	}

	public void setYbalance(BigDecimal ybalance) {
		this.ybalance = ybalance;
	}

	public Boolean getIsmember() {
		return ismember;
	}

	public void setIsmember(Boolean ismember) {
		this.ismember = ismember;
	}

	public String getIpsId() {
		return ipsId;
	}

	public void setIpsId(String ipsId) {
		this.ipsId = ipsId;
	}

	public String getIpsUsrcustid() {
		return ipsUsrcustid;
	}

	public void setIpsUsrcustid(String ipsUsrcustid) {
		this.ipsUsrcustid = ipsUsrcustid;
	}

	public String getDevicetoken() {
		return devicetoken;
	}

	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getUserEk1() {
		return userEk1;
	}

	public void setUserEk1(String userEk1) {
		this.userEk1 = userEk1;
	}

	public String getUserEk2() {
		return userEk2;
	}

	public void setUserEk2(String userEk2) {
		this.userEk2 = userEk2;
	}

	public String getUserEk3() {
		return userEk3;
	}

	public void setUserEk3(String userEk3) {
		this.userEk3 = userEk3;
	}

	public static final String Common_ID = "00000000-0000-0000-0000-000000000000";

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
		AccountsUsers other = (AccountsUsers) that;
		return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
				&& (this.getUsername() == null ? other.getUsername() == null
						: this.getUsername().equals(other.getUsername()))
				&& (this.getUserpassword() == null ? other.getUserpassword() == null
						: this.getUserpassword().equals(other.getUserpassword()))
				&& (this.getCheckpassword() == null ? other.getCheckpassword() == null
						: this.getCheckpassword().equals(other.getCheckpassword()))
				&& (this.getTruename() == null ? other.getTruename() == null
						: this.getTruename().equals(other.getTruename()))
				&& (this.getCardid() == null ? other.getCardid() == null : this.getCardid().equals(other.getCardid()))
				&& (this.getCompanyname() == null ? other.getCompanyname() == null
						: this.getCompanyname().equals(other.getCompanyname()))
				&& (this.getCompanyaddress() == null ? other.getCompanyaddress() == null
						: this.getCompanyaddress().equals(other.getCompanyaddress()))
				&& (this.getActivity() == null ? other.getActivity() == null
						: this.getActivity().equals(other.getActivity()))
				&& (this.getParentid() == null ? other.getParentid() == null
						: this.getParentid().equals(other.getParentid()))
				&& (this.getIsagent() == null ? other.getIsagent() == null
						: this.getIsagent().equals(other.getIsagent()))
				&& (this.getLinecount() == null ? other.getLinecount() == null
						: this.getLinecount().equals(other.getLinecount()))
				&& (this.getIsaudituser() == null ? other.getIsaudituser() == null
						: this.getIsaudituser().equals(other.getIsaudituser()))
				&& (this.getStyle() == null ? other.getStyle() == null : this.getStyle().equals(other.getStyle()))
				&& (this.getUserlevel() == null ? other.getUserlevel() == null
						: this.getUserlevel().equals(other.getUserlevel()))
				&& (this.getPayname() == null ? other.getPayname() == null
						: this.getPayname().equals(other.getPayname()))
				&& (this.getPaybank() == null ? other.getPaybank() == null
						: this.getPaybank().equals(other.getPaybank()))
				&& (this.getPaybankaddress() == null ? other.getPaybankaddress() == null
						: this.getPaybankaddress().equals(other.getPaybankaddress()))
				&& (this.getPaybankcardnumber() == null ? other.getPaybankcardnumber() == null
						: this.getPaybankcardnumber().equals(other.getPaybankcardnumber()))
				&& (this.getUserquestion() == null ? other.getUserquestion() == null
						: this.getUserquestion().equals(other.getUserquestion()))
				&& (this.getUseranswer() == null ? other.getUseranswer() == null
						: this.getUseranswer().equals(other.getUseranswer()))
				&& (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
				&& (this.getTelphone() == null ? other.getTelphone() == null
						: this.getTelphone().equals(other.getTelphone()))
				&& (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
				&& (this.getCreatetime() == null ? other.getCreatetime() == null
						: this.getCreatetime().equals(other.getCreatetime()))
				&& (this.getPlatid() == null ? other.getPlatid() == null : this.getPlatid().equals(other.getPlatid()))
				&& (this.getOpenmoney() == null ? other.getOpenmoney() == null
						: this.getOpenmoney().equals(other.getOpenmoney()))
				&& (this.getPayfeeuserin() == null ? other.getPayfeeuserin() == null
						: this.getPayfeeuserin().equals(other.getPayfeeuserin()))
				&& (this.getMaxmoney() == null ? other.getMaxmoney() == null
						: this.getMaxmoney().equals(other.getMaxmoney()))
				&& (this.getRptemail() == null ? other.getRptemail() == null
						: this.getRptemail().equals(other.getRptemail()))
				&& (this.getIdntfcode() == null ? other.getIdntfcode() == null
						: this.getIdntfcode().equals(other.getIdntfcode()))
				&& (this.getIdntfcodecrtime() == null ? other.getIdntfcodecrtime() == null
						: this.getIdntfcodecrtime().equals(other.getIdntfcodecrtime()))
				&& (this.getYbalance() == null ? other.getYbalance() == null
						: this.getYbalance().equals(other.getYbalance()))
				&& (this.getIsmember() == null ? other.getIsmember() == null
						: this.getIsmember().equals(other.getIsmember()))
				&& (this.getIpsId() == null ? other.getIpsId() == null : this.getIpsId().equals(other.getIpsId()))
				&& (this.getIpsUsrcustid() == null ? other.getIpsUsrcustid() == null
						: this.getIpsUsrcustid().equals(other.getIpsUsrcustid()))
				&& (this.getDevicetoken() == null ? other.getDevicetoken() == null
						: this.getDevicetoken().equals(other.getDevicetoken()))
				&& (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
				&& (this.getHeadimg() == null ? other.getHeadimg() == null
						: this.getHeadimg().equals(other.getHeadimg()))
				&& (this.getUserEk1() == null ? other.getUserEk1() == null
						: this.getUserEk1().equals(other.getUserEk1()))
				&& (this.getUserEk2() == null ? other.getUserEk2() == null
						: this.getUserEk2().equals(other.getUserEk2()))
				&& (this.getUserEk3() == null ? other.getUserEk3() == null
						: this.getUserEk3().equals(other.getUserEk3()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		result = prime * result + ((getUserpassword() == null) ? 0 : getUserpassword().hashCode());
		result = prime * result + ((getCheckpassword() == null) ? 0 : getCheckpassword().hashCode());
		result = prime * result + ((getTruename() == null) ? 0 : getTruename().hashCode());
		result = prime * result + ((getCardid() == null) ? 0 : getCardid().hashCode());
		result = prime * result + ((getCompanyname() == null) ? 0 : getCompanyname().hashCode());
		result = prime * result + ((getCompanyaddress() == null) ? 0 : getCompanyaddress().hashCode());
		result = prime * result + ((getActivity() == null) ? 0 : getActivity().hashCode());
		result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
		result = prime * result + ((getIsagent() == null) ? 0 : getIsagent().hashCode());
		result = prime * result + ((getLinecount() == null) ? 0 : getLinecount().hashCode());
		result = prime * result + ((getIsaudituser() == null) ? 0 : getIsaudituser().hashCode());
		result = prime * result + ((getStyle() == null) ? 0 : getStyle().hashCode());
		result = prime * result + ((getUserlevel() == null) ? 0 : getUserlevel().hashCode());
		result = prime * result + ((getPayname() == null) ? 0 : getPayname().hashCode());
		result = prime * result + ((getPaybank() == null) ? 0 : getPaybank().hashCode());
		result = prime * result + ((getPaybankaddress() == null) ? 0 : getPaybankaddress().hashCode());
		result = prime * result + ((getPaybankcardnumber() == null) ? 0 : getPaybankcardnumber().hashCode());
		result = prime * result + ((getUserquestion() == null) ? 0 : getUserquestion().hashCode());
		result = prime * result + ((getUseranswer() == null) ? 0 : getUseranswer().hashCode());
		result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
		result = prime * result + ((getTelphone() == null) ? 0 : getTelphone().hashCode());
		result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
		result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
		result = prime * result + ((getPlatid() == null) ? 0 : getPlatid().hashCode());
		result = prime * result + ((getOpenmoney() == null) ? 0 : getOpenmoney().hashCode());
		result = prime * result + ((getPayfeeuserin() == null) ? 0 : getPayfeeuserin().hashCode());
		result = prime * result + ((getMaxmoney() == null) ? 0 : getMaxmoney().hashCode());
		result = prime * result + ((getRptemail() == null) ? 0 : getRptemail().hashCode());
		result = prime * result + ((getIdntfcode() == null) ? 0 : getIdntfcode().hashCode());
		result = prime * result + ((getIdntfcodecrtime() == null) ? 0 : getIdntfcodecrtime().hashCode());
		result = prime * result + ((getYbalance() == null) ? 0 : getYbalance().hashCode());
		result = prime * result + ((getIsmember() == null) ? 0 : getIsmember().hashCode());
		result = prime * result + ((getIpsId() == null) ? 0 : getIpsId().hashCode());
		result = prime * result + ((getIpsUsrcustid() == null) ? 0 : getIpsUsrcustid().hashCode());
		result = prime * result + ((getDevicetoken() == null) ? 0 : getDevicetoken().hashCode());
		result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
		result = prime * result + ((getHeadimg() == null) ? 0 : getHeadimg().hashCode());
		result = prime * result + ((getUserEk1() == null) ? 0 : getUserEk1().hashCode());
		result = prime * result + ((getUserEk2() == null) ? 0 : getUserEk2().hashCode());
		result = prime * result + ((getUserEk3() == null) ? 0 : getUserEk3().hashCode());
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
		sb.append(", userpassword=").append(userpassword);
		sb.append(", checkpassword=").append(checkpassword);
		sb.append(", truename=").append(truename);
		sb.append(", cardid=").append(cardid);
		sb.append(", companyname=").append(companyname);
		sb.append(", companyaddress=").append(companyaddress);
		sb.append(", activity=").append(activity);
		sb.append(", parentid=").append(parentid);
		sb.append(", isagent=").append(isagent);
		sb.append(", linecount=").append(linecount);
		sb.append(", isaudituser=").append(isaudituser);
		sb.append(", style=").append(style);
		sb.append(", userlevel=").append(userlevel);
		sb.append(", payname=").append(payname);
		sb.append(", paybank=").append(paybank);
		sb.append(", paybankaddress=").append(paybankaddress);
		sb.append(", paybankcardnumber=").append(paybankcardnumber);
		sb.append(", userquestion=").append(userquestion);
		sb.append(", useranswer=").append(useranswer);
		sb.append(", qq=").append(qq);
		sb.append(", telphone=").append(telphone);
		sb.append(", email=").append(email);
		sb.append(", createtime=").append(createtime);
		sb.append(", platid=").append(platid);
		sb.append(", openmoney=").append(openmoney);
		sb.append(", payfeeuserin=").append(payfeeuserin);
		sb.append(", maxmoney=").append(maxmoney);
		sb.append(", rptemail=").append(rptemail);
		sb.append(", idntfcode=").append(idntfcode);
		sb.append(", idntfcodecrtime=").append(idntfcodecrtime);
		sb.append(", ybalance=").append(ybalance);
		sb.append(", ismember=").append(ismember);
		sb.append(", ipsId=").append(ipsId);
		sb.append(", ipsUsrcustid=").append(ipsUsrcustid);
		sb.append(", devicetoken=").append(devicetoken);
		sb.append(", logo=").append(logo);
		sb.append(", headimg=").append(headimg);
		sb.append(", userEk1=").append(userEk1);
		sb.append(", userEk2=").append(userEk2);
		sb.append(", userEk3=").append(userEk3);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}