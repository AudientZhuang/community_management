package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Maintenance;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;


public interface MaintenanceService {

    /**
     * 添加维护信息
     * @param maintenance
     * @return
     */
    Result addMaintenance(Maintenance maintenance) throws Exception;

    /**
     * 更新维护信息
     * @param maintenance
     * @return
     */
    Result updateMaintenance(Maintenance maintenance) throws Exception;

    /**
     * 删除维护信息
     * @param id
     * @return
     */
    Result deleteMaintenance(Integer id) throws Exception;

    /**
     * 查询指定id的维护信息
     * @param id
     * @return
     */
    Result findMaintenanceById(Integer id);

    /**
     * 根据条件查询维护信息，需要分页
     * @param conditionMap
     * @return
     */
    Result findMaintenancePage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询维护信息，不需要分页
     * @return
     */
    Result findMaintenance(Map<String,String> conditionMap) throws Exception;
}
