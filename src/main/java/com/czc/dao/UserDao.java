package com.czc.dao;

import com.czc.bean.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName:UserDap
 * Description:
 */
public interface UserDao extends JpaRepository<User,String> {
    User findByEmailAndPassword(String email, String password);
}
