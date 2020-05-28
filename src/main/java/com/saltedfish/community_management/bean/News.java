package com.saltedfish.community_management.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class News {

    private Integer id;     //自增ID
    private String image;   //新闻图片路径
    private String title;   //新闻标题
    private String content; //新闻内容
    private String author;  //作者
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;      //发布日期

}
