package com.loongrise.service;

import com.loongrise.entity.AviationMaterialCate;

import java.util.List;

public interface AviationMaterialCateService {
    //获取所有的零部件所属类型
    List<AviationMaterialCate> getAviationMaterialCateList();

    //根据id获取零部件类型信息
    AviationMaterialCate getAviationMaterialCateById(long amCategoryId);
}
