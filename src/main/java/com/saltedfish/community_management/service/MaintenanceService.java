package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Maintenance;
import com.saltedfish.community_management.common.Result;

import java.util.Map;


public interface MaintenanceService {

    /**
     * 添加维护信息
     * @param maintenance
     * @return
     */
    public Result addMaintenance(Maintenance maintenance);

    /**
     * 更新维护信息
     * @param maintenance
     * @return
     */
    public Result updateMaintenance(Maintenance maintenance);

    /**
     * 删除维护信息
     * @param id
     * @return
     */
    public Result deleteMaintenance(Integer id);

    /**
     * 查询指定id的维护信息
     * @param id
     * @return
     */
    public Result findMaintenanceById(Integer id);

    /**
     * 根据条件查询维护信息
     * @return
     */
    public Result findMaintenance(Map<String,String> conditionMap);
}
