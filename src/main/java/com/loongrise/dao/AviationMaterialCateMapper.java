package com.loongrise.dao;

import com.loongrise.entity.AviationMaterialCate;

public interface AviationMaterialCateMapper {
    int deleteByPrimaryKey(Integer am_category_id);

    int insert(AviationMaterialCate record);

    int insertSelective(AviationMaterialCate record);

    AviationMaterialCate selectByPrimaryKey(Integer am_category_id);

    int updateByPrimaryKeySelective(AviationMaterialCate record);

    int updateByPrimaryKey(AviationMaterialCate record);
}