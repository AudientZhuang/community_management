package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.Repair;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.RepairMapper;
import com.saltedfish.community_management.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public Result addRepair(Repair repair) {
        Result result = new Result();
        try {
            Integer effort = repairMapper.insertRepair(repair);
            if (effort != 0){
                //添加住户申报维修信息成功
                result.setStatus(ResultCode.INSERT_REPAIR_SUCCESS.getStatus());
                result.setMessage(ResultCode.INSERT_REPAIR_SUCCESS.getMessage());
            }else{
                //添加住户申报维修信息失败
                result.setStatus(ResultCode.INSERT_REPAIR_FAILED.getStatus());
                result.setMessage(ResultCode.INSERT_REPAIR_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.INSERT_REPAIR_EXCEPTION.getStatus());
            result.setMessage(ResultCode.INSERT_REPAIR_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result updateRepair(Repair repair) {
        Result result = new Result();
        try {
            Integer effort = repairMapper.updateRepair(repair);
            if(effort != 0){
                //更新住户申报维修信息成功
                result.setStatus(ResultCode.UPDATE_REPAIR_SUCCESS.getStatus());
                result.setMessage(ResultCode.UPDATE_REPAIR_SUCCESS.getMessage());
            }else{
                //更新住户申报维修信息失败
                result.setStatus(ResultCode.UPDATE_REPAIR_FAILED.getStatus());
                result.setMessage(ResultCode.UPDATE_REPAIR_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.UPDATE_REPAIR_EXCEPTION.getStatus());
            result.setMessage(ResultCode.UPDATE_REPAIR_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result deleteRepair(Integer id) {
        Result result = new Result();
        try {
            Integer effort = repairMapper.deleteRepair(id);
            if (effort != 0){
                //删除住户申报维修信息成功
                result.setStatus(ResultCode.DELETE_REPAIR_SUCCESS.getStatus());
                result.setMessage(ResultCode.DELETE_REPAIR_SUCCESS.getMessage());
            }else{
                //删除住户申报维修信息失败
                result.setStatus(ResultCode.DELETE_REPAIR_FAILED.getStatus());
                result.setMessage(ResultCode.DELETE_REPAIR_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.DELETE_REPAIR_EXCEPTION.getStatus());
            result.setMessage(ResultCode.DELETE_REPAIR_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findRepairById(Integer id) {
        Result result = new Result();
        try {
            Repair repair = repairMapper.findRepairById(id);
            if (repair != null){
                //查询指定id的住户申报维修信息成功
                result.setStatus(ResultCode.FIND_REPAIR_BY_ID_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_REPAIR_BY_ID_SUCCESS.getMessage());
                result.setData(repair);
            }else{
                //查询指定id的住户申报维修信息失败
                result.setStatus(ResultCode.FIND_REPAIR_BY_ID_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_REPAIR_BY_ID_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_REPAIR_BY_ID_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_REPAIR_BY_ID_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findRepair(Map<String, String> conditionMap) {
        Result result = new Result();
        try {
            List<Repair> repairList = repairMapper.findRepair(conditionMap);
            if (repairList != null){
                //根据条件查询住户申报维修信息成功
                result.setStatus(ResultCode.FIND_REPAIR_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_REPAIR_SUCCESS.getMessage());
                result.setData(repairList);
            }else{
                //根据条件查询住户申报维修信息失败
                result.setStatus(ResultCode.FIND_REPAIR_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_REPAIR_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_REPAIR_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_REPAIR_EXCEPTION.getMessage());
            return result;
        }
    }
}
