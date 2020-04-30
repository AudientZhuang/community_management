package com.saltedfish.community_management.bean;

import lombok.Data;

@Data
public class Room {

    private Integer id;         //自增ID
    private Integer buildingId; //外键绑定楼栋ID
    private String roomNum;     //房间号

}
