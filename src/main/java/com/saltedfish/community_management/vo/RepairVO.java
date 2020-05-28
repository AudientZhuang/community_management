package com.saltedfish.community_management.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
 * @author Audient
 * @date 2020/5/21
 */
@Data
public class RepairVO {

    private Integer id;             //自增ID
    private Integer householdId;    //外键绑定住户ID
    private String householdName;   //住户名称
    private String name;            //报修住户姓名
    private String telephone;       //联系电话
    private String content;         //报修内容
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date date;              //报修日期
    private Integer status;         //报修状态(1表示已解决,0表示未解决)
    private String reply;           //回复信息
}
