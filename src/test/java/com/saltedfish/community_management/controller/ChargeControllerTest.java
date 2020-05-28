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
public class ChargeControllerTest {

    @Autowired
    private ChargeController chargeController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(chargeController).build();
    }

    @Test
    public void addCharge() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/charge")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("name","水费")
                .param("description","gkd")
                .param("standard","200")
                .param("creationDate","2020-1-1")
                .param("note","note...");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void updateCharge() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/charge")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id","6")
                .param("name","电费")
                .param("description","电费gkd")
                .param("standard","250")
                .param("creationDate","2020-1-1")
                .param("note","note...");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void deleteCharge() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/charge/6")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void findChargeById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/charge/3")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void findCharge() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/charge")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("pageNum","1")
                .param("pageSize","2")
                .param("standard","100");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
