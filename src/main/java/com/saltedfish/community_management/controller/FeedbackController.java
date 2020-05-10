package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Feedback;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    /**
     * 添加反馈信息
     * @param feedback
     * @return
     */
    @PostMapping("/feedback")
    public Result addFeedback(Feedback feedback){
        try {
            //对前端信息进行校验

            //添加反馈信息到数据库
            Result result = feedbackService.addFeedback(feedback);
            if (result.getStatus() != ResultCode.INSERT_FEEDBACK_EXCEPTION.getStatus()){
                //添加反馈信息没有异常
                return result;
            }else{
                //添加反馈信息出现异常
                throw new Exception(ResultCode.INSERT_FEEDBACK_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 更新反馈信息
     * @param feedback
     * @return
     */
    @PutMapping("/feedback")
    public Result updateFeedback(Feedback feedback){
        try {
            //对前端信息进行校验

            //更新反馈信息到数据库
            Result result = feedbackService.updateFeedback(feedback);
            if (result.getStatus() != ResultCode.UPDATE_FEEDBACK_EXCEPTION.getStatus()){
                //更新反馈信息没有异常
                return result;
            }else{
                //更新反馈信息出现异常
                throw new Exception(ResultCode.UPDATE_FEEDBACK_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 删除反馈信息
     * @param id
     * @return
     */
    @DeleteMapping("/feedback/{id}")
    public Result deleteFeedback(@PathVariable("id") Integer id){
        try{
            Result result = feedbackService.deleteFeedback(id);
            if (result.getStatus() != ResultCode.DELETE_FEEDBACK_EXCEPTION.getStatus()){
                //删除反馈信息没有异常
                return result;
            }else{
                //删除反馈信息出现异常
                throw new Exception(ResultCode.DELETE_FEEDBACK_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 查询指定id的反馈信息
     * @param id
     * @return
     */
    @GetMapping("/feedback/{id}")
    public Result findFeedbackById(@PathVariable("id") Integer id){
        try {
            Result result = feedbackService.findFeedbackById(id);
            if (result.getStatus() != ResultCode.FIND_FEEDBACK_BY_ID_EXCEPTION.getStatus()){
                //查询指定id的反馈信息没有异常
                return result;
            }else{
                //查询指定id的反馈信息出现异常
                throw new Exception(ResultCode.FIND_FEEDBACK_BY_ID_EXCEPTION.getMessage());
            }

        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 根据条件查询反馈信息
     * @param request
     * @return
     */
    @GetMapping("/feedback")
    public Result findFeedback(HttpServletRequest request){
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String,String> conditionMap = new HashMap<>();
            if (parameterMap.size() >= 0){
                //参数为空时也可以正常运行
                for (String key: parameterMap.keySet()) {
                    conditionMap.put(key,parameterMap.get(key)[0]);
                }
                Result result = feedbackService.findFeedback(conditionMap);
                if (result.getStatus() != ResultCode.FIND_FEEDBACK_EXCEPTION.getStatus()){
                    //根据条件查询反馈信息没有异常
                    return result;
                }else{
                    //根据条件查询反馈信息出现异常
                    throw new Exception(ResultCode.FIND_FEEDBACK_EXCEPTION.getMessage());
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
