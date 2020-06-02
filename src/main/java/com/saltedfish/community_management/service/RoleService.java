package com.saltedfish.community_management.service;

import com.saltedfish.community_management.common.Result;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Audient
 * @date 2020/6/2
 */
public interface RoleService {

    /**
     * 通过用户id获取对应的角色信息
     * @param id
     * @return
     */
    Result getRolesByUserId(Integer id) throws Exception;

    /**
     * 更新用户角色
     * @param userId
     * @param roleIdList
     * @return
     */
    Result updateUserRoles(Integer userId, List<Integer> roleIdList) throws Exception;
}
