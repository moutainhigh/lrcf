package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.Region;
import com.lrcf.yhb.pojo.RegionInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
* @ClassName: RegionInfoService.java
* @Description: 获取全国的区域详细信息
*
* @version: v1.0.0
* @author: wangxf
* @date: 2017年5月15日 下午2:57:24 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2017年5月15日     wangxf           v1.0.0               修改原因
 */
public interface RegionInfoService {

	/**
	 * 
	* @Function: RegionInfoService.java
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
	* @Function: RegionInfoService.java
	* @Description: 根据传入的parentId获取其一级children信息
	*
	* @param: parentId
	* @return： List<Region>
	* @throws： 
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月15日 下午4:37:55 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月15日     wangxf           v1.0.0               修改原因
	 */
	List<Region> selectRegionInfoByParentId(Double parentId);
	
	/**
	 * 
	* @Function: RegionInfoService.java
	* @Description: 获取所有的省份和他所对应的市
	*
	* @param: 
	* @return： List<Map<String, Object>>
	* @throws： 
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月15日 下午4:50:25 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月15日     wangxf           v1.0.0               修改原因
	 */
	List<Map<String, Object>> getProAndCityInfo();
	
	/**
	 * 
	* @Function: RegionInfoService.java
	* @Description: 封装省市信息出参json，当前用户已有银行卡信息 ： selected + 银行卡信息列表： list
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月16日 上午10:23:22 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月16日     wangxf           v1.0.0               修改原因
	 */
	Map<String, Object> getProMapForJson(String userId);
	
	/**
	 * 
	* @Function: RegionInfoService.java
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
