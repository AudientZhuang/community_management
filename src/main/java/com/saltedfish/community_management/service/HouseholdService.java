package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.Result;

public interface HouseholdService {
    /**
     * 添加住户信息
     * @param household
     * @return
     */
    public Result addHousehold(Household household);

}
