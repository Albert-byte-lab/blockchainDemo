package com.loongrise.dao;

import com.loongrise.entity.RFID;

import java.util.List;

public interface RFIDDao {

    int insertRFID(RFID rfid);

    List<RFID> queryRFIDList();

    RFID queryRFIDById(int rfidId);

    //根据epc值获取对应的标签信息
    RFID queryRFIDByEpc(String epc);
}
