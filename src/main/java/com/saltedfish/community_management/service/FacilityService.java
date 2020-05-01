package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Facility;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface FacilityService {

    /**
     * 添加设施信息
     * @param facility
     * @return
     */
    public Result addFacility(Facility facility);

    /**
     * 更新设施信息
     * @param facility
     * @return
     */
    public Result updateFacility(Facility facility);

    /**
     * 删除设施信息
     * @param id
     * @return
     */
    public Result deleteFacility(Integer id);

    /**
     * 查询指定id的设施信息
     * @param id
     * @return
     */
    public Result findFacilityById(Integer id);

    /**
     * 根据条件查询设施信息
     * @param conditionMap
     * @return
     */
    public Result findFacility(Map<String,String> conditionMap);

}
