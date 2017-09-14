package com.lrcf.yhb.dao.mapper;


import com.lrcf.yhb.pojo.RegionInfoEntity;

import java.util.List;

/**
 * 
* @ClassName: RegionInfoDao.java
* @Description: 获取详细的区域信息
*
* @version: v1.0.0
* @author: wangxf
* @date: 2017年5月15日 下午3:33:47 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2017年5月15日     wangxf           v1.0.0               修改原因
 */
public interface RegionInfoDao {

	/**
	 * 
	* @Function: RegionInfoDao.java
	* @Description: 获取城市的详细信息
	*
	* @param: 
	* @return： List<RegionInfoEntity>
	* @throws： 
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月15日 下午3:36:41 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月15日     wangxf           v1.0.0               修改原因
	 */
	List<RegionInfoEntity> selectRegionInfo();
	
	/**
	 * 
	* @Function: RegionInfoDao.java
	* @Description: 根据用户的userId来获取用户银行卡的省市信息
	*
	* @param: userId
	* @return： RegionInfoEntity
	* @throws： 
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月16日 下午2:13:55 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月16日     wangxf           v1.0.0               修改原因
	 */
	RegionInfoEntity selectProAndCityForUserId(String userId);
}
