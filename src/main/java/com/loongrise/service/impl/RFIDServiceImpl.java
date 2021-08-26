package com.loongrise.service.impl;

import com.loongrise.dao.RFIDDao;
import com.loongrise.entity.RFID;
import com.loongrise.service.RFIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RFIDServiceImpl implements RFIDService {

    @Autowired
    private RFIDDao rfidDao;

    @Override
    public int addRFID(RFID rfid) {
        return rfidDao.insertRFID(rfid);
    }

    @Override
    public List<RFID> queryRFID() {
        return rfidDao.queryRFIDList();
    }

    @Override
    public RFID getRFIDByEpc(String epc) {
        return rfidDao.queryRFIDByEpc(epc);
    }

    @Override
    public List<RFID> getRFIDListByEpcs(List<String> epcList) {
        List<RFID> rfidList = new ArrayList<>();
        RFID rfid = null;
        for(String epc:epcList){
           rfid =  rfidDao.queryRFIDByEpc(epc);
           if(rfid != null){
               rfidList.add(rfid);
           }
        }
        if(rfidList != null){
            return rfidList;
        }
        return null;
    }

    @Override
    public RFID queryRFIDById(Long rdidID) {
        return rfidDao.queryRFIDById(rdidID);
    }

    @Override
    public RFID getRFIDByAmId(long amId) {
        return rfidDao.queryRFIDByAmId(amId);
    }

}
