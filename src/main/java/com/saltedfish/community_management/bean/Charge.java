package com.saltedfish.community_management.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class Charge {

    private Integer id;         //自增ID
    private String name;        //缴费项目名称
    private String description; //缴费项目描述
    private Double standard;    //缴费标准(金额)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;  //创建日期
    private String note;        //备注

}
