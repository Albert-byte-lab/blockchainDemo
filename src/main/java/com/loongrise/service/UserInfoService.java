package com.loongrise.service;

import com.loongrise.entity.UserInfo;

public interface UserInfoService {
    //根据userId获取用户信息
    UserInfo getUserInfoById(long userId);
}
