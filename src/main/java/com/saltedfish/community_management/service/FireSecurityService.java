package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.FireSecurity;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface FireSecurityService {

    /**
     * 添加消防检查情况
     * @param fireSecurity
     * @return
     */
    public Result addFireSecurity(FireSecurity fireSecurity);

    /**
     * 更新消防检查情况
     * @param fireSecurity
     * @return
     */
    public Result updateFireSecurity(FireSecurity fireSecurity);

    /**
     * 删除消防检查情况
     * @param id
     * @return
     */
    public Result deleteFireSecurity(Integer id);

    /**
     * 查询指定id的消防检查情况
     * @param id
     * @return
     */
    public Result findFireSecurityById(Integer id);

    /**
     * 根据条件查询消防检查情况
     * @param conditionMap
     * @return
     */
    public Result findFireSecurity(Map<String,String> conditionMap);
}
