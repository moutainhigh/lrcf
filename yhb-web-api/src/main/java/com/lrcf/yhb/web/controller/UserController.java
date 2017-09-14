package com.lrcf.yhb.web.controller;

import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.pojo.AccountsUsersBalances;
import com.lrcf.yhb.user.api.AccountsUsersBalancesService;
import com.lrcf.yhb.user.api.AccountsUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
* @Desc   用户控制类
* @param
* @return
* @Author 孔荣勋【Krx】
* @Date 2017/7/17 0017 14:50
*/
@RestController
public class UserController {

    @Autowired
    AccountsUsersService usersService;
    @Autowired
    AccountsUsersBalancesService usersBalancesService;


    @GetMapping(value = "/user/info")
    public YhbResult getuserInfo(){
        AccountsUsersBalances userBalance = usersBalancesService.selectByUserId("03b636e0-f859-4c7d-b624-e1f77a73bf61");
        return YhbResult.success("用户余额:"+userBalance.getUserbalance());
    }


}
