package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Feedback;
import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.FeedbackMapper;
import com.saltedfish.community_management.mapper.HouseholdMapper;
import com.saltedfish.community_management.service.FeedbackService;
import com.saltedfish.community_management.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private HouseholdMapper householdMapper;

    @Override
    public Result addFeedback(Feedback feedback) throws Exception {
        // 检查住户信息是否存在
        Household household = householdMapper.findHouseholdById(feedback.getHouseholdId());
        // 住户信息不存在
        if (household == null){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"住户信息不存在",null);
        }

        // 添加反馈信息
        Integer effort = feedbackMapper.insertFeedback(feedback);
        if (effort != 0){
            //添加反馈信息成功
            return new Result(HttpStatus.OK.value(),"添加反馈信息成功",null);
        }else{
            //添加反馈信息失败
            throw new Exception("添加反馈信息失败");
        }
    }

    @Override
    public Result updateFeedback(Feedback feedback) throws Exception {
        Integer effort = feedbackMapper.updateFeedback(feedback);
        if (effort != 0){
            //更新反馈信息成功
            return new Result(HttpStatus.OK.value(),"更新反馈信息成功",null);
        }else{
            //更新反馈信息失败
            throw new Exception("更新反馈信息失败");
        }
    }

    @Override
    public Result deleteFeedback(Integer id) throws Exception {
        Integer effort = feedbackMapper.deleteFeedback(id);
        if (effort != 0){
            //删除反馈信息成功
            return new Result(HttpStatus.OK.value(),"删除反馈信息成功",null);
        }else{
            //删除反馈信息失败
            throw new Exception("删除反馈信息失败");
        }
    }

    @Override
    public Result findFeedbackById(Integer id) {
        Feedback feedback = feedbackMapper.findFeedbackById(id);
        if (feedback != null){
            //查询指定id的反馈信息成功
            return new Result(HttpStatus.OK.value(),"查询指定id的反馈信息成功",feedback);
        }else{
            //查询指定id的反馈信息失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到反馈信息",null);
        }
    }

    @Override
    public Result findFeedbackPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Feedback> feedbackList = feedbackMapper.findFeedback(conditionMap);
        if (feedbackList != null){
            //根据条件查询反馈信息成功
            PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(feedbackList));
            return new Result(HttpStatus.OK.value(),"根据条件查询反馈信息成功",pageResult);
        }else{
            //根据条件查询反馈信息失败
            throw new Exception("根据条件查询反馈信息失败");
        }
    }

    @Override
    public Result findFeedback(Map<String, String> conditionMap) throws Exception {
        List<Feedback> feedbackList = feedbackMapper.findFeedback(conditionMap);
        if (feedbackList != null){
            //根据条件查询反馈信息成功
            return new Result(HttpStatus.OK.value(),"根据条件查询反馈信息成功",feedbackList);
        }else{
            //根据条件查询反馈信息失败
            throw new Exception("根据条件查询反馈信息失败");
        }
    }
}
