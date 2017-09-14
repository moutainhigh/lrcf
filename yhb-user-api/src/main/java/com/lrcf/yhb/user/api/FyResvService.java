package com.lrcf.yhb.user.api;

import java.util.Map;

public interface FyResvService {
	/**
	 * 快速充值回调
	 * 
	 * @param param
	 */
	void smpGate(Map<String, String> param);

	/**
	 * 快速查询接口
	 * 
	 * @param param
	 */
	void smpQueryGate(Map<String, String> param);

	/**
	 * App快速查询接口
	 * 
	 * @param param
	 */
	void appSmpGate(Map<String, String> param);
}
