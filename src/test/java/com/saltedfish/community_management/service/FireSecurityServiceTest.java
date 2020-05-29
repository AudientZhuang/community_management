package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.FireSecurity;
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
public class FireSecurityServiceTest {

    @Autowired
    private FireSecurityService fireSecurityService;

    @Test
    public void addFireSecurity(){
        //添加的消防检查情况
        FireSecurity fireSecurity = new FireSecurity();
        fireSecurity.setBuildId(1);
        fireSecurity.setCheckContent("检查内容");
        fireSecurity.setCreateDate(new Date(System.currentTimeMillis()));
        fireSecurity.setCheckDate(new Date(System.currentTimeMillis()));
        fireSecurity.setLevel(0);
        try {
            Result result = fireSecurityService.addFireSecurity(fireSecurity);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateFireSecurity(){
        //添加的消防检查情况
        FireSecurity fireSecurity = new FireSecurity();
        fireSecurity.setId(1);
        fireSecurity.setBuildId(1);
        fireSecurity.setCheckContent("检查内容修改版");
        fireSecurity.setCreateDate(new Date(System.currentTimeMillis()));
        fireSecurity.setCheckDate(new Date(System.currentTimeMillis()));
        fireSecurity.setUpdateDate(new Date(System.currentTimeMillis()));
        fireSecurity.setLevel(1);
        try {
            Result result = fireSecurityService.updateFireSecurity(fireSecurity);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFireSecurity(){
        try {
            Result result = fireSecurityService.deleteFireSecurity(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findFireSecurityById(){
        try {
            Result result = fireSecurityService.findFireSecurityById(1);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findFireSecurity(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("level","1");
            Result result = fireSecurityService.findFireSecurity(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
