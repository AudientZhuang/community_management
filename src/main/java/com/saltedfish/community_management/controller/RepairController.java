package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Repair;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 住户申报维修信息
 */
@RestController
public class RepairController {

    @Autowired
    private RepairService repairService;

    /**
     * 添加住户申报维修信息
     * @param repair
     * @return
     */
    @PostMapping("/repair")
    public Result addRepair(Repair repair){
        try {
            //对前端信息进行校验

            //添加住户申报维修信息到数据库
            Result result = repairService.addRepair(repair);
            if (result.getStatus() != ResultCode.INSERT_PAYMENT_EXCEPTION.getStatus()){
                //添加住户申报维修信息没有异常
                return result;
            }else{
                //添加住户申报维修信息出现异常
                throw new Exception(ResultCode.INSERT_REPAIR_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 更新住户申报维修信息
     * @param repair
     * @return
     */
    @PutMapping("/repair")
    public Result updateRepair(Repair repair){
        try {
            //对前端信息进行校验

            //更新住户申报维修信息到数据库
            Result result = repairService.updateRepair(repair);
            if (result.getStatus() != ResultCode.UPDATE_PAYMENT_EXCEPTION.getStatus()){
                //更新住户申报维修信息没有异常
                return result;
            }else{
                //更新住户申报维修信息出现异常
                throw new Exception(ResultCode.UPDATE_REPAIR_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 删除住户申报维修信息
     * @param id
     * @return
     */
    @DeleteMapping("/repair/{id}")
    public Result deleteRepair(@PathVariable("id") Integer id){
        try {
            //在数据库中删除指定id的住户申报维修信息
            Result result = repairService.deleteRepair(id);
            if (result.getStatus() != ResultCode.DELETE_REPAIR_EXCEPTION.getStatus()){
                //删除住户申报维修信息没有异常
                return result;
            }else{
                //删除住户申报维修信息出现异常
                throw new Exception(ResultCode.DELETE_REPAIR_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 查询指定id的住户申报维修信息
     * @param id
     * @return
     */
    @GetMapping("/repair/{id}")
    public Result findRepair(@PathVariable("id") Integer id){
        try {
            Result result = repairService.findRepairById(id);
            if (result.getStatus() != ResultCode.FIND_REPAIR_BY_ID_EXCEPTION.getStatus()){
                //查询指定id的住户申报维修信息没有异常
                return result;
            }else{
                //查询指定id的住户申报维修信息出现异常
                throw new Exception(ResultCode.FIND_REPAIR_BY_ID_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 根据条件查询住户申报维修信息
     * @param request
     * @return
     */
    @GetMapping("/repair")
    public Result findRepair(HttpServletRequest request){
        try {
            //获取条件参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String,String> conditionMap = new HashMap<>();
            if (parameterMap.size() >= 0){
                //参数为空时也可以运行
                for (String key: parameterMap.keySet()) {
                    conditionMap.put(key,parameterMap.get(key)[0]);
                }
                Result result = repairService.findRepair(conditionMap);
                if (result.getStatus() != ResultCode.FIND_REPAIR_EXCEPTION.getStatus()){
                    //根据条件查询住户申报维修信息没有异常
                    return result;
                }else{
                    //根据条件查询住户申报维修信息出现异常
                    throw new Exception(ResultCode.FIND_REPAIR_EXCEPTION.getMessage());
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
