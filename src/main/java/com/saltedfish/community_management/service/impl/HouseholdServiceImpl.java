package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.HouseholdMapper;
import com.saltedfish.community_management.service.HouseholdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HouseholdMapper householdMapper;

    @Override
    public Result addHousehold(Household household) {
        Result result = new Result();
        try {
            Integer effort = householdMapper.insertHousehold(household);
            if (effort != 0){
                //添加成功
                result.setStatus(ResultCode.INSERT_HOUSEHOLD_SUCCESS.getStatus());
                result.setMessage(ResultCode.INSERT_HOUSEHOLD_SUCCESS.getMessage());
            }else{
                //添加失败
                result.setStatus(ResultCode.INSERT_HOUSEHOLD_FAILED.getStatus());
                result.setMessage(ResultCode.INSERT_HOUSEHOLD_FAILED.getMessage());
            }
            return result;
        } catch (Exception e) {
            //捕获异常
            logger.info(e.getMessage());
            result.setStatus(ResultCode.INSERT_HOUSEHOLD_EXCEPTION.getStatus());
            result.setMessage(ResultCode.INSERT_HOUSEHOLD_EXCEPTION.getMessage());
            //result.setMessage(e.getMessage());
            return result;
        }
    }
}
