package com.lrcf.yhb.user.service;

import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.dao.mapper.RegionDao;
import com.lrcf.yhb.dao.mapper.RegionInfoDao;
import com.lrcf.yhb.pojo.Region;
import com.lrcf.yhb.pojo.RegionInfoEntity;
import com.lrcf.yhb.user.api.RegionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
@Service("regionInfoService")
public class RegionInfoServiceImpl implements RegionInfoService {

	@Autowired
	RegionInfoDao regionInfoDao;
	@Autowired
	RegionDao regionDao;
	
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
	@Override
	public List<RegionInfoEntity> selectRegionInfo(){
		return regionInfoDao.selectRegionInfo();
	}
	
	/**
	 * 
	* @Function: RegionInfoServiceImpl.java
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
	@Override
	public List<Region> selectRegionInfoByParentId(Double parentId){
		if( null != parentId ){
			return regionDao.selectByParentId(parentId);
		}
		return null;
	}
	
	/**
	 * 
	* @Function: RegionInfoServiceImpl.java
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
	@Override
	public List<Map<String, Object>> getProAndCityInfo(){
		// List<RegionInfoEntity> regionInfoList = selectRegionInfo();

		List<Region> regionProList = regionDao.selectByLevel(1);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		if( null != regionProList && regionProList.size() > 0 ){
			
			for( Region regionPro : regionProList ){
				
				Map<String, Object> proMap = new HashMap<String, Object>();
				List<Map<String, Object>> childrenList = new ArrayList<Map<String, Object>>();
				
				List<Region> childs = selectRegionInfoByParentId(regionPro.getRegionId());
				if( null != childs &&  childs.size() > 0 ){
					Map<String, Object> childMap = null;
					for( Region region : childs ){
						childMap = new HashMap<String, Object>();
						childMap.put("value", region.getRegionId());
						childMap.put("label", region.getRegionName());
						childrenList.add(childMap);
					}
				}
				
				proMap.put("value", regionPro.getRegionId().intValue());
				proMap.put("label", regionPro.getRegionName());
				proMap.put("children", childrenList);
				
				returnList.add(proMap);
			}
		}
		return returnList;
	}
	
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
	@Override
	public RegionInfoEntity selectProAndCityForUserId(String userId){
		if( StringUtil.isNotBlank(userId) ){
			return regionInfoDao.selectProAndCityForUserId(userId);
		}
		return null;
	}
	
	/**
	 * 
	* @Function: RegionInfoServiceImpl.java
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
	@Override
	public Map<String, Object> getProMapForJson(String userId){
		
		// 银行卡相关信息--省市信息
		Map<String, Object> proMap = new HashMap<String, Object>();
		// 现有银行卡信息 --现有的省市信息
		List<Object> selected = new ArrayList<Object>();
		RegionInfoEntity regionInfoEntity = selectProAndCityForUserId(userId);
		if( null != regionInfoEntity ){
			
			selected.add((int)regionInfoEntity.getProvince_id());
			selected.add((int)regionInfoEntity.getCity_id());
			
		}
		proMap.put("selected", selected);
		proMap.put("list", getProAndCityInfo());
		return proMap;
	}
}
