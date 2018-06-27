package com.czc.service;

import com.czc.bean.BallHistory;

import java.util.List;

/**
 * ClassName:HistoryService
 * Description:
 */
public interface HistoryService {
    List<BallHistory> findAll();
    BallHistory findOne(String code);
}
