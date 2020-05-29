package com.saltedfish.community_management.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
 * @author Audient
 * @date 2020/5/21
 */
@Data
public class FacilityVO {
    private Integer id;         //自增ID
    private String name;        //设施名称
    private Integer cateId;     //外键绑定分类ID
    private String cateName;    //设施分类名称
    private Integer num;        //设施购入数量
    private Double price;       //设施价格
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date purchaseDate;  //购买日期
}
