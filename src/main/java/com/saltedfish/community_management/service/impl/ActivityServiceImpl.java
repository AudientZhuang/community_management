package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Activity;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.ActivityMapper;
import com.saltedfish.community_management.service.ActivityService;
import com.saltedfish.community_management.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Result addActivity(Activity activity) throws Exception {
        Integer effort = activityMapper.insertActivity(activity);
        if (effort != 0){
            //添加活动信息成功
            return new Result(HttpStatus.OK.value(),"添加活动信息成功",null);
        }else{
            //添加活动信息失败
            throw new Exception("添加活动信息失败");
        }
    }

    @Override
    public Result updateActivity(Activity activity) throws Exception {
        Integer effort = activityMapper.updateActivity(activity);
        if(effort != 0){
            //更新活动信息成功
            return new Result(HttpStatus.OK.value(),"更新活动信息成功",null);
        }else{
            //更新活动信息失败
            throw new Exception("更新活动信息失败");
        }
    }

    @Override
    public Result deleteActivity(Integer id) throws Exception {
        Result result = new Result();
        Integer effort = activityMapper.deleteActivity(id);
        if(effort != 0){
            //删除活动信息成功
            return new Result(HttpStatus.OK.value(),"删除活动信息成功",null);
        }else {
            //删除活动信息失败
            throw new Exception("删除活动信息失败");
        }
    }

    @Override
    public Result findActivityById(Integer id) throws Exception {
        Activity activity = activityMapper.findActivityById(id);
        if(activity != null){
            //查询指定id的活动信息成功
            return new Result(HttpStatus.OK.value(),"查询指定id的活动信息成功",activity);
        }else {
            //没有找到指定id的活动信息
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到活动信息",null);
        }
    }

    @Override
    public Result findActivityPage(PageRequest pageRequest,Map<String, String> conditionMap) throws Exception {
        //分页
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Activity> activityList = activityMapper.findActivity(conditionMap);
        if (activityList != null){
            //根据条件查询活动信息成功
            PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(activityList));
            return new Result(HttpStatus.OK.value(),"根据条件查询活动信息成功",pageResult);
        }else {
            //根据条件查询活动信息失败
            throw new Exception("根据条件查询活动信息失败");
        }
    }

    @Override
    public Result findActivity(Map<String, String> conditionMap) throws Exception {
        List<Activity> activityList = activityMapper.findActivity(conditionMap);
        if (activityList != null){
            //根据条件查询活动信息成功
            return new Result(HttpStatus.OK.value(),"根据条件查询活动信息成功",activityList);
        }else {
            //根据条件查询活动信息失败
            throw new Exception("根据条件查询活动信息失败");
        }
    }

    @Override
    public Result findMyUnderwayActivity(Integer hh_id, Date currentTime) {
        List<Activity> activityList = activityMapper.findMyUnderwayActivity(hh_id, currentTime);
        return new Result(HttpStatus.OK.value(),"获取我的正在进行活动成功",activityList);
    }

    @Override
    public Result findMyOverdueActivity(Integer hh_id, Date currentTime) {
        List<Activity> activityList = activityMapper.findMyOverdueActivity(hh_id, currentTime);
        return new Result(HttpStatus.OK.value(),"获取我的已过期活动成功",activityList);
    }
}
