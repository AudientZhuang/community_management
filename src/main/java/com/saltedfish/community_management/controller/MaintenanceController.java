package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Maintenance;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 设施维护信息
 */
@RestController
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    /**
     * 添加设施维护信息
     * @param maintenance
     * @return
     */
    @PostMapping("/maintenance")
    public Result addMaintenance(Maintenance maintenance){
        try{
            //对前端信息进行校验

            //添加设施维护信息到数据库
            Result result = maintenanceService.addMaintenance(maintenance);
            if (result.getStatus() != ResultCode.INSERT_MAINTENANCE_EXCEPTION.getStatus()){
                //添加设施维护信息没有异常
                return result;
            }else{
                //添加设备信息出现异常
                throw new Exception(ResultCode.INSERT_MAINTENANCE_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 修改设施维护信息
     * @param maintenance
     * @return
     */
    @PutMapping("/maintenance")
    public Result updateMaintenance(Maintenance maintenance){
        try {
            //对前端信息进行校验

            //更新设施维护信息到数据库
            Result result = maintenanceService.updateMaintenance(maintenance);
            if (result.getStatus() != ResultCode.UPDATE_MAINTENANCE_EXCEPTION.getStatus()){
                //更新设施维护信息没有异常
                return result;
            }else{
                //更新设施维护信息出现异常
                throw new Exception(ResultCode.UPDATE_MAINTENANCE_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 删除设施维护信息
     * @param id
     * @return
     */
    @DeleteMapping("/maintenance/{id}")
    public Result deleteMaintenance(@PathVariable("id") Integer id){
        try {
            //在数据库中删除设施维护信息
            Result result = maintenanceService.deleteMaintenance(id);
            if (result.getStatus() != ResultCode.DELETE_MAINTENANCE_EXCEPTION.getStatus()){
                //删除设施维护信息没有异常
                return result;
            }else{
                //删除设施维护信息出现异常
                throw new Exception(ResultCode.DELETE_MAINTENANCE_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 查询指定id的设施维护信息
     * @param id
     * @return
     */
    @GetMapping("/maintenance/{id}")
    @ResponseBody
    public Result findMaintenanceById(@PathVariable("id") Integer id){
        try{
            Result result = maintenanceService.findMaintenanceById(id);
            if (result.getStatus() != ResultCode.FIND_MAINTENANCE_BY_ID_EXCEPTION.getStatus()){
                //查询指定id的设施维护信息没有异常
                return result;
            }else{
                //查询指定id的设施维护信息出现异常
                throw new Exception(ResultCode.FIND_MAINTENANCE_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 根据条件查询设施维护信息
     * @param request
     * @return
     */
    @GetMapping("/maintenance")
    public Result findMaintenance(HttpServletRequest request){
        try{
            //获取条件参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String,String> conditionMap = new HashMap<>();
            if (parameterMap.size() >= 0){
                //参数为空也可以正常运行
                for (String key: parameterMap.keySet()) {
                    conditionMap.put(key,parameterMap.get(key)[0]);
                }
                Result result = maintenanceService.findMaintenance(conditionMap);
                if (result.getStatus() != ResultCode.FIND_MAINTENANCE_EXCEPTION.getStatus()){
                    //根据条件查询设施维护信息没有异常
                    return result;
                }else{
                    //根据条件查询设施维护信息出现异常
                    throw new Exception(ResultCode.FIND_MAINTENANCE_EXCEPTION.getMessage());
                }
            }else{
                //获取不到参数
                throw new Exception();
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }



}
