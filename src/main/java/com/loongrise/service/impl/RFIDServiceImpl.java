package com.loongrise.service.impl;

import com.loongrise.dao.RFIDDao;
import com.loongrise.entity.RFID;
import com.loongrise.service.RFIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
