package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.FacilityCategory;
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
public class FacilityCategoryServiceTest {

    @Autowired
    private FacilityCategoryService facilityCategoryService;

    @Test
    public void addFacilityCategory(){
        //添加的设施分类
        FacilityCategory facilityCategory = new FacilityCategory();
        facilityCategory.setCateName("场地");

        try {
            Result result = facilityCategoryService.addFacilityCategory(facilityCategory);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateFacilityCategory(){
        //更新的设施分类
        FacilityCategory facilityCategory = new FacilityCategory();
        facilityCategory.setId(1);
        facilityCategory.setCateName("器具");

        try {
            Result result = facilityCategoryService.updateFacilityCategory(facilityCategory);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFacilityCategory(){
        try {
            Result result = facilityCategoryService.deleteFacilityCategory(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findFacilityCategoryById(){
        try {
            Result result = facilityCategoryService.findFacilityCategoryById(1);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findFacilityCategory(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("cateName","器具");
            Result result = facilityCategoryService.findFacilityCategory(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
