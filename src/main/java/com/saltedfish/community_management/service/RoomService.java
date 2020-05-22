package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Room;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface RoomService {

    /**
     * 添加房间信息
     * @param room
     * @return
     */
    Result addRoom(Room room) throws Exception;

    /**
     * 更新房间信息
     * @param room
     * @return
     */
    Result updateRoom(Room room) throws Exception;

    /**
     * 删除房间信息
     * @param id
     * @return
     */
    Result deleteRoom(Integer id) throws Exception;

    /**
     * 查询指定id的房间信息
     * @param id
     * @return
     */
    Result findRoomById(Integer id);

    /**
     * 根据条件查询房间信息，需要分页
     * @param conditionMap
     * @return
     */
    Result findRoomPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询房间信息，不需要分页
     * @param conditionMap
     * @return
     */
    Result findRoom(Map<String,String> conditionMap) throws Exception;

}
