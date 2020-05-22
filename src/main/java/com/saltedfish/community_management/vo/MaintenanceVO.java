package com.saltedfish.community_management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Audient
 * @date 2020/5/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceVO {

    private Integer id;         //自增ID
    private Integer facilityId; //外键绑定设施iD
    private String facilityName;//设施名称
    private String content;     //维护内容
    private Integer status;     //维护状态(0表示未维护，1表示已维护)
    private Double cost;        //维护费用
    private Date createDate;    //记录创建日期
    private Date date;          //维护日期
    private String note;        //备注
}
