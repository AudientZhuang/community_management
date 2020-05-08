package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Repair;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface RepairService {

    /**
     * 添加住户申报维修信息
     * @param repair
     * @return
     */
    public Result addRepair(Repair repair);

    /**
     * 更新住户申报维修信息
     * @param repair
     * @return
     */
    public Result updateRepair(Repair repair);

    /**
     * 删除住户申报维维信息
     * @param id
     * @return
     */
    public Result deleteRepair(Integer id);

    /**
     * 查询指定id的住户申报维修信息
     * @param id
     * @return
     */
    public Result findRepairById(Integer id);

    /**
     * 根据条件查询住户申报维修信息
     * @param conditionMap
     * @return
     */
    public Result findRepair(Map<String,String> conditionMap);



}
