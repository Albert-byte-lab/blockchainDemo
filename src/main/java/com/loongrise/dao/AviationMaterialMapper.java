package com.loongrise.dao;

import com.loongrise.entity.AviationMaterial;

public interface AviationMaterialMapper {
    int deleteByPrimaryKey(Integer am_id);

    int insert(AviationMaterial record);

    int insertSelective(AviationMaterial record);

    AviationMaterial selectByPrimaryKey(Integer am_id);

    int updateByPrimaryKeySelective(AviationMaterial record);

    int updateByPrimaryKey(AviationMaterial record);
}