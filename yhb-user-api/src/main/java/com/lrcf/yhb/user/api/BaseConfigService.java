/**
 * 
 */
package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.BaseConfig;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: BaseConfigService.java
 * @Description: 系统配置
 * @author:Krx
 * @date: 2017年5月8日 下午3:46:55
 */
public interface BaseConfigService {

	/**
	 * @Description: 根据配置名称查询配置
	 * @param:param
	 * @return：BaseConfig
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:47:16
	 */
	BaseConfig selectByParam(String param);


	/**
	 * @Description: 获取所有的配置方式
	 * @param:param
	 * @return：BaseConfig
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:47:16
	 */
	List<BaseConfig> getAllBaseConfig();

	/**
	 * @Description: 获取秒杀或主推的配置
	 * @param:param
	 * @return：BaseConfig
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:47:16
	 */
	Map<String, Object> getSeckill();


}
