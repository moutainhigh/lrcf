/**
 * 
 */
package com.lrcf.yhb.gift.service;

import com.lrcf.yhb.gift.api.AccountRaiseGetService;
import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.dao.mapper.AccountRaiseGetDao;
import com.lrcf.yhb.pojo.AccountRaiseGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: AccountRaiseGetServiceImpl.java
* @Description: 用户加息劵实现类
* @author:Krx
* @date: 2017年5月16日 上午11:01:22 
*/
@Service("accountRaiseGetService")
public class AccountRaiseGetServiceImpl implements AccountRaiseGetService {

	@Autowired
	AccountRaiseGetDao accountsRaiseDao;
	/**
	 *
	 * @Description: 根据UserId,type,productId获取加息劵
	 *
	 * @param: userId
	 * @return：List
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:47:16
	 */
	@Override
	public List<AccountRaiseGet> getUserRaise(String userId, Integer id, String...type) {
		Integer state  = 0;
		if(StringUtil.isNotBlank(type.toString())){
			state = Integer.parseInt(type.toString());
		}

		Map param = new HashMap();
		param.put("state", state);
		param.put("userId", userId);
		param.put("id", id);


		return accountsRaiseDao.selectRaiseByUserIdAndStateAndProId(param);
	}

	/**
	 * @param param
	 * @Description: 根据param获取加息劵记录总数
	 * @param: userId
	 * @return：List
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:47:16
	 */
	@Override
	public int getUserRaiseCount(Map<String, Object> param) {
		return accountsRaiseDao.countAccountRaiseGet(param);
	}

	/**
	 * @param param
	 * @Description: 根据param获取加息劵列表
	 * @param: userId
	 * @return：List
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:47:16
	 */
	@Override
	public List<AccountRaiseGet> getUserRaiseList(Map<String, Object> param) {
		Map<String, Object> sqlMap = new HashMap<String, Object>();
		//userId
		String userId = param.get("userId").toString();
		//状态 //0: 未使用, 2: 已使用, 3: 已过期
		Integer state = Integer.parseInt(param.get("state").toString());
		//0表示未使用 1表示已使用 3表示已过期
		if(state == 2){
			state = 1;
		}
		sqlMap.put("state", state);
		sqlMap.put("userId", userId);
		//获取页数
		Integer page = Integer.parseInt(param.get("current").toString());
		//每页显示多少记录数
		Integer size = Integer.parseInt(param.get("size").toString());
		//重新计算页数
		sqlMap.put("current",(page - 1) * size);
		sqlMap.put("size", size);
		//排序
		String rank = param.get("rank").toString();
		if(rank.equals("value")){
			rank = "raiseSize";  //红包金额
		} else if(rank.equals("getTime")){
			rank = "raiseGetTime";  //得到时间
		}else if(rank.equals("endTime")){
			rank = "raiseOverTime"; //过期时间
		}
		sqlMap.put("rank",rank);


		List<AccountRaiseGet> accountRaiseGetList = accountsRaiseDao.selectRaiseList(sqlMap);
		if (accountRaiseGetList.size() > 0 || StringUtil.isNotNull(accountRaiseGetList)) {
			return accountRaiseGetList;
		}
		return null;
	}
}
