package com.lrcf.yhb.user.service;

import com.lrcf.yhb.common.api.Fy.FyConstants;
import com.lrcf.yhb.common.api.ips.IpsConstants;
import com.lrcf.yhb.dao.mapper.HxCallbackDao;
import com.lrcf.yhb.dao.mapper.HxOrderInfoDao;
import com.lrcf.yhb.pojo.HxCallback;
import com.lrcf.yhb.pojo.HxOrderInfo;
import com.lrcf.yhb.user.api.HuanXunOrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("huanXunOrderInfoService")
public class HuanXunOrderInfoServiceImpl implements HuanXunOrderInfoService {
	private static Logger logger = LoggerFactory.getLogger(HuanXunOrderInfoServiceImpl.class);
	
	@Autowired
	HxOrderInfoDao hxOrderInfoDao;
	@Autowired
	HxCallbackDao hxCallBackDao;

	@Transactional
	@Override
	public void addForRequest(Map<String, String> params) {
		HxOrderInfo orderInfo = new HxOrderInfo();
		orderInfo.setCreateTime(new Date());// 请求时间
		orderInfo.setActName(params.get(FyConstants.operationType));// 类型
		orderInfo.setUsrCustid(params.get(FyConstants.mchnt_cd));// 用户id
		orderInfo.setExtendField(params.get(FyConstants.order_id));
		orderInfo.setReqInfo(params.toString());// 请求报文
		orderInfo.setCreateTime(new Date());
		hxOrderInfoDao.insertSelective(orderInfo);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional
	public void updateForReturn(Map<String, String> returnParam) {
		System.out.println("返回的参数" + returnParam);
		try {
			HxOrderInfo orderInfo = hxOrderInfoDao.selectByMerBill(returnParam.get("order_id"));
			if (orderInfo == null || "".equals(orderInfo)) {
				logger.error("update HuanXunOrderInfo error!!!!!");
			} else {
				orderInfo.setReturnInfo(returnParam.toString());
				orderInfo.setReturnTime(new Date());
				hxOrderInfoDao.updateByPrimaryKeySelective(orderInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("update HuanXunOrderInfo error why by" + e);
		}
	}

	@Override
	@Transactional
	public void updateForNotify(Map<String, String> returnParam) {
		try {
			HxOrderInfo orderInfo = hxOrderInfoDao.selectByMerBill(returnParam.get("order_id"));
			if (orderInfo == null || "".equals(orderInfo)) {
				logger.error("update HuanXunOrderInfo error!!!!!");
			} else {
				orderInfo.setIpsBillno(returnParam.get(FyConstants.Fy_ssn));
				orderInfo.setNotifyInfo(returnParam.toString());
				orderInfo.setNotifyTime(new Date());
				hxOrderInfoDao.updateByPrimaryKeySelective(orderInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("update HuanXunOrderInfo error why by" + e);
		}

	}

	@Override
	public int selectSuccessOrder(Map<String, String> param) {
		return 0;
	}

	@Override
	public void insertHfCallback(HxCallback hfCallback) {

	}

	@Override
	@Transactional
	public void deleteHfCallback(Map<String, String> param) {
		try {
			HxOrderInfo orderInfo = hxOrderInfoDao.selectByMerBill(param.get("merBillNo"));
			if (orderInfo != null) {
				hxOrderInfoDao.deleteByPrimaryKey(orderInfo.getId());
				HxCallback callBack = new HxCallback();
				callBack.setAddTime(new Date());
				callBack.setHxTrxId(orderInfo.getExtendField());
				callBack.setReturnParams(orderInfo.getReqInfo());
				hxCallBackDao.insertSelective(callBack);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("delete HuanXunOrderInfo and insert to insertHxCallback  error why by" + e);
		}
	}

	@Override
	public HxOrderInfo selectByMerBill(String param) {
		return hxOrderInfoDao.selectByMerBill(param);
	}

	@Override
	public HxOrderInfo selectByipsBillNo(Object param) {
		return hxOrderInfoDao.selectByipsBill(param);
	}

	@Override
	@Transactional
	public void appUpdateForNotify(Map<String, String> params) {
		try {
			Map<String, String> param = new HashMap();
			// param.put("extendField", params.get("merBillNo"));
			HxOrderInfo orderInfo = hxOrderInfoDao.selectByMerBill(params.get("MCHNTORDERID"));
			if (orderInfo == null || "".equals(orderInfo)) {
				logger.error("update HuanXunOrderInfo error!!!!!");
			} else {
				orderInfo.setIpsBillno(params.get(IpsConstants.ipsBillNo));
				orderInfo.setNotifyInfo(params.toString());
				orderInfo.setNotifyTime(new Date());
				orderInfo.setIpsBillno(params.get("ipsBillNo"));
				hxOrderInfoDao.updateByPrimaryKeySelective(orderInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("update HuanXunOrderInfo error why by" + e);
		}
	}

	@Override
	@Transactional
	public void addForRequests(Map<String, String> params) {
		HxOrderInfo orderInfo = new HxOrderInfo();
		orderInfo.setCreateTime(new Date());// 请求时间
		orderInfo.setActName(params.get(IpsConstants.operationType));// 请求类型
		orderInfo.setUsrCustid(params.get(IpsConstants.merchantID));// 商户Id
		orderInfo.setExtendField(params.get(IpsConstants.merBillNo));
		orderInfo.setReqInfo(params.toString());// 请求的参数
		orderInfo.setCreateTime(new Date());
		hxOrderInfoDao.insertSelective(orderInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void updateForReturns(Map<String, String> returnParam) {
		System.out.println("返回过来的参数" + returnParam);
		try {
			HxOrderInfo orderInfo = hxOrderInfoDao.selectByMerBill(returnParam.get("merBillNo"));
			if (orderInfo == null || "".equals(orderInfo)) {
				logger.error("update HuanXunOrderInfo error!!!!!");
			} else {
				orderInfo.setIpsBillno(returnParam.get(IpsConstants.ipsBillNo));
				orderInfo.setReturnInfo(returnParam.toString());
				orderInfo.setReturnTime(new Date());
				hxOrderInfoDao.updateByPrimaryKeySelective(orderInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("update HuanXunOrderInfo error why by" + e);
		}
	}

	@Override
	@Transactional
	public void updateForNotifys(Map<String, String> returnParam) {
		try {
			HxOrderInfo orderInfo = hxOrderInfoDao.selectByMerBill(returnParam.get("merBillNo"));
			if (orderInfo == null || "".equals(orderInfo)) {
				logger.error("update HuanXunOrderInfo error!!!!!");
			} else {
				orderInfo.setIpsBillno(returnParam.get(IpsConstants.ipsBillNo));
				orderInfo.setNotifyInfo(returnParam.toString());
				orderInfo.setNotifyTime(new Date());
				orderInfo.setIpsBillno(returnParam.get("ipsBillNo"));
				hxOrderInfoDao.updateByPrimaryKeySelective(orderInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("update HuanXunOrderInfo error why by" + e);
		}

	}

}
