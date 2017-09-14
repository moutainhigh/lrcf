package com.lrcf.yhb.common.redis.pojo;

import java.io.Serializable;

/**
 * 用户信息redis
 * Created by Krx on 2017/6/19.
 */
public class User implements Serializable {

    private String userId;
    private String userName;
    private String trueName;

    public User(String userId, String userName, String trueName) {
        this.userId = userId;
        this.userName = userName;
        this.trueName = trueName;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
}
