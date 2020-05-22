package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.FacilityCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 设施分类
 */
@Mapper
public interface FacilityCategoryMapper {

    /**
     * 添加设施分类
     * @param facilityCategory
     * @return
     */
    public Integer insertFacilityCategory(FacilityCategory facilityCategory);

    /**
     * 更新设施分类
     * @param facilityCategory
     * @return
     */
    public Integer updateFacilityCategory(FacilityCategory facilityCategory);

    /**
     * 删除设施分类
     * @param id
     * @return
     */
    public Integer deleteFacilityCategory(@Param("id") Integer id);

    /**
     * 查询指定id的设施分类
     * @param id
     * @return
     */
    public FacilityCategory findFacilityCategoryById(@Param("id") Integer id);

    /**
     * 根据条件查询设施分类
     * @param conditionMap
     * @return
     */
    public List<FacilityCategory> findFacilityCategory(@Param("conditionMap") Map<String,String> conditionMap);

}

