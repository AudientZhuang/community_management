package com.saltedfish.community_management.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Payment {

    private Integer id;             //自增ID
    private Integer householdId;    //外键绑定住户ID
    private Integer charId;         //外键绑定缴费项目ID
    private Double charStandard;    //外键绑定缴费标准
    private Double payReal;         //实际支付
    private Integer payStatus;      //支付状态(1表示已支付,0表示未支付)
    private Date payDate;           //支付日期
}
