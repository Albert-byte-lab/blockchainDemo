package com.loongrise.dao;

import com.loongrise.entity.LocalAuth;
import org.springframework.cglib.core.Local;

public interface LocalAuthDao {

    //根据用户名和密码查询对应的用户信息
    LocalAuth queryLocalAuth(LocalAuth localAuth);

}
