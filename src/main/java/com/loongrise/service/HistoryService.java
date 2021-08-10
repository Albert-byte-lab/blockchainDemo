package com.loongrise.service;

import com.loongrise.entity.History;

import java.util.List;

public interface HistoryService {

    List<History> getHistoryList();

    int addHistory(History history);

    List<History> getHistoryListByAmId(long amId);
}
