package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Maintenance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MaintenanceMapper {

    /**
     * 添加维护信息
     * @param maintenance
     * @return
     */
    public Integer insertMaintenance(Maintenance maintenance);

    /**
     * 更新维护信息
     * @param maintenance
     * @return
     */
    public Integer updateMaintenance(Maintenance maintenance);

    /**
     * 删除维护信息
     * @param id
     * @return
     */
    public Integer deleteMaintenance(@Param("id") Integer id);

    /**
     * 查询指定id的维护信息
     * @param id
     * @return
     */
    public Maintenance findMaintenanceById(@Param("id") Integer id);

    /**
     * 根据条件查询维护信息
     * @param conditionMap
     * @return
     */
    public List<Maintenance> findMaintenance(@Param("conditionMap") Map<String,String> conditionMap);
}
