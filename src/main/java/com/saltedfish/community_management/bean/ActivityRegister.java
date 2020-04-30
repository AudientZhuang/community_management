package com.saltedfish.community_management.bean;

import lombok.Data;

@Data
public class ActivityRegister {

    private Integer id;         //自增ID
    private Integer act_id;     //外键绑定活动ID
    private Integer hh_id;      //外键绑定住户ID
    private String telephone;   //联系电话
    private Integer num;        //报名人数
}
