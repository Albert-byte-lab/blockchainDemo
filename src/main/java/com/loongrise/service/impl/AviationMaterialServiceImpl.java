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
}
