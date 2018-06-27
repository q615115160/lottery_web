package com.czc.dao;

import com.czc.bean.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName:CommentDao
 * Description:
 */
public interface CommentDao  extends JpaRepository<Comment,Integer> {
}
