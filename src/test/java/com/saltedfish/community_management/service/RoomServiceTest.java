package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Room;
import com.saltedfish.community_management.common.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @Test
    public void addRoom(){
        //添加的房间信息
        Room room = new Room();
        room.setBuildingId(1);
        room.setRoomNum("1-138");

        try {
            Result result = roomService.addRoom(room);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateRoom(){
        //添加的房间信息
        Room room = new Room();
        room.setId(1);
        room.setBuildingId(1);
        room.setRoomNum("1-140");

        try {
            Result result = roomService.updateRoom(room);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteRoom(){
        try {
            Result result = roomService.deleteRoom(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findRoomById(){
        try {
            Result result = roomService.findRoomById(1);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findRoom(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("buildingId","1");
            Result result = roomService.findRoom(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(200));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
