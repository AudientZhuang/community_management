package com.saltedfish.community_management.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Audient
 * @date 2020/5/21
 */
@Data
public class PaymentVO {

    private Integer id;             //自增ID
    private Integer householdId;    //外键绑定住户ID
    private String householdName;   //住户名称
    private Integer charId;         //外键绑定缴费项目ID
    private String chargeName;      //缴费项目名称
    private Double charStandard;    //外键绑定缴费标准
    private Double payReal;         //实际支付
    private Integer payStatus;      //支付状态(1表示已支付,0表示未支付)
    private Date payDate;           //支付日期
}
