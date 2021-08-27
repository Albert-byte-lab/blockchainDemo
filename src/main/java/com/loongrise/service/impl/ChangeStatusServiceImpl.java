package com.loongrise.service.impl;

import com.loongrise.dao.ChangeStatusDao;
import com.loongrise.service.ChangeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeStatusServiceImpl implements ChangeStatusService {
    @Autowired
    private ChangeStatusDao changeStatusDao;
    @Override
    public int modifyStatus() {
        return changeStatusDao.changeStatus();
    }
}
