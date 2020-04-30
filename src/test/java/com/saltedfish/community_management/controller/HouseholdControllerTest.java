package com.saltedfish.community_management.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.servlet.function.RequestPredicates.param;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureMockMvc
public class HouseholdControllerTest {

    //@Autowired
    private MockMvc mockMvc;

    @Autowired
    private HouseholdController householdController;

    @Before
    public void setup() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(householdController).build();
    }

    @Test
    public void addHousehold() throws Exception{

        RequestBuilder request = MockMvcRequestBuilders.post("/household")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                //.param("account", "root")
                //.param("password", "admin")
                .param("name", "zhangsan")
                .param("gender", "男")
                .param("age", "18")
                .param("telephone", "12345678")
                .param("IDcard", "19981024014")
                .param("arrivalDate", new Date(System.currentTimeMillis()).toString())
                .param("isOwner", "0")
                .param("buildingId", "1")
                .param("roomId", "1");

        ResultActions result = mockMvc.perform(request);

        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())   //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();      //返回


    }


}
