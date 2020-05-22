package com.saltedfish.community_management.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class ActivityRegisterControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ActivityRegisterController activityRegisterController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(activityRegisterController).build();
    }

    @Test
    public void addActivityRegister() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/activityRegister")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("act_id","1")
                .param("hh_id","1")
                .param("telephone","11212323")
                .param("num","1");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回

    }


    @Test
    public void updateActivityRegister() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/activityRegister")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id","1")
                .param("act_id","1")
                .param("hh_id","1")
                .param("telephone","222222")
                .param("num","1");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回

    }

    @Test
    public void deleteActivityRegister() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/activityRegister/2")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }

    @Test
    public void findActivityRegisterById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/activityRegister/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }

    @Test
    public void findActivityRegister() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/activityRegister")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);
                //.param("pageNum","1")
                //.param("pageSize","2");
                //.param("act_id","1");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }
}
