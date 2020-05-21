package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Facility;
import com.saltedfish.community_management.bean.FacilityCategory;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.FacilityCategoryMapper;
import com.saltedfish.community_management.mapper.FacilityMapper;
import com.saltedfish.community_management.service.FacilityService;
import com.saltedfish.community_management.util.PageUtil;
import com.saltedfish.community_management.util.VOUtil;
import com.saltedfish.community_management.vo.FacilityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityMapper facilityMapper;

    @Autowired
    private FacilityCategoryMapper facilityCategoryMapper;


    @Override
    public Result addFacility(Facility facility) throws Exception {

        Integer effort = facilityMapper.insertFacility(facility);
        if (effort != 0){
            //添加设施信息成功
            return new Result(HttpStatus.OK.value(),"添加设施信息成功",null);
        }else{
            //添加设施信息失败
            throw new Exception("添加设施信息失败");
        }
    }

    @Override
    public Result updateFacility(Facility facility) throws Exception {
        Integer effort = facilityMapper.updateFacility(facility);
        if (effort != 0){
            //更新设施信息成功
            return new Result(HttpStatus.OK.value(),"更新设施信息成功",null);
        }else {
            //更新设施信息失败
            throw new Exception("更新设施信息失败");
        }
    }

    @Override
    public Result deleteFacility(Integer id) throws Exception {
        Integer effort = facilityMapper.deleteFacility(id);
        if (effort != 0){
            //删除设施信息成功
            return new Result(HttpStatus.OK.value(),"删除设施信息成功",null);
        }else {
            //删除设施信息失败
            throw new Exception("删除设施信息失败");
        }
    }

    @Override
    public Result findFacilityById(Integer id) throws Exception {
        Facility facility = facilityMapper.findFacilityById(id);
        if(facility != null){
            //查询指定id的设施信息成功
            return new Result(HttpStatus.OK.value(),"查询指定id的设施信息成功",facility);
        }else {
            //查询指定id的设施信息失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到设施信息",null);
        }
    }

    @Override
    public Result findFacilityPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Facility> facilityList = facilityMapper.findFacility(conditionMap);
        if (facilityList == null){
            //根据条件查询设施信息失败
            throw new Exception("根据条件查询设施信息失败");
        }
        //根据条件查询设施信息成功
        //封装返回结果，需要设施分类名称
        List<FacilityVO> facilityVOList = new ArrayList<>();
        for (Facility facility : facilityList) {
            //对设施信息进行完善
            //根据id获取设施分类信息
            FacilityCategory facilityCategory = facilityCategoryMapper.findFacilityCategoryById(facility.getCateId());
            //获取不到设施分类信息，跳过
            if (facilityCategory == null){
                continue;
            }
            FacilityVO facilityVO = VOUtil.toFacilityVO(facility);
            facilityVO.setCateName(facilityCategory.getCateName());
            facilityVOList.add(facilityVO);
        }
        PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(facilityVOList));
        return new Result(HttpStatus.OK.value(),"根据条件查询设施信息成功",pageResult);
    }

    @Override
    public Result findFacility(Map<String, String> conditionMap) throws Exception {
        List<Facility> facilityList = facilityMapper.findFacility(conditionMap);
        if (facilityList == null){
            //根据条件查询设施信息失败
            throw new Exception("根据条件查询设施信息失败");
        }
        //根据条件查询设施信息成功
        //封装返回结果，需要设施分类名称
        List<FacilityVO> facilityVOList = new ArrayList<>();
        for (Facility facility : facilityList) {
            //对设施信息进行完善
            //根据id获取设施分类信息
            FacilityCategory facilityCategory = facilityCategoryMapper.findFacilityCategoryById(facility.getCateId());
            //获取不到设施分类信息，跳过
            if (facilityCategory == null){
                continue;
            }
            FacilityVO facilityVO = VOUtil.toFacilityVO(facility);
            facilityVO.setCateName(facilityCategory.getCateName());
            facilityVOList.add(facilityVO);
        }
        return new Result(HttpStatus.OK.value(),"根据条件查询设施信息成功",facilityVOList);
    }
}
