package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.FacilityCategory;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.FacilityCategoryMapper;
import com.saltedfish.community_management.service.FacilityCategoryService;
import com.saltedfish.community_management.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FacilityCategoryServiceImpl implements FacilityCategoryService {

    @Autowired
    private FacilityCategoryMapper facilityCategoryMapper;

    @Override
    public Result addFacilityCategory(FacilityCategory facilityCategory) throws Exception {
        Integer effort = facilityCategoryMapper.insertFacilityCategory(facilityCategory);
        if (effort != 0){
            //添加设施分类成功
            return new Result(HttpStatus.OK.value(),"添加设施分类成功",null);
        }else{
            //添加设施分类失败
            throw new Exception("添加设施分类失败");
        }
    }

    @Override
    public Result updateFacilityCategory(FacilityCategory facilityCategory) throws Exception {
            Integer effort = facilityCategoryMapper.updateFacilityCategory(facilityCategory);
            if (effort != 0){
                //更新设施分类成功
                return new Result(HttpStatus.OK.value(),"更新设施分类成功",null);
            }else{
                //更新设施分类失败
                throw new Exception("更新设施分类失败");
            }
    }

    @Override
    public Result deleteFacilityCategory(Integer id) throws Exception {
        Integer effort = facilityCategoryMapper.deleteFacilityCategory(id);
        if (effort != 0){
            //删除设施分类成功
            return new Result(HttpStatus.OK.value(),"删除设施分类成功",null);
        }else{
            //删除设备分类失败
            throw new Exception("删除设备分类失败");
        }
    }

    @Override
    public Result findFacilityCategoryById(Integer id) throws Exception {
        FacilityCategory facilityCategory = facilityCategoryMapper.findFacilityCategoryById(id);
        if (facilityCategory != null){
            //查询指定id的设施分类成功
            return new Result(HttpStatus.OK.value(),"查询指定id的设施分类成功",facilityCategory);
        }else{
            //查询指定id的设施分类失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到设施分类",null);
        }
    }

    @Override
    public Result findFacilityCategoryPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<FacilityCategory> facilityCategoryList = facilityCategoryMapper.findFacilityCategory(conditionMap);
        if (facilityCategoryList != null){
            //根据条件查询设施分类成功
            PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(facilityCategoryList));
            return new Result(HttpStatus.OK.value(),"根据条件查询设施分类成功",pageResult);
        }else{
            //根据条件查询设施分类失败
            throw new Exception("根据条件查询设施分类失败");
        }
    }

    @Override
    public Result findFacilityCategory(Map<String, String> conditionMap) throws Exception {
        List<FacilityCategory> facilityCategoryList = facilityCategoryMapper.findFacilityCategory(conditionMap);
        if (facilityCategoryList != null){
            //根据条件查询设施分类成功
            return new Result(HttpStatus.OK.value(),"根据条件查询设施分类成功",facilityCategoryList);
        }else{
            //根据条件查询设施分类失败
            throw new Exception("根据条件查询设施分类失败");
        }
    }
}
