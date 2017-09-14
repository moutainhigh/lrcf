package com.lrcf.yhb.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings({ "unchecked" })
@Service("fySend")
@Transactional
public class FySendServiceImpl  {
//implements FySendService
//	@Override
//	public Map<String, String> smpGate(Map<String, String> param) throws Exception {
//		Map<String,String> fParam = new HashMap();
//		fParam.put(FyConstants.order_amt, param.get(FyConstants.order_amt));
//		fParam.put(FyConstants.order_pay_type, FyConstants.B2C);
//		fParam.put(FyConstants.iss_ins_cd, param.get(FyConstants.iss_ins_cd));
//		fParam.put(FyConstants.ver,FyConstants.version);
//		fParam.put(FyConstants.order_id,param.get(FyConstants.order_id));
//		fParam.put(FyConstants.operationType,FyConstants.smpGate);
//
//		return DepositGateWay.dealRequest(fParam,FyConstants.TYPE_FROM);
//	}
//	@Override
//	public Map<String, String> cardBinQuery(Map<String, String> param) throws Exception {
//		Map<String,String> fParam = new HashMap();
//		fParam.put(FyConstants.Ono, param.get(FyConstants.Ono));
//		fParam.put(FyConstants.operationType,FyConstants.cardBinQuery);
//		return DepositGateWay.dealRequest(fParam,FyConstants.TYPE_XML);
//	}
//	@Override
//	public Map<String, String> smpQueryGate(Map<String, String> param) throws Exception {
//		Map<String,String> fParam = new HashMap();
//		fParam.put(FyConstants.order_id, param.get(FyConstants.order_id));
//		fParam.put(FyConstants.operationType,FyConstants.smpQueryGate);
//		return DepositGateWay.dealRequest(fParam,FyConstants.TYPE_FROM);
//
//	}
//	@Override
//	public Map<String, String> payAction(Map<String, String> param) throws Exception {
//		Map<String,String> fParam = new HashMap();
//		fParam.put(FyConstants.ENCTP, FyConstants.post_jm);
//		fParam.put(FyConstants.TYPE, FyConstants.app_trade_type);  //交易类型
//		fParam.put(FyConstants.VERSION,FyConstants.APP_version);
//		fParam.put(FyConstants.MCHNTORDERID, OrderNoUtils.makeOrderNo());
//		fParam.put(FyConstants.USERID, param.get("userId"));
//		fParam.put(FyConstants.AMT,param.get("amt"));
//		fParam.put(FyConstants.BANKCARD,param.get("bankCard"));
//		fParam.put(FyConstants.NAME,param.get("name"));
//		fParam.put(FyConstants.IDTYPE,"0");  //身份证类型 0身份证
//		fParam.put(FyConstants.SIGNTP, "md5");
//		fParam.put(FyConstants.IDNO,param.get("cardId"));  //身份证号
//		fParam.put(FyConstants.operationType,FyConstants.payAction);
//		return DepositGateWay.dealRequest(fParam,FyConstants.TYPE_XML);
//	}
//	@Override
//	public Map<String, String> lmtQueryAction(Map<String, String> param) throws Exception {
//		Map<String,String> fParam = new HashMap();
//		fParam.put(FyConstants.INSCD, param.get(FyConstants.INSCD));
//		return DepositGateWay.dealLimitQueryRequest(fParam);
//	}
//	@Override
//	public Map<String, String> queryOrderId(Map<String, String> param) throws Exception {
//		Map<String,String> fParam = new HashMap();
//		fParam.put(FyConstants.OrderId, param.get(FyConstants.OrderId));
//		return DepositGateWay.dealQueryOrderIdRequest(fParam);
//	}
//	@Override
//	public Map<String, String> smpAQueryGate(Map<String, String> param) throws Exception {
//		Map<String,String> fParam = new HashMap();
//		fParam.put(FyConstants.OrderId, param.get(FyConstants.OrderId));
//		return DepositGateWay.dealRequest(fParam,FyConstants.TYPE_XML);
//	}
}
