package com.lrcf.yhb.user.service;


import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lrcf.yhb.common.config.BaseConstants;
import com.lrcf.yhb.common.enums.ResultEnum;
import com.lrcf.yhb.common.redis.RedisUtil;
import com.lrcf.yhb.common.redis.pojo.User;
import com.lrcf.yhb.common.util.*;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.dao.mapper.*;
import com.lrcf.yhb.dto.RegistDTO;
import com.lrcf.yhb.pojo.*;
import com.lrcf.yhb.user.api.*;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: AccountsUsersServiceImpl.java
 * @Description: 用户实现类
 * @author:Krx
 * @date: 2017年4月27日 下午2:29:18
 */
@Service("accountsUsersService")
public class AccountsUsersServiceImpl implements AccountsUsersService {
    private static Logger logger = LoggerFactory.getLogger(AccountsUsersServiceImpl.class);

    @Autowired
    AccountsUsersDao usersMapper;
    @Autowired
    AgentDao agentDao;
    @Autowired
    BaseConfigDao baseConfigDao;
    @Autowired
    SignShareDao signShareDao;
    @Autowired
    ProfitTableDao profitTableDao;
    @Autowired
    AccountsUsersBalancesDao accountsUsersBalancesDao;
    @Autowired
    ActivityAdminSendDao activityAdminSendDao;
    @Autowired
    AccountUsersActivityDao accountUsersActivityDao;
    @Autowired
    AdminRaiseSendDao adminRaiseSendDao;
    @Autowired
    AccountRaiseGetDao accountRaiseGetDao;
    @Autowired
    ExperienceCPDao experienceCPDao;
    @Autowired
    ExperienceSendDao experienceSendDao;
    @Autowired
    SendSmsInfoService sendSmsInfoService;
    @Autowired
    BaseConfigService baseConfigService;
    @Autowired
    AppSmsVerifyService appSmsVerifyService;
    @Autowired
    AgentService agentService;
    @Autowired
    AccountsUsersService accountsUsersService;
    @Autowired
    BlackListService blackListService;
    @Autowired
    AccountsUsersRegisteredStateService accountsUsersRegisteredStateService;
    @Autowired
    BaseBankcardService baseBankcardService;
    @Autowired
    AccountsLogsService accountsLogsService;

    /**
     *
     * @see AccountsUsersService#selectUserByUserName(String)
     * @Function: AccountsUsersServiceImpl.java
     * @Description: 根据username查询用户
     *
     * @param:userName
     * @return：AccountsUsers
     * @author: Krx
     * @date: 2017年4月27日 下午2:29:33
     */
    @Override
    public AccountsUsers selectUserByUserName(String userName) {
        AccountsUsers user_cache = usersMapper.selectUserByUserName(userName);
        return user_cache;
    }

    /**
     *
     * @Function: AccountsUsersServiceImpl.java
     * @Description: 用户注册-Service
     *
     * @param: Map<String,
	 *             String> 手机号：account , 密码：password , 手机验证码：phoneCode ,
     *             验证码：verif_code , 邀请人手机号码：inviteCode（可以为空）
     * @return：AccountsUsers @throws：
     *
     * @version: v1.0.0
     * @author: wangxf
     * @date: 2017年5月4日 上午10:11:46
     *
     *        Modification History: Date Author Version Description
     *        ---------------------------------------------------------*
     *        2017年5月4日 wangxf v1.0.0 修改原因
     */
    public AccountsUsers registers(Map<String, String> registerMap) {
        logger.info("注册参数》》》" + registerMap);

        // 创建一个AccountUsers对象
        AccountsUsers accountsUsers = new AccountsUsers();
        // 邀请码
        String invitationCode = null;

        if (StringUtil.isNotBlank(registerMap.get("inviteCode"))) {
            invitationCode = registerMap.get("inviteCode");

            if (invitationCode.length() == 6) {
                Agent agent = agentDao.selectAgentByUserName(registerMap.get("inviteCode"));
                if (StringUtil.isNotNull(agent)) {
                    accountsUsers.setPlatid(agent.getUserid()); // 代理商父级Id
                }
            } else {
                AccountsUsers parentusers = selectUserByUserName(registerMap.get("inviteCode"));
                if (StringUtil.isNotNull(parentusers)) {
                    accountsUsers.setParentid(parentusers.getUserid()); // 经销商父级Id
                }
            }

        }

        accountsUsers.setUserid(GenerateNo.getUUID().toLowerCase());
        accountsUsers.setUsername(registerMap.get("account")); // UserName
        accountsUsers.setTelphone(registerMap.get("account")); // Telphone
        accountsUsers.setUserpassword(DesEncrypt.getMd5Password(registerMap.get("password"))); // Userpassword
        accountsUsers.setUserEk1(getUserSourceAddress(registerMap.get("type"))); // 来源
        accountsUsers.setUserEk2(invitationCode); // 邀请码
        accountsUsers.setUserEk3("1"); // 设置为老用户

        int count = insertSelectiveUsers(accountsUsers);

        if (count > 0) {
            return accountsUsers;
        }

        return null;

    }

