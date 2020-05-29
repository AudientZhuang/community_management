package com.saltedfish.community_management.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class Household {

    private Integer id;         //自增ID
    //private String account;     //账号
    //private String password;    //密码(默认123456)
    private String name;        //真实姓名
    private String gender;      //性别(男 或 女)
    private Integer age;        //年龄
    private String telephone;   //联系电话
    private String IDcard;      //身份证号码
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;   //入住日期
    private Integer isOwner;    //是否为业主(1表示是,0表示否)
    private Integer buildingId; //外键绑定楼栋ID
    private Integer roomId;     //外键绑定房间ID

}
