package com.loongrise.dao;

import com.loongrise.entity.AviationMaterialImg;

public interface AviationMaterialImgMapper {
    int deleteByPrimaryKey(Integer am_img_id);

    int insert(AviationMaterialImg record);

    int insertSelective(AviationMaterialImg record);

    AviationMaterialImg selectByPrimaryKey(Integer am_img_id);

    int updateByPrimaryKeySelective(AviationMaterialImg record);

    int updateByPrimaryKey(AviationMaterialImg record);
}