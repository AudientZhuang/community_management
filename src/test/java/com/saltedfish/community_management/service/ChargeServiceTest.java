package com.saltedfish.community_management.service;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.saltedfish.community_management.bean.Charge;
import com.saltedfish.community_management.common.Result;
import org.junit.Assert;
import org.junit.Test;
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
public class ChargeServiceTest {

    @Autowired
    private ChargeService chargeService;

    @Test
    public void addCharge(){
        //添加的缴费项目
        Charge charge = new Charge();
        charge.setName("水费");
        charge.setDescription("交水费啦");
        charge.setStandard(100.0);
        charge.setCreationDate(new Date(System.currentTimeMillis()));

        try {
            Result result = chargeService.addCharge(charge);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateCharge(){
        //添加的缴费项目
        Charge charge = new Charge();
        charge.setId(1);
        charge.setName("电费费");
        charge.setDescription("交电费费啦");
        charge.setStandard(150.0);
        charge.setCreationDate(new Date(System.currentTimeMillis()));

        try {
            Result result = chargeService.updateCharge(charge);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteCharge(){
        try {
            Result result = chargeService.deleteCharge(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findChargeById(){
        try {
            Result result = chargeService.findChargeById(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findCharge(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("name","电费");
            Result result = chargeService.findCharge(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
