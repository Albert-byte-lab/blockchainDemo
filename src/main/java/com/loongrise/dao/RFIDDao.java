package com.loongrise.dao;

import com.loongrise.entity.RFID;

import java.util.List;

public interface RFIDDao {

    int insertRFID(RFID rfid);

    List<RFID> queryRFIDList();

    RFID queryRFID(int rfidId);
}
