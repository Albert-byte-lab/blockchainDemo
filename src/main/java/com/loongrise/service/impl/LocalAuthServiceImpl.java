package com.loongrise.service.impl;

import com.loongrise.dao.LocalAuthDao;
import com.loongrise.entity.LocalAuth;
import com.loongrise.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalAuthServiceImpl implements LocalAuthService {

    @Autowired
    private LocalAuthDao localAuthDao;

    @Override
    public LocalAuth getLocalAuthBypwd(LocalAuth localAuth) {
        return localAuthDao.queryLocalAuth(localAuth);
    }
}
