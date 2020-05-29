package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.service.ActivityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.interceptor.AbstractCacheInvoker;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ActivityController activityController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(activityController).build();
    }

    @Test
    public void addActivity() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/activity")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("image","C:/logo.png")
                .param("title","title1")
                .param("content","content1")
                .param("address","北京路")
                //.param("number","200")
                .param("startDate","2020-05-8")
                .param("endDate","2020-05-11")
                .param("deadline","2020-05-10")
                .param("publisher","lisi")
                .param("publishDate","2020-05-05");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回

    }


    @Test
    public void updateActivity() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/activity")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id","2")
                .param("image","C:/logo.png")
                .param("title","title1")
                .param("content","content1")
                .param("address","北京路")
                //.param("number","200")
                .param("startDate","2020-05-8")
                .param("endDate","2020-05-11")
                .param("deadline","2020-05-10")
                .param("publisher","lisi")
                .param("publishDate","2020-05-05");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回

    }

    @Test
    public void deleteActivity() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/activity/2")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }

    @Test
    public void findActivityById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/activity/4")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }

    @Test
    public void findActivity() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/activity")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("pageNum","1")
                .param("pageSize","4");
                //.param("publisher","lisi");
                //.param("number","200");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }

    @Test
    public void findActivityByIdAndHouseholdId() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/household/activity/14")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("hh_id", "22");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }
}
