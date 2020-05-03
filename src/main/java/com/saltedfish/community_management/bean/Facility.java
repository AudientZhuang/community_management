package com.saltedfish.community_management.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Facility {

    private Integer id;         //自增ID
    private String name;        //设施名称
    private Integer cateId;     //外键绑定分类ID
    private Integer num;        //设施购入数量
    private Double price;       //设施价格
    private Date purchaseDate;  //购买日期
}
