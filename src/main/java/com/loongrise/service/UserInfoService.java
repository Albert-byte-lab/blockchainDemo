package com.loongrise.service;

import com.loongrise.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    //根据userId获取用户信息
    UserInfo getUserInfoById(long userId);

    //获取所有的用户信息
    List<UserInfo> getAllUserInfo();
}
