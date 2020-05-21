package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Charge;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface ChargeService {

    /**
     * 添加缴费项目
     * @param charge
     * @return
     */
    Result addCharge(Charge charge) throws Exception;

    /**
     * 更新缴费项目
     * @param charge
     * @return
     */
    Result updateCharge(Charge charge) throws Exception;

    /**
     * 删除缴费项目
     * @param id
     * @return
     */
    Result deleteCharge(Integer id) throws Exception;

    /**
     * 查询指定id的缴费项目
     * @param id
     * @return
     */
    Result findChargeById(Integer id) throws Exception;

    /**
     * 根据条件查询缴费项目，需要分页
     * @param conditionMap
     * @return
     */
    Result findChargePage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询缴费项目，不需要分页
     * @param conditionMap
     * @return
     */
    Result findCharge(Map<String,String> conditionMap) throws Exception;
}
