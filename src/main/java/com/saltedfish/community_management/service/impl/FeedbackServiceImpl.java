package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.Feedback;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.FeedbackMapper;
import com.saltedfish.community_management.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public Result addFeedback(Feedback feedback) {
        Result result = new Result();
        try {
            Integer effort = feedbackMapper.insertFeedback(feedback);
            if (effort != 0){
                //添加反馈信息成功
                result.setStatus(ResultCode.INSERT_FEEDBACK_SUCCESS.getStatus());
                result.setMessage(ResultCode.INSERT_FEEDBACK_SUCCESS.getMessage());
            }else{
                //添加反馈信息失败
                result.setStatus(ResultCode.INSERT_FEEDBACK_FAILED.getStatus());
                result.setMessage(ResultCode.INSERT_FEEDBACK_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.INSERT_FEEDBACK_EXCEPTION.getStatus());
            result.setMessage(ResultCode.INSERT_FEEDBACK_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result updateFeedback(Feedback feedback) {
        Result result = new Result();
        try {
            Integer effort = feedbackMapper.updateFeedback(feedback);
            if (effort != 0){
                //更新反馈信息成功
                result.setStatus(ResultCode.UPDATE_FEEDBACK_SUCCESS.getStatus());
                result.setMessage(ResultCode.UPDATE_FEEDBACK_SUCCESS.getMessage());
            }else{
                //更新反馈信息失败
                result.setStatus(ResultCode.UPDATE_FEEDBACK_FAILED.getStatus());
                result.setMessage(ResultCode.UPDATE_FEEDBACK_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.UPDATE_FEEDBACK_EXCEPTION.getStatus());
            result.setMessage(ResultCode.UPDATE_FEEDBACK_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result deleteFeedback(Integer id) {
        Result result = new Result();
        try {
            Integer effort = feedbackMapper.deleteFeedback(id);
            if (effort != 0){
                //删除反馈信息成功
                result.setStatus(ResultCode.DELETE_FEEDBACK_SUCCESS.getStatus());
                result.setMessage(ResultCode.DELETE_FEEDBACK_SUCCESS.getMessage());
            }else{
                //删除反馈信息失败
                result.setStatus(ResultCode.DELETE_FEEDBACK_FAILED.getStatus());
                result.setMessage(ResultCode.DELETE_FEEDBACK_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.DELETE_FEEDBACK_EXCEPTION.getStatus());
            result.setMessage(ResultCode.DELETE_FEEDBACK_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findFeedbackById(Integer id) {
        Result result = new Result();
        try {
            Feedback feedback = feedbackMapper.findFeedbackById(id);
            if (feedback != null){
                //查询指定id的反馈信息成功
                result.setStatus(ResultCode.FIND_FEEDBACK_BY_ID_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_FEEDBACK_BY_ID_SUCCESS.getMessage());
                result.setData(feedback);
            }else{
                //查询指定id的反馈信息失败
                result.setStatus(ResultCode.FIND_FEEDBACK_BY_ID_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_FEEDBACK_BY_ID_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_FEEDBACK_BY_ID_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_FEEDBACK_BY_ID_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findFeedback(Map<String, String> conditionMap) {
        Result result = new Result();
        try {
            List<Feedback> feedbackList = feedbackMapper.findFeedback(conditionMap);
            if (feedbackList != null){
                //根据条件查询反馈信息成功
                result.setStatus(ResultCode.FIND_FEEDBACK_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_FEEDBACK_SUCCESS.getMessage());
                result.setData(feedbackList);
            }else{
                //根据条件查询反馈信息失败
                result.setStatus(ResultCode.FIND_FEEDBACK_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_FEEDBACK_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_FEEDBACK_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_FEEDBACK_EXCEPTION.getMessage());
            return result;
        }
    }
}
