package com.czc.dao;

import com.czc.bean.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ClassName:OrderDao
 * Description:
 */
public interface OrderDao extends JpaRepository<Order,String> {

    List<Order> findByUid(String uid);
}
