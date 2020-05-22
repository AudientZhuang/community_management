package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Charge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 缴费项目
 */
@Mapper
public interface ChargeMapper {

    /**
     * 添加缴费项目
     * @param charge
     * @return
     */
    public Integer insertCharge(Charge charge);

    /**
     * 更新缴费项目
     * @param charge
     * @return
     */
    public Integer updateCharge(Charge charge);

    /**
     * 删除缴费项目
     * @param id
     * @return
     */
    public Integer deleteCharge(@Param("id") Integer id);

    /**
     * 查询指定id的缴费项目
     * @param id
     * @return
     */
    public Charge findChargeById(@Param("id") Integer id);

    /**
     * 根据条件查询缴费项目
     * @param conditionMap
     * @return
     */
    public List<Charge> findCharge(@Param("conditionMap") Map<String,String> conditionMap);

}
