package com.saltedfish.community_management.bean;

import lombok.Data;

@Data
public class Permission {

    private Integer id;         //自增ID
    private String permission;  //管理权限
    private String description; //权限描述
}
