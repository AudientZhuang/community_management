package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.Role;
import com.saltedfish.community_management.bean.User;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.mapper.RoleMapper;
import com.saltedfish.community_management.mapper.UserMapper;
import com.saltedfish.community_management.service.RoleService;
import com.saltedfish.community_management.vo.UserRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Audient
 * @date 2020/6/2
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result getRolesByUserId(Integer id) throws Exception {
        // 查找用户的角色信息
        List<Role> roleList = roleMapper.findRolesByUserId(id);
        // 获取不到用户的角色信息
        if (roleList == null){
            throw new Exception("获取不到用户的角色信息");
        }
        // 返回结果
        return new Result(HttpStatus.OK.value(),"查找用户的角色信息成功",roleList);
    }

    @Transactional
    @Override
    public Result updateUserRoles(Integer userId, List<Integer> roleIdList) throws Exception {
        // 未更新之前的用户角色id
        List<Integer> oldRoleIdList = roleMapper.findRoleIdByUserId(userId);
        // 不需要更新的用户角色id
        List<Integer> constantRoleIdList = new ArrayList<>();
        for (Integer roleId : roleIdList) {
            // 如果该用户已经拥有该角色,不需要更新
            if (oldRoleIdList.contains(roleId)){
                constantRoleIdList.add(roleId);
            }
        }

        for (Integer constantRoleId : constantRoleIdList) {
            // 移除不需要更新的用户角色,剩下的就是需要在数据库中进行删除的角色id
            if (oldRoleIdList.contains(constantRoleId)){
                oldRoleIdList.remove(constantRoleId);
            }
            // 移除不需要更新的用户角色,剩下的就是需要在数据库中进行添加的角色id
            if (roleIdList.contains(constantRoleId)){
                roleIdList.remove(constantRoleId);
            }
        }

        for (Integer oldRoleId : oldRoleIdList) {
            // 删除用户的角色
            Integer effort = roleMapper.deleteUserRole(userId, oldRoleId);
            // 删除失败
            if (effort == 0){
                throw new Exception("删除用户角色失败");
            }
        }

        for (Integer roleId : roleIdList) {
            // 添加用户的角色
            Integer effort = roleMapper.insertUserRole(userId, roleId);
            // 添加失败
            if (effort == 0){
                throw new Exception("添加用户角色失败");
            }
        }


        return new Result(HttpStatus.OK.value(),"更新用户角色成功",null);
    }

    @Override
    public Result getAllUserRoles() throws Exception {
        // 查找所有的管理员信息
        List<User> adminUserList = userMapper.findAdminUser();

        List<UserRoleVO> userRoleVOList = new ArrayList<>();

        if (adminUserList == null){
            throw new Exception("查找所有用户的角色信息失败");
        }

        for (User user : adminUserList) {
            // 查找管理员对应的角色信息
            List<Role> roleList = roleMapper.findRolesByUserId(user.getId());

            // 将用户信息和角色信息封装为UserRoleVO对象
            UserRoleVO userRoleVO = new UserRoleVO();
            userRoleVO.setUserId(user.getId());
            userRoleVO.setUsername(user.getUsername());
            userRoleVO.setRoleList(roleList);
            userRoleVOList.add(userRoleVO);
        }
        return new Result(HttpStatus.OK.value(),"查找所有用户的角色信息成功",userRoleVOList);
    }
}
