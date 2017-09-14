/**
 * 
 */
package com.lrcf.yhb.user.service;

import com.lrcf.yhb.common.util.DateUtil;
import com.lrcf.yhb.common.vo.UserMessageVo;
import com.lrcf.yhb.dao.mapper.AccountsCenterMeassageDao;
import com.lrcf.yhb.pojo.AccountsCenterMeassage;
import com.lrcf.yhb.user.api.AccountsCenterMeassageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: AccountsCenterMeassageServiceImpl.java
* @Description: 消息信息记录
* @author:Krx
* @date: 2017年5月11日 下午3:12:15 
*/
@Service("accountsCenterMeassageService")
public class AccountsCenterMeassageServiceImpl implements AccountsCenterMeassageService {

	private final static Logger log = LoggerFactory.getLogger(AccountsCenterMeassageServiceImpl.class);

	@Autowired
	AccountsCenterMeassageDao accountsCenterMeassageDao;
	
	/** 
	* @Function: AccountsCenterMeassageServiceImpl.java
	* @Description: 插入用户消息记录
	*
	* @param:AccountsCenterMeassage
	* @return：boolean
	* @author: Krx
	* @date: 2017年5月11日 下午3:12:50 
	*/
	@Override
	public boolean insertAccountsCenterMeassage(AccountsCenterMeassage message) {
		if(accountsCenterMeassageDao.insertSelective(message)>0){
			return true;
		}
		return false;
	}

	/**
	 * @param param
	 * @Description: 用户消息总数
	 * @param:实体类
	 * @return：boolean
	 * @author: krx
	 * @date: 2017年5月11日 下午3:11:26
	 */
	@Override
	public int getUserMessage(Map<String, Object> param) {
		log.info("访问参数:"+param);
		int count = accountsCenterMeassageDao.selectByUserId(param.get("userId").toString());
		return count;
	}

	/**
	 * @param param
	 * @Description: 用户消息列表
	 * @param:实体类
	 * @return：boolean
	 * @author: krx
	 * @date: 2017年5月11日 下午3:11:26
	 */
	@Override
	public List<UserMessageVo> getUserMessageList(Map<String, Object> param) {
		//获取页数
		Integer page = Integer.parseInt(param.get("current").toString());
		//每页显示多少记录数
		Integer size = Integer.parseInt(param.get("size").toString());
		//重新计算页数
		param.remove("current");

		param.put("current",(page - 1) * size);

		List<AccountsCenterMeassage> accountsCenterMeassagesList = accountsCenterMeassageDao.getUserMessageVO(param);

		List<UserMessageVo> userMessageVoLis = new ArrayList<UserMessageVo>();
		UserMessageVo userMessageVo = null;
		for (AccountsCenterMeassage accountsCenterMeassage:accountsCenterMeassagesList) {
			userMessageVo = new UserMessageVo();

			userMessageVo.setRead(accountsCenterMeassage.getState() == 1 ? false :true);
			userMessageVo.setId(accountsCenterMeassage.getId());
			userMessageVo.setOrigin(accountsCenterMeassage.getRemark());
			userMessageVo.setContent(accountsCenterMeassage.getMeassage());
			userMessageVo.setTime(DateUtil.parseToDateTimeStr(accountsCenterMeassage.getTime()));

			userMessageVoLis.add(userMessageVo);
		}
		return userMessageVoLis;
	}

	/**
	 * 更新
	 *
	 * @param param
	 * @return
	 */
	@Override
	public boolean updateUserMessage(Map<String, Object> param) {
		AccountsCenterMeassage message = new AccountsCenterMeassage();
		List<AccountsCenterMeassage> meassageList = new ArrayList<AccountsCenterMeassage>();
		int count = 0;
		if(param.containsKey("ids")){
			String id = param.get("ids").toString();
			String[] ids = id.split(",");

			for (String s : ids) {
				message.setId(Integer.parseInt(s));
				message.setUserid(param.get("userId").toString());
				meassageList.add(message);
			}

			for (AccountsCenterMeassage ms : meassageList) {
				count = accountsCenterMeassageDao.updateByPrimaryKeySelective(message);
			}

			return  count > 0 ? false : true;
		}
		String id = param.get("id").toString();
		message.setId(Integer.parseInt(id));
		message.setUserid(param.get("userId").toString());

		count = accountsCenterMeassageDao.updateByPrimaryKeySelective(message);

		return count > 0 ? true : false;
	}

	/**
	 * 删除Id
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteUserMessage(Integer id) {
		int count = accountsCenterMeassageDao.deleteByPrimaryKey(id);
		return count > 0 ? true : false;
	}


}
