package com.saltedfish.community_management.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Maintenance {

    private Integer id;         //自增ID
    private Integer facilityId; //外键绑定设施iD
    private String content;     //维护内容
    private Integer status;     //维护状态(0表示未维护，1表示已维护)
    private Double cost;        //维护费用
    private Date createDate;    //记录创建日期
    private Date date;          //维护日期
    private String note;        //备注
}
