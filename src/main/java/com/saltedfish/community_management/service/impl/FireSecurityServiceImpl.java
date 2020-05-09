package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.FireSecurity;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.FireSecurityMapper;
import com.saltedfish.community_management.service.FireSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.font.CreatedFontTracker;

import java.util.List;
import java.util.Map;

@Service
public class FireSecurityServiceImpl implements FireSecurityService {

    @Autowired
    private FireSecurityMapper fireSecurityMapper;

    @Override
    public Result addFireSecurity(FireSecurity fireSecurity) {
        Result result = new Result();
        try {
            Integer effort = fireSecurityMapper.insertFireSecurity(fireSecurity);
            if (effort != 0){
                //添加消防检查情况成功
                result.setStatus(ResultCode.INSERT_FIRE_SECURITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.INSERT_FIRE_SECURITY_SUCCESS.getMessage());
            }else{
                //添加消防检查情况失败
                result.setStatus(ResultCode.INSERT_FIRE_SECURITY_FAILED.getStatus());
                result.setMessage(ResultCode.INSERT_FIRE_SECURITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.INSERT_FIRE_SECURITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.INSERT_FIRE_SECURITY_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result updateFireSecurity(FireSecurity fireSecurity) {
        Result result = new Result();
        try {
            Integer effort = fireSecurityMapper.updateFireSecurity(fireSecurity);
            if (effort != 0){
                //更新消防检查情况成功
                result.setStatus(ResultCode.UPDATE_FIRE_SECURITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.UPDATE_FIRE_SECURITY_SUCCESS.getMessage());
            }else{
                //更新消防检查情况失败
                result.setStatus(ResultCode.UPDATE_FIRE_SECURITY_FAILED.getStatus());
                result.setMessage(ResultCode.UPDATE_FIRE_SECURITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.UPDATE_FIRE_SECURITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.UPDATE_FIRE_SECURITY_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result deleteFireSecurity(Integer id) {
        Result result = new Result();
        try {
            Integer effort = fireSecurityMapper.deleteFireSecurity(id);
            if (effort != 0){
                //删除消防检查情况成功
                result.setStatus(ResultCode.DELETE_FIRE_SECURITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.DELETE_FIRE_SECURITY_SUCCESS.getMessage());
            }else {
                //删除消防检查情况失败
                result.setStatus(ResultCode.DELETE_FIRE_SECURITY_FAILED.getStatus());
                result.setMessage(ResultCode.DELETE_FIRE_SECURITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.DELETE_FIRE_SECURITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.DELETE_FIRE_SECURITY_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findFireSecurityById(Integer id) {
        Result result = new Result();
        try {
            FireSecurity fireSecurity = fireSecurityMapper.findFireSecurityById(id);
            if (fireSecurity != null){
                //查询指定id的消防检查情况成功
                result.setStatus(ResultCode.FIND_FIRE_SECURITY_BY_ID_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_FIRE_SECURITY_BY_ID_SUCCESS.getMessage());
                result.setData(fireSecurity);
            }else{
                //查询指定id的消防检查情况失败
                result.setStatus(ResultCode.FIND_FIRE_SECURITY_BY_ID_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_FIRE_SECURITY_BY_ID_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_FIRE_SECURITY_BY_ID_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_FIRE_SECURITY_BY_ID_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findFireSecurity(Map<String, String> conditionMap) {
        Result result = new Result();
        try {
            List<String> fireSecurityList = fireSecurityMapper.findFireSecurity(conditionMap);
            if (fireSecurityList != null){
                //根据条件查询消防检查情况成功
                result.setStatus(ResultCode.FIND_FIRE_SECURITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_FIRE_SECURITY_SUCCESS.getMessage());
                result.setData(fireSecurityList);
            }else{
                //根据条件查询消防检查情况失败
                result.setStatus(ResultCode.FIND_FIRE_SECURITY_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_FIRE_SECURITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_FIRE_SECURITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_FIRE_SECURITY_EXCEPTION.getMessage());
            return result;
        }
    }
}
