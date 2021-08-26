package com.loongrise.service.impl;

import com.loongrise.dao.HistoryDao;
import com.loongrise.entity.History;
import com.loongrise.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryDao historyDao;


    @Override
    public List<History> getHistoryList() {
        return historyDao.queryHistoryList();
    }

    @Override
    public int addHistory(History history) {
        return historyDao.insertHistory(history);
    }

    @Override
    public List<History> getHistoryListByAmId(History history) {
        return historyDao.queryHistoryListByAmId(history);
    }
}
