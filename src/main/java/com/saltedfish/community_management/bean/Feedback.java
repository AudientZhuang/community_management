package com.saltedfish.community_management.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Feedback {

    private Integer id;             //自增ID
    private Integer householdId;    //外键绑定住户ID
    private String content;         //反馈内容
    private Date date;              //反馈日期
    private Integer status;         //反馈回复状态(0表示未回复，1表示已回复)
    private String reply;           //回复信息
}
