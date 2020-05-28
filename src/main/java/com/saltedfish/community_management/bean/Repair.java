package com.saltedfish.community_management.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class Repair {

    private Integer id;             //自增ID
    private Integer householdId;    //外键绑定住户ID
    private String name;            //报修住户姓名
    private String telephone;       //联系电话
    private String content;         //报修内容
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;              //报修日期
    private Integer status;         //报修状态(1表示已解决,0表示未解决)
    private String reply;           //回复信息
}