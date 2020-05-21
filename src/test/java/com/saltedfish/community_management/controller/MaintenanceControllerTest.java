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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaintenanceControllerTest {

    @Autowired
    private MaintenanceController maintenanceController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(maintenanceController).build();
    }

    @Test
    public void addMaintenance() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/maintenance")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("facilityId", "2")
                .param("content", "内容2")
                .param("status", "0")
                .param("cost", "200")
                .param("createDate", new Date(Date.valueOf("2020-2-1").getTime()).toString())
                .param("date", new Date(Date.valueOf("2020-2-5").getTime()).toString())
                .param("note", "备注2");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }


    @Test
    public void updateMaintenance() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/maintenance")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id","4")
                .param("facilityId", "2")
                .param("content", "内容2")
                .param("status", "0")
                .param("cost", "200")
                .param("createDate", new Date(Date.valueOf("2020-2-1").getTime()).toString())
                .param("date", new Date(Date.valueOf("2020-2-5").getTime()).toString())
                .param("note", "备注22222");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }

    @Test
    public void deleteMaintenance() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/maintenance/5")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }


    @Test
    public void findMaintenanceById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/maintenance/4")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }

    @Test
    public void findMaintenance() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/maintenance")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("pageNum","1")
                .param("pageSize","2")
                .param("facilityId","2");
        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回
    }

}
