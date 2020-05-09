package com.saltedfish.community_management.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
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
public class PaymentControllerTest {

    @Autowired
    private PaymentController paymentController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    public void addPayment() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/payment")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("householdId","3")
                .param("charId","1")
                .param("charStandard","200")
                .param("payReal","200")
                .param("payStatus","1")
                .param("payDate",new Date(Date.valueOf("2020-2-2").getTime()).toString());

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }

    @Test
    public void updatePayment() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/payment")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id","5")
                .param("householdId","3")
                .param("charId","1")
                .param("charStandard","250")
                .param("payReal","200")
                .param("payStatus","1")
                .param("payDate",new Date(Date.valueOf("2020-2-2").getTime()).toString());

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }


    @Test
    public void deletePayment() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/payment/6")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }

    @Test
    public void findPaymentById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/payment/5")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }

    @Test
    public void findPayment() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/payment")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("householdId","2");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk()) //执行状态
                .andDo(MockMvcResultHandlers.print())   //打印
                .andReturn();//返回
    }
}
