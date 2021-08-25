package com.loongrise.service.impl;

import com.loongrise.dao.AviationMaterialDao;
import com.loongrise.entity.AviationMaterial;
import com.loongrise.service.AviationMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AviationMaterialServiceImpl implements AviationMaterialService {
    @Autowired
    private AviationMaterialDao aviationMaterialDao;
    @Override
    public List<AviationMaterial> getAviationMaterialList() {
        return aviationMaterialDao.queryAmList();
    }

    @Override
    public int addAm(AviationMaterial aviationMaterial) {
        return aviationMaterialDao.insertAm(aviationMaterial);
    }

    @Override
    public long getNewId() {
        return aviationMaterialDao.queryNewId();
    }

    @Override
    public AviationMaterial getAmById(long amId) {
        return aviationMaterialDao.queryAmById(amId);
    }

    @Override
    public List<AviationMaterial> getOneAmList() {
        return aviationMaterialDao.oneQueryAmList();
    }

    @Override
    public List<AviationMaterial> getTwoAmList() {
        return aviationMaterialDao.twoQueryAmList();
    }

    @Override
    public List<AviationMaterial> getThreeAmList() {
        return aviationMaterialDao.threeQueryAmList();
    }

    @Override
    public List<AviationMaterial> getFourAmList() {
        return aviationMaterialDao.fourQueryAmList();
    }

    @Override
    public List<AviationMaterial> getFiveAmList() {
        return aviationMaterialDao.fiveQueryAmList();
    }

    @Override
    public int addOneAm(AviationMaterial aviationMaterial) {
        return aviationMaterialDao.insertOneAm(aviationMaterial);
    }
}
