package com.lrcf.yhb.web.controller;

import com.lrcf.yhb.common.api.ips.IpsConstants;
import com.lrcf.yhb.common.api.ips.IpsSignUtils;
import com.lrcf.yhb.common.api.ips.JsonUtils;
import com.lrcf.yhb.common.enums.ResultEnum;
import com.lrcf.yhb.common.util.ThreeDesUtils;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.pojo.HxOrderInfo;
import com.lrcf.yhb.tps.api.HuanXunOrderInfoService;
import com.lrcf.yhb.tps.api.IpsHuanXunRecvService;
import com.lrcf.yhb.web.util.HttpRequestUtils;
import com.lrcf.yhb.web.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * Created by Administrator on 2017/7/28 0028.
 */
@Controller
@RequestMapping("Ips/huifu/")
public class IpsRecvController {
    private final static Logger log = LoggerFactory.getLogger(IpsDepositController.class);

    @Value("${IPS.Pub.Key}")
    private String deskey;
    @Value("${IPS.IV}")
    private String iv;

    @Autowired
    HuanXunOrderInfoService huanXunOrderInfoService;
    @Autowired
    IpsHuanXunRecvService recvService;

    /**
     * 后台回调
     * @param request
     * @return
     */
    @RequestMapping(value = "bgReturn")
    public void getBgReturn(HttpServletRequest request,HttpServletResponse response){
        Map<String, String> params = HttpRequestUtils.getParameters(request);
        try {
            //验证签名
            Boolean flag = IpsSignUtils.verifyByMD5(params);
            if (flag) {
                //解密响应文件
                String responseText = ThreeDesUtils.decrypt3DES(params.get(IpsConstants.response), deskey, iv);
                log.info("解密后的参数内容" + responseText);
                Map<String, Object> map = JsonUtils.parseJSON2Map(responseText);
                //查询数据库
                HxOrderInfo orderInfo = huanXunOrderInfoService.selectByMerBill(map.get("merBillNo").toString());
                //获取请求类型，例如开户、充值....
                String cmdId = orderInfo.getActName();

                //更新数据信息
                params.put(IpsConstants.response, map.toString());
                params.put(IpsConstants.ipsBillNo,
                        map.get(IpsConstants.ipsBillNo).toString());
                params.put(IpsConstants.merBillNo,
                        map.get(IpsConstants.merBillNo).toString());

                //查询数据库用户信息
                HxOrderInfo hxOrderInfo = huanXunOrderInfoService.selectByipsBillNo(map.get("ipsBillNo").toString());
                if (hxOrderInfo == null) {
                    huanXunOrderInfoService.updateForNotifys(params); //更新数据库 hx_order_info 添加环迅返回信息
                    if (IpsConstants.RESP_SUCC.equals(params.get(IpsConstants.resultCode))) { // 成功
                        String methodName = IpsConstants.s2SUrlMap.get(cmdId);// 获取方法名
                        Method method = IpsHuanXunRecvService.class.getMethod(methodName, Map.class);
                        Long startTime = System.currentTimeMillis();

                        YhbResult result = (YhbResult) method.invoke(recvService, map); // 调用逻辑代码方法
                        System.out.println("result:" + result);
                        if (result.getCode() == 200) {
                            // 校验通过开始处理订单
                            ResponseUtils.renderText(response, "OK");
                        }
                        Long endTime = System.currentTimeMillis();
                        log.debug("invoke method " + methodName + " time is "
                                + (endTime - startTime) + " ms");
                    }

                }else {
                    log.error("verifyByMD5 error:" + params);
                }
            }
        } catch (Exception e) {
            log.error("异常信息:" + e.getMessage());
          //  huanXunOrderInfoService.deleteHfCallback(params);
        }
    }


    /**
     * 前台回调
     * @param request
     * @return
     */
    @RequestMapping(value = "frontReturn")
    public ModelAndView geyFrontUrlParams(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params = HttpRequestUtils.getParameters(request);
        //解密响应文件
        String responseText = ThreeDesUtils.decrypt3DES(params.get(IpsConstants.response), deskey, iv);
        log.info("解密后的参数内容" + responseText);
        Map<String, Object> map = JsonUtils.parseJSON2Map(responseText);

        //更新数据信息
        params.put(IpsConstants.response, map.toString());
        params.put(IpsConstants.ipsBillNo,
                map.get(IpsConstants.ipsBillNo).toString());
        params.put(IpsConstants.merBillNo,
                map.get(IpsConstants.merBillNo).toString());

        huanXunOrderInfoService.updateForReturns(params);
        String status = "";
        try {
            if (IpsConstants.RESP_SUCC.equals(params.get(IpsConstants.resultCode))) { // 成功
                status = "200";
            }
        } catch (Exception e) {
            log.error("错误异常:" + e);
            status = "500";
        }
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("status", status);
        return modelAndView;
    }


}
