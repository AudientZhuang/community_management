package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 住户信息
 */
@RestController
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @PostMapping("/household")
    public Result addHousehold(Household household){
        try{
            //对前端信息进行校验

            //添加住户信息到数据库
            Result result = householdService.addHousehold(household);
            if (result.getStatus() != ResultCode.INSERT_HOUSEHOLD_EXCEPTION.getStatus()){
                return result;
            }else{
                //throw new Exception(ResultCode.INSERT_HOUSEHOLD_EXCEPTION.getMessage());
                return new Result(-1,"zhelicuole",null);
            }
        }catch (Exception e){
            //有异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }


}
