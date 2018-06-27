package com.czc.service;

import com.czc.bean.Order;

import java.util.List;


/**
 * ClassName:OrderService
 * Description:
 */
public interface OrderService {


    void save(Order order);

    Order find(String oid);

    List<Order> findByUid(String uid);
}
