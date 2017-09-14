package com.lrcf.yhb.common.enums;

/**
 * 
* @ClassName: CommonTypeEnums.java
* @Description: 常用变量值的定义
*
* @version: v1.0.0
* @author: wangxf
* @date: 2017年5月10日 上午11:47:57 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2017年5月10日     wangxf           v1.0.0               修改原因
 */
public enum CommonTypeEnums {
	
	/*
	 * 新闻：
	 */
	// 新闻类型：外联-out 内联-in
	NEWS_TYPE_OUT(1,"out"),
	
	NEWS_TYPE_IN(2,"in");
	
	private Integer code;
	private String codeValue;
	
	public Integer getCode() {
		return code;
	}

	public String getCodeValue() {
		return codeValue;
	}

	private CommonTypeEnums(Integer code, String codeValue){
		this.code = code;
		this.codeValue = codeValue;
	}
}
