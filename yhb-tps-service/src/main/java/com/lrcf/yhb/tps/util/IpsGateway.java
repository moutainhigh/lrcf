package com.lrcf.yhb.tps.util;

import com.lrcf.yhb.common.api.ips.*;
import com.lrcf.yhb.tps.api.HuanXunOrderInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Component
public class IpsGateway {

	private static Logger log = LoggerFactory.getLogger(IpsGateway.class);

	@Autowired
	private HuanXunOrderInfoService huanXunOrderInfoService;
	private static IpsGateway ipsGateway;

	public void setOrderInfo(HuanXunOrderInfoService huanXunOrderInfoService){
		this.huanXunOrderInfoService = huanXunOrderInfoService;
	}

	@PostConstruct
	public void init(){
		ipsGateway = this;
		ipsGateway.huanXunOrderInfoService = this.huanXunOrderInfoService;
	}


	public static final String URL = "http://180.168.26.114:20010/p2p-deposit/gateway.htm";

	public static final String merchantID = "1184980025";

	public static final String MD5Key = "Ys6z7H93z9h3kQll7tv02SUsjWDcVsatanaPuE4NMbfGLLDOoaAhN7hN9eUxzx45wGT3Ch8De1XwPvRNF0n7GqrnbWRmnlVbxZEs7n6og5229XUveYq9sENyEP5CEsLr";
	/**
	 * 采用form表单提交的方式交互
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getHuifuFormParams(
			Map<String, String> params) throws Exception {
		return postHuifuParams(params, IpsConstants.TYPE_FORM);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> getHuifuFormParams(
			Map<String, String> params, String version) throws Exception {
		return postHuifuParams(params, IpsConstants.TYPE_FORM);
	}

	/**
	 * 采用json数据后端交互
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Map postHuifuParams(Map<String, String> params)
			throws Exception {
		return postHuifuParams(params, IpsConstants.TYPE_JSON);
	}

	/**
	 * 采用json数据后端交互
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> postHuifuParams(
			Map<String, String> params, String version) throws Exception {
		return postHuifuParams(params, IpsConstants.TYPE_JSON);
	}

	private static Map postHuifuParams(Map<String, String> params,
			int postType) throws Exception {
		//商户号设置
		params.put(IpsConstants.merchantID,merchantID);
		params.put(IpsConstants.Md5Key,MD5Key);
		//加密sign
		params.put(IpsConstants.sign, IpsSignUtils.encryptByMD5(params));
		params.remove(IpsConstants.Md5Key);
		log.info("即将拼接的参数:"+params);
		ipsGateway.huanXunOrderInfoService.addForRequests(params);// 添加数据库
		
		params.remove(IpsConstants.merBillNo);
		
		if(postType==IpsConstants.TYPE_FORM){
			params.put("gateWayUrl", URL);
			StringUtil.replaceQuotes(params); // 替换单引号与双引号
			return params;
		}else if(postType == IpsConstants.TYPE_JSON){
			try {
				String ret = new HXWebClient().doPost(URL, params);
				ret = URLDecoder.decode(ret, "UTF-8");
				Map retMap = JsonUtils.parseJSON2Map(ret);
				ipsGateway.huanXunOrderInfoService.updateForReturns(retMap);// 更新数据库
				log.info("接受的map类型:"+retMap);
				return retMap;
			} catch (Exception e) { 
				e.printStackTrace();
				log.error("postHuifuParams error:" + params, e);
				throw new Exception("postHuifuParams error:" + params);
			}
		}
		return params;
	}

	public static void encodeFields(Map<String, String> params, String remark) {
		String paramsStr = "";
		Iterator<Entry<String, String>> entrys = params.entrySet().iterator();
		while (entrys.hasNext()) {
			Entry<String, String> entry = entrys.next();
			try {
				if (!StringUtils.isEmpty(entry.getValue()))
					params.put(entry.getKey(),
							URLDecoder.decode(entry.getValue(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			paramsStr += "&" + entry.getKey() + "=" + entry.getValue();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		log.debug(remark + " recv from huifu-->" + paramsStr);
	}
}
