package com.loongrise.service.impl;

import com.loongrise.dao.AviationMaterialCateDao;
import com.loongrise.entity.AviationMaterialCate;
import com.loongrise.service.AviationMaterialCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AviationMaterialCateServiceImpl implements AviationMaterialCateService {
    @Autowired
    private AviationMaterialCateDao aviationMaterialCateDao;
    @Override
    public List<AviationMaterialCate> getAviationMaterialCateList() {
        return aviationMaterialCateDao.queryAllAmcList();
    }

    @Override
    public AviationMaterialCate getAviationMaterialCateById(long amCategoryId) {
        return aviationMaterialCateDao.queryAmcById(amCategoryId);
    }
}
