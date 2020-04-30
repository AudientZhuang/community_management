package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Household;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseholdMapper {
    /**
     * 添加住户信息
     * @param household
     * @return
     * @throws Exception
     */
    public Integer insertHousehold(Household household) throws Exception;
}
