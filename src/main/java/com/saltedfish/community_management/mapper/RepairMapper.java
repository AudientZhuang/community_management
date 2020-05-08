package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 住户申报维修信息
 */
@Mapper
public interface RepairMapper {

    /**
     * 添加住户申报维修信息
     * @param repair
     * @return
     */
    public Integer insertRepair(Repair repair);

    /**
     * 更新住户申报维修信息
     * @param repair
     * @return
     */
    public Integer updateRepair(Repair repair);

    /**
     * 删除住户申报维修信息
     * @param id
     * @return
     */
    public Integer deleteRepair(@Param("id") Integer id);

    /**
     * 查询指定id的住户申报维修信息
     * @param id
     * @return
     */
    public Repair findRepairById(@Param("id") Integer id);

    /**
     * 根据条件查询住户申报维修信息
     * @param conditionMap
     * @return
     */
    public List<Repair> findRepair(@Param("conditionMap") Map<String,String> conditionMap);


}
