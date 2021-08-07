package com.loongrise.service.impl;

import com.loongrise.dao.UserInfoDao;
import com.loongrise.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoDao {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo queryUserInfoById(long userId) {
        return userInfoDao.queryUserInfoById(userId);
    }
}
