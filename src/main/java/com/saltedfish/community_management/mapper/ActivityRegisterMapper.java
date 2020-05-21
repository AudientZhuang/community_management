package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.ActivityRegister;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 活动报名信息
 */
@Mapper
public interface ActivityRegisterMapper {

    /**
     * 添加活动报名信息
     * @param activityRegister
     * @return
     */
    public Integer insertActivityRegister(ActivityRegister activityRegister);

    /**
     * 更新活动报名信息
     * @param activityRegister
     * @return
     */
    public Integer updateActivityRegister(ActivityRegister activityRegister);

    /**
     * 删除活动报名信息
     * @param id
     * @return
     */
    public Integer deleteActivityRegister(@Param("id") Integer id);

    /**
     * 查询指定id的活动报名信息
     * @param id
     * @return
     */
    public ActivityRegister findActivityRegisterById(@Param("id") Integer id);

    /**
     * 根据条件查询活动报名信息
     * @param conditionMap
     * @return
     */
    public List<ActivityRegister> findActivityRegister(@Param("conditionMap") Map<String,String> conditionMap);

}
