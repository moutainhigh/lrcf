/**
 * 
 */
package com.lrcf.yhb.user.service;


import com.lrcf.yhb.common.config.BaseConstants;
import com.lrcf.yhb.common.util.GenerateNo;
import com.lrcf.yhb.dao.mapper.DealOrderDao;
import com.lrcf.yhb.pojo.AccountsUsers;
import com.lrcf.yhb.pojo.BaseInterfaceBank;
import com.lrcf.yhb.pojo.DealOrder;
import com.lrcf.yhb.user.api.BaseInterfaceBankService;
import com.lrcf.yhb.user.api.DealOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: DealOrderServiceImpl.java
 * @Description: 该类的功能描述
 * @author:Krx
 * @date: 2017年5月9日 下午1:42:19
 */
@Service("dealOrderService")
public class DealOrderServiceImpl implements DealOrderService {

	@Autowired
	DealOrderDao dealOrderDao;
	@Autowired
	BaseInterfaceBankService baseInterfaceBankService;

	/**
	 * @see DealOrderService#insertDealOrder(Map)
	 * @Function: DealOrderServiceImpl.java
	 * @Description: 插入充值订单
	 *
	 * @param:param
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月9日 下午1:42:30
	 */
	@Override
	public boolean insertDealOrder(Map<String, String> param) {
		String trdAmt = "100.01";
		String token = "70f320bc9cce4d3490b1b6065ab00710ef6ee733-b616-4341-bad0-16dc6adbd958";
		String bankCode = "0803030000";

		// 获取Redis_Key
		// 用户信息
//		AccountsUsers user = cache.getCache(cache_key, AccountsUsers.class);
		AccountsUsers user = null;
		if (user == null) {
			return false;
		}

		// 查询支持的银行
		BaseInterfaceBank interfaceBank = baseInterfaceBankService.selectBankNumByBankCode(bankCode);
		// 充值来源
		String type = param.get("type");
		// 充值金额
		BigDecimal order_amt = new BigDecimal(trdAmt);
		// 平台手续费
//		BigDecimal payFee = new BigDecimal(PropertiesFileUtil.getInstance("conf").get("PayFee"));
		BigDecimal payFee = new BigDecimal(0.5);
		DealOrder dealOrder = new DealOrder();
		dealOrder.setOrderid(GenerateNo.getUUID());
		dealOrder.setOrdernumber(param.get("order_id"));
		dealOrder.setOrdermoney(order_amt);
		dealOrder.setOrderstate(1);
		dealOrder.setChannelid(interfaceBank == null ? 0 : interfaceBank.getId());
		dealOrder.setInterfacepercentage(payFee);
		dealOrder.setChannelname(Integer.parseInt(type) == 1 ? "网银支付" : "手机支付");
		dealOrder.setInterfacename(interfaceBank == null ? "暂无" : interfaceBank.getRemark());
		dealOrder.setPayitem(interfaceBank == null ? "暂无" : interfaceBank.getBanknum());
		dealOrder.setEmployeeid(user.getParentid());
		dealOrder.setEmployeepercentage(BigDecimal.ZERO);
		dealOrder.setOthermoney(BigDecimal.ZERO);
		dealOrder.setUserid(user.getUserid());
		dealOrder.setCreatetime(new Date()); // 订单创建时间
		dealOrder.setCheckid(BaseConstants.ParentIDCom);
		dealOrder.setCheckorderid(BaseConstants.ParentIDCom);
		dealOrder.setChecktime(new Date());
		dealOrder.setReturntime(new Date());
		dealOrder.setRemark("充值");
		int count = dealOrderDao.insertSelective(dealOrder);

		if (count > 0) {
			return true;
		}

		return false;
	}

	/**
	* @see DealOrderService#selectOrderByOrderNumber(String)
	* @Function: DealOrderServiceImpl.java
	* @Description: 根据单号查询订单信息
	*
	* @param:orderNumber
	* @return：DealOrder
	* @author: Krx
	* @date: 2017年5月11日 下午2:17:31 
	*/
	@Override
	public DealOrder selectOrderByOrderNumber(String orderNumber) {
		return dealOrderDao.selectByPrimaryKey(orderNumber);
	}

	/** 
	* @Function: DealOrderServiceImpl.java
	* @Description: 更新充值订单信息
	*
	* @param:dealOrder
	* @return：boolean
	* @author: Krx
	* @date: 2017年5月11日 下午2:37:55 
	*/
	@Override
	public boolean updateDealOrder(DealOrder dealOrder) {
		if(dealOrderDao.updateByPrimaryKeySelective(dealOrder)>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	* @Function: DealOrderService.java
	* @Description: 获取投资记录信息
	*
	* @return： List<DealOrder>
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月11日 上午10:12:15 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月11日     wangxf           v1.0.0               修改原因
	 */
	@Override
	public List<DealOrder> selectInvestmentRecord(){
		return dealOrderDao.selectInvestmentRecord();
	}
	
}
