package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Activity;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 活动信息
 */
@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    /**
     * 添加活动信息
     * @param activity
     * @return
     */
    @PostMapping("/activity")
    public Result addActivity(Activity activity){
        try{
            //对前端信息进行校验

            //添加活动信息到数据库
            Result result = activityService.addActivity(activity);
            if(result.getStatus() != ResultCode.INSERT_ACTIVITY_EXCEPTION.getStatus()){
                //添加活动信息没有异常
                return result;
            }else{
                //添加活动信息出现异常
                throw new Exception(ResultCode.INSERT_ACTIVITY_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 更新活动信息
     * @param activity
     * @return
     */
    @PutMapping("/activity")
    public Result updateActivity(Activity activity){
        try{
            //对前端信息进行校验

            //更新活动信息到数据库
            Result result = activityService.updateActivity(activity);
            if (result.getStatus() != ResultCode.UPDATE_ACTIVITY_EXCEPTION.getStatus()){
                //更新活动信息没有异常
                return result;
            }else {
                //更新活动信息出现异常
                throw new Exception(ResultCode.UPDATE_ACTIVITY_EXCEPTION.getMessage());
            }

        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 删除活动信息
     * @param id
     * @return
     */
    @DeleteMapping("/activity/{id}")
    public Result deleteActivity(@PathVariable("id") Integer id){
        try{
            //在数据库中删除活动信息
            Result result = activityService.deleteActivity(id);
            if (result.getStatus() != ResultCode.DELETE_ACTIVITY_EXCEPTION.getStatus()){
                //删除活动信息没有异常
                return result;
            }else {
                //删除活动信息出现异常
                throw new Exception(ResultCode.DELETE_ACTIVITY_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 查询指定id的活动信息
     * @param id
     * @return
     */
    @GetMapping("/activity/{id}")
    public Result findActivityById(@PathVariable("id") Integer id){
        try{
            Result result = activityService.findActivityById(id);
            if (result.getStatus() != ResultCode.FIND_ACTIVITY_BY_ID_EXCEPTION.getStatus()){
                //查询指定id的活动信息没有异常
                return result;
            }else {
                //查询指定id的活动信息出现异常
                throw new Exception(ResultCode.FIND_ACTIVITY_BY_ID_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 根据条件查询活动信息
     * @return
     */
    @GetMapping("/activity")
    public Result findActivity(HttpServletRequest request){
        try{
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String,String> conditionMap = new HashMap<>();
            if (parameterMap.size() >= 0){
                //参数为空也可以正常运行
                for (String key: parameterMap.keySet()) {
                    conditionMap.put(key,parameterMap.get(key)[0]);
                }
                Result result = activityService.findActivity(conditionMap);
                if(result.getStatus() != ResultCode.FIND_ACTIVITY_EXCEPTION.getStatus()){
                    //根据条件查询活动信息没有异常
                    return result;
                }else {
                    throw new Exception(ResultCode.FIND_ACTIVITY_EXCEPTION.getMessage());
                }
            }else{
                //获取不到参数
                throw new Exception();
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

}
