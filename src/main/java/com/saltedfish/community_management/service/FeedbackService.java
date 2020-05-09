package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Feedback;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface FeedbackService {

    /**
     * 添加反馈信息
     * @param feedback
     * @return
     */
    public Result addFeedback(Feedback feedback);

    /**
     * 更新反馈信息
     * @param feedback
     * @return
     */
    public Result updateFeedback(Feedback feedback);

    /**
     * 删除反馈信息
     * @param id
     * @return
     */
    public Result deleteFeedback(Integer id);

    /**
     * 查询指定id的反馈信息
     * @param id
     * @return
     */
    public Result findFeedbackById(Integer id);

    /**
     * 根据条件查询反馈信息
     * @param conditionMap
     * @return
     */
    public Result findFeedback(Map<String,String> conditionMap);

}
