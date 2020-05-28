package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Payment;
import com.saltedfish.community_management.common.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {
    @Autowired
    private PaymentService paymentService;

    @Test
    public void addPayment(){
        //添加的收费情况
        Payment payment = new Payment();
        payment.setHouseholdId(2);
        payment.setCharId(1);
        payment.setCharStandard(90.0);
        payment.setPayReal(100.0);
        payment.setPayStatus(1);
        payment.setPayDate(new Date(System.currentTimeMillis()));
        try {
            Result result = paymentService.addPayment(payment);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updatePayment(){
        //更新的的收费情况
        Payment payment = new Payment();
        payment.setId(1);
        payment.setHouseholdId(1);
        payment.setCharId(1);
        payment.setCharStandard(90.0);
        payment.setPayReal(100.0);
        payment.setPayStatus(1);
        payment.setPayDate(new Date(System.currentTimeMillis()));
        try {
            Result result = paymentService.updatePayment(payment);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deletePayment(){
        try {
            Result result = paymentService.deletePayment(1);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findPaymentById(){
        try {
            Result result = paymentService.findPaymentById(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
             e.printStackTrace();
        }
    }

    @Test
    public void findPayment(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("householdId","1");
            Result result = paymentService.findPayment(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
