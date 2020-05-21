package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.FireSecurity;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface FireSecurityService {

    /**
     * 添加消防检查情况
     * @param fireSecurity
     * @return
     */
    Result addFireSecurity(FireSecurity fireSecurity) throws Exception;

    /**
     * 更新消防检查情况
     * @param fireSecurity
     * @return
     */
    Result updateFireSecurity(FireSecurity fireSecurity) throws Exception;

    /**
     * 删除消防检查情况
     * @param id
     * @return
     */
    Result deleteFireSecurity(Integer id) throws Exception;

    /**
     * 查询指定id的消防检查情况
     * @param id
     * @return
     */
    Result findFireSecurityById(Integer id);

    /**
     * 根据条件查询消防检查情况，需要分页
     * @param conditionMap
     * @return
     */
    Result findFireSecurityPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询消防检查情况，不需要分页
     * @param conditionMap
     * @return
     */
    Result findFireSecurity(Map<String,String> conditionMap) throws Exception;
}
