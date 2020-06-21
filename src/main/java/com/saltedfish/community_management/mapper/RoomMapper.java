package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 房间信息
 */
@Mapper
public interface RoomMapper {

    /**
     * 添加房间信息
     * @param room
     * @return
     */
    public Integer insertRoom(Room room);

    /**
     * 更新房间信息
     * @param room
     * @return
     */
    public Integer updateRoom(Room room);

    /**
     * 删除房间信息
     * @param id
     * @return
     */
    public Integer deleteRoom(@Param("id") Integer id);

    /**
     * 查询指定id的房间信息
     * @param id
     * @return
     */
    public Room findRoomById(@Param("id") Integer id);

    /**
     * 根据条件查询房间信息
     * @param conditionMap
     * @return
     */
    public List<Room> findRoom(@Param("conditionMap") Map<String,String> conditionMap);


}
