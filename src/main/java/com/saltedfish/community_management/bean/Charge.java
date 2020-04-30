package com.saltedfish.community_management.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Charge {

    private Integer id;         //自增ID
    private String name;        //缴费项目名称
    private String desc;        //缴费项目描述
    private Double standard;    //缴费标准(金额)
    private Date creationDate;  //创建日期
    private String note;        //备注

}
