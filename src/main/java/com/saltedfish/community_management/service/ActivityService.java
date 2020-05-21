package com.saltedfish.community_management.service;


import com.saltedfish.community_management.bean.Activity;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface ActivityService {
    /**
     * 添加活动信息
     * @param activity
     * @return
     */
    Result addActivity(Activity activity) throws Exception;

    /**
     * 更新活动信息
     * @param activity
     * @return
     */
    Result updateActivity(Activity activity) throws Exception;

    /**
     * 删除活动信息
     * @param id
     * @return
     */
    Result deleteActivity(Integer id) throws Exception;

    /**
     * 查询指定id的活动信息
     * @param id
     * @return
     */
    Result findActivityById(Integer id) throws Exception;

    /**
     * 根据条件查询活动信息，需要分页
     * @param conditionMap
     * @return
     */
    Result findActivityPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询活动信息,不需要分页
     * @param conditionMap
     * @return
     */
    Result findActivity(Map<String,String> conditionMap) throws Exception;

}
