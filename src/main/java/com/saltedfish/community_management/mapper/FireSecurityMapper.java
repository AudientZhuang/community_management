package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.FireSecurity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 消防检查情况
 */
@Mapper
public interface FireSecurityMapper {

    /**
     * 添加消防检查情况
     * @param fireSecurity
     * @return
     */
    public Integer insertFireSecurity(FireSecurity fireSecurity);

    /**
     * 更新消防检查情况
     * @param fireSecurity
     * @return
     */
    public Integer updateFireSecurity(FireSecurity fireSecurity);

    /**
     * 删除消防检查情况
     * @param id
     * @return
     */
    public Integer deleteFireSecurity(@Param("id") Integer id);

    /**
     * 查询指定id的消防检查情况
     * @param id
     * @return
     */
    public FireSecurity findFireSecurityById(@Param("id") Integer id);

    /**
     * 根据条件查询消防检查情况
     * @param conditionMap
     * @return
     */
    public List<FireSecurity> findFireSecurity(@Param("conditionMap") Map<String,String> conditionMap);

}
