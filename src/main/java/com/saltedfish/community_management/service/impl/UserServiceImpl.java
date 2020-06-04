package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.User;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.UserMapper;
import com.saltedfish.community_management.service.UserService;
import com.saltedfish.community_management.util.SHA256Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    // 日志对象
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result cmLogin(String account, String password) {
        User user = userMapper.cmLogin(account, password);
        if(user != null) {
            // 存在该用户
            return new Result(HttpStatus.OK.value(),"登陆成功",user.getHh_id());
        }
        else{
            // 不存在该用户 登录失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"登陆失败",null);
        }
    }

    @Override
    public Result wxLogin(String openId) {
        User user = userMapper.wxLogin(openId);
        if(user != null) {
            // 存在用户
            return new Result(HttpStatus.OK.value(),"登陆成功",user);
        }
        else {
            // 不存在该用户
            return new Result(HttpStatus.UNAUTHORIZED.value(),"登陆失败",null);
        }
    }

    @Override
    public Result bindWx(String openId, Integer id) {
        Integer effort = userMapper.bindWx(openId, id);
        if(effort != 0) {
            // 绑定成功
            return new Result(HttpStatus.OK.value(),"绑定成功",1);
        }
        else {
            // 绑定失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"绑定失败",0);
        }
    }

    @Override
    public Result unbindWx(Integer id) {
        Integer effort = userMapper.unbindWx(id);
        if(effort != 0) {
            // 解除绑定成功
            return new Result(HttpStatus.OK.value(),"解除绑定成功",null);
        }
        else {
            // 解除绑定失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"解除绑定失败",null);
        }
    }

    @Override
    public Result findIsBindByHid(Integer hh_id) {
        User user = userMapper.findIsBindByHid(hh_id);
        if(user != null) {
            //该用户已绑定微信
            return new Result(HttpStatus.OK.value(),"该用户已绑定微信",1);
        }
        else {
            //该用户未绑定微信
            return new Result(HttpStatus.UNAUTHORIZED.value(),"该用户未绑定微信",0);
        }
    }

    @Override
    public Result findUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        if (user != null){
            // 找到指定账号的用户
            return new Result(HttpStatus.OK.value(),"找到用户",user);
        }else {
            // 没有找到用户
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到用户",null);
        }
    }

    @Override
    public Result verifyPassword(Integer hh_id, String password) {
        User user = userMapper.findUserByHouseholdId(hh_id);
        if(user == null) {
            // 没有找到用户
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到用户",null);
        } else {
            // 找到指定hh_id用户
            String enter_password = SHA256Util.sha256(password, user.getSalt());
            if(enter_password.equals(user.getPassword())) {
                return new Result(HttpStatus.OK.value(),"密码验证正确",null);
            }
            else {
                return new Result(HttpStatus.UNAUTHORIZED.value(),"密码验证错误",null);
            }
        }
    }

    @Override
    public Result modifyPassword(Integer hh_id, String passsword) {
        User user = userMapper.findUserByHouseholdId(hh_id);
        if(user == null) {
            // 没有找到用户
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到用户",null);
        } else {
            // 找到指定id用户
            String salt = UUID.randomUUID().toString();
            String newPassword = SHA256Util.sha256(passsword, salt);
            Integer effort = userMapper.modifyPassword(hh_id, newPassword, salt);
            if(effort != 0) {
                // 修改成功
                return new Result(HttpStatus.OK.value(),"修改用户密码成功",null);
            } else {
                // 修改失败
                return new Result(HttpStatus.UNAUTHORIZED.value(),"修改用户密码失败", null);
            }
        }
    }

}
