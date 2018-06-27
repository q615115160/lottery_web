package com.czc.service.impl;

import com.czc.bean.Comment;
import com.czc.dao.CommentDao;
import com.czc.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:CommentServiceImpl
 * Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao mCommentDao;

    @Override
    public Comment save(Comment comment) {
        return mCommentDao.save(comment);
    }
}
