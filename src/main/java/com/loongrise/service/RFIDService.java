package com.loongrise.service;

import com.loongrise.entity.RFID;

import java.util.List;

public interface RFIDService {
    //新增rfid信息
    int addRFID(RFID rfid);
    //查询所有的rfid信息
    List<RFID> queryRFID();

    //根据epc值获取对应的标签信息
    RFID getRFIDByEpc(String epc);

    //批量获取epc值对应的标签信息
    List<RFID> getRFIDListByEpcs(List<String> epcList);

    RFID queryRFIDById(Long rdidID);

    RFID getRFIDByAmId(long amId);
}
