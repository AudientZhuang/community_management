package com.saltedfish.community_management.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Activity {

    private Integer id;         //自增ID
    private String image;       //活动图片路径
    private String title;       //活动标题
    private String content;     //活动内容
    private String address;     //活动地址
    private Integer number;        //活动人数
    private Date date;          //活动日期
    private String publisher;   //活动发布者
    private Date publishDate;   //活动发布日期

}
