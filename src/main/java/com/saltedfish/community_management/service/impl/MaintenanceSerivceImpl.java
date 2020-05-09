package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.Maintenance;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.MaintenanceMapper;
import com.saltedfish.community_management.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MaintenanceSerivceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceMapper maintenanceMapper;

    @Override
    public Result addMaintenance(Maintenance maintenance) {
        Result result = new Result();
        try{
            Integer effort = maintenanceMapper.insertMaintenance(maintenance);
            if (effort != 0){
                //添加设施维护信息成功
                result.setStatus(ResultCode.INSERT_MAINTENANCE_SUCCESS.getStatus());
                result.setMessage(ResultCode.INSERT_MAINTENANCE_SUCCESS.getMessage());
            }else{
                //添加设施维护信息失败
                result.setStatus(ResultCode.INSERT_MAINTENANCE_FAILED.getStatus());
                result.setMessage(ResultCode.INSERT_MAINTENANCE_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.INSERT_MAINTENANCE_EXCEPTION.getStatus());
            result.setMessage(ResultCode.INSERT_MAINTENANCE_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result updateMaintenance(Maintenance maintenance) {
        Result result = new Result();
        try {
            Integer effort = maintenanceMapper.updateMaintenance(maintenance);
            if (effort != 0){
                //更新设施维护信息成功
                result.setStatus(ResultCode.UPDATE_MAINTENANCE_SUCCESS.getStatus());
                result.setMessage(ResultCode.UPDATE_MAINTENANCE_SUCCESS.getMessage());
            }else{
                //更新设施维护信息失败
                result.setStatus(ResultCode.UPDATE_MAINTENANCE_FAILED.getStatus());
                result.setMessage(ResultCode.UPDATE_MAINTENANCE_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.UPDATE_MAINTENANCE_EXCEPTION.getStatus());
            result.setMessage(ResultCode.UPDATE_MAINTENANCE_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result deleteMaintenance(Integer id) {
        Result result = new Result();
        try{
            Integer effort = maintenanceMapper.deleteMaintenance(id);
            if (effort != 0){
                //删除设施维护信息成功
                result.setStatus(ResultCode.DELETE_MAINTENANCE_SUCCESS.getStatus());
                result.setMessage(ResultCode.DELETE_MAINTENANCE_SUCCESS.getMessage());
            }else{
                //删除设施维护信息失败
                result.setStatus(ResultCode.DELETE_MAINTENANCE_FAILED.getStatus());
                result.setMessage(ResultCode.DELETE_MAINTENANCE_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.DELETE_MAINTENANCE_EXCEPTION.getStatus());
            result.setMessage(ResultCode.DELETE_MAINTENANCE_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findMaintenanceById(Integer id) {
        Result result = new Result();
        try {
            Maintenance maintenance = maintenanceMapper.findMaintenanceById(id);
            if (maintenance != null){
                //查询指定id的设施维护信息成功
                result.setStatus(ResultCode.FIND_MAINTENANCE_BY_ID_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_MAINTENANCE_BY_ID_SUCCESS.getMessage());
                result.setData(maintenance);
            }else{
                //查询指定id的设施维护信息失败
                result.setStatus(ResultCode.FIND_MAINTENANCE_BY_ID_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_MAINTENANCE_BY_ID_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_MAINTENANCE_BY_ID_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_MAINTENANCE_BY_ID_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findMaintenance(Map<String, String> conditionMap) {
        Result result = new Result();
        try {
            List<Maintenance> maintenanceList = maintenanceMapper.findMaintenance(conditionMap);
            if (maintenanceList != null){
                //根据条件查询设施维护信息成功
                result.setStatus(ResultCode.FIND_MAINTENANCE_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_MAINTENANCE_SUCCESS.getMessage());
                result.setData(maintenanceList);
            }else{
                //根据条件查询设施维护信息失败
                result.setStatus(ResultCode.FIND_MAINTENANCE_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_MAINTENANCE_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_MAINTENANCE_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_MAINTENANCE_EXCEPTION.getMessage());
            return result;
        }
    }
}
