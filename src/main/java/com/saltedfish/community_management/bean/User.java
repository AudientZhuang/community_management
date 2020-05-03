package com.saltedfish.community_management.bean;

import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
public class User {

    private Integer id;     //自增ID
    private Integer hh_id;  //外键关联住户id
    private String account; //住户账号
    private String password;//住户密码(默认123456)
    private String openId;  //绑定微信唯一标识
}
