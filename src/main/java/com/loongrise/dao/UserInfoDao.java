package com.loongrise.dao;

import com.loongrise.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {

    UserInfo queryUserInfoById(long userId);

    List<UserInfo> queryAllUserInfo();
}
