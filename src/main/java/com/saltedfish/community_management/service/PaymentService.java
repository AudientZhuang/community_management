package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Payment;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface PaymentService {

    /**
     * 添加收费情况
     * @param payment
     * @return
     */
    Result addPayment(Payment payment) throws Exception;

    /**
     * 更新收费情况
     * @param payment
     * @return
     */
    Result updatePayment(Payment payment) throws Exception;

    /**
     * 删除收费情况
     * @return
     */
    Result deletePayment(Integer id) throws Exception;

    /**
     * 查询指定id的收费情况
     * @param id
     * @return
     */
    Result findPaymentById(Integer id);

    /**
     * 根据条件查询收费情况，需要分页
     * @param conditionMap
     * @return
     */
    Result findPaymentPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询收费情况，不需要分页
     * @param conditionMap
     * @return
     */
    Result findPayment(Map<String,String> conditionMap) throws Exception;

}
