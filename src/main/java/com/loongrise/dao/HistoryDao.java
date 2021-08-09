package com.loongrise.dao;

import com.loongrise.entity.History;

import java.util.List;

public interface HistoryDao {
    //新增历史记录
    int insertHistory(History history);

    //查看所有的历史记录信息
    List<History> queryHistoryList();
}
