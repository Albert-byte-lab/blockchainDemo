package com.loongrise.service;

import com.loongrise.entity.History;

import java.util.List;

public interface HistoryService {

    List<History> getHistoryList();

    int addHistory(History history);

    List<History> getHistoryListByAmId(History history);

    long getNewAmId(long amId);

    History getHistoryByHistoryId(long historyId);

    int modifyHistory(History history);
}
