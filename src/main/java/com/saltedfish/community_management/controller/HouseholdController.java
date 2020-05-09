package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.HouseholdService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 住户信息
 */
@RestController
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    /**
     * 添加住户信息
     * @param household
     * @return
     */
    @PostMapping("/household")
    public Result addHousehold(Household household){
        try{
            //对前端信息进行校验

            //添加住户信息到数据库
            Result result = householdService.addHousehold(household);
            if (result.getStatus() != ResultCode.INSERT_HOUSEHOLD_EXCEPTION.getStatus()){
                //添加住户信息到数据库没有异常
                return result;
            }else {
                //添加住户信息到数据库出现异常
                throw new Exception(ResultCode.INSERT_HOUSEHOLD_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 更新住户信息
     * @param household
     * @return
     */
    @PutMapping("/household")
    public Result updateHousehold(Household household){
        try{
            //对前端信息进行校验

            //更新住户信息到数据库
            Result result = householdService.updateHousehold(household);
            if (result.getStatus() != ResultCode.UPDATE_HOUSEHOLD_EXCEPTION.getStatus()){
                //更新住户信息到数据库没有异常
                return result;
            }else {
                //更新住户信息到数据库出现异常
                throw new Exception(ResultCode.UPDATE_HOUSEHOLD_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 删除住户信息
     * @param id
     * @return
     */
    @DeleteMapping("/household/{id}")
    public Result deleteHousehold(@PathVariable("id") Integer id){
        try{
            //在数据库中删除住户信息
            Result result = householdService.deleteHousehold(id);
            if (result.getStatus() != ResultCode.DELETE_HOUSEHOLD_EXCEPTION.getStatus()){
                //删除住户信息没有异常
                return result;
            }else{
                //删除住户信息出现异常
                throw new Exception(ResultCode.DELETE_HOUSEHOLD_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }


    /**
     * 查询指定id的住户信息
     * @param id
     * @return
     */
    @GetMapping("/household/{id}")
    public Result findHousehold(@PathVariable("id") Integer id){
        try{
            //在数据库中查询指定id的住户信息
            Result result = householdService.findHouseholdById(id);
            if (result.getStatus() != ResultCode.FIND_HOUSEHOLD_BY_ID_EXCEPTION.getStatus()){
                //查询指定id的住户信息没有异常
                return result;
            }else{
                //查询指定id的住户信息出现异常
                throw new Exception(ResultCode.FIND_HOUSEHOLD_BY_ID_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 根据条件查询住户信息
     * @return
     */
    @GetMapping("/household")
    public Result findHousehold(HttpServletRequest request){
        try{
            //获取条件参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String,String> conditionMap = new HashMap<>();
            if (parameterMap.size() >= 0){
                //当传入参数为空时也可以正常运行
                for (String key: parameterMap.keySet()) {
                    conditionMap.put(key, parameterMap.get(key)[0]);
                }
                Result result = householdService.findHousehold(conditionMap);
                if (result.getStatus() != ResultCode.FIND_HOUSEHOLD_EXCEPTION.getStatus()){
                    return result;
                }else{
                    throw new Exception(ResultCode.FIND_HOUSEHOLD_EXCEPTION.getMessage());
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
