package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Activity;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.mapper.ActivityMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityServiceTest {

    @Autowired
    private ActivityService activityService;

    @Test
    public void addActivity(){
        //添加的活动信息
        Activity activity = new Activity();
        activity.setImage("D:/img/1.jpg");
        activity.setTitle("活动1");
        activity.setContent("内容1111111");
        activity.setAddress("人民南路");
        activity.setNumber(100);
        activity.setDate(new Date(Date.valueOf("2020-5-11").getTime()));
        activity.setPublisher("root");
        activity.setPublishDate(new Date(System.currentTimeMillis()));

        try{
            Result result = activityService.addActivity(activity);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void updateActivity(){
        //修改的活动信息
        Activity activity = new Activity();
        activity.setId(1);
        activity.setImage("D:/img/1.jpg");
        activity.setTitle("活动1");
        activity.setContent("内容1111111");
        activity.setAddress("人民南路");
        activity.setNumber(100);
        activity.setDate(new Date(Date.valueOf("2020-5-11").getTime()));
        activity.setPublisher("root");
        activity.setPublishDate(new Date(System.currentTimeMillis()));

        try {
            Result result = activityService.updateActivity(activity);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteActivity(){
        try{
            Result result = activityService.deleteActivity(1);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findActivityById(){
        try{
            Result result = activityService.findActivityById(3);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findActivity(){
        try{
            Map<String,String> conditionMap = new HashMap<>();
            //conditionMap.put("number","100");
            //conditionMap.put("publisher","root");
            PageRequest pageRequest = new PageRequest();
            pageRequest.setPageNum(1);
            pageRequest.setPageSize(5);
            Result result = activityService.findActivityPage(pageRequest,conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
