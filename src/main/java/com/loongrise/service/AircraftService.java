package com.loongrise.service;

import com.loongrise.entity.Aircraft;

import java.util.List;

public interface AircraftService {
    //新增飞机类型信息
    int addAircraft(Aircraft aircraft);

    //获取所有的飞机类型信息
    List<Aircraft> getAllAircraft();

    //根据acId获取飞机类型信息
    Aircraft getAircraftById(long acId);

    //更新指定的飞机类型信息
    int modifyAircraft(Aircraft aircraft);

    //删除acId对应的飞机类型信息
    int deleteAircraftById(long acId);

}
