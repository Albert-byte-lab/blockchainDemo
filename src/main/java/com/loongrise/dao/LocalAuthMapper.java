package com.loongrise.dao;

import com.loongrise.entity.LocalAuth;

public interface LocalAuthMapper {
    int deleteByPrimaryKey(Integer local_auth_id);

    int insert(LocalAuth record);

    int insertSelective(LocalAuth record);

    LocalAuth selectByPrimaryKey(Integer local_auth_id);

    int updateByPrimaryKeySelective(LocalAuth record);

    int updateByPrimaryKey(LocalAuth record);
}