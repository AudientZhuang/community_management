package com.saltedfish.community_management.service;


import com.saltedfish.community_management.bean.Activity;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface ActivityService {
    /**
     * 添加活动信息
     * @param activity
     * @return
     */
    public Result addActivity(Activity activity);

    /**
     * 更新活动信息
     * @param activity
     * @return
     */
    public Result updateActivity(Activity activity);

    /**
     * 删除活动信息
     * @param id
     * @return
     */
    public Result deleteActivity(Integer id);

    /**
     * 查询指定id的活动信息
     * @param id
     * @return
     */
    public Result findActivityById(Integer id);

    /**
     * 根据条件查询活动信息
     * @param conditionMap
     * @return
     */
    public Result findActivity(Map<String,String> conditionMap);

}
