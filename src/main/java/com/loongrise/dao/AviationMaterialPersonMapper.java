package com.loongrise.dao;

import com.loongrise.entity.AviationMaterialPerson;

public interface AviationMaterialPersonMapper {
    int deleteByPrimaryKey(Integer am_person_id);

    int insert(AviationMaterialPerson record);

    int insertSelective(AviationMaterialPerson record);

    AviationMaterialPerson selectByPrimaryKey(Integer am_person_id);

    int updateByPrimaryKeySelective(AviationMaterialPerson record);

    int updateByPrimaryKey(AviationMaterialPerson record);
}