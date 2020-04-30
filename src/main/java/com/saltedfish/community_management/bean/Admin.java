package com.saltedfish.community_management.bean;

import lombok.Data;

@Data
public class Admin {

    private Integer id;         //自增ID
    private String username;    //账号
    private String password;    //密码(默认6个0)
}
