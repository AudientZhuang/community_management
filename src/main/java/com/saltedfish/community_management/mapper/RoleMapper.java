package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Audient
 * @date 2020/6/2
 */
@Mapper
public interface RoleMapper {

    /**
     * 根据用户id获取对应的角色信息
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(@Param("userId") Integer userId);

    /**
     * 根据用户id获取对应的角色id
     * @param userId
     * @return
     */
    List<Integer> findRoleIdByUserId(@Param("userId") Integer userId);

    /**
     * 删除指定userId的用户的指定roleId的角色
     * @param userId
     * @param roleId
     * @return
     */
    Integer deleteUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    /**
     * 为指定userId的用户添加指定roleId的角色
     * @param userId
     * @param roleId
     * @return
     */
    Integer insertUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
}
