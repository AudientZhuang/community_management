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

    @Override
    public Result wxLogin(String openId) {
        Result result = new Result();
        try {
            User user = userMapper.wxLogin(openId);
            if(user != null) {
                //存在用户
                result.setStatus(ResultCode.LOGIN_WX_SUCCESS.getStatus());
                result.setMessage(ResultCode.LOGIN_WX_SUCCESS.getMessage());
                result.setData(user.getHh_id());
            }
            else {
                //不存在该用户
                result.setStatus(ResultCode.LOGIN_WX_FAILED.getStatus());
                result.setMessage(ResultCode.LOGIN_WX_FAILED.getMessage());
                result.setData(-1);
            }
            return result;
        }catch (Exception e) {
            //捕获异常
            result.setStatus(ResultCode.LOGIN_WX_EXCEPTION.getStatus());
            result.setMessage(ResultCode.LOGIN_WX_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result bindWx(String openId, Integer id) {
        Result result = new Result();
        try {
            Integer effort = userMapper.bindWx(openId, id);
            if(effort != 0) {
                //绑定成功
                result.setStatus(ResultCode.BIND_WX_SUCESS.getStatus());
                result.setMessage(ResultCode.BIND_WX_SUCESS.getMessage());
                result.setData(1);
            }
            else {
                //绑定失败
                result.setStatus(ResultCode.BIND_WX_FAILED.getStatus());
                result.setMessage(ResultCode.BIND_WX_FAILED.getMessage());
                result.setData(0);
            }
            return result;
        }catch (Exception e) {
            //捕获异常
            logger.info("发生异常：" + e.getMessage());
            result.setStatus(ResultCode.BIND_WX_EXCEPTION.getStatus());
            result.setMessage(ResultCode.BIND_WX_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findIsBindByHid(Integer hh_id) {
        Result result = new Result();
        try {
            User user = userMapper.findIsBindByHid(hh_id);
            if(user != null) {
                //该用户已绑定微信
                result.setStatus(ResultCode.FIND_USER_ISBIND_BY_ID_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_USER_ISBIND_BY_ID_SUCCESS.getMessage());
                result.setData(1);
            }
            else {
                //该用户未绑定微信
                result.setStatus(ResultCode.FIND_USER_ISBIND_BY_ID_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_USER_ISBIND_BY_ID_FAILED.getMessage());
                result.setData(0);
            }
            return result;
        } catch (Exception e) {
            //捕获异常
            result.setStatus(ResultCode.FIND_USER_ISBIND_BY_ID_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_USER_ISBIND_BY_ID_EXCEPTION.getMessage());
            return result;
        }
    }

}
