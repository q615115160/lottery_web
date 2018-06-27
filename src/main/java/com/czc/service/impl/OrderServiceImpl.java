package com.czc.service.impl;

import com.czc.bean.Order;
import com.czc.dao.OrderDao;
import com.czc.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:OrderServiceImpl
 * Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao mOrderDao;
    @Override
    public void save(Order order) {
        mOrderDao.save(order);
    }

    @Override
    public Order find(String oid) {
        return mOrderDao.findOne(oid);
    }

    @Override
    public List<Order> findByUid(String uid) {
        return mOrderDao.findByUid(uid);
    }
}