    /**
     *
     * @Description: 来源路径判断
     *
     * @param:type
     * @return：来源
     * @author: Krx
     * @date: 2017年5月9日 上午10:13:13
     */
    public String getUserSourceAddress(String type) {
        String source = "";
        switch (type) {
            case "1": // Pc
                source = BaseConstants.PC;
                break;
            case "2": // App
                source = BaseConstants.APP;
                break;
            case "3": // H5
                source = BaseConstants.H5;
                break;
            case "4": // 微信
                source = BaseConstants.WEIXIN;
                break;
            case "5": // 经销商
                source = BaseConstants.AGENT_ADDUSER;
                break;
            case "6": // 代理商
                source = BaseConstants.DISTRIBUTOR_ADDUSER;
                break;

            default:
                break;
        }
        return source;
    }

    /**
     * @see AccountsUsersService#selectUserByPrimaryKey(String)
     * @Function: AccountsUsersServiceImpl.java
     * @Description: 根据UserId查询用户信息
     *
     * @param:描述1描述
     * @return：返回结果描述
     * @author: Krx
     * @date: 2017年5月8日 上午9:16:05
     */
    @Override
    public AccountsUsers selectUserByPrimaryKey(String userId) {
        return this.usersMapper.selectByPrimaryKey(userId);
    }

    /**
     * @Function: AccountsUsersServiceImpl.java
     * @Description: 查询用户列表信息
     *
     * @param:描述1描述
     * @return：返回结果描述
     * @author: Krx
     * @date: 2017年5月8日 上午9:18:52
     */
//	@Override
//	public List<AccountsUsers> selectByExample(AccountsUsersExample example) {
//		return this.usersMapper.selectByExample(example);
//	}

    /**
     * @Function: AccountsUsersServiceImpl.java
     * @Description: 该函数的功能描述
     *
     * @param:描述1描述
     * @return：返回结果描述
     * @author: Krx
     * @date: 2017年5月8日 上午10:51:14
     */
    @Override
    public int insertSelectiveUsers(AccountsUsers users) {
        logger.info("添加数据>>>" + users);
        if (usersMapper.insertSelective(users) > 0) {
            // 添加静态字段
            ProfitTable profitTable = new ProfitTable();
            profitTable.setUserid(users.getUserid());
            profitTableDao.insertSelective(profitTable);

            // 添加余额字段
            AccountsUsersBalances balance = new AccountsUsersBalances();
            balance.setUserid(users.getUserid());
            balance.setModifytime(new Date());
            accountsUsersBalancesDao.insertSelective(balance);

            // 注册生成上下级分享
            signShare(users);
            // 注册添加新用户七天收益
            insertJedisRate(users.getUserid());
            // 如果为代理商名下注册
            if (users.getPlatid() != null && !BaseConstants.ParentIDCom.equals(users.getPlatid())) {
                belowAgent(users);// 代理商名下注册用户奖励
            }

            return 1;
        }
        return 0;
    }

