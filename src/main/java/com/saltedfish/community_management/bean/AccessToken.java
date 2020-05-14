package com.saltedfish.community_management.bean;

import lombok.Data;

@Data
public class AccessToken {
    private String access_token; //小程序全局唯一后台接口调用凭证
    private Integer expires_in; //凭证有效时间
}
