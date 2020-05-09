package com.saltedfish.community_management.service.impl;

import com.saltedfish.community_management.bean.Payment;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.PaymentMapper;
import com.saltedfish.community_management.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Result addPayment(Payment payment) {
        Result result = new Result();
        try{
            Integer effort = paymentMapper.insertPayment(payment);
            if (effort != 0){
                //添加收费情况成功
                result.setStatus(ResultCode.INSERT_PAYMENT_SUCCESS.getStatus());
                result.setMessage(ResultCode.INSERT_PAYMENT_SUCCESS.getMessage());
            }else{
                //添加收费情况失败
                result.setStatus(ResultCode.INSERT_PAYMENT_FAILED.getStatus());
                result.setMessage(ResultCode.INSERT_PAYMENT_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.INSERT_PAYMENT_EXCEPTION.getStatus());
            result.setMessage(ResultCode.INSERT_PAYMENT_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result updatePayment(Payment payment) {
        Result result = new Result();
        try{
            Integer effort = paymentMapper.updatePayment(payment);
            if (effort != 0){
                //更新收费情况成功
                result.setStatus(ResultCode.UPDATE_PAYMENT_SUCCESS.getStatus());
                result.setMessage(ResultCode.UPDATE_PAYMENT_SUCCESS.getMessage());
            }else{
                //更新收费情况失败
                result.setStatus(ResultCode.UPDATE_PAYMENT_FAILED.getStatus());
                result.setMessage(ResultCode.UPDATE_PAYMENT_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.UPDATE_PAYMENT_EXCEPTION.getStatus());
            result.setMessage(ResultCode.UPDATE_PAYMENT_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result deletePayment(Integer id) {
        Result result = new Result();
        try {
            Integer effort = paymentMapper.deletePayment(id);
            if (effort != 0){
                //删除收费情况成功
                result.setStatus(ResultCode.DELETE_PAYMENT_SUCCESS.getStatus());
                result.setMessage(ResultCode.DELETE_PAYMENT_SUCCESS.getMessage());
            }else{
                //删除收费情况失败
                result.setStatus(ResultCode.DELETE_PAYMENT_FAILED.getStatus());
                result.setMessage(ResultCode.DELETE_PAYMENT_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.DELETE_PAYMENT_EXCEPTION.getStatus());
            result.setMessage(ResultCode.DELETE_PAYMENT_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findPaymentById(Integer id) {
        Result result = new Result();
        try{
            Payment payment = paymentMapper.findPaymentById(id);
            if (payment != null){
                //查找收费记录成功
                result.setStatus(ResultCode.FIND_PAYMENT_BY_ID_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_PAYMENT_BY_ID_SUCCESS.getMessage());
                result.setData(payment);
            }else{
                //查找收费记录失败
                result.setStatus(ResultCode.FIND_PAYMENT_BY_ID_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_PAYMENT_BY_ID_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_PAYMENT_BY_ID_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_PAYMENT_BY_ID_EXCEPTION.getMessage());
            return result;
        }
    }

    @Override
    public Result findPayment(Map<String, String> conditionMap) {
        Result result = new Result();
        try {
            List<Payment> paymentList = paymentMapper.findPayment(conditionMap);
            if (paymentList != null){
                //根据条件查询收费情况成功
                result.setStatus(ResultCode.FIND_PAYMENT_SUCCESS.getStatus());
                result.setMessage(ResultCode.FIND_PAYMENT_SUCCESS.getMessage());
                result.setData(paymentList);
            }else{
                //根据条件查询收费情况失败
                result.setStatus(ResultCode.FIND_PAYMENT_FAILED.getStatus());
                result.setMessage(ResultCode.FIND_PAYMENT_FAILED.getMessage());
            }
            return result;
        }catch (Exception e){
            //捕获异常
            result.setStatus(ResultCode.FIND_PAYMENT_EXCEPTION.getStatus());
            result.setMessage(ResultCode.FIND_PAYMENT_EXCEPTION.getMessage());
            return result;
        }
    }
}
