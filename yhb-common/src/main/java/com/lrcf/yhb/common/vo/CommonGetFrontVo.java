/**
 * 
 */
package com.lrcf.yhb.common.vo;


import com.lrcf.yhb.common.config.BaseEntity;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: DatasConvertVo.java
 * @Description: 该类的功能描述
 * @author:Krx
 * @date: 2017年5月10日 上午9:59:22
 */
public class CommonGetFrontVo extends BaseEntity {

	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 3933020264381348228L;

	private String token;

	private Object datas;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

}
