package com.loongrise.dao;

import com.loongrise.entity.History;

import java.util.List;

public interface HistoryDao {
    //新增历史记录
    int insertHistory(History history);

    //查看所有的历史记录信息
    List<History> queryHistoryList();

    //根据amId获取对应的历史记录
    List<History> queryHistoryListByAmId(History history);

    //获取当前零部件最新的historyId;
    long queryNewId(long amId);

    //根据historyId获取对应的history
    History queryByHistoryId(long historyId);

    //更新历史记录表
    int updateHistory(History history);
}
