package com.saltedfish.community_management.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class Facility {

    private Integer id;         //自增ID
    private String name;        //设施名称
    private Integer cateId;     //外键绑定分类ID
    private Integer num;        //设施购入数量
    private Double price;       //设施价格
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;  //购买日期
}
