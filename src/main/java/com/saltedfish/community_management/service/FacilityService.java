package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Facility;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface FacilityService {

    /**
     * 添加设施信息
     * @param facility
     * @return
     */
    Result addFacility(Facility facility) throws Exception;

    /**
     * 更新设施信息
     * @param facility
     * @return
     */
    Result updateFacility(Facility facility) throws Exception;

    /**
     * 删除设施信息
     * @param id
     * @return
     */
    Result deleteFacility(Integer id) throws Exception;

    /**
     * 查询指定id的设施信息
     * @param id
     * @return
     */
    Result findFacilityById(Integer id) throws Exception;

    /**
     * 根据条件查询设施信息，需要分页
     * @param conditionMap
     * @return
     */
    Result findFacilityPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询设施信息，不需要分页
     * @param conditionMap
     * @return
     */
    Result findFacility(Map<String,String> conditionMap) throws Exception;

}