    /**
     *
     * @Description: 代理商名下奖励
     *
     * @param:user
     * @return：boolean
     * @author: krx
     * @throws ParseException
     * @date: 2017年5月8日 上午11:59:08
     */
    private void belowAgent(AccountsUsers user) {
        Map<String, String> map = new HashMap<String, String>();

        if (user.getPlatid() != null && !user.getPlatid().equals(BaseConstants.ParentIDCom)) {
            // 查詢配置
            BaseConfig getRewardConfig = baseConfigDao.selectByParam("cfg_getRewardConfig");

            Agent agent = agentDao.selectAgentByUserId(user.getPlatid());

            if (agent != null && getRewardConfig.getValuese().equals("1")) {// 配置的开关1为开，0为关
                Integer order = getRewardConfig.getOrders();
                Integer Id = Integer.parseInt(getRewardConfig.getValue());
                if (order == 1) {
                    // 查询红包
                    ActivityAdminSend as = activityAdminSendDao.selectByPrimaryKey(Id);

                    int day = DateUtil.daysBetween(as.getRedcreatetime(), as.getRedlasttime());
                    Date overduTime = DateUtil.addDay(new Date(), day); // 过期时间

                    AccountUsersActivity aua = new AccountUsersActivity(as.getProductid(), user.getUserid(),
                            GenerateNo.payRecordNo(), String.valueOf(as.getId()), as.getRedname(), as.getRedmoney(),
                            new Date(), overduTime, as.getRedrule());

                    if (accountUsersActivityDao.insertSelective(aua) > 0) {
                        as.setRedsendcount(as.getRedsendcount() + 1);
                        if (activityAdminSendDao.updateByPrimaryKeySelective(as) > 0) {
                            // 发送红包短信
                            sendSmsInfoService.sendVerifySms(2,user.getUsername());
                        }
                    }
                } else if (order == 2) {
                    // 加息劵
                    AdminRaiseSend ar = adminRaiseSendDao.selectByPrimaryKey(Id);

                    int day = DateUtil.daysBetween(ar.getRaisecreatetime(), ar.getRaiseovertime());
                    Date overduTime = DateUtil.addDay(new Date(), day);

                    AccountRaiseGet arg = new AccountRaiseGet(user.getUserid(), ar.getRaisename(), ar.getProductid(),
                            String.valueOf(ar.getId()), ar.getRaisemark(), ar.getRaisesize(), overduTime, new Date(),
                            DateUtil.daysBetween(ar.getRaisecreatetime(), ar.getRaiseovertime()));

                    if (accountRaiseGetDao.insertSelective(arg) > 0) {
                        // 发加息劵短信
//                        map.put("account", user.getUsername());
//                        map.put("smsContext",
//                                sendSmsInfoService.getSmsContextBySmsState(3, String.valueOf(ar.getRaisesize() * 100)));
                        sendSmsInfoService.sendVerifySms(3,user.getUsername());
                    }
                } else if (order == 3) {
                    // 体验金
                    ExperienceCP ecp = experienceCPDao.selectByPrimaryKey(Id);
                    int day;
                    try {
                        day = DateUtil.daysBetween(ecp.getExperiencecpaddtime(),
                                DateUtil.convertStringToDate(DateUtil.dateTimePattern, ecp.getExperiencecpemK3()));
                        Date overduTime = DateUtil.addDay(new Date(), day);

                        ExperienceSend experienceSend = new ExperienceSend(ecp.getExperiencecpemK2(), user.getUserid(),
                                Id, new Date(), 0, ecp.getExperiencecprate(), ecp.getExperiencecpcountmoeny(),
                                ecp.getExperiencecpname(), DateUtil.parseToDateTimeStr(overduTime));

                        if (experienceSendDao.insertSelective(experienceSend) > 0) {
                            Integer i = Integer.parseInt(ecp.getExperiencecpemK1());
                            Integer count = i + 1;
                            ecp.setExperiencecpemK1(String.valueOf(count));
                            if (experienceCPDao.updateByPrimaryKeySelective(ecp) > 0) {
                                // 发体验金短信
//                                map.put("account", user.getUsername());
//                                map.put("smsContext", sendSmsInfoService.getSmsContextBySmsState(4,
//                                        String.valueOf(ecp.getExperiencecpcountmoeny())));
                                sendSmsInfoService.sendVerifySms(4,user.getUsername());
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 注册生成signshare
     *
     * @param
     * @return
     */
    private boolean signShare(AccountsUsers user) {
        String userId = user.getParentid() == null || BaseConstants.ParentIDCom.equals(user.getParentid())
                ? user.getPlatid() : user.getParentid();

        if (userId != null && !"".equals(userId)) {
            BaseConfig baseConfig = baseConfigDao.selectByParam("cfg_agentreg");
            if (baseConfig.getValuese().equals("1")) {
                Agent agent = agentDao.selectAgentByUserId(userId);
                if (agent != null) {
                    SignShare sign = new SignShare(userId, agent.getUsername(), new Date(), 2, user.getUserid(),
                            user.getUsername(), "线下注册", "1");
                    if (signShareDao.insertSelective(sign) > 0) {
                        // 注册不加钱，注册并绑卡才加钱
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    AccountsUsers parentUser = usersMapper.selectByPrimaryKey(userId);
                    if (parentUser != null) {
                        SignShare sign = new SignShare(userId, parentUser.getUsername(), new Date(), 1,
                                user.getUserid(), user.getUsername(), "线下注册", "1");
                        if (signShareDao.insertSelective(sign) > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 增加新手用户的redis缓存
     *
     * @param userId
     * @return
     */
    public boolean insertJedisRate(String userId) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        boolean result = false;
        for (int i = 6; i >= 0; i--) {
            String time = DateUtil.getLastDayFirst(-i);// 获取当前0
            Map<String, Object> maps = new HashMap<String, Object>();
            maps.put("time", time.substring(5, 10));
            maps.put("rates", String.valueOf(0.000));
            list.add(maps);
        }

        JSONArray array = JSONArray.fromObject(list);
        String jsonstr = array.toString();
//		result = cache.putCache(
//				RedisCache.user_cache + RedisCache.SEVENRATES + userId + RedisCache.SEVENRATES.replace(":", ""),
//				jsonstr);

        return result;
    }

    /**
     * @see AccountsUsersService#updateUserInfo(Map)
     * @Function: AccountsUsersServiceImpl.java
     * @Description: 更新用户信息
     *
     * @param:registerMap
     * @return：boolean
     * @author: Krx
     * @date: 2017年5月9日 上午10:51:23
     */
    @Override
    public boolean updateUserInfo(Map<String, String> registerMap) {
        //手机号码
        String account = registerMap.get("account");

        AccountsUsers users  = selectUserByUserName(account);
        //当为1时，属于忘记密码
        if(registerMap.containsKey("password")){
            users.setUserpassword(DesEncrypt.getMd5Password(registerMap.get("passsword")));

        }

        int count  = usersMapper.updateByPrimaryKeySelective(users);


        return count > 0 ? true : false;
    }

    /**
     *
     * @Function: AccountsUsersServiceImpl.java
     * @Description: 上传头像
     *
     * @param: AccountsUsers accountsUsers
     * @return： boolean
     * @throws：
     *
     * @version: v1.0.0
     * @author: wangxf
     * @date: 2017年5月11日 下午3:20:29
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2017年5月11日     wangxf           v1.0.0               修改原因
     */
    @Override
    public boolean updateUserInfo(AccountsUsers accountsUsers){

        if( null == accountsUsers ){
            return false;
        }
        int count = usersMapper.updateByPrimaryKeySelective(accountsUsers);

        return count > 0 ? true : false;
    }

    /**
     *
     * @Function: AccountsUsersService.java
     * @Description: 判断身份证号码是否已经被注册
     *
     * @param: AccountsUsers accountsUsers
     * @return： boolean
     * @throws：
     *
     * @version: v1.0.0
     * @author: wangxf
     * @date: 2017年5月11日 下午3:20:29
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2017年5月11日     wangxf           v1.0.0               修改原因
     */
    public boolean selectUserInfoByCardId(String cardId){

        boolean flag = false;
        if( StringUtil.isNotBlank(cardId) ){
            List<AccountsUsers> accountsUsersList = usersMapper.selectUserByCardId(cardId);

            if( null != accountsUsersList && accountsUsersList.size() > 0 ){
                flag = true;
            }
        }

        return flag;
    }
    /**
     * 校验用户注册时的参数
     * @param registerMap
     * @return
     */
    private YhbResult checkUserParam(Map<String, String> registerMap){
        //校验用户参数是否存在
        String userPhone = registerMap.get("userPhone");
        String userPwd = registerMap.get("userPwd");
        String channel = registerMap.get("channel");
        if(StringUtils.isBlank(userPhone) || StringUtils.isBlank(userPwd) || StringUtils.isBlank(channel)){
            return YhbResult.build(400,"参数错误");
        }
        //校验用户是否已存在
        AccountsUsers au = usersMapper.selectUserByUserName(userPhone);
        if(au!=null){
            return YhbResult.success(false);
        }
        return  YhbResult.success(true);
    }

    /**
     * 登录
     *
     * @param userName,pwd
     * @return
     */
    @Override
    public YhbResult login(String userName, String pwd, String type) {
        //判断账号/密码/登录来源
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(pwd) || StringUtils.isBlank(type)) {
            return YhbResult.build(ResultEnum.SYSTEM_PARAMISNULL.getCode(), ResultEnum.SYSTEM_PARAMISNULL.getCodeDesc());
        }

        String key = origin(type);
        //判断来源路径是否正确
        if (StringUtils.isBlank(key)) {
            return YhbResult.build(ResultEnum.SYSTEM_ORIGINISNULL.getCode(), ResultEnum.SYSTEM_ORIGINISNULL.getCodeDesc());
        }

        AccountsUsers users = selectUserByUserName(userName);
        //判断用户是否存在
        if (users == null) {
            return YhbResult.build(ResultEnum.USER_ISNULL.getCode(), ResultEnum.USER_ISNULL.getCodeDesc());
        }
        //用户密码是否正确
        if (!DesEncrypt.checkPassword(users.getUserpassword(), pwd)) {
            return YhbResult.build(ResultEnum.PASSWORD_ISERROR.getCode(), ResultEnum.PASSWORD_ISERROR.getCodeDesc());
        }

        //用户信息存入redis
        RedisUtil.set(key, JSON.toJSONString(new User(users.getUserid(), userName, users.getTruename()))
                ,RedisUtil.EXRP_SECONDS);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("token",key);

        return YhbResult.success(map);
    }

    /**
     * 判断用户来源，设置redis key
     * @param type
     * @return
     */
    public String origin(String type){
        String key = "";

        switch (type) {
            case BaseConstants.PC:
                key = BaseConstants.PC_SESSION + GenerateNo.getToken();
                break;
            case BaseConstants.WEIXIN:
                key = BaseConstants.WECHAT_SESSION + GenerateNo.getToken();
                break;
            case BaseConstants.APP:
                key = BaseConstants.APP_SESSION + GenerateNo.getToken();
                break;
            case BaseConstants.H5:
                key = BaseConstants.PC_SESSION + GenerateNo.getToken();
                break;
            case BaseConstants.ADMIN_SESSION:
                key = BaseConstants.ADMIN_SESSION + GenerateNo.getToken();
            case BaseConstants.AGENT_SESSION:
                key = BaseConstants.AGENT_SESSION + GenerateNo.getToken();
            default:
                break;
        }

        return key;
    }
    /**
     * 根据token值获取用户信息
     *
     * @param token
     * @return
     */
    @Override
    public YhbResult token(String token) {
        //判断token是否为空
        if (StringUtils.isBlank(token)) {
            return YhbResult.build(ResultEnum.TOKEN_ISNULL.getCode(), ResultEnum.TOKEN_ISNULL.getCodeDesc());
        }

        User users = JSONObject.parseObject(RedisUtil.get(token),User.class);
        //判断redis中用户信息是否失效
        if (users == null) {
            return YhbResult.build(ResultEnum.SYSTEM_TOKENTIMEOUT.getCode(), ResultEnum.SYSTEM_TOKENTIMEOUT.getCodeDesc());
        }

        return YhbResult.success(users);
    }

    /**
     * 请求格式 POST
     * 验证验证码
     *
     * @param authCode 输入的验证码
     * @param uuid     Redis验证码uuid
     * @return {
     * "success": 0 可用 1 不可用
     * }
     */
    @Override
    public String validateAuthCode(String authCode, String uuid) {
        return null;
    }

    /**
     * 注册
     * @return
     */
    @Override
    public YhbResult register(RegistDTO registDTO) {
        String userPhone = registDTO.getPhone();
        String inviteCode =registDTO.getInviteCode();// 密码
        String pwd = registDTO.getPwd();//密码
        String type = registDTO.getType();//注册来源
        String phoneCode = registDTO.getPhoneCode();//短信验证码
        String calcRst = registDTO.getCalcRst();//图形验证码
        String timesTamp = registDTO.getTimesTamp();//时间戳
        String registStep = registDTO.getRegistStep();//注册步骤

        String name = registDTO.getName();//用户名
        String cardId = registDTO.getCardId();//身份证号

        AccountsUsers accountsUsers1 = accountsUsersService.selectUserByUserName(userPhone);
        if (accountsUsers1  != null) {
            return YhbResult.build(ResultEnum.ERRORRREGISTERUSER.getCode(),ResultEnum.ERRORRREGISTERUSER.getCodeDesc());
        }
        BaseConfig baseConfig = baseConfigService.selectByParam("cfg_picCalc");
        boolean flagCalc = "1".equals(baseConfig.getValue())? true:false;
        DesEncrypt desEncrpt = new DesEncrypt(BaseConstants.DES_PUBLIC_ENCRYPT_KEY);
        try {
            if ("1".equals(registStep)) {
                //图形验证码验证
                if (flagCalc) {//图形验证码开启则验证图形验证码
                    String resultCalc = RedisUtil.get(BaseConstants.RANDOM_CODE_KEY + ":" +timesTamp);
                    if (!calcRst.equals(resultCalc) ) {
                        return YhbResult.build(ResultEnum.ERRORCALCMSG.getCode(),ResultEnum.ERRORCALCMSG.getCodeDesc());
                    }
                }
                // 登录基本入参非空验证
                LoginUtil loginUtil = new LoginUtil();
                String msg = loginUtil.loginValidate(userPhone, phoneCode, pwd);
                if (!"ok".equals(msg)) {
                    return YhbResult.build(ResultEnum.ERRORISBLANK.getCode(), ResultEnum.ERRORISBLANK.getCodeDesc());
                }
                //短信验证码是否正确验证
                boolean smgIsExit = appSmsVerifyService.selectVerifyIsExit(userPhone, phoneCode);// 短信验证码是否正确验证
                if (!smgIsExit) {
                    return YhbResult.build(ResultEnum.ERRORMASSAGEMSG.getCode(),ResultEnum.ERRORMASSAGEMSG.getCodeDesc());
                }
                return YhbResult.success("注册第一步完成");

            }else {
                //京东万象二要素验证
                String appkey = BaseConstants.appKey2; // String | 万象平台提供的appkey

            //京东万象的实名认证
               /* DefaultApi apiInstance = new DefaultApi();
                String results = apiInstance.idcard(cardId,name,appkey);
                JSONObject  jasonObject =JSONObject.fromObject(results);
                Map<String,Map<String,Map<String,String>>> map = (Map<String,Map<String,Map<String,String>>>)jasonObject;
                if(map.get("result").get("resp").get("code").equals(Integer.valueOf("0"))){
//                    resultMap.put("result", false);
//                    resultMap.put("msg",map.get("result").get("resp").get("desc");
                    return YhbResult.build(ResultEnum.ERRORRMSGVALIDATETWO.getCode(),ResultEnum.ERRORRMSGVALIDATETWO.getCodeDesc());
                }*/


                // 上级是否存在验证
                AccountsUsers accountsUsers = new AccountsUsers();
                String parentId = AccountsUsers.Common_ID;
                String platId = AccountsUsers.Common_ID;

                if (StringUtils.isNotBlank(inviteCode)) {
                    if (inviteCode.length() == 6) {//上级是代理商
                        Agent agent = agentService.selectEmk3(inviteCode);
                        if (agent != null) {
                            platId = agent.getUserid();
                        } else {
                            return YhbResult.build(ResultEnum.ERRORNOINVITECODE.getCode(),ResultEnum.ERRORNOINVITECODE.getCodeDesc());
                        }
                    } else {//上级是经销商或者普通商户
                        AccountsUsers ap = accountsUsersService.selectUserByUserName(inviteCode);
                        if (ap != null) {
                            parentId = ap.getUserid();
                        } else {
                            return YhbResult.build(ResultEnum.ERRORNOINVITECODE.getCode(),ResultEnum.ERRORNOINVITECODE.getCodeDesc());
                        }

                    }
                    //上级子商户注册人数限制
                    String flag = accountsUsersService.registerLimit(parentId);
                    if(StringUtils.isNotBlank(flag)){
                        return YhbResult.build(ResultEnum.ERRORNOINVITER.getCode(),ResultEnum.ERRORNOINVITER.getCodeDesc());
                    }
                }

                //验证结束，开始填充数据
                pwd = desEncrpt.decrypt(StringUtils.trimToEmpty(desEncrpt.encrypt(StringUtils.trimToEmpty(pwd))));
                DesEncrypt aesEncrypt = new DesEncrypt(BaseConstants.DES_PRIVATE_ENCRYPT_KEY);
                pwd = MD5Utils.stringToMD5(aesEncrypt.encrypt(pwd));
                UUID uuid = UUID.randomUUID();
                String userUUID = uuid.toString();
                accountsUsers.setUserid(userUUID);
                accountsUsers.setUsername(userPhone);
                accountsUsers.setUserpassword(pwd);
                accountsUsers.setActivity(true);
                accountsUsers.setIsagent(false);
                accountsUsers.setLinecount(0);
                accountsUsers.setIsaudituser(false);
                accountsUsers.setStyle(4);
                accountsUsers.setUserlevel(0);
                accountsUsers.setCreatetime(new Date());
                accountsUsers.setOpenmoney(new BigDecimal(0.0000));
                accountsUsers.setPayfeeuserin(new BigDecimal(0.0000));
                accountsUsers.setMaxmoney(new BigDecimal(0.0000));
                accountsUsers.setIdntfcode(0);
                accountsUsers.setIdntfcodecrtime(new Date());
                accountsUsers.setYbalance(new BigDecimal(0.0000));
                accountsUsers.setIsmember(false);
                accountsUsers.setTruename(name);
                accountsUsers.setCardid(cardId);
                if(StringUtils.isNotBlank(type)){
                    accountsUsers.setUserEk1(type);
                }else{
                    accountsUsers.setUserEk1("未知途径");
                }
                accountsUsers.setParentid(parentId);
                accountsUsers.setUserEk3("1");
                accountsUsers.setPlatid(platId);

                if (inviteCode != null) {
                 // public void insertAccountsUsersRegisteredState(String userId, String userName, String Num, String Ex) {
                    insertAccountsUsersRegisteredState(parentId, userPhone,"", inviteCode);
                }
                accountsUsers.setUserEk2(inviteCode);
                int i = accountsUsersService.insertSelectiveUsers(accountsUsers);
                if (i == 1 && inviteCode != null) {//插入到记录表:数据库字段表
                insertAccountsUsersRegisteredState(userUUID, "", parentId, userPhone);
                AccountsLogs accountsLogs = new AccountsLogs();
                accountsLogs.setUserid(userUUID);
                accountsLogs.setLogintime(new Date());
                accountsLogs.setIsadmin(false);
//                accountsLogs.setLoginip(this.getIpAddr(request));
                accountsLogs.setLoginip("0:0:0:0:0:0:0:1");
                accountsLogs.setIsshow(true);
                accountsLogs.setEvent(1);
                accountsLogsService.saveUserLog(accountsLogs);
                }
                return   YhbResult.success("注册成功");
            }
        } catch (Exception e) {
            logger.error("注册出错：" + e.getMessage());
            return YhbResult.build(ResultEnum.ERRORREGIST.getCode(), ResultEnum.ERRORREGIST.getCodeDesc());
        } finally {
        }
    }


    /**
     * @param registerMap
     * @Function: AccountsUsersService.java
     * @Description: 用户注册-Service
     * @param: Map<String,
     * String>
     * @return：AccountsUsers @throws：
     * @version: v1.0.0
     * @author: wangxf
     * @date: 2017年5月4日 上午10:11:46
     * <p>
     * Modification History: Date Author Version Description
     * ---------------------------------------------------------*
     * 2017年5月4日 wangxf v1.0.0 修改原因
     */
    @Override
    public YhbResult register(Map<String, String> registerMap) {
        return null;
    }

    //注册限制
    @Override
    public String registerLimit(String parentId) {
        BaseConfig bg = baseConfigService.selectByParam("cfg_registerLimit");
        //查询上次子级商户绑卡时间
        String minuteLimit = RedisUtil.get(parentId + BaseConstants.REGISTERMINUTELIMIT);
        if (StringUtils.isNotBlank(minuteLimit)) {
            return "操作过于频繁，请稍后再试";
        } else {
            //保存上级信息在redis中，n分钟只能绑定一个下级
            RedisUtil.set(parentId + BaseConstants.REGISTERMINUTELIMIT, DateUtils.parseToDateTimeStr(new Date()),Integer.parseInt(bg.getValue()) * 60);
//            jedis.set(parentId + BaseConstants.REGISTERMINUTELIMIT, DateUtils.parseToDateTimeStr(new Date()));
//            jedis.expire(parentId + BaseConstants.REGISTERMINUTELIMIT,);
        }
        String dayStr = DateUtils.getDate(new Date());
        //查询某一天保存的子级商户注册次数
//        String dayLimit = jedis.get(parentId + BaseConstants.REGISTERDAYLIMIT);
        String dayLimit = RedisUtil.get(parentId + BaseConstants.REGISTERDAYLIMIT);
        Map<String, Object> map = null;
        if (StringUtils.isNotBlank(dayLimit)) {
            map = JsonUtil.parseStrToMap(dayLimit);
            if (dayStr.equals(map.get("time"))) {   //目前记录数据是当天时间，累加子级注册次数
                int number = (int) map.get("number");
                map.put("number", number + 1);
//                jedis.set(parentId + BaseConstants.REGISTERDAYLIMIT, JsonUtil.parseMapToStr(map));
                RedisUtil.set(parentId + BaseConstants.REGISTERDAYLIMIT, JsonUtil.parseMapToStr(map));
                if (number + 1 > Integer.parseInt(bg.getValuese())) {
//                    jedis.close();
                    joinBlack(parentId);
                    return "系统繁忙，请联系客服";
                }
            } else {
//                jedis.del(parentId + BaseConstants.REGISTERDAYLIMIT);  //记录不是当前时间，删除当前记录，并记录当天记录
                RedisUtil.remove(parentId + BaseConstants.REGISTERDAYLIMIT);
                map = new HashMap<>();
                map.put("time", dayStr);
                map.put("number", 1);
                String json = JsonUtil.parseMapToStr(map);
//                jedis.set(parentId + BaseConstants.REGISTERDAYLIMIT, json);
                RedisUtil.set(parentId + BaseConstants.REGISTERDAYLIMIT, json);
            }
        } else {
            map = new HashMap<>();
            map.put("time", dayStr);
            map.put("number", 1);
            String json = JsonUtil.parseMapToStr(map);
//            jedis.set(parentId + BaseConstants.REGISTERDAYLIMIT, json);
            RedisUtil.set(parentId + BaseConstants.REGISTERDAYLIMIT, json);

        }
        BlackList balck = blackListService.selectBlackByUserId(parentId);   //判断上级是否是黑名单，是黑名单提示
        if (balck != null) {
//            jedis.close();
            return "邀请人账号异常，请联系客服";
        }
//		List<BaseBankCard> baseBankCard = baseBankCardService.selectUserBanlCard(parentId);
//		if(baseBankCard == null || baseBankCard.isEmpty()){
//			jedis.close();
//			return "邀请人未进行实名认证";
//		}
        return "";
    }
    /**
     * 把上级加入黑名单
     * @param parentId
     */
    private void joinBlack(String parentId){
        AccountsUsers ap = this.selectUserByPrimaryKey(parentId);
        String name = "";
        String phone = "";
        String idCard = "";
        String bankNum = "";
        String remark = "子商户刷单";
        if(ap!=null){
            name = ap.getTruename();
            phone = ap.getUsername();
            if(StringUtils.isNotBlank(ap.getCardid())){
                idCard = ap.getCardid();
            }

        }else{
            Agent agent = agentService.selectByUserId(parentId);
            name = agent.getEmk1();
            phone = agent.getUsername();
            if(StringUtils.isNotBlank(agent.getCardid())){
                idCard = agent.getCardid();
            }

        }
        BaseBankcard bankCard = baseBankcardService.selectForMd5ByUserId(parentId);
        if(bankCard != null){
            bankNum = bankCard.getBankcardnumber();
        }
        BlackList blackList = new BlackList();
        blackList.setName(name);
        blackList.setPhone(phone);
        blackList.setRemark(remark);
        blackList.setUserid(parentId);
        blackList.setAddmanager("系统自动添加");
        blackList.setCardnum(bankNum);
        blackList.setIdcard(idCard);
        blackList.setAddtime(new Date());
        blackListService.addBlackList(blackList);
    }

    public void insertAccountsUsersRegisteredState(String userId, String userName, String Num, String Ex) {
        AccountsUsersRegisteredState accountsUsersRegisteredState = new AccountsUsersRegisteredState();
        accountsUsersRegisteredState.setUserid(userId);
        accountsUsersRegisteredState.setUsername(userName);
        accountsUsersRegisteredState.setEx(Ex);
        accountsUsersRegisteredState.setType(1);
        accountsUsersRegisteredState.setState(true);
        accountsUsersRegisteredState.setNum(Num);
        accountsUsersRegisteredStateService.addAccountsUsersRegisteredState(accountsUsersRegisteredState);
    }


    /**
     * 根据Ips商户账号查询用户信息
     *
     * @param ipsAcctNo
     * @return
     */
    @Override
    public AccountsUsers selectIpsAcctNo(String ipsAcctNo) {
        return usersMapper.selectIpsAcctNo(ipsAcctNo);
    }
}
