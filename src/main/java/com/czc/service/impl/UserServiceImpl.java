package com.czc.service.impl;

import com.czc.bean.User;
import com.czc.dao.UserDao;
import com.czc.service.UserService;
import com.czc.utils.MD5Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao mUserDao;

    @Override
    public User register(User user) {
        user.setPassword(MD5Utils.encode(user.getPassword()));
        User save = mUserDao.save(user);
        return save;
    }

    @Override
    public User findUser(String email, String password) {
        password = MD5Utils.encode(password);
        User user=mUserDao.findByEmailAndPassword(email,password);
        return user;
    }
}
