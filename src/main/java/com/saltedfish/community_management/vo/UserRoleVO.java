package com.saltedfish.community_management.vo;

import com.saltedfish.community_management.bean.Role;
import lombok.Data;

import java.util.List;

/**
 * @author Audient
 * @date 2020/6/6
 */
@Data
public class UserRoleVO {

    private Integer userId;  // 用户id
    private String username; // 用户名
    private List<Role> roleList; // 用户拥有的角色

}
