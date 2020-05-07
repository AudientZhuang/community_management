package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.User;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.UserMapper;
import com.saltedfish.community_management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result cmLogin(String account, String password) {
        Result result = new Result();
        try {
            User user = userMapper.cmLogin(account, password);
            if(user != null) {
                //存在该用户
                result.setStatus(ResultCode.LOGIN_USER_SUCCESS.getStatus());
                result.setMessage(ResultCode.LOGIN_USER_SUCCESS.getMessage());
                result.setData(user.getHh_id());
            }
            else{
                //不存在该用户 登录失败
                result.setStatus(ResultCode.LOGIN_USER_FAILED.getStatus());
                result.setMessage(ResultCode.LOGIN_USER_FAILED.getMessage());
                result.setData(-1);
            }
            return result;
        }catch (Exception e) {
            //捕获异常
            result.setStatus(ResultCode.LOGIN_USER_EXCEPTION.getStatus());
            result.setMessage(ResultCode.LOGIN_USER_EXCEPTION.getMessage());
            return result;
        }
    }
}
