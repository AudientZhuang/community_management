package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Maintenance;
import com.saltedfish.community_management.common.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaintenanceServiceTest {

    @Autowired
    private MaintenanceService maintenanceService;


    @Test
    public void addMaintenance(){
        //添加的设施维护信息
        Maintenance maintenance = new Maintenance();
        maintenance.setContent("设施维护内容");
        maintenance.setFacilityId(1);
        maintenance.setStatus(1);
        maintenance.setCost(100.0);
        maintenance.setCreateDate(new Date(Date.valueOf("2020-1-1").getTime()));
        maintenance.setDate(new Date(Date.valueOf("2020-1-10").getTime()));
        maintenance.setNote("备注");

        try{
            Result result = maintenanceService.addMaintenance(maintenance);
            System.out.println("返回结果为：" + result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void updateMaintenance(){
        //更新的设施维护信息
        Maintenance maintenance = new Maintenance();
        maintenance.setId(1);
        maintenance.setContent("设施维护内容修改版");
        maintenance.setFacilityId(1);
        maintenance.setStatus(1);
        maintenance.setCost(110.0);
        maintenance.setCreateDate(new Date(Date.valueOf("2020-1-1").getTime()));
        maintenance.setDate(new Date(Date.valueOf("2020-1-10").getTime()));
        maintenance.setNote("备注修改版");

        try{
            Result result = maintenanceService.updateMaintenance(maintenance);
            System.out.println("返回结果：" + result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteMaintenance(){
        try {
            Result result = maintenanceService.deleteMaintenance(2);
            System.out.println("返回结果：" + result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findMaintenanceById(){
        try {
            Result result = maintenanceService.findMaintenanceById(1);
            System.out.println("返回结果：" + result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findMaintenance(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            //conditionMap.put("facilityId","2");
            Result result = maintenanceService.findMaintenance(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
