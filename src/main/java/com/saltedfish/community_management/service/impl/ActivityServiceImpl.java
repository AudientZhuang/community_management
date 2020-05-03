package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.Activity;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.ActivityMapper;
import com.saltedfish.community_management.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Result addActivity(Activity activity) {
        Result result = new Result();
        try{
            Integer effort = activityMapper.insertActivity(activity);
            if (effort != 0){
                //添加活动信息成功
                result.setStatus(ResultCode.INSERT_ACTIVITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.INSERT_ACTIVITY_SUCCESS.getMessage());
            }else{
                //添加活动信息失败
                result.setStatus(ResultCode.INSERT_ACTIVITY_FAILED.getStatus());
                result.setMessage(ResultCode.INSERT_ACTIVITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.INSERT_ACTIVITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.INSERT_ACTIVITY_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result updateActivity(Activity activity) {
        Result result = new Result();
        try{
            Integer effort = activityMapper.updateActivity(activity);
            if(effort != 0){
                //更新活动信息成功
                result.setStatus(ResultCode.UPDATE_ACTIVITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.UPDATE_ACTIVITY_SUCCESS.getMessage());

            }else{
                //更新活动信息失败
                result.setStatus(ResultCode.UPDATE_ACTIVITY_FAILED.getStatus());
                result.setMessage(ResultCode.UPDATE_ACTIVITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.UPDATE_ACTIVITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.UPDATE_ACTIVITY_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result deleteActivity(Integer id) {
        Result result = new Result();
        try {
            Integer effort = activityMapper.deleteActivity(id);
            if(effort != 0){
                //删除成功
                result.setStatus(ResultCode.DELETE_ACTIVITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.DELETE_ACTIVITY_SUCCESS.getMessage());
            }else {
                //删除失败
                result.setStatus(ResultCode.DELETE_ACTIVITY_FAILED.getStatus());
                result.setMessage(ResultCode.DELETE_ACTIVITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.DELETE_ACTIVITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.DELETE_ACTIVITY_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findActivityById(Integer id) {
        Result result = new Result();
        try {
            Activity activity = activityMapper.findActivityById(id);
            if(activity != null){
                //查询指定id的活动信息成功
                result.setStatus(ResultCode.FIND_ACTIVITY_BY_ID_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_ACTIVITY_BY_ID_SUCCESS.getMessage());
                result.setData(activity);
            }else {
                //没有找到指定id的活动信息
                result.setStatus(ResultCode.FIND_ACTIVITY_BY_ID_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_ACTIVITY_BY_ID_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_ACTIVITY_BY_ID_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_ACTIVITY_BY_ID_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findActivity(Map<String, String> conditionMap) {
        Result result = new Result();
        try{
            List<Activity> activityList = activityMapper.findActivity(conditionMap);
            if (activityList.size() >= 0){
                //根据条件查询活动信息成功
                result.setStatus(ResultCode.FIND_ACTIVITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_ACTIVITY_SUCCESS.getMessage());
                result.setData(activityList);
                return result;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_ACTIVITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_ACTIVITY_EXCEPTION.getMessage());
            return result;
        }
    }
}
