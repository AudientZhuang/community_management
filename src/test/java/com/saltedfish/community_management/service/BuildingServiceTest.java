package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Building;
import com.saltedfish.community_management.common.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingServiceTest {

    @Autowired
    private BuildingService buildingService;

    @Test
    public void addBuilding(){
        //添加的楼栋信息
        Building building = new Building();
        building.setBuildName("紫荆苑");
        try {
            Result result = buildingService.addBuilding(building);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateBuilding(){
        //修改的楼栋信息
        Building building = new Building();
        building.setId(1);
        building.setBuildName("公主楼");

        try {
            Result result = buildingService.updateBuilding(building);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteBuilding(){
        try {
            Result result = buildingService.deleteBuilding(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findBuildingById(){
        try {
            Result result = buildingService.findBuildingById(1);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findBuilding(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("buildName","公主楼");
            Result result = buildingService.findBuilding(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
