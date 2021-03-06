package com.saltedfish.community_management.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Audient
 * @date 2020/5/20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseholdVO {
    private Integer id;         //自增ID
    private String account;     //账号
    private String password;    //密码(默认123456)
    private String name;        //真实姓名
    private String gender;      //性别(男 或 女)
    private Integer age;        //年龄
    private String telephone;   //联系电话
    private String IDcard;      //身份证号码
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;   //入住日期
    private Integer isOwner;    //是否为业主(1表示是,0表示否)
    private Integer buildingId; //外键绑定楼栋ID
    private String buildingName;//楼栋名称
    private Integer roomId;     //外键绑定房间ID
    private String roomNum;    //房间号
}
