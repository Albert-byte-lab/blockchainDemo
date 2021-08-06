package com.loongrise.dao;

import com.loongrise.entity.PersonInfo;

public interface PersonInfoMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(PersonInfo record);

    int insertSelective(PersonInfo record);

    PersonInfo selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(PersonInfo record);

    int updateByPrimaryKey(PersonInfo record);
}