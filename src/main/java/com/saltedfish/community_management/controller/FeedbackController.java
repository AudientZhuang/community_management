package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Feedback;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.FeedbackService;
import com.saltedfish.community_management.util.PageUtil;
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
    public Result addFeedback(Feedback feedback) throws Exception {
        //对前端信息进行校验

        //添加反馈信息到数据库
        return feedbackService.addFeedback(feedback);
    }

    /**
     * 更新反馈信息
     * @param feedback
     * @return
     */
    @PutMapping("/feedback")
    public Result updateFeedback(Feedback feedback) throws Exception {
        //对前端信息进行校验

        //更新反馈信息到数据库
        return feedbackService.updateFeedback(feedback);
    }

    /**
     * 删除反馈信息
     * @param id
     * @return
     */
    @DeleteMapping("/feedback/{id}")
    public Result deleteFeedback(@PathVariable("id") Integer id) throws Exception {
        return feedbackService.deleteFeedback(id);
    }

    /**
     * 查询指定id的反馈信息
     * @param id
     * @return
     */
    @GetMapping("/feedback/{id}")
    public Result findFeedbackById(@PathVariable("id") Integer id){
        return feedbackService.findFeedbackById(id);
    }

    /**
     * 根据条件查询反馈信息
     * @param request
     * @return
     */
    @GetMapping("/feedback")
    public Result findFeedback(HttpServletRequest request) throws Exception {
        // 分页请求封装类
        PageRequest pageRequest = new PageRequest();
        // 设置一个分页变量，判断是否需要分页，默认为不需要分页
        Boolean isPage = false;
        Result result = new Result();
        // 获取前端请求的条件参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 条件参数Map
        Map<String,String> conditionMap = new HashMap<>();
        if (parameterMap == null) {
            // 无法获取参数，连接出现异常
            throw new Exception();
        }
        //参数为空也可以正常运行
        for (String key: parameterMap.keySet()) {
            //请求参数中含有分页参数pageNum或pageSize
            if ("pageNum".equals(key) || "pageSize".equals(key)){
                // 将分页变量设置为true
                isPage = true;
                // 将分页参数设置给pageRequest
                pageRequest = PageUtil.addPageRequestParam(key,parameterMap.get(key)[0],pageRequest);
                // 跳过，不将分页请求参数添加到条件参数Map中
                continue;
            }
            //条件请求参数，添加到条件Map中
            conditionMap.put(key,parameterMap.get(key)[0]);
        }
        // 根据是否需要分页调用不同的服务方法
        if (isPage == true){
            // 需要分页
            result = feedbackService.findFeedbackPage(pageRequest,conditionMap);
        }else{
            // 不需要分页
            result = feedbackService.findFeedback(conditionMap);
        }
        // 返回结果
        return result;
    }


}
