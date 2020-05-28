package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Charge;
import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.bean.Payment;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.ChargeMapper;
import com.saltedfish.community_management.mapper.HouseholdMapper;
import com.saltedfish.community_management.mapper.PaymentMapper;
import com.saltedfish.community_management.service.ChargeService;
import com.saltedfish.community_management.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChargeServiceImpl implements ChargeService {
    @Autowired
    private ChargeMapper chargeMapper;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private HouseholdMapper householdMapper;

    @Transactional
    @Override
    public Result addCharge(Charge charge) throws Exception {
        Integer effort = chargeMapper.insertCharge(charge);
        if (effort != 0){
            // 添加缴费项目成功

            // 查找所有的户主信息
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("isOwner", "1");
            List<Household> householdList = householdMapper.findHousehold(conditionMap);
            // 为每个户主生成账单
            for (Household household : householdList) {
                // 账单信息
                Payment payment = new Payment();
                payment.setCharId(charge.getId());
                payment.setHouseholdId(household.getId());
                payment.setCharStandard(charge.getStandard());
                payment.setPayStatus(0);
                Integer insertStatus = paymentMapper.insertPayment(payment);
                if (insertStatus == 0){
                    throw new Exception("为用户生成账单失败");
                }
            }
            return new Result(HttpStatus.OK.value(),"添加缴费项目成功",null);
        }else{
            //添加缴费项目失败
            throw new Exception("添加缴费项目失败");
        }
    }

    @Override
    @Transactional
    public Result updateCharge(Charge charge) throws Exception {
        Integer effort = chargeMapper.updateCharge(charge);
        if (effort != 0){
            //更新缴费项目成功

            // 对户主的账单进行修改
            // 查找所有关于该缴费项目的账单信息
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("charId",charge.getId().toString());
            List<Payment> paymentList = paymentMapper.findPayment(conditionMap);
            for (Payment payment : paymentList) {
                payment.setCharStandard(charge.getStandard());
                Integer updateStatus = paymentMapper.updatePayment(payment);
                if (updateStatus == 0){
                    throw new Exception("更新缴费项目失败");
                }
            }

            return new Result(HttpStatus.OK.value(),"更新缴费项目成功",null);
        }else{
            //更新缴费项目失败
            throw new Exception("更新缴费项目失败");
        }
    }

    @Override
    public Result deleteCharge(Integer id) throws Exception {
        Integer effort = chargeMapper.deleteCharge(id);
        if(effort != 0){
            //删除缴费项目成功

            // 对户主的账单进行修改
            // 查找所有关于该缴费项目的账单信息
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("charId",id.toString());
            List<Payment> paymentList = paymentMapper.findPayment(conditionMap);
            for (Payment payment : paymentList) {
                Integer deleteStatus = paymentMapper.deletePayment(payment.getId());
                if (deleteStatus == 0){
                    throw new Exception("删除缴费项目失败");
                }
            }
            return new Result(HttpStatus.OK.value(),"删除缴费项目成功",null);
        }else{
            //删除缴费项目失败
            throw new Exception("删除缴费项目失败");
        }
    }

    @Override
    public Result findChargeById(Integer id) throws Exception {
        Charge charge = chargeMapper.findChargeById(id);
        if (charge != null){
            //查询指定id的缴费项目成功
            return new Result(HttpStatus.OK.value(),"删除缴费项目成功",charge);
        }else{
            //查询指定id的缴费项目失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到缴费项目",null);
        }
    }

    @Override
    public Result findChargePage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Charge> chargeList = chargeMapper.findCharge(conditionMap);
        if (chargeList != null){
            //根据条件查询缴费项目成功
            PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(chargeList));
            return new Result(HttpStatus.OK.value(),"根据条件查询缴费项目成功",pageResult);
        }else{
            //根据条件查询缴费项目失败
            throw new Exception("根据条件查询缴费项目失败");
        }
    }

    @Override
    public Result findCharge(Map<String, String> conditionMap) throws Exception {
        List<Charge> chargeList = chargeMapper.findCharge(conditionMap);
        if (chargeList != null){
            //根据条件查询缴费项目成功
            return new Result(HttpStatus.OK.value(),"根据条件查询缴费项目成功",chargeList);
        }else{
            //根据条件查询缴费项目失败
            throw new Exception("根据条件查询缴费项目失败");
        }
    }

}
