package com.saltedfish.community_management.bean;

import lombok.Data;

@Data
public class OpenId {

    private String openid; //用户微信唯一标识
    private String session_key; //会话秘钥
}
