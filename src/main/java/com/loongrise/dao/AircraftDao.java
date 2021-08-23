package com.loongrise.dao;

import com.loongrise.entity.Aircraft;

import java.util.List;

public interface AircraftDao {
    //获取所有飞机类型信息
    List<Aircraft> queryAllAircraft();

    //根据acId获取飞机类型信息
    Aircraft queryAircraftById(long acId);

    //添加飞机类型信息
    int insertOneAircraft(Aircraft aircraft);

    //更新飞机类型信息
    int updateAircraft(Aircraft aircraft);

    //删除指定的飞机类型信息
    int deleteAircraft(long acId);

}
