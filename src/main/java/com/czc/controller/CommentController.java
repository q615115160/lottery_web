package com.czc.controller;

import com.czc.bean.Comment;
import com.czc.bean.User;
import com.czc.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import javax.servlet.http.HttpSession;

/**
 * ClassName:CommentController
 * Description:
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService mCommentService;

    @RequestMapping("/add")
    public String addComment(String nid, String content,HttpSession session){
        Comment comment = new Comment();
        comment.setNid(nid);
        comment.setContent(content);
        comment.setTime(new Date().toLocaleString());
        User user = (User) session.getAttribute("user");
        comment.setUsername(user.getUsername());
        Comment savedComment=mCommentService.save(comment);
        return "redirect:/bbs/detail?nid="+nid;

    }

}
