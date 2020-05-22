package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.Page;
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
import com.saltedfish.community_management.service.PaymentService;
import com.saltedfish.community_management.util.PageUtil;
import com.saltedfish.community_management.util.VOUtil;
import com.saltedfish.community_management.vo.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private HouseholdMapper householdMapper;

    @Autowired
    private ChargeMapper chargeMapper;

    @Override
    public Result addPayment(Payment payment) throws Exception {
        Integer effort = paymentMapper.insertPayment(payment);
        if (effort != 0){
            //添加收费情况成功
            return new Result(HttpStatus.OK.value(),"添加收费情况成功",null);
        }else{
            //添加收费情况失败
            throw new Exception("添加收费情况失败");
        }
    }

    @Override
    public Result updatePayment(Payment payment) throws Exception {
        Integer effort = paymentMapper.updatePayment(payment);
        if (effort != 0){
            //更新收费情况成功
            return new Result(HttpStatus.OK.value(),"更新收费情况成功",null);
        }else{
            //更新收费情况失败
            throw new Exception("更新收费情况失败");
        }
    }

    @Override
    public Result deletePayment(Integer id) throws Exception {
        Integer effort = paymentMapper.deletePayment(id);
        if (effort != 0){
            //删除收费情况成功
            return new Result(HttpStatus.OK.value(),"删除收费情况成功",null);
        }else{
            //删除收费情况失败
            throw new Exception("删除收费情况失败");
        }
    }

    @Override
    public Result findPaymentById(Integer id) {
        Payment payment = paymentMapper.findPaymentById(id);
        if (payment == null){
            //查找收费记录失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到收费记录",null);
        }
        //查找收费记录成功
        //对收费情况进行完善，需要住户名称，缴费项目名称
        //根据id获取住户信息
        Household household = householdMapper.findHouseholdById(payment.getHouseholdId());
        //获取不到住户信息，跳过
        if (household == null){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"住户信息不存在",null);
        }
        //根据id获取缴费项目
        Charge charge = chargeMapper.findChargeById(payment.getCharId());
        //获取不到缴费项目，跳过
        if (charge == null){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"缴费项目不存在",null);
        }
        PaymentVO paymentVO = VOUtil.toPaymentVO(payment);
        paymentVO.setHouseholdName(household.getName());
        paymentVO.setChargeName(charge.getName());
        return new Result(HttpStatus.OK.value(),"查找收费记录成功",paymentVO);
    }

    @Override
    public Result findPaymentPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        // 分页
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Payment> paymentList = paymentMapper.findPayment(conditionMap);
        if (paymentList == null){
            //根据条件查询收费情况失败
            throw new Exception("根据条件查询收费情况失败");
        }
        //根据条件查询收费情况成功
        //封装返回结果，需要住户名称和缴费项目名称
        List<PaymentVO> paymentVOList = new ArrayList<>();
        for (Payment payment : paymentList) {
            //对收费情况进行完善，需要住户名称，缴费项目名称
            //根据id获取住户信息
            Household household = householdMapper.findHouseholdById(payment.getHouseholdId());
            //获取不到住户信息，跳过
            if (household == null){
                continue;
            }
            //根据id获取缴费项目
            Charge charge = chargeMapper.findChargeById(payment.getCharId());
            //获取不到缴费项目，跳过
            if (charge == null){
                continue;
            }
            PaymentVO paymentVO = VOUtil.toPaymentVO(payment);
            paymentVO.setHouseholdName(household.getName());
            paymentVO.setChargeName(charge.getName());
            paymentVOList.add(paymentVO);
        }
        PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(paymentVOList));
        return new Result(HttpStatus.OK.value(),"根据条件查询收费情况成功",pageResult);
    }

    @Override
    public Result findPayment(Map<String, String> conditionMap) throws Exception {
        List<Payment> paymentList = paymentMapper.findPayment(conditionMap);
        if (paymentList == null){
            //根据条件查询收费情况失败
            throw new Exception("根据条件查询收费情况失败");
        }
        //根据条件查询收费情况成功
        //封装返回结果，需要住户名称和缴费项目名称
        List<PaymentVO> paymentVOList = new ArrayList<>();
        for (Payment payment : paymentList) {
            //对收费情况进行封装
            //根据id获取住户信息
            Household household = householdMapper.findHouseholdById(payment.getHouseholdId());
            //获取不到住户信息，跳过
            if (household == null){
                continue;
            }
            //根据id获取缴费项目
            Charge charge = chargeMapper.findChargeById(payment.getCharId());
            //获取不到缴费项目，跳过
            if (charge == null){
                continue;
            }
            PaymentVO paymentVO = VOUtil.toPaymentVO(payment);
            paymentVO.setHouseholdName(household.getName());
            paymentVO.setChargeName(charge.getName());
            paymentVOList.add(paymentVO);
        }
        return new Result(HttpStatus.OK.value(),"根据条件查询收费情况成功",paymentVOList);
    }
}
