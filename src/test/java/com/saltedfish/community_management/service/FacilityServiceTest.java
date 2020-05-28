package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Facility;
import com.saltedfish.community_management.common.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacilityServiceTest {

    @Autowired
    private FacilityService facilityService;

    @Test
    public void addFacility(){
        //添加的设施信息
        Facility facility = new Facility();
        facility.setCateId(2);
        facility.setName("篮球场");
        facility.setNum(1);
        facility.setPrice(20000.0);
        facility.setPurchaseDate(new Date(System.currentTimeMillis()));
        try{
            Result result = facilityService.addFacility(facility);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateFacility(){
        //添加的设施信息
        Facility facility = new Facility();
        facility.setId(2);
        facility.setCateId(2);
        facility.setName("篮球场");
        facility.setNum(1);
        facility.setPrice(20000.0);
        facility.setPurchaseDate(new Date(System.currentTimeMillis()));
        try{
            Result result = facilityService.updateFacility(facility);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFacility(){
        try {
            Result result = facilityService.deleteFacility(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findFacilityById(){
        try{
            Result result = facilityService.findFacilityById(4);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findFacility(){
        try{
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("name","乒乓球桌");
            Result result = facilityService.findFacility(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();

        }
    }


}
