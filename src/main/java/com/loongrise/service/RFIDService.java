package com.loongrise.service;

import com.loongrise.entity.RFID;

import java.util.List;

public interface RFIDService {
    //新增rfid信息
    int addRFID(RFID rfid);
    //查询所有的rfid信息
    List<RFID> queryRFID();
}
