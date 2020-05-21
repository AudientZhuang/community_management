package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Building;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 楼栋信息
 */
@Mapper
public interface BuildingMapper {

    /**
     * 添加楼栋信息
     * @param building
     * @return
     */
    public Integer insertBuilding(Building building);

    /**
     * 更新楼栋信息
     * @param building
     * @return
     */
    public Integer updateBuilding(Building building);

    /**
     * 删除楼栋信息
     * @param id
     * @return
     */
    public Integer deleteBuilding(@Param("id") Integer id);

    /**
     * 查询指定id的楼栋信息
     * @param id
     * @return
     */
    public Building findBuildingById(@Param("id") Integer id);

    /**
     * 根据条件查询楼栋信息
     * @param conditionMap
     * @return
     */
    public List<Building> findBuilding(@Param("conditionMap") Map<String,String> conditionMap);
}
