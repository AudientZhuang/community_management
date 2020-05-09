package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.Facility;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.FacilityMapper;
import com.saltedfish.community_management.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityMapper facilityMapper;


    @Override
    public Result addFacility(Facility facility) {
        Result result = new Result();
        try{
            Integer effort = facilityMapper.insertFacility(facility);
            if (effort != 0){
                //添加设施信息成功
                result.setStatus(ResultCode.INSERT_FACILITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.INSERT_FACILITY_SUCCESS.getMessage());
            }else{
                //添加设施信息失败
                result.setStatus(ResultCode.INSERT_FACILITY_FAILED.getStatus());
                result.setMessage(ResultCode.INSERT_FACILITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.INSERT_FACILITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.INSERT_FACILITY_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result updateFacility(Facility facility) {
        Result result = new Result();
        try {
            Integer effort = facilityMapper.updateFacility(facility);
            if (effort != 0){
                //更新设施信息成功
                result.setStatus(ResultCode.UPDATE_FACILITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.UPDATE_FACILITY_SUCCESS.getMessage());
            }else {
                //更新设施信息失败
                result.setStatus(ResultCode.UPDATE_FACILITY_FAILED.getStatus());
                result.setMessage(ResultCode.UPDATE_FACILITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.UPDATE_FACILITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.UPDATE_FACILITY_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result deleteFacility(Integer id) {
        Result result = new Result();
        try {
            Integer effort = facilityMapper.deleteFacility(id);
            if (effort != 0){
                //删除设施信息成功
                result.setStatus(ResultCode.DELETE_FACILITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.DELETE_FACILITY_SUCCESS.getMessage());
            }else {
                //删除设施信息失败
                result.setStatus(ResultCode.DELETE_FACILITY_FAILED.getStatus());
                result.setMessage(ResultCode.DELETE_FACILITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.DELETE_FACILITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.DELETE_FACILITY_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findFacilityById(Integer id) {
        Result result = new Result();
        try {
            Facility facility = facilityMapper.findFacilityById(id);
            if(facility != null){
                //查询指定id的设施信息成功
                result.setStatus(ResultCode.FIND_FACILITY_BY_ID_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_FACILITY_BY_ID_SUCCESS.getMessage());
                result.setData(facility);
            }else {
                //查询指定id的设施信息失败
                result.setStatus(ResultCode.FIND_FACILITY_BY_ID_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_FACILITY_BY_ID_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_FACILITY_BY_ID_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_FACILITY_BY_ID_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findFacility(Map<String, String> conditionMap) {
        Result result = new Result();
        try {
            List<Facility> facilityList = facilityMapper.findFacility(conditionMap);
            if (facilityList != null){
                //根据条件查询设施信息成功
                result.setStatus(ResultCode.FIND_FACILITY_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_FACILITY_SUCCESS.getMessage());
                result.setData(facilityList);
            }else {
                //根据条件查询设施信息失败
                result.setStatus(ResultCode.FIND_FACILITY_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_FACILITY_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_FACILITY_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_FACILITY_EXCEPTION.getMessage());
            return result;
        }
    }
}
