package com.loongrise.entity;

import java.util.Date;

/**
 * 本地账户实体类
 */
public class LocalAuth {

    private Long localAuthId;
    //账户所属用户
    private UserInfo userInfo;
    private String username;
    private String password;
    private Date cTime;
    private Date leTime;

    public Long getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(Long localAuthId) {
        this.localAuthId = localAuthId;
    }

    public UserInfo getPersonInfo() {
        return userInfo;
    }

    public void setPersonInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getLeTime() {
        return leTime;
    }

    public void setLeTime(Date leTime) {
        this.leTime = leTime;
    }
}
