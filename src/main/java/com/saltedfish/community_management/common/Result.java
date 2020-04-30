package com.saltedfish.community_management.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定义返回到前端的对象格式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer status;     //状态值
    private String message; //状态信息
    private Object data;    //数据对象
}
