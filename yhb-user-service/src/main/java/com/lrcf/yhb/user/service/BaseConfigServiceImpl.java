/**
 * 
 */
package com.lrcf.yhb.user.service;

import com.lrcf.yhb.dao.mapper.BaseConfigDao;
import com.lrcf.yhb.pojo.BaseConfig;
import com.lrcf.yhb.user.api.BaseConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: BaseConfigServiceImpl.java
* @Description: 配置实现类
* @author:Krx
* @date: 2017年5月8日 下午3:47:51 
*/
@Service("baseConfigService")
public class BaseConfigServiceImpl implements BaseConfigService {

	@Autowired
	BaseConfigDao baseConfigDao;


	/**
	 * @param param
	 * @Description: 根据配置名称查询配置
	 * @param:param
	 * @return：BaseConfig
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:47:16
	 */
	@Override
	public BaseConfig selectByParam(String param) {
		return this.baseConfigDao.selectByParam(param);
	}

	/**
	 * @Description: 获取所有的配置方式
	 * @param:param
	 * @return：BaseConfig
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:47:16
	 */
	@Override
	public List<BaseConfig> getAllBaseConfig() {
		return this.baseConfigDao.getAllbase();
	}

	/**
	 * @Description: 获取秒杀或主推的配置
	 * @param:param
	 * @return：BaseConfig
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:47:16
	 */
	@Override
	public Map<String, Object> getSeckill() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fpid = "";
		int state = 0;

		try {
			BaseConfig bg = baseConfigDao.selectByParam("cfg_seckillFPid");
			if (bg != null && (sdf.parse(bg.getData())).getTime() >= (new Date()).getTime()) {
				fpid = bg.getValue();
				state = 1;
			} else if (bg != null && (sdf.parse(bg.getData())).getTime() <= (new Date()).getTime() && bg.getRes1().equals("1")) {
				BaseConfig bgc = baseConfigDao.selectByParam("cfg_appIndexPro");
				if (bgc != null) {
					if (bgc.getValue() != null && !bgc.getValue().equals("")) {
						fpid = bgc.getValue();
						state = 0;
						resultMap.put("fpid", fpid);
						resultMap.put("state", state);
						return resultMap;
					} else {
						resultMap.put("code", -1);
						resultMap.put("message", "首推产品未设置");
						return resultMap;
					}
				} else {
					resultMap.put("code", -1);
					resultMap.put("message", "首推产品未设置");
					return resultMap;
				}
			} else if (bg != null && (sdf.parse(bg.getData())).getTime() <= (new Date()).getTime() && bg.getRes1().equals("2")) {
				fpid = bg.getValue();
				state = 1;
			} else if (bg == null) {
				BaseConfig bgc = baseConfigDao.selectByParam("cfg_appIndexPro");
				if (bgc != null) {
					if (bgc.getValue() != null && !bgc.getValue().equals("")) {
						fpid = bgc.getValue();
						state = 0;
					} else {
						resultMap.put("code", -1);
						resultMap.put("message", "首推产品未设置");
						return resultMap;
					}
				} else {
					resultMap.put("code", -1);
					resultMap.put("message", "首推产品未设置");
					return resultMap;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			resultMap.put("fpid", fpid);
			resultMap.put("state", state);
			return resultMap;
		}
	}


}
