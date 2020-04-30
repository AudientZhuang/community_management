package com.saltedfish.community_management.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class News {

    private Integer id;     //自增ID
    private String image;   //新闻图片路径
    private String title;   //新闻标题
    private String content; //新闻内容
    private String author;  //作者
    private Date date;      //发布日期

}
