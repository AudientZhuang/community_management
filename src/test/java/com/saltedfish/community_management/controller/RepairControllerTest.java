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
public class RepairControllerTest {

    @Autowired
    private RepairController repairController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(repairController).build();
    }

    @Test
    public void addRepair() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/repair")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("householdId","2")
                .param("name","lisi")
                .param("telephone","2222222")
                .param("content","content222")
                .param("status","0")
                .param("date","2020-2-20")
                .param("reply","回复消息");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }

    @Test
    public void updateRepair() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/repair")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id","4")
                .param("householdId","2")
                .param("name","lisi")
                .param("telephone","3333")
                .param("content","content222")
                .param("status","0")
                .param("date","2020-2-20")
                .param("reply","回复消息");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }

    @Test
    public void deleteRepair() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/repair/5")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }

    @Test
    public void findRepairById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/repair/4")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }

    @Test
    public void findRepair() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/repair")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("pageNum","1")
                .param("pageSize","2")
                .param("householdId","1");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }

}
