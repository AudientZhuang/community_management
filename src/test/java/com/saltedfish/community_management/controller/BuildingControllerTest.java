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

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingControllerTest {

    @Autowired
    private BuildingController buildingController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(buildingController).build();
    }

    @Test
    public void addBuilding() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/building")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("buildName", "映翠苑");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


    @Test
    public void updateBuilding() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/building")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id","3")
                .param("buildName", "公主楼");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void deleteBuilding() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/building/4")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void findBuildingById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/building/3")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void findBuilding() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/building")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("pageNum","1")
                .param("pageSize","2")
                .param("buildName","映翠苑");

        ResultActions result = mockMvc.perform(request);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
