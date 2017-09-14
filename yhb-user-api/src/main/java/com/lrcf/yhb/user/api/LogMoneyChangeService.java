/**
 * 
 */
package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.LogMoneyChange;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: LogMoneyChangeService.java
 * @Description: 金额日志
 * @author:Krx
 * @date: 2017年5月11日 下午2:10:34
 */
public interface LogMoneyChangeService {

	/**
	 * 
	 * @Description: 添加金额日志
	 *
	 * @param:LogMoneyChange
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月11日 下午2:11:23
	 */
	boolean insertLogMoneyChange(LogMoneyChange logMoneyChange);

}
