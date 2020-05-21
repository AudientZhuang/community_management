package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Feedback;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface FeedbackService {

    /**
     * 添加反馈信息
     * @param feedback
     * @return
     */
    Result addFeedback(Feedback feedback) throws Exception;

    /**
     * 更新反馈信息
     * @param feedback
     * @return
     */
    Result updateFeedback(Feedback feedback) throws Exception;

    /**
     * 删除反馈信息
     * @param id
     * @return
     */
    Result deleteFeedback(Integer id) throws Exception;

    /**
     * 查询指定id的反馈信息
     * @param id
     * @return
     */
    Result findFeedbackById(Integer id);

    /**
     * 根据条件查询反馈信息，需要分页
     * @param conditionMap
     * @return
     */
    Result findFeedbackPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询反馈信息，不需要分页
     * @param conditionMap
     * @return
     */
    Result findFeedback(Map<String,String> conditionMap) throws Exception;

}
