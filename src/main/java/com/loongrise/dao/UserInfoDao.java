package com.loongrise.dao;

import com.loongrise.entity.UserInfo;

public interface UserInfoDao {

    UserInfo queryUserInfoById(long userId);
}
