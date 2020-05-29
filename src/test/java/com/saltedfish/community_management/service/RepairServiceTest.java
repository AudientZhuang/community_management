package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Repair;
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
public class RepairServiceTest {

    @Autowired
    private RepairService repairService;

    @Test
    public void addRepair(){
        //添加的住户申报维修信息
        Repair repair = new Repair();
        repair.setHouseholdId(1);
        repair.setName("zhangsan");
        repair.setContent("维修内容1");
        repair.setStatus(1);
        repair.setTelephone("123456");
        repair.setDate(new Date(System.currentTimeMillis()));
        repair.setReply("回复信息1");

        try {
            Result result = repairService.addRepair(repair);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateRepair(){
        //更新的住户申报维修信息
        Repair repair = new Repair();
        repair.setId(1);
        repair.setHouseholdId(1);
        repair.setName("zhangsan");
        repair.setContent("维修内容2");
        repair.setStatus(1);
        repair.setTelephone("123456890");
        repair.setDate(new Date(System.currentTimeMillis()));
        repair.setReply("回复信息2");

        try {
            Result result = repairService.updateRepair(repair);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteRepair(){
        try {
            Result result = repairService.deleteRepair(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findRepairById(){
        try {
            Result result = repairService.findRepairById(1);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findRepair(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("status","1");
            Result result = repairService.findRepair(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
