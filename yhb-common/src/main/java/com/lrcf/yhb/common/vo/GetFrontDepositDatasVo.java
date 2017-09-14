/**
 * 
 */
package com.lrcf.yhb.common.vo;

import com.lrcf.yhb.common.config.BaseEntity;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: Datas.java
 * @Description: datas中的值
 * @author:Krx
 * @date: 2017年5月9日 下午2:23:17
 */
public class GetFrontDepositDatasVo extends BaseEntity {
	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 3237387803935804785L;
	
	private String account;
	private String bankCode;
	private String trdAmt;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getTrdAmt() {
		return trdAmt;
	}

	public void setTrdAmt(String trdAmt) {
		this.trdAmt = trdAmt;
	}

}
