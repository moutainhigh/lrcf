/**
 * 
 */
package com.lrcf.yhb.common.vo;


import com.lrcf.yhb.common.config.BaseEntity;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: ReturnDatasVo.java
 * @Description: 返回的对象
 * @author:Krx
 * @date: 2017年5月10日 下午2:42:01
 */
public class CommonReturnFrontVo extends BaseEntity {

	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = -432886676229473626L;

	private boolean status;

	private Object datas;
	
	public CommonReturnFrontVo(){
		this.status = false ;
		this.datas = "";
	}
	
	public CommonReturnFrontVo(boolean status,Object datas){
		this.status = status ;
		this.datas = datas;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

}
