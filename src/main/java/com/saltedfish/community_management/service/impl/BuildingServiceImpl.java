package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Building;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.BuildingMapper;
import com.saltedfish.community_management.service.BuildingService;
import com.saltedfish.community_management.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public Result addBuilding(Building building) throws Exception {
        Integer effort = buildingMapper.insertBuilding(building);
        if (effort != 0){
            //添加楼栋信息成功
            return new Result(HttpStatus.OK.value(),"添加楼栋信息成功",null);
        }else{
            //添加楼栋信息失败
            throw new Exception("添加楼栋信息失败");
        }
    }

    @Override
    public Result updateBuilding(Building building) throws Exception {
        Integer effort = buildingMapper.updateBuilding(building);
        if (effort != 0){
            //更新楼栋信息成功
            return new Result(HttpStatus.OK.value(),"更新楼栋信息成功",null);
        }else{
            //更新楼栋信息失败
            throw new Exception("更新楼栋信息失败");
        }

    }

    @Override
    public Result deleteBuilding(Integer id) throws Exception {
        Integer effort = buildingMapper.deleteBuilding(id);
        if (effort != 0) {
            //删除楼栋信息成功
            return new Result(HttpStatus.OK.value(),"删除楼栋信息成功",null);
        }else{
            //删除楼栋信息失败
            throw new Exception("删除楼栋信息失败");
        }
    }

    @Override
    public Result findBuildingById(Integer id) throws Exception {
        Building building = buildingMapper.findBuildingById(id);
        if (building != null){
            //查询指定id的楼栋信息成功
            return new Result(HttpStatus.OK.value(),"查询指定id的楼栋信息成功",building);
        }else{
            //查询指定id的楼栋信息失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到楼栋信息",null);
        }
    }

    @Override
    public Result findBuildingPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Building> buildingList = buildingMapper.findBuilding(conditionMap);
        if (buildingList != null){
            //根据条件查询楼栋信息成功
            PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(buildingList));
            return new Result(HttpStatus.OK.value(),"根据条件查询楼栋信息成功",pageResult);
        }else{
            //根据条件查询楼栋信息失败
            throw new Exception("根据条件查询楼栋信息失败");
        }
    }

    @Override
    public Result findBuilding(Map<String, String> conditionMap) throws Exception {
        List<Building> buildingList = buildingMapper.findBuilding(conditionMap);
        if (buildingList != null){
            //根据条件查询楼栋信息成功
            return new Result(HttpStatus.OK.value(),"根据条件查询楼栋信息成功",buildingList);
        }else{
            //根据条件查询楼栋信息失败
            throw new Exception("根据条件查询楼栋信息失败");
        }
    }
}
