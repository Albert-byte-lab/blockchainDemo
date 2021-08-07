package com.loongrise.service;

import com.loongrise.entity.AviationMaterial;

import java.util.List;

public interface AviationMaterialService {
    //获取所有的零部件信息
    List<AviationMaterial> getAviationMaterialList();

    //增加零部件
    int addAm(AviationMaterial aviationMaterial);
}
