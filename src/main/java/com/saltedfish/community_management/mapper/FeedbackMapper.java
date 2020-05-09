package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 反馈信息
 */
@Mapper
public interface FeedbackMapper {

    /**
     * 添加反馈信息
     * @param feedback
     * @return
     */
    public Integer insertFeedback(Feedback feedback);

    /**
     * 修改反馈信息
     * @param feedback
     * @return
     */
    public Integer updateFeedback(Feedback feedback);

    /**
     * 删除反馈信息
     * @param id
     * @return
     */
    public Integer deleteFeedback(@Param("id") Integer id);

    /**
     * 查询指定id的反馈信息
     * @param id
     * @return
     */
    public Feedback findFeedbackById(@Param("id") Integer id);

    /**
     * 根据条件查询反馈信息
     * @param conditionMap
     * @return
     */
    public List<Feedback> findFeedback(@Param("conditionMap") Map<String,String> conditionMap);

}
