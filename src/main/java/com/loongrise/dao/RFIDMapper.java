package com.loongrise.dao;

import com.loongrise.entity.RFID;

public interface RFIDMapper {
    int deleteByPrimaryKey(Integer rfid_id);

    int insert(RFID record);

    int insertSelective(RFID record);

    RFID selectByPrimaryKey(Integer rfid_id);

    int updateByPrimaryKeySelective(RFID record);

    int updateByPrimaryKey(RFID record);
}