package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.mapper.HouseholdMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseholdServiceTest {

    @Autowired
    private HouseholdService householdService;

    @Test
    public void addHousehold(){
        Household household = new Household();
        //household.setAccount("root");
        //household.setPassword("admin");
        household.setName("zhangsan");
        household.setGender("男");
        household.setAge(18);
        household.setIDcard("121212121212");
        household.setTelephone("1234556");
        household.setArrivalDate(new Date(System.currentTimeMillis()));
        household.setIsOwner(1);
        household.setBuildingId(1);
        household.setRoomId(1);

        try {
            Result result = householdService.addHousehold(household);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
