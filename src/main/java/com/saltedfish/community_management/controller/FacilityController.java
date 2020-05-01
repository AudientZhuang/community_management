package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Facility;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 设施信息
 */
@RestController
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    /**
     * 添加设施信息
     * @param facility
     * @return
     */
    @PostMapping("/facility")
    public Result addFacility(Facility facility){
        try{
            //对前端信息进行校验

            //添加设施信息到数据库
            Result result = facilityService.addFacility(facility);
            if (result.getStatus() != ResultCode.INSERT_FACILITY_EXCEPTION.getStatus()){
                //添加设施信息没有异常
                return result;
            }else {
                //添加设施信息出现异常
                throw new Exception(ResultCode.INSERT_FACILITY_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    @PutMapping("/facility")
    public Result updateFacility(Facility facility){
        try{
            //对前端信息进行校验

            //更新设施信息到数据库
            Result result = facilityService.updateFacility(facility);
            if (result.getStatus() != ResultCode.UPDATE_FACILITY_EXCEPTION.getStatus()){
                //更新设施信息没有异常
                return result;
            }else {
                //更新设施信息出现异常
                throw new Exception(ResultCode.UPDATE_FACILITY_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    @DeleteMapping("/facility/{id}")
    public Result deleteFacility(@PathVariable("id") Integer id){
        try{
            //如果当前设施有维护信息，需要先将其维护信息删除，才可以进一步删除设施的信息\

            //删除设施信息
            Result result = facilityService.deleteFacility(id);
            if (result.getStatus() != ResultCode.DELETE_FACILITY_EXCEPTION.getStatus()){
                //删除设施信息没有异常
                return result;
            }else {
                //删除设施信息出现异常
                throw new Exception(ResultCode.DELETE_FACILITY_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    @GetMapping("/facility/{id}")
    public Result findFacilityById(@PathVariable("id") Integer id){
        try{
            //查询指定id的设施信息
            Result result = facilityService.findFacilityById(id);
            if (result.getStatus() != ResultCode.FIND_FACILITY_BY_ID_EXCEPTION.getStatus()){
                //查询指定id的设施信息没有异常
                return result;
            }else {
                //查询指定id的设施信息出现异常
                throw new Exception(ResultCode.FIND_FACILITY_BY_ID_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    @GetMapping("/facility")
    public Result findFacility(HttpServletRequest request){
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String,String> conditionMap = new HashMap<>();
            if (parameterMap.size() >= 0){
                //参数为空时也可以正常运行
                for (String key: parameterMap.keySet()) {
                    conditionMap.put(key,parameterMap.get(key)[0]);
                }
                Result result = facilityService.findFacility(conditionMap);
                if (result.getStatus() != ResultCode.FIND_FACILITY_EXCEPTION.getStatus()){
                    //根据条件查询设施信息没有异常
                    return result;
                }else {
                    //根据条件查询设施信息出现异常
                    throw new Exception(ResultCode.FIND_FACILITY_EXCEPTION.getMessage());
                }
            }else {
                //获取不到参数
                throw new Exception();
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }


}
