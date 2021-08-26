package com.loongrise.dao;

import com.loongrise.entity.RFID;

import java.util.List;

public interface RFIDDao {

    int insertRFID(RFID rfid);

    List<RFID> queryRFIDList();

    RFID queryRFIDById(Long rfidId);

    //根据epc值获取对应的标签信息
    RFID queryRFIDByEpc(String epc);

    //根据amId获取对应的rfid信息
    RFID queryRFIDByAmId(long amId);


}
