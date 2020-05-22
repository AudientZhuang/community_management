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
public class NewsControllerTest {

    @Autowired
    private NewsController newsController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(newsController).build();
    }

    @Test
    public void addFacility() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/news")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("image","D:/ereere")
                .param("title","新闻标题221222")
                .param("content","新闻内容222222")
                .param("author","作者22222")
                .param("date",new Date(Date.valueOf("2020-01-31").getTime()).toString());

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void updateFacility() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/news")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id","3")
                .param("image","D:/ereere")
                .param("title","新闻标题221222修改")
                .param("content","新闻内容222222修改")
                .param("author","作者22222")
                .param("date",new Date(Date.valueOf("2020-01-31").getTime()).toString());

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void deleteFacility() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/news/4")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void findFacilityById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/news/3")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void findFacility() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/news")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("pageNum","1")
                .param("pageSize","2")
                .param("author","作者22222");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
