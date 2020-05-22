package com.saltedfish.community_management.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Repair {

    private Integer id;             //自增ID
    private Integer householdId;    //外键绑定住户ID
    private String name;            //报修住户姓名
    private String telephone;       //联系电话
    private String content;         //报修内容
    private Date date;              //报修日期
    private Integer status;         //报修状态(1表示已解决,0表示未解决)
    private String reply;           //回复信息
}