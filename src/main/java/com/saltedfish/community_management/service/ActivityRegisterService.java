package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.ActivityRegister;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface ActivityRegisterService {

    /**
     * 添加活动报名信息
     * @param activityRegister
     * @return
     */
    Result addActivityRegister(ActivityRegister activityRegister) throws Exception;

    /**
     * 更新活动报名信息
     * @param activityRegister
     * @return
     */
    Result updateActivityRegister(ActivityRegister activityRegister) throws Exception;

    /**
     * 删除活动报名信息
     * @param id
     * @return
     */
    Result deleteActivityRegister(Integer id) throws Exception;

    /**
     * 查询指定id的活动报名信息
     * @param id
     * @return
     */
    Result findActivityRegisterById(Integer id) throws Exception;

    /**
     * 根据条件查询活动报名信息,需要分页
     * @param conditionMap
     * @return
     */
    Result findActivityRegisterPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;


    /**
     * 根据条件查询活动报名信息,不需要分页
     * @param conditionMap
     * @return
     */
    Result findActivityRegister(Map<String,String> conditionMap) throws Exception;


}
