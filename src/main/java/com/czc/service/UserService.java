package com.czc.service;

import com.czc.bean.User;

/**
 * ClassName:UserService
 * Description:
 */
public interface UserService {

    User register(User user);

    User findUser(String email, String password);
}
