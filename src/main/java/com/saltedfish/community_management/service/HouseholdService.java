package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface HouseholdService {
    /**
     * 添加住户信息
     * @param household
     * @return
     */
    public Result addHousehold(Household household);

    /**
     * 更新住户信息
     * @param household
     * @return
     */
    public Result updateHousehold(Household household);

    /**
     * 删除住户信息
     * @param id
     * @return
     */
    public Result deleteHousehold(Integer id);

    /**
     * 查询指定id的住户信息
     * @param id
     * @return
     */
    public Result findHouseholdById(Integer id);

    /**
     * 根据条件查询住户信息
     * @param conditionMap
     * @return
     */
    public Result findHousehold(Map<String,String> conditionMap);
}
