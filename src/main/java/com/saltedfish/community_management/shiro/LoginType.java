package com.saltedfish.community_management.shiro;

/**
 * @author Audient
 * @date 2020/6/2
 */
public enum LoginType {
    PASSWORD("password"), // 密码登录
    NOPASSWD("nopassword"); // 免密登录
    private String code;// 状态值
    private LoginType(String code) {
        this.code = code;
    }
    public String getCode () {
        return code;
    }
}
