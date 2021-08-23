package com.loongrise.service.impl;

import com.loongrise.dao.AircraftDao;
import com.loongrise.entity.Aircraft;
import com.loongrise.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftServiceImpl implements AircraftService {

    @Autowired
    private AircraftDao aircraftDao;

    @Override
    public int addAircraft(Aircraft aircraft) {
        return aircraftDao.insertOneAircraft(aircraft);
    }

    @Override
    public List<Aircraft> getAllAircraft() {
        return aircraftDao.queryAllAircraft();
    }

    @Override
    public Aircraft getAircraftById(long acId) {
        return aircraftDao.queryAircraftById(acId);
    }

    @Override
    public int modifyAircraft(Aircraft aircraft) {
        return aircraftDao.updateAircraft(aircraft);
    }

    @Override
    public int deleteAircraftById(long acId) {
        return aircraftDao.deleteAircraft(acId);
    }
}
