package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.vo.HouseholdVO;

import java.util.Map;

public interface HouseholdService {
    /**
     * 添加住户信息
     * @param householdVO
     * @return
     */
    Result addHousehold(HouseholdVO householdVO) throws Exception;

    /**
     * 更新住户信息
     * @param household
     * @return
     */
    Result updateHousehold(Household household) throws Exception;

    /**
     * 删除住户信息
     * @param id
     * @return
     */
    Result deleteHousehold(Integer id) throws Exception;

    /**
     * 查询指定id的住户信息
     * @param id
     * @return
     */
    Result findHouseholdById(Integer id);

    /**
     * 根据条件查询住户信息，需要分页
     * @param conditionMap
     * @return
     */
    Result findHouseholdPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询住户信息，不需要分页
     * @param conditionMap
     * @return
     */
    Result findHousehold(Map<String,String> conditionMap) throws Exception;
}
