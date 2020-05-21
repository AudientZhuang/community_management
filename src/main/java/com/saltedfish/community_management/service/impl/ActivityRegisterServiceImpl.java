package com.saltedfish.community_management.service.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Activity;
import com.saltedfish.community_management.bean.ActivityRegister;
import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.mapper.ActivityMapper;
import com.saltedfish.community_management.mapper.ActivityRegisterMapper;
import com.saltedfish.community_management.mapper.HouseholdMapper;
import com.saltedfish.community_management.service.ActivityRegisterService;
import com.saltedfish.community_management.util.PageUtil;
import com.saltedfish.community_management.util.VOUtil;
import com.saltedfish.community_management.vo.ActivityRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ActivityRegisterServiceImpl implements ActivityRegisterService {

    @Autowired
    private ActivityRegisterMapper activityRegisterMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private HouseholdMapper householdMapper;

    @Override
    public Result addActivityRegister(ActivityRegister activityRegister) throws Exception {
        Integer effort = activityRegisterMapper.insertActivityRegister(activityRegister);
        if (effort != 0){
            //添加活动报名信息成功
            return new Result(HttpStatus.OK.value(),"添加活动报名信息成功",null);
        }else{
            //添加活动报名信息失败
            throw new Exception("添加活动报名信息失败");
        }
    }

    @Override
    public Result updateActivityRegister(ActivityRegister activityRegister) throws Exception {
        Integer effort = activityRegisterMapper.updateActivityRegister(activityRegister);
        if (effort != 0){
            //更新活动报名信息成功
            return new Result(HttpStatus.OK.value(),"更新活动报名信息成功",null);
        }else {
            //更新活动信息失败
            throw new Exception("更新活动信息失败");
        }
    }

    @Override
    public Result deleteActivityRegister(Integer id) throws Exception {
        Integer effort = activityRegisterMapper.deleteActivityRegister(id);
        if (effort != 0){
            //删除活动报名信息成功
            return new Result(HttpStatus.OK.value(),"删除活动报名信息成功",null);
        }else{
            //删除活动报名信息失败
            throw new Exception("删除活动报名信息失败");
        }
    }

    @Override
    public Result findActivityRegisterById(Integer id) throws Exception {
        ActivityRegister activityRegister = activityRegisterMapper.findActivityRegisterById(id);
        if (activityRegister != null){
            //查询指定id的活动报名信息成功
            return new Result(HttpStatus.OK.value(),"查询指定id的活动报名信息成功",activityRegister);
        }else{
            //查询指定id的活动报名信息失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到活动报名信息",null);
        }
    }

    @Override
    public Result findActivityRegisterPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ActivityRegister> activityRegisterList = activityRegisterMapper.findActivityRegister(conditionMap);
        if (activityRegisterList != null){
            //根据条件查询活动报名信息成功
            //封装返回结果，需要活动名称和住户名称
            List<ActivityRegisterVO> activityRegisterVOList = new ArrayList<>();
            for (ActivityRegister activityRegister : activityRegisterList) {
                //将活动报名信息进行完善
                //根据活动id获取活动信息
                Activity activity = activityMapper.findActivityById(activityRegister.getAct_id());
                //获取不到活动信息，跳过
                if (activity == null){
                    continue;
                }
                //根据住户id获取住户信息
                Household household = householdMapper.findHouseholdById(activityRegister.getHh_id());
                //获取不到住户信息，跳过
                if (household == null){
                    continue;
                }
                //对活动报名信息进行封装
                ActivityRegisterVO activityRegisterVO = VOUtil.toActivityRegisterVO(activityRegister);
                activityRegisterVO.setActName(activity.getTitle());
                activityRegisterVO.setHouseholdName(household.getName());
                activityRegisterVOList.add(activityRegisterVO);
            }
            PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(activityRegisterVOList));
            return new Result(HttpStatus.OK.value(),"根据条件查询活动报名信息成功",pageResult);
        }else{
            //根据条件查询活动报名信息失败
            throw new Exception("根据条件查询活动报名信息失败");
        }
    }

    @Override
    public Result findActivityRegister(Map<String, String> conditionMap) throws Exception {
        List<ActivityRegister> activityRegisterList = activityRegisterMapper.findActivityRegister(conditionMap);
        if (activityRegisterList != null){
            //根据条件查询活动报名信息成功

            //封装返回结果，需要活动名称和住户名称
            List<ActivityRegisterVO> activityRegisterVOList = new ArrayList<>();
            for (ActivityRegister activityRegister : activityRegisterList) {
                //将活动报名信息进行完善
                //根据活动id获取活动信息
                Activity activity = activityMapper.findActivityById(activityRegister.getAct_id());
                //获取不到活动信息，跳过
                if (activity == null){
                    continue;
                }
                //根据住户id获取住户信息
                Household household = householdMapper.findHouseholdById(activityRegister.getHh_id());
                //获取不到住户信息，跳过
                if (household == null){
                    continue;
                }
                //对活动报名信息进行封装
                ActivityRegisterVO activityRegisterVO = VOUtil.toActivityRegisterVO(activityRegister);
                activityRegisterVO.setActName(activity.getTitle());
                activityRegisterVO.setHouseholdName(household.getName());
                activityRegisterVOList.add(activityRegisterVO);
            }

            return new Result(HttpStatus.OK.value(),"根据条件查询活动报名信息成功",activityRegisterVOList);
        }else{
            //根据条件查询活动报名信息失败
            throw new Exception("根据条件查询活动报名信息失败");
        }
    }
}
