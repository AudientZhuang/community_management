package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Feedback;
import com.saltedfish.community_management.common.Result;
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
public class FeedbackServiceTest {

    @Autowired
    private FeedbackService feedbackService;

    @Test
    public void addFeedback(){
        //添加的反馈信息
        Feedback feedback = new Feedback();
        feedback.setHouseholdId(1);
        feedback.setContent("反馈内容11");
        feedback.setStatus(0);
        feedback.setDate(new Date(System.currentTimeMillis()));

        try {
            Result result = feedbackService.addFeedback(feedback);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateFeedback(){
        //添加的反馈信息
        Feedback feedback = new Feedback();
        feedback.setId(1);
        feedback.setHouseholdId(1);
        feedback.setContent("反馈内容11");
        feedback.setStatus(1);
        feedback.setReply("回复信息111");
        feedback.setDate(new Date(System.currentTimeMillis()));

        try {
            Result result = feedbackService.updateFeedback(feedback);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFeedback(){
        try {
            Result result = feedbackService.deleteFeedback(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findFeedbackById(){
        try {
            Result result = feedbackService.findFeedbackById(1);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findFeedback(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("status","0");
            Result result = feedbackService.findFeedback(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
