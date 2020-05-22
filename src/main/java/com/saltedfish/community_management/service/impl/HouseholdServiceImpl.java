package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Building;
import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.bean.Room;
import com.saltedfish.community_management.bean.User;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.BuildingMapper;
import com.saltedfish.community_management.mapper.HouseholdMapper;
import com.saltedfish.community_management.mapper.RoomMapper;
import com.saltedfish.community_management.mapper.UserMapper;
import com.saltedfish.community_management.service.HouseholdService;
import com.saltedfish.community_management.util.PageUtil;
import com.saltedfish.community_management.util.VOUtil;
import com.saltedfish.community_management.vo.HouseholdVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HouseholdMapper householdMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    @Transactional
    public Result addHousehold(HouseholdVO householdVO) throws Exception {
        //householdVO包含了user和household的信息，需要分开进行保存
        //1、进行household的添加
        Household household = new Household();
        household.setName(householdVO.getName());
        household.setGender(householdVO.getGender());
        household.setAge(householdVO.getAge());
        household.setTelephone(householdVO.getTelephone());
        household.setIDcard(householdVO.getIDcard());
        household.setArrivalDate(householdVO.getArrivalDate());
        household.setIsOwner(householdVO.getIsOwner());
        household.setBuildingId(householdVO.getBuildingId());
        household.setRoomId(householdVO.getRoomId());
        Integer householdEffort = householdMapper.insertHousehold(household);
        if (householdEffort == 0){
            //添加住户信息成功
            throw new Exception("添加住户信息失败");
        }
        //2、进行user的添加
        User user = new User();
        user.setAccount(householdVO.getAccount());
        user.setPassword(householdVO.getPassword());
        user.setHh_id(household.getId());
        Integer userEffort = userMapper.insertUser(user);
        if (userEffort == 0){
            throw new Exception("添加用户信息失败");
        }
        return new Result(HttpStatus.OK.value(),"注册成功",null);

    }

    @Override
    public Result updateHousehold(Household household) throws Exception {
        Integer effort = householdMapper.updateHousehold(household);
        if (effort != 0){
            //更新住户信息成功
            return new Result(HttpStatus.OK.value(),"更新住户信息成功",null);
        }else{
            //更新住户信息失败
            throw new Exception("更新住户信息失败");
        }
    }

    @Override
    public Result deleteHousehold(Integer id) throws Exception {
        Integer effort = householdMapper.deleteHousehold(id);
        if (effort != 0){
            //删除住户信息成功
            return new Result(HttpStatus.OK.value(),"删除住户信息成功",null);
        }else{
            //删除住户信息失败
            throw new Exception("删除住户信息失败");
        }
    }

    @Override
    public Result findHouseholdById(Integer id) {
        Household household = householdMapper.findHouseholdById(id);
        if (household != null){
            //查询指定id的住户信息成功
            return new Result(HttpStatus.OK.value(),"查询指定id的住户信息成功",household);
        }else{
            //没有找到指定id的住户信息
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到住户信息",null);
        }
    }

    @Override
    public Result findHouseholdPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        // 分页
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Household> householdList = householdMapper.findHousehold(conditionMap);
        if (householdList == null){
            //根据条件查询住户信息失败
            throw new Exception("根据条件查询住户信息失败");
        }
        //根据条件查询住户信息成功
        //封装返回结果，需要楼栋名称和房间号
        List<HouseholdVO> householdVOList = new ArrayList<>();
        for (Household household : householdList) {
            //对住户信息进行完善
            //根据hh_id获取住户账号信息
            User user = userMapper.findUserByHouseholdId(household.getId());
            //获取不到住户账号信息，跳过
            if (user == null){
                continue;
            }
            //根据id获取楼栋信息
            Building building = buildingMapper.findBuildingById(household.getBuildingId());
            //获取不到楼栋信息，跳过
            if (building == null){
                continue;
            }
            //根据id获取房间信息
            Room room = roomMapper.findRoomById(household.getRoomId());
            //获取不到房间信息，跳过
            if (room == null){
                continue;
            }
            //对住户信息进行封装
            HouseholdVO householdVO = VOUtil.toHouseholdVO(household);
            householdVO.setAccount(user.getAccount());
            householdVO.setPassword(user.getPassword());
            householdVO.setBuildingName(building.getBuildName());
            householdVO.setRoomNum(room.getRoomNum());
            householdVOList.add(householdVO);
        }

        PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(householdVOList));
        return new Result(HttpStatus.OK.value(),"根据条件查询住户信息成功",pageResult);
    }

    @Override
    public Result findHousehold(Map<String, String> conditionMap) throws Exception {
        List<Household> householdList = householdMapper.findHousehold(conditionMap);
        if (householdList == null){
            //根据条件查询住户信息失败
            throw new Exception("根据条件查询住户信息失败");

        }
        //根据条件查询住户信息成功
        //封装返回结果，需要楼栋名称和房间号
        List<HouseholdVO> householdVOList = new ArrayList<>();
        for (Household household : householdList) {
            //对住户信息进行完善
            //根据hh_id获取住户账号信息
            User user = userMapper.findUserByHouseholdId(household.getId());
            //获取不到住户账号信息，跳过
            if (user == null){
                continue;
            }
            //根据id获取楼栋信息
            Building building = buildingMapper.findBuildingById(household.getBuildingId());
            //获取不到楼栋信息，跳过
            if (building == null){
                continue;
            }
            //根据id获取房间信息
            Room room = roomMapper.findRoomById(household.getRoomId());
            //获取不到房间信息，跳过
            if (room == null){
                continue;
            }
            HouseholdVO householdVO = VOUtil.toHouseholdVO(household);
            householdVO.setAccount(user.getAccount());
            householdVO.setPassword(user.getPassword());
            householdVO.setBuildingName(building.getBuildName());
            householdVO.setRoomNum(room.getRoomNum());
            householdVOList.add(householdVO);
        }

        return new Result(HttpStatus.OK.value(),"根据条件查询住户信息成功",householdVOList);
    }
}
