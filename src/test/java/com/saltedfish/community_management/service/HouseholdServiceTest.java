package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.vo.HouseholdVO;
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
public class HouseholdServiceTest {

    @Autowired
    private HouseholdService householdService;

    @Test
    public void addHousehold(){
        HouseholdVO householdVO = new HouseholdVO();
        householdVO.setAccount("admin");
        householdVO.setPassword("11111");
        householdVO.setName("zhangsan");
        householdVO.setGender("男");
        householdVO.setAge(18);
        householdVO.setIDcard("121212121212");
        householdVO.setTelephone("1234556");
        householdVO.setArrivalDate(new Date(System.currentTimeMillis()));
        householdVO.setIsOwner(1);
        householdVO.setBuildingId(1);
        householdVO.setRoomId(1);

        try {
            Result result = householdService.addHousehold(householdVO);
            System.out.println("返回结果为：" + result);
            Assert.assertThat(result.getStatus(),is(200));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateHousehold(){
        Household household = new Household();
        household.setId(24);
        household.setName("zhangsan");
        household.setGender("男");
        household.setAge(100);
        household.setIDcard("121212121212");
        household.setTelephone("1234556");
        household.setArrivalDate(new Date(System.currentTimeMillis()));
        household.setIsOwner(1);
        household.setBuildingId(1);
        household.setRoomId(1);
        try{
            Result result = householdService.updateHousehold(household);
            System.out.println("返回结果为：" + result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void deleteHousehold(){
        try{
            Result result = householdService.deleteHousehold(27);
            System.out.println("返回结果为：" + result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findHouseholdById(){
        try{
            Result result = householdService.findHouseholdById(26);
            System.out.println("返回结果为：" + result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findHousehold(){
        try {
            Map<String, String> conditionMap = new HashMap<>();
            conditionMap.put("gender","男");
            conditionMap.put("arrivalDate","2020-04-30");
            Result result = householdService.findHousehold(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
