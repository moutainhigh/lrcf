package com.lrcf.yhb.common.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;

public class ResponseDto {

	/**
	 * 集合key
	 */
	private final String LIST_KEY = "list";

	/**
	 * 分页key
	 */
	private final String PAGE_KEY = "page";

	/**
	 * 返回类型
	 */
	private Map<String, Object> params = new HashMap<String, Object>();

	/**
	 * 返回CODE
	 */
	@Expose
	private String code;

	/**
	 * 返回提示信息
	 */
	@Expose
	private String message = "成功";

	/**
	 * 返回结果信息
	 */
	@Expose
	private Object result;

	/**
	 * 添加list集合
	 * 
	 * @param list
	 */
	public void addLists(List<Object> list) {
		params.put(LIST_KEY, list);
		this.setResult(params);
	}

	/**
	 * 添加page信息
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param totalPage
	 */
	public void addPage(int currentPage, int pageSize, int totalPage, Object data) {
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);
		params.put("totalPage", totalPage);
		params.put(PAGE_KEY, data);

		this.setResult(params);
	}


	/**
	 * 添加其他信息
	 */
	public void addKeyValue(String key, Object value) {
		if (value == null) {
			value = "";
		}
		params.put(key, value);

		this.setResult(params);
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
