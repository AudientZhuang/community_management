package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Household;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HouseholdMapper {
    /**
     * 添加住户信息
     * @param household
     * @return
     */
    public Integer insertHousehold(Household household);

    /**
     * 更新住户信息
     * @param household
     * @return
     */
    public Integer updateHousehold(Household household);

    /**
     * 删除住户信息
     * @param id
     * @return
     */
    public Integer deleteHousehold(@Param("id") Integer id);

    /**
     * 查询指定id的住户信息
     * @param id
     * @return
     */
    public Household findHouseholdById(@Param("id") Integer id);

    /**
     * 根据查询条件查询住户信息
     * @param conditionMap
     * @return
     */
    public List<Household> findHousehold(@Param("conditionMap") Map<String,String> conditionMap);

}
