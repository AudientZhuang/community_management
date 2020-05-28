package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Activity;
import com.saltedfish.community_management.vo.MyActivityVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ActivityMapper {
    /**
     * 添加活动信息
     * @param activity
     * @return
     */
    public Integer insertActivity(Activity activity);

    /**
     * 更新活动信息
     * @param activity
     * @return
     */
    public Integer updateActivity(Activity activity);

    /**
     * 取消活动
     * @param id
     * @return
     */
    public Integer cancelActivity(Integer id);

    /**
     * 删除活动信息
     * @param id
     * @return
     */
    public Integer deleteActivity(@Param("id") Integer id);

    /**
     * 查询指定id的活动信息
     * @param id
     * @return
     */
    public Activity findActivityById(@Param("id") Integer id);

    /**
     * 根据条件查询活动信息
     * @param conditionMap
     * @return
     */
    public List<Activity> findActivity(@Param("conditionMap") Map<String,String> conditionMap);

    /**
     * 获取指定id的住户的正在进行的活动
     * @param hh_id
     * @param currentTime
     * @return
     */
    public List<MyActivityVO> findMyUnderwayActivity(@Param("hh_id") Integer hh_id, @Param("currentTime") Date currentTime);

    /**
     * 获取指定id的住户的已过期的活动
     * @param hh_id
     * @param currentTime
     * @return
     */
    public List<MyActivityVO> findMyOverdueActivity(@Param("hh_id") Integer hh_id, @Param("currentTime") Date currentTime);


}
