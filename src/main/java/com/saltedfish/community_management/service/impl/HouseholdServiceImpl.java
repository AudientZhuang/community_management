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

import java.util.List;
import java.util.Map;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HouseholdMapper householdMapper;

    @Override
    public Result addHousehold(Household household) {
        Result result = new Result();

        //householdMapper.insertHousehold(household);
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
            logger.info("发生异常：" + e.getMessage());
            result.setStatus(ResultCode.INSERT_HOUSEHOLD_EXCEPTION.getStatus());
            result.setMessage(ResultCode.INSERT_HOUSEHOLD_EXCEPTION.getMessage());
            //result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Result updateHousehold(Household household) {
        Result result = new Result();
        try{
            Integer effort = householdMapper.updateHousehold(household);
            if (effort != 0){
                //更新成功
                result.setStatus(ResultCode.UPDATE_HOUSEHOLD_SUCCESS.getStatus());
                result.setMessage(ResultCode.UPDATE_HOUSEHOLD_SUCCESS.getMessage());
            }else{
                //更新失败
                result.setStatus(ResultCode.UPDATE_HOUSEHOLD_FAILED.getStatus());
                result.setMessage(ResultCode.UPDATE_HOUSEHOLD_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            logger.info("发生异常：" + e.getMessage());
            result.setStatus(ResultCode.UPDATE_HOUSEHOLD_EXCEPTION.getStatus());
            result.setMessage(ResultCode.UPDATE_HOUSEHOLD_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result deleteHousehold(Integer id) {
        Result result = new Result();
        try{
            Integer effort = householdMapper.deleteHousehold(id);
            if (effort != 0){
                //删除成功
                result.setStatus(ResultCode.DELETE_HOUSEHOLD_SUCCESS.getStatus());
                result.setMessage(ResultCode.DELETE_HOUSEHOLD_SUCCESS.getMessage());
            }else{
                //删除失败
                result.setStatus(ResultCode.DELETE_HOUSEHOLD_FAILED.getStatus());
                result.setMessage(ResultCode.DELETE_HOUSEHOLD_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.DELETE_HOUSEHOLD_EXCEPTION.getStatus());
            result.setMessage(ResultCode.DELETE_HOUSEHOLD_EXCEPTION.getMessage());
            return result;
        }

    }

    @Override
    public Result findHouseholdById(Integer id) {
        Result result = new Result();
        try{
            Household household = householdMapper.findHouseholdById(id);
            if (household != null){
                //查询指定id的住户信息成功
                result.setStatus(ResultCode.FIND_HOUSEHOLD_BY_ID_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_HOUSEHOLD_BY_ID_SUCCESS.getMessage());
                result.setData(household);
            }else{
                //没有找到指定id的住户信息
                result.setStatus(ResultCode.FIND_HOUSEHOLD_BY_ID_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_HOUSEHOLD_BY_ID_FAILED.getMessage());

            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_HOUSEHOLD_BY_ID_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_HOUSEHOLD_BY_ID_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findHousehold(Map<String, String> conditionMap) {
        Result result = new Result();
        try{
            List<Household> householdList = householdMapper.findHousehold(conditionMap);
            if (householdList != null){
                //根据条件查询住户信息成功
                result.setStatus(ResultCode.FIND_HOUSEHOLD_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_HOUSEHOLD_SUCCESS.getMessage());
                result.setData(householdList);
                return result;
            }else{
                throw new Exception("householdList");
            }
        }catch (Exception e) {
            //捕获异常
            result.setStatus(ResultCode.FIND_HOUSEHOLD_EXCEPTION.getStatus());
            //result.setMessage(ResultCode.FIND_HOUSEHOLD_EXCEPTION.getMessage());
            result.setMessage(e.getMessage());
            return result;
        }
    }
}
