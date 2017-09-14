package com.lrcf.yhb.web.controller;

import com.lrcf.yhb.common.util.SecurityCodeUtil;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.dto.RegistDTO;
import com.lrcf.yhb.pojo.AccountsUsers;
import com.lrcf.yhb.product.api.FinanceproductsUsersService;
import com.lrcf.yhb.tps.api.IPSDepositRecService;
import com.lrcf.yhb.user.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 无需登录，不许要token验证加密
 * Created by Krx on 2017/6/19.
 */
@RestController
public class InletController {

    private final static Logger log = LoggerFactory.getLogger(InletController.class);

    @Autowired
    AccountsUsersService usersService;
    @Autowired
    SendSmsInfoService sendSmsInfoService;
    @Autowired
    FinanceproductsUsersService financeproductsUsersService;
    @Autowired
    AccountsUsersBalancesService usersBalancesService;
    @Autowired
    AccountsCenterMeassageService centerMeassageService;
    @Autowired
    IPSDepositRecService iPSDepositRecService;


    /**
     * 登录，登录成功后返回对应的Token信息
     * @param name 账号
     * @param pwd  密码
     * @param type 登录来源
     * @return token
     * @Author 孔荣勋
     */
    @PostMapping(value = "/inlet/login")
    public YhbResult login(String name,String pwd,String type){
        return usersService.login(name,pwd,type);
    }

    /**
     * 注册，注册成功后返回的响应状态码和响应信息
     * @param registDTO 注册封装实体类
     * @Author yj
     */
    @PostMapping(value = "/inlet/register")
    public YhbResult register(RegistDTO registDTO){
        return usersService.register(registDTO);
    }

    /**
     * 用户端发送验证码，smsType验证码类型
     * smsType : 0 短信验证码  1: 纯文本验证码 ...... 详见参考 com.lrcf.yhb.common.enums.SendSmsStateEnum
     * @param phone  手机账号
     * @return YhbResult(code,msg)
     * @Author 孔荣勋
     */
    @GetMapping(value = "/inlet/sms/{phone}")
    public YhbResult sms(@PathVariable String phone){
        return sendSmsInfoService.sendVerifySms(0, phone);
    }

    /**
     * 图形验证码
     * @param request
     * @param response
     * @Author 杨健
     */
    @PostMapping(value = "/inlet/isShowregistCalcPic")
    public void isShowregistCalcPic(HttpServletRequest request, HttpServletResponse response) {
        try {
            SecurityCodeUtil.getTowCalcPic(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试分布式事务，根据可靠消息一致性，确认事务一致性。
     * 实现，成功，事务一致性提交，否则回滚事务。
     * 基于zookeeper+activeMq+Mysql 实现事务
     * @return
     */
//    @GetMapping(value = "/inlet/user/test")
//    public  YhbResult test(){
//        return financeproductsUsersService.test();
//    }


    @GetMapping(value = "/inlet/test")
    public YhbResult tests(@RequestBody Map<String,String> param){
//        log.info("访问test，userId:" + userId);
//        System.out.println("sssss" + userId);
//
//        AccountsUsers users = usersService.selectUserByUserName("18538587512");
//
//        Map<String,Object> param = new HashMap<String,Object>();
//        param.put("userId", userId);
//        int count = centerMeassageService.getUserMessage(param);
//        return YhbResult.success("测试"+count+users.getTruename());
        Map<String, String> getReqMap = new HashMap<>();
        try {
         getReqMap = iPSDepositRecService.userRegister(param);
        } catch (Exception e) {
            log.info("异常信息"+e.getMessage());
        }

        return YhbResult.success(getReqMap);
    }
}
