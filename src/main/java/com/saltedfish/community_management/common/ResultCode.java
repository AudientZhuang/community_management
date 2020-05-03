package com.saltedfish.community_management.common;

/**
 * 返回结果信息
 */
public enum ResultCode {
    //添加住户信息
    INSERT_HOUSEHOLD_SUCCESS(1,"添加住户信息成功"),
    INSERT_HOUSEHOLD_FAILED(0,"添加住户信息失败"),
    INSERT_HOUSEHOLD_EXCEPTION(-1,"添加住户信息异常"),
    //更新住户信息
    UPDATE_HOUSEHOLD_SUCCESS(1,"更新住户信息成功"),
    UPDATE_HOUSEHOLD_FAILED(0,"更新住户信息失败"),
    UPDATE_HOUSEHOLD_EXCEPTION(-1,"更新住户信息异常"),
    //删除住户信息
    DELETE_HOUSEHOLD_SUCCESS(1,"删除住户信息成功"),
    DELETE_HOUSEHOLD_FAILED(0,"删除住户信息失败"),
    DELETE_HOUSEHOLD_EXCEPTION(-1,"删除住户信息异常"),
    //查询指定id的住户信息
    FIND_HOUSEHOLD_BY_ID_SUCCESS(1,"查询指定id的住户信息成功"),
    FIND_HOUSEHOLD_BY_ID_FAILED(0,"查询指定id的住户信息失败"),
    FIND_HOUSEHOLD_BY_ID_EXCEPTION(-1,"查询指定id的住户信息异常"),
    //根据条件查询住户信息
    FIND_HOUSEHOLD_SUCCESS(1,"根据条件查询住户信息成功"),
    //FIND_HOUSEHOLD_FAILED(0,"根据条件查询住户信息失败"),
    FIND_HOUSEHOLD_EXCEPTION(-1,"根据条件查询住户信息异常"),
    //添加活动信息
    INSERT_ACTIVITY_SUCCESS(1,"添加活动信息成功"),
    INSERT_ACTIVITY_FAILED(0,"添加活动信息失败"),
    INSERT_ACTIVITY_EXCEPTION(-1,"添加活动信息异常"),
    //更新活动信息
    UPDATE_ACTIVITY_SUCCESS(1,"更新活动信息成功"),
    UPDATE_ACTIVITY_FAILED(0,"更新活动信息失败"),
    UPDATE_ACTIVITY_EXCEPTION(-1,"更新活动信息异常"),
    //删除活动信息
    DELETE_ACTIVITY_SUCCESS(1,"删除活动信息成功"),
    DELETE_ACTIVITY_FAILED(0,"删除活动信息失败"),
    DELETE_ACTIVITY_EXCEPTION(-1,"删除活动信息异常"),
    //查询指定id的活动信息
    FIND_ACTIVITY_BY_ID_SUCCESS(1,"查询指定id的活动信息成功"),
    FIND_ACTIVITY_BY_ID_FAILED(0,"查询指定id的活动信息失败"),
    FIND_ACTIVITY_BY_ID_EXCEPTION(-1,"查询指定id的活动信息异常"),
    //根据条件查询活动信息
    FIND_ACTIVITY_SUCCESS(1,"根据条件查询活动信息成功"),
    FIND_ACTIVITY_FAILED(0,"根据条件查询活动信息失败"),
    FIND_ACTIVITY_EXCEPTION(-1,"根据条件查询活动信息异常"),
    //添加设施信息
    INSERT_FACILITY_SUCCESS(1,"添加设施信息成功"),
    INSERT_FACILITY_FAILED(0,"添加设施信息失败"),
    INSERT_FACILITY_EXCEPTION(-1,"添加设施信息异常"),
    //更新设施信息
    UPDATE_FACILITY_SUCCESS(1,"更新设施信息成功"),
    UPDATE_FACILITY_FAILED(0,"更新设施信息失败"),
    UPDATE_FACILITY_EXCEPTION(-1,"更新设施信息异常"),
    //删除设施信息
    DELETE_FACILITY_SUCCESS(1,"删除设施信息成功"),
    DELETE_FACILITY_FAILED(0,"删除设施信息失败"),
    DELETE_FACILITY_EXCEPTION(-1,"删除设施信息异常"),
    //查询指定id的设施信息
    FIND_FACILITY_BY_ID_SUCCESS(1,"查询指定id的设施信息成功"),
    FIND_FACILITY_BY_ID_FAILED(0,"查询指定id的设施信息失败"),
    FIND_FACILITY_BY_ID_EXCEPTION(-1,"查询指定id的设施信息异常"),
    //根据条件查询设施信息
    FIND_FACILITY_SUCCESS(1,"根据条件查询设施信息成功"),
    FIND_FACILITY_FAILED(0,"根据条件查询设施信息失败"),
    FIND_FACILITY_EXCEPTION(-1,"根据条件查询设施信息异常"),

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
