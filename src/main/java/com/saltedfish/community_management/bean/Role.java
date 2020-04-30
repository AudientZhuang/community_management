package com.saltedfish.community_management.bean;

import lombok.Data;

@Data
public class Role {

    private Integer id;         //自增ID
    private String role;        //角色
    private String description; //角色描述
}
