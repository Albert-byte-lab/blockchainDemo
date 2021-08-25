package com.loongrise.service;

import com.loongrise.entity.AviationMaterial;

import java.util.List;

public interface AviationMaterialService {
    //获取所有的零部件信息
    List<AviationMaterial> getAviationMaterialList();

    //增加零部件
    int addAm(AviationMaterial aviationMaterial);

    //获取新增零部件的id值
    long getNewId();

    //根据id获取零部件信息
    AviationMaterial getAmById(long amId);

    //one
    List<AviationMaterial> getOneAmList();
    //two
    List<AviationMaterial> getTwoAmList();
    //three
    List<AviationMaterial> getThreeAmList();
    //four
    List<AviationMaterial> getFourAmList();
    //five
    List<AviationMaterial> getFiveAmList();

    //零部件信息录入
    int addOneAm(AviationMaterial aviationMaterial);

}
