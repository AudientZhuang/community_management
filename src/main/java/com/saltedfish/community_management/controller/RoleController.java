package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Audient
 * @date 2020/6/2
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 通过用户id获取对应的角色信息
     * @param userId
     * @return
     */
    @GetMapping("/roles")
    public Result getRolesByUserId(@RequestParam("userId") Integer userId) throws Exception {
        return roleService.getRolesByUserId(userId);
    }

    /**
     * 更新指定用户的角色信息
     * @param userId
     * @param roleIdList
     * @return
     */
    @PostMapping("/user/roles")
    public Result updateUserRoles(@RequestParam("userId") Integer userId,
                                  @RequestParam("roleIdList") List<Integer> roleIdList) throws Exception {
        return roleService.updateUserRoles(userId,roleIdList);
    }

    /**
     * 获取所有用户的所有角色信息
     * @return
     */
    @GetMapping("/user/all/roles")
    public Result getAllUserRoles() throws Exception {
        return roleService.getAllUserRoles();
    }
}
