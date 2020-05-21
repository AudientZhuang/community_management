package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Facility;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FacilityMapper {
    /**
     * 添加设施信息
     * @param facility
     * @return
     */
    public Integer insertFacility(Facility facility);

    /**
     * 更新设施信息
     * @param facility
     * @return
     */
    public Integer updateFacility(Facility facility);

    /**
     * 删除设施信息
     * @param id
     * @return
     */
    public Integer deleteFacility(@Param("id") Integer id);

    /**
     * 查询指定id的设施信息
     * @param id
     * @return
     */
    public Facility findFacilityById(@Param("id") Integer id);

    /**
     * 根据条件查询设施信息
     * @param conditionMap
     * @return
     */
    public List<Facility> findFacility(@Param("conditionMap") Map<String,String> conditionMap);


}
