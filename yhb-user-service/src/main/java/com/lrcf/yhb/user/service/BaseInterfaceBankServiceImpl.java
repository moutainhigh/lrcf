/**
 * 
 */
package com.lrcf.yhb.user.service;


import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.dao.mapper.BaseInterfaceBankDao;
import com.lrcf.yhb.pojo.BaseInterfaceBank;
import com.lrcf.yhb.user.api.BaseInterfaceBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: BaseInterfaceBankService.java
 * @Description: 银行接口
 * @author:Krx
 * @date: 2017年5月9日 下午1:45:09
 */
@Service("baseInterfaceBankService")
public class BaseInterfaceBankServiceImpl implements BaseInterfaceBankService {

	@Autowired
	BaseInterfaceBankDao interfaceBankDao;

	/**
	 * @see BaseInterfaceBankService#selectBankNumByBankCode(String)
	 * @Function: BaseInterfaceBankServiceImpl.java
	 * @Description: 查询银行通过银行代码
	 *
	 * @param:bankCode
	 * @return：BaseInterfaceBank
	 * @author: Krx
	 * @date: 2017年5月9日 下午1:45:24
	 */
	@Override
	public BaseInterfaceBank selectBankNumByBankCode(String bankCode) {
		BaseInterfaceBank interfaceBank = interfaceBankDao.selectBankNumByBankCode(bankCode);
		if (interfaceBank != null) {
			return interfaceBank;
		}
		return null;
	}

	/**
	 *
	 * @Function: BaseInterfaceBankServiceImpl.java
	 * @Description: 查询所有可以绑卡的银行列表
	 *
	 * @param:
	 * @return：
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月13日 下午3:37:00
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月13日     wangxf           v1.0.0               修改原因
	 */
	public List<BaseInterfaceBank> selectBankList(){
		List<BaseInterfaceBank> bankList = interfaceBankDao.selectAll();
		return bankList;
	}

	/**
	 *
	 * @Function: BaseInterfaceBankServiceImpl.java
	 * @Description: 拼接银行卡类表信息：{ value: '', //代号 label: '' //银行名  }
	 *
	 * @param: List<BaseInterfaceBank>
	 * @return： List<Map<String, Object>>
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月13日 下午4:33:48
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月13日     wangxf           v1.0.0               修改原因
	 */
	public List<Map<String, Object>> getBankReturnJson(List<BaseInterfaceBank> bankList){

		List<Map<String, Object>> bankListJson = null;

		if( null != bankList && bankList.size() > 0 ){

			bankListJson = new ArrayList<Map<String, Object>>();
			Map<String, Object> bank = null;

			for( BaseInterfaceBank baseBank : bankList ){
				bank = new HashMap<String,Object>();
				bank.put("value", baseBank.getBanknum());
				bank.put("label", baseBank.getRemark());

				bankListJson.add(bank);
			}
		}

		return bankListJson;
	}

	/**
	 *
	 * @Function: BaseInterfaceBankService.java
	 * @Description: 通过userid获取用户的银行卡信息
	 *
	 * @param: userId
	 * @return： BaseInterfaceBank
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月16日 下午2:46:49
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月16日     wangxf           v1.0.0               修改原因
	 */
	public BaseInterfaceBank selectBankInfoForUserId(String userId){

		if( StringUtil.isNotBlank(userId) ){
			return interfaceBankDao.selectBankInfoForUserId(userId);
		}
		return null;
	}

	/**
	 *
	 * @Function: BaseInterfaceBankService.java
	 * @Description: 封装银行卡信息出参json，当前用户已有银行卡信息 ： selected + 银行卡信息列表： list
	 *
	 * @param:userId
	 * @return： Map<String, Object>
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月16日 上午10:12:50
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月16日     wangxf           v1.0.0               修改原因
	 */
	public Map<String, Object> getBankMapForJson(String userId){

		List<BaseInterfaceBank> bankList = selectBankList();
		Map<String, Object> bankMap = null;
		if( null != bankList && bankList.size() > 0 ){
			bankMap = new HashMap<String, Object>();
			List<String> selected = new ArrayList<String>();

			List<Map<String, Object>> list = getBankReturnJson(bankList);

			// 可以选择的银行卡列表
			if( null != list && list.size() > 0 ){
				bankMap.put("list", list);
			}
			BaseInterfaceBank bank = selectBankInfoForUserId(userId);
			selected.add(bank.getBanknum());
			bankMap.put("selected", selected);
		}
		return bankMap;
	}
}
