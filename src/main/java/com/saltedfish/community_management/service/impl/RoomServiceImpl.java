package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Building;
import com.saltedfish.community_management.bean.Room;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.BuildingMapper;
import com.saltedfish.community_management.mapper.RoomMapper;
import com.saltedfish.community_management.service.RoomService;
import com.saltedfish.community_management.util.PageUtil;
import com.saltedfish.community_management.util.VOUtil;
import com.saltedfish.community_management.vo.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public Result addRoom(Room room) throws Exception {
        // 检查楼栋信息是否存在
        Building building = buildingMapper.findBuildingById(room.getBuildingId());
        // 楼栋信息不存在
        if (building == null){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"楼栋信息不存在",null);
        }

        // 添加房间信息
        Integer effort = roomMapper.insertRoom(room);
        if (effort != 0){
            //添加房间信息成功
            return new Result(HttpStatus.OK.value(),"添加房间信息成功",null);
        }else{
            //添加房间信息失败
            throw new Exception("添加房间信息失败");
        }
    }

    @Override
    public Result updateRoom(Room room) throws Exception {
        Integer effort = roomMapper.updateRoom(room);
        if(effort != 0){
            //更新房间信息成功
            return new Result(HttpStatus.OK.value(),"更新房间信息成功",null);
        }else{
            //更新房间信息失败
            throw new Exception("更新房间信息失败");
        }
    }

    @Override
    public Result deleteRoom(Integer id) throws Exception {
        Integer effort = roomMapper.deleteRoom(id);
        if (effort != 0){
            //删除房间信息成功
            return new Result(HttpStatus.OK.value(),"删除房间信息成功",null);
        }else{
            //删除房间信息失败
            throw new Exception("删除房间信息失败");
        }
    }

    @Override
    public Result findRoomById(Integer id) {
        Room room = roomMapper.findRoomById(id);
        if (room == null){
            //查询指定id的房间信息失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到房间信息",null);
        }
        //查询指定id的房间信息成功
        //对房间信息进行完善
        //根据id获取楼栋信息
        Building building = buildingMapper.findBuildingById(room.getBuildingId());
        //获取不到楼栋信息，跳过
        if (building == null){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"楼栋信息不存在",null);
        }
        RoomVO roomVO = VOUtil.toRoomVO(room);
        roomVO.setBuildingName(building.getBuildName());
        return new Result(HttpStatus.OK.value(),"查询指定id的房间信息成功",roomVO);
    }

    @Override
    public Result findRoomPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        // 分页
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Room> roomList = roomMapper.findRoom(conditionMap);
        if (roomList == null){
            //根据条件查询房间信息失败
            throw new Exception("根据条件查询房间信息失败");
        }
        //根据条件查询房间信息成功
        //封装返回结果，需要楼栋名称
        List<RoomVO> roomVOList = new ArrayList<>();
        for (Room room : roomList) {
            //对房间信息进行完善
            //根据id获取楼栋信息
            Building building = buildingMapper.findBuildingById(room.getBuildingId());
            //获取不到楼栋信息，跳过
            if (building == null){
                continue;
            }
            RoomVO roomVO = VOUtil.toRoomVO(room);
            roomVO.setBuildingName(building.getBuildName());
            roomVOList.add(roomVO);
        }
        PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(roomList));
        pageResult.setItems(roomVOList);
        return new Result(HttpStatus.OK.value(),"根据条件查询房间信息成功",pageResult);

    }

    @Override
    public Result findRoom(Map<String, String> conditionMap) throws Exception {
        List<Room> roomList = roomMapper.findRoom(conditionMap);
        if (roomList == null){
            //根据条件查询房间信息失败
            throw new Exception("根据条件查询房间信息失败");
        }
        //根据条件查询房间信息成功
        //封装返回结果，需要楼栋名称
        List<RoomVO> roomVOList = new ArrayList<>();
        for (Room room : roomList) {
            //对房间信息进行完善
            //根据id获取楼栋信息
            Building building = buildingMapper.findBuildingById(room.getBuildingId());
            //获取不到楼栋信息，跳过
            if (building == null){
                continue;
            }
            RoomVO roomVO = VOUtil.toRoomVO(room);
            roomVO.setBuildingName(building.getBuildName());
            roomVOList.add(roomVO);
        }
        return new Result(HttpStatus.OK.value(),"根据条件查询房间信息成功",roomVOList);
    }
}
