package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Repair;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface RepairService {

    /**
     * 添加住户申报维修信息
     * @param repair
     * @return
     */
    Result addRepair(Repair repair) throws Exception;

    /**
     * 更新住户申报维修信息
     * @param repair
     * @return
     */
    Result updateRepair(Repair repair) throws Exception;

    /**
     * 删除住户申报维维信息
     * @param id
     * @return
     */
    Result deleteRepair(Integer id) throws Exception;

    /**
     * 查询指定id的住户申报维修信息
     * @param id
     * @return
     */
    Result findRepairById(Integer id) throws Exception;

    /**
     * 根据条件查询住户申报维修信息，需要分页
     * @param conditionMap
     * @return
     */
    Result findRepairPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询住户申报维修信息，不需要分页
     * @param conditionMap
     * @return
     */
    Result findRepair(Map<String,String> conditionMap) throws Exception;



}
