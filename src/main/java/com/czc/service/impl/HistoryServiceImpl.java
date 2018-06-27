package com.czc.service.impl;

import com.czc.bean.BallHistory;
import com.czc.dao.HistoryDao;
import com.czc.service.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:HistoryServiceImpl
 * Description:
 */
@Service
class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryDao dao;

    @Override
    public List<BallHistory> findAll() {
        return dao.findAll();
    }

    @Override
    public BallHistory findOne(String code) {
        return dao.findOne(code);
    }


}
