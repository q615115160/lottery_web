package com.czc.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Note {
    //帖子的编号
    @Id
    private String nid;
    //帖子的标题
    private String title;
    //帖子的内容
    private String content;
    //发帖的时间
    private String time;
    //谁发的帖子
    private String username;

    //发帖人的IP地址
    private String ipaddress;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="nid")
    private List<Comment> comments;


}
