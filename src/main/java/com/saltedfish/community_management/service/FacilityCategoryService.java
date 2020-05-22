package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.FacilityCategory;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface FacilityCategoryService {

    /**
     * 添加设施分类
     * @param facilityCategory
     * @return
     */
    Result addFacilityCategory(FacilityCategory facilityCategory) throws Exception;

    /**
     * 更新设施分类
     * @param facilityCategory
     * @return
     */
    Result updateFacilityCategory(FacilityCategory facilityCategory) throws Exception;

    /**
     * 删除设施分类
     * @param id
     * @return
     */
    Result deleteFacilityCategory(Integer id) throws Exception;

    /**
     * 查询指定id的设施分类
     * @param id
     * @return
     */
    Result findFacilityCategoryById(Integer id) throws Exception;

    /**
     * 根据条件查询设施分类，需要分页
     * @param conditionMap
     * @return
     */
    Result findFacilityCategoryPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询设施分类，不需要分页
     * @param conditionMap
     * @return
     */
    Result findFacilityCategory(Map<String,String> conditionMap) throws Exception;
}
