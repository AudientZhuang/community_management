package com.saltedfish.community_management.bean;

import lombok.Data;

@Data
public class OpenIdJson {
    private String openid; //用户唯一标识
    private String session_key; //状态码
}
