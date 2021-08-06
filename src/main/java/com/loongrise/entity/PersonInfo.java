package com.loongrise.entity;

import java.util.Date;

/**
 * 用户信息实体类
 */
public class PersonInfo {
    private long userId;
    //用户所属类别: 1:飞机制造商工程部门，2:零部件供应商，3:飞机制造商总装配厂，4:航司，5:飞机修理厂
    private Integer userType;
    //用户姓名
    private String name;
    //用户简介
    private String desc;
    //所属地址
    private String address;
    private Date cTime;
    private Date leTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
