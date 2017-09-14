package com.lrcf.yhb.common.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * json数据操作基础类
 * @author Administrator
 *
 */
public class JsonUtil {

	/**
	 * map转json字符串
	 * @param map
	 * @return
	 */
	public static String parseMapToStr(Map<String, Object> map){
		return JSON.toJSONString(map);
	}
	
	/**
	 * json字符串转map
	 * @param str
	 * @return
	 */
	public static Map<String, Object> parseStrToMap(String str){
		return JSON.parseObject(str);
	}


}
