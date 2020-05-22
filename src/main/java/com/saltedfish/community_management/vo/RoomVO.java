package com.saltedfish.community_management.vo;

import lombok.Data;

/**
 * @author Audient
 * @date 2020/5/21
 */
@Data
public class RoomVO {
    private Integer id;         //自增ID
    private Integer buildingId; //外键绑定楼栋ID
    private String buildingName;//楼栋名称
    private String roomNum;     //房间号
}
