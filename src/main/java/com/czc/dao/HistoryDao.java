package com.czc.dao;

import com.czc.bean.BallHistory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName:HistoryDao
 * Description:
 */
public interface HistoryDao extends JpaRepository<BallHistory, String> {

}
