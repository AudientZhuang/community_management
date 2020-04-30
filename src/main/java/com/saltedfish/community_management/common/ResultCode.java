package com.saltedfish.community_management.common;

/**
 * 返回结果信息
 */
public enum ResultCode {
    //添加住户信息
    INSERT_HOUSEHOLD_SUCCESS(1,"添加住户信息成功"),
    INSERT_HOUSEHOLD_FAILED(0,"添加住户信息失败"),
    INSERT_HOUSEHOLD_EXCEPTION(-1,"添加住户信息异常"),
    SYSTEM_BUSY(-1,"系统繁忙"),
    LOGIN_SUCCESS(1,"登陆成功");

    private Integer status;
    private String message;

    ResultCode(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
