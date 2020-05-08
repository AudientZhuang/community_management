package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Payment;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface PaymentService {

    /**
     * 添加收费情况
     * @param payment
     * @return
     */
    public Result addPayment(Payment payment);

    /**
     * 更新收费情况
     * @param payment
     * @return
     */
    public Result updatePayment(Payment payment);

    /**
     * 删除收费情况
     * @return
     */
    public Result deletePayment(Integer id);

    /**
     * 查询指定id的收费情况
     * @param id
     * @return
     */
    public Result findPaymentById(Integer id);

    /**
     * 根据条件查询收费情况
     * @param conditionMap
     * @return
     */
    public Result findPayment(Map<String,String> conditionMap);

}
