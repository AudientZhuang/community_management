package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Payment;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 收费情况
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 添加收费情况
     * @param payment
     * @return
     */
    @PostMapping("/payment")
    public Result addPayment(Payment payment){
        try {
            //对前端信息进行校验

            //添加收费情况到数据库
            Result result = paymentService.addPayment(payment);
            if (result.getStatus() != ResultCode.INSERT_PAYMENT_EXCEPTION.getStatus()){
                //添加收费情况没有异常
                return result;
            }else{
                //添加收费情况出现异常
                throw new Exception(ResultCode.INSERT_PAYMENT_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 更新收费情况
     * @param payment
     * @return
     */
    @PutMapping("/payment")
    public Result updatePayment(Payment payment){
        try{
            //对前端信息进行校验

            //更新收费情况到数据库
            Result result = paymentService.updatePayment(payment);
            if (result.getStatus() != ResultCode.UPDATE_PAYMENT_EXCEPTION.getStatus()){
                //更新收费情况没有异常
                return result;
            }else{
                //更新收费情况出现异常
                throw new Exception(ResultCode.UPDATE_PAYMENT_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 删除收费情况
     * @param id
     * @return
     */
    @DeleteMapping("/payment/{id}")
    public Result deletePayment(@PathVariable("id") Integer id){
        try {
            Result result = paymentService.deletePayment(id);
            if (result.getStatus() != ResultCode.DELETE_PAYMENT_EXCEPTION.getStatus()){
                //删除收费记录没有异常
                return result;
            }else {
                //删除收费记录出现异常
                throw new Exception(ResultCode.DELETE_PAYMENT_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 查询指定id的收费情况
     * @param id
     * @return
     */
    @GetMapping("/payment/{id}")
    public Result findPaymentById(@PathVariable("id") Integer id){
        try {
            Result result = paymentService.findPaymentById(id);
            if (result.getStatus() != ResultCode.FIND_PAYMENT_BY_ID_EXCEPTION.getStatus()){
                //查询指定id的收费情况没有异常
                return result;
            }else{
                //查询指定id的收费情况出现异常
                throw new Exception(ResultCode.FIND_PAYMENT_BY_ID_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 根据条件查询收费情况
     * @param request
     * @return
     */
    @GetMapping("/payment")
    public Result findPayment(HttpServletRequest request){
        try {
            //获取条件参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String,String> conditionMap = new HashMap<>();
            if (parameterMap.size() >= 0){
                //参数为空时也可以运行
                for (String key: parameterMap.keySet()) {
                    conditionMap.put(key, parameterMap.get(key)[0]);
                }
                Result result = paymentService.findPayment(conditionMap);
                if (result.getStatus() != ResultCode.FIND_PAYMENT_EXCEPTION.getStatus()){
                    //根据条件查询收费情况没有异常
                    return result;
                }else{
                    //根据条件查询收费情况出现异常
                    throw new Exception(ResultCode.FIND_PAYMENT_EXCEPTION.getMessage());
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
