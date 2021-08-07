package com.loongrise.service;

import com.loongrise.entity.LocalAuth;

public interface LocalAuthService {

    /**
     * 根据用户名密码查询
     * @param localAuth
     * @return
     */
    LocalAuth getLocalAuthBypwd(LocalAuth localAuth);

}
