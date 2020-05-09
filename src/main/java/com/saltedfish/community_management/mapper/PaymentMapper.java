package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 收费情况Mapper
 */
@Mapper
public interface PaymentMapper {

    /**
     * 添加收费情况
     * @param payment
     * @return
     */
    public Integer insertPayment(Payment payment);

    /**
     * 更新收费情况
     * @param payment
     * @return
     */
    public Integer updatePayment(Payment payment);

    /**
     * 删除收费情况
     * @param id
     * @return
     */
    public Integer deletePayment(@Param("id") Integer id);

    /**
     * 查询指定id的收费情况
     * @param id
     * @return
     */
    public Payment findPaymentById(@Param("id") Integer id);

    /**
     * 根据条件查询收费情况
     * @param conditionMap
     * @return
     */
    public List<Payment> findPayment(@Param("conditionMap") Map<String,String> conditionMap);

}
