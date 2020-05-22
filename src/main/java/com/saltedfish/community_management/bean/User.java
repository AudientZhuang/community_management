package com.saltedfish.community_management.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;     //自增ID
    private Integer hh_id;  //外键关联住户id
    private String account; //住户账号
    private String password;//住户密码(默认123456)
    private String openId;  //绑定微信（保留字段）
}
