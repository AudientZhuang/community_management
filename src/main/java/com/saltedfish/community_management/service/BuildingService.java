package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Building;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface BuildingService {

    /**
     * 添加楼栋信息
     * @param building
     * @return
     */
    Result addBuilding(Building building) throws Exception;

    /**
     * 更新楼栋信息
     * @param building
     * @return
     */
    Result updateBuilding(Building building) throws Exception;

    /**
     * 删除楼栋信息
     * @param id
     * @return
     */
    Result deleteBuilding(Integer id) throws Exception;

    /**
     * 查询指定id的楼栋信息
     * @param id
     * @return
     */
    Result findBuildingById(Integer id) throws Exception;

    /**
     * 根据条件查询楼栋信息，需要分页
     * @param conditionMap
     * @return
     */
    Result findBuildingPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询楼栋信息，不需要分页
     * @param conditionMap
     * @return
     */
    Result findBuilding(Map<String,String> conditionMap) throws Exception;
}
