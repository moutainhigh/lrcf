/**
 * 
 */
package com.lrcf.yhb.user.service;

import com.lrcf.yhb.dao.mapper.LogMoneyChangeDao;
import com.lrcf.yhb.pojo.LogMoneyChange;
import com.lrcf.yhb.user.api.LogMoneyChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: LogMoneyChangeServiceImpl.java
* @Description: 金额日志
* @author:Krx
* @date: 2017年5月11日 下午2:11:49 
*/
@Service("logMoneyChangeService")
public class LogMoneyChangeServiceImpl implements LogMoneyChangeService {

	@Autowired
	LogMoneyChangeDao logMoneyChangeDao;
	
	//金额日志插入
	@Transactional
	@Override
	public boolean insertLogMoneyChange(LogMoneyChange logMoneyChange) {
		return false;
	}

}
