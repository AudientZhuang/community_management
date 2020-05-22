package com.saltedfish.community_management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Audient
 * @date 2020/5/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRegisterVO {

    private Integer id;         //自增ID
    private Integer act_id;     //外键绑定活动ID
    private String actName;     //活动名称
    private Integer hh_id;      //外键绑定住户ID
    private String householdName;  //住户名称
    private String telephone;   //联系电话
    private Integer num;        //报名人数
}
