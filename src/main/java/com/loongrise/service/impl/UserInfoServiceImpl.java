package com.loongrise.service.impl;

import com.loongrise.dao.UserInfoDao;
import com.loongrise.entity.UserInfo;
import com.loongrise.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo getUserInfoById(long userId) {
        return userInfoDao.queryUserInfoById(userId);
    }
}
