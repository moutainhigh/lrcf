/**
 * 
 */
package com.lrcf.yhb.common.vo;


import com.lrcf.yhb.common.config.BaseEntity;

import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: ReturnDatasVo.java
 * @Description: 实体对象
 * @author:Krx
 * @date: 2017年5月10日 下午2:43:04
 */
public class ReturnDepositDatasVo extends BaseEntity {

	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = -8643348158033073153L;
	
	private String action;
	private Map<String,Object> items;
	
	public Map<String, Object> getItems() {
		return items;
	}

	public void setItems(Map<String, Object> items) {
		this.items = items;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
