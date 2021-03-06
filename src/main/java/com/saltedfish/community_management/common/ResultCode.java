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

    //社区账号登录
    LOGIN_USER_SUCCESS(1,"社区账号登录成功"),
    LOGIN_USER_FAILED(0,"社区账号登录失败"),
    LOGIN_USER_EXCEPTION(-1,"社区账号登录异常"),
    //微信登录
    LOGIN_WX_SUCCESS(1,"微信登录成功"),
    LOGIN_WX_FAILED(0,"微信登录失败"),
    LOGIN_WX_EXCEPTION(-1,"微信登录异常"),
    //绑定微信
    BIND_WX_SUCESS(1,"绑定微信成功"),
    BIND_WX_FAILED(0,"绑定微信失败"),
    BIND_WX_EXCEPTION(-1,"绑定微信异常"),
    //查询指定hh_id的用户是否绑定微信
    FIND_USER_ISBIND_BY_ID_SUCCESS(1,"查询指定hh_id的用户是否绑定微信成功"),
    FIND_USER_ISBIND_BY_ID_FAILED(0,"查询指定hh_id的用户否绑定微信失败"),
    FIND_USER_ISBIND_BY_ID_EXCEPTION(-1,"查询指定hh_id的用户否绑定微信异常"),
    //添加用户信息
    INSERT_USER_SUCCESS(1,"添加用户信息成功"),
    INSERT_USER_FAILED(0,"添加用户信息失败"),
    INSERT_USER_EXCEPTION(-1,"添加用户信息异常"),

    //获取access_token
    GET_ACCESSTOKEN_SUCCESS(1,"获取access_token成功"),
    GET_ACCESSTOKEN_FAILED(0,"获取access_token失败"),
    GET_ACCESSTOKEN_EXCEPTION(1,"获取access_token异常"),

    //添加设施维护信息
    INSERT_MAINTENANCE_SUCCESS(1,"添加设施维护信息成功"),
    INSERT_MAINTENANCE_FAILED(0,"添加设施维护信息失败"),
    INSERT_MAINTENANCE_EXCEPTION(-1,"添加设施维护信息异常"),
    //更新设施维护信息
    UPDATE_MAINTENANCE_SUCCESS(1,"更新设施维护信息成功"),
    UPDATE_MAINTENANCE_FAILED(0,"更新设施维护信息失败"),
    UPDATE_MAINTENANCE_EXCEPTION(-1,"更新设施维护信息异常"),
    //删除设施维护信息
    DELETE_MAINTENANCE_SUCCESS(1,"删除设施维护信息成功"),
    DELETE_MAINTENANCE_FAILED(0,"删除设施维护信息失败"),
    DELETE_MAINTENANCE_EXCEPTION(-1,"删除设施维护信息异常"),
    //查询指定id的设施维护信息
    FIND_MAINTENANCE_BY_ID_SUCCESS(1,"查询指定id的设施维护信息成功"),
    FIND_MAINTENANCE_BY_ID_FAILED(0,"查询指定id的设施维护信息失败"),
    FIND_MAINTENANCE_BY_ID_EXCEPTION(-1,"查询指定id的设施维护信息异常"),
    //根据条件查询设施维护信息
    FIND_MAINTENANCE_SUCCESS(1,"根据条件查询设施维护信息成功"),
    FIND_MAINTENANCE_FAILED(0,"根据条件查询设施维护信息失败"),
    FIND_MAINTENANCE_EXCEPTION(-1,"根据条件查询设施维护信息异常"),

    //添加收费情况
    INSERT_PAYMENT_SUCCESS(1,"添加收费情况成功"),
    INSERT_PAYMENT_FAILED(0,"添加收费情况失败"),
    INSERT_PAYMENT_EXCEPTION(-1,"添加收费情况异常"),
    //更新收费情况
    UPDATE_PAYMENT_SUCCESS(1,"更新收费情况成功"),
    UPDATE_PAYMENT_FAILED(0,"更新收费情况失败"),
    UPDATE_PAYMENT_EXCEPTION(-1,"更新收费情况异常"),
    //删除收费情况
    DELETE_PAYMENT_SUCCESS(1,"删除收费情况成功"),
    DELETE_PAYMENT_FAILED(0,"删除收费情况失败"),
    DELETE_PAYMENT_EXCEPTION(-1,"删除收费情况异常"),
    //查询指定id的收费情况
    FIND_PAYMENT_BY_ID_SUCCESS(1,"查询指定id的收费情况成功"),
    FIND_PAYMENT_BY_ID_FAILED(0,"查询指定id的收费情况失败"),
    FIND_PAYMENT_BY_ID_EXCEPTION(-1,"查询指定id的收费情况异常"),
    //根据条件查询收费情况
    FIND_PAYMENT_SUCCESS(1,"根据条件查询收费情况成功"),
    FIND_PAYMENT_FAILED(0,"根据条件查询收费情况失败"),
    FIND_PAYMENT_EXCEPTION(-1,"根据条件查询收费情况异常"),


    //添加住户申报维修信息
    INSERT_REPAIR_SUCCESS(1,"添加住户申报维修信息成功"),
    INSERT_REPAIR_FAILED(0,"添加住户申报维修信息失败"),
    INSERT_REPAIR_EXCEPTION(-1,"添加住户申报维修信息异常"),
    //更新住户申报维修信息
    UPDATE_REPAIR_SUCCESS(1,"更新住户申报维修信息成功"),
    UPDATE_REPAIR_FAILED(0,"更新住户申报维修信息失败"),
    UPDATE_REPAIR_EXCEPTION(-1,"更新住户申报维修信息异常"),
    //删除住户申报维修信息
    DELETE_REPAIR_SUCCESS(1,"删除住户申报维修信息成功"),
    DELETE_REPAIR_FAILED(0,"删除住户申报维修信息失败"),
    DELETE_REPAIR_EXCEPTION(-1,"删除住户申报维修信息异常"),
    //查询指定id的住户申报维修信息
    FIND_REPAIR_BY_ID_SUCCESS(1,"查询指定id的住户申报维修信息成功"),
    FIND_REPAIR_BY_ID_FAILED(0,"查询指定id的住户申报维修信息失败"),
    FIND_REPAIR_BY_ID_EXCEPTION(-1,"查询指定id的住户申报维修信息异常"),
    //根据条件查询住户申报维修信息
    FIND_REPAIR_SUCCESS(1,"根据条件查询住户申报维修信息成功"),
    FIND_REPAIR_FAILED(0,"根据条件查询住户申报维修信息失败"),
    FIND_REPAIR_EXCEPTION(-1,"根据条件查询住户申报维修信息异常"),

    //添加消防检查情况
    INSERT_FIRE_SECURITY_SUCCESS(1,"添加消防检查情况成功"),
    INSERT_FIRE_SECURITY_FAILED(0,"添加消防检查情况失败"),
    INSERT_FIRE_SECURITY_EXCEPTION(-1,"添加消防检查情况异常"),
    //更新消防检查情况
    UPDATE_FIRE_SECURITY_SUCCESS(1,"更新消防检查情况成功"),
    UPDATE_FIRE_SECURITY_FAILED(0,"更新消防检查情况失败"),
    UPDATE_FIRE_SECURITY_EXCEPTION(-1,"更新消防检查情况异常"),
    //删除消防检查情况
    DELETE_FIRE_SECURITY_SUCCESS(1,"删除消防检查情况成功"),
    DELETE_FIRE_SECURITY_FAILED(0,"删除消防检查情况失败"),
    DELETE_FIRE_SECURITY_EXCEPTION(-1,"删除消防检查情况异常"),
    //查询指定id的消防检查情况
    FIND_FIRE_SECURITY_BY_ID_SUCCESS(1,"查询指定id的消防检查情况成功"),
    FIND_FIRE_SECURITY_BY_ID_FAILED(0,"查询指定id的消防检查情况失败"),
    FIND_FIRE_SECURITY_BY_ID_EXCEPTION(-1,"查询指定id的消防检查情况异常"),
    //根据条件查询消防检查情况
    FIND_FIRE_SECURITY_SUCCESS(1,"根据条件查询消防检查情况成功"),
    FIND_FIRE_SECURITY_FAILED(0,"根据条件查询消防检查情况失败"),
    FIND_FIRE_SECURITY_EXCEPTION(-1,"根据条件查询消防检查情况异常"),

    //添加反馈信息
    INSERT_FEEDBACK_SUCCESS(1,"添加反馈信息成功"),
    INSERT_FEEDBACK_FAILED(0,"添加反馈信息失败"),
    INSERT_FEEDBACK_EXCEPTION(-1,"添加反馈信息异常"),
    //更新反馈信息
    UPDATE_FEEDBACK_SUCCESS(1,"更新反馈信息成功"),
    UPDATE_FEEDBACK_FAILED(0,"更新反馈信息失败"),
    UPDATE_FEEDBACK_EXCEPTION(-1,"更新反馈信息异常"),
    //删除反馈信息
    DELETE_FEEDBACK_SUCCESS(1,"删除反馈信息成功"),
    DELETE_FEEDBACK_FAILED(0,"删除反馈信息失败"),
    DELETE_FEEDBACK_EXCEPTION(-1,"删除反馈信息异常"),
    //查询指定id的反馈信息
    FIND_FEEDBACK_BY_ID_SUCCESS(1,"查询指定id的反馈信息成功"),
    FIND_FEEDBACK_BY_ID_FAILED(0,"查询指定id的反馈信息失败"),
    FIND_FEEDBACK_BY_ID_EXCEPTION(-1,"查询指定id的反馈信息异常"),
    //根据条件查询反馈信息
    FIND_FEEDBACK_SUCCESS(1,"根据条件查询反馈信息成功"),
    FIND_FEEDBACK_FAILED(0,"根据条件查询反馈信息失败"),
    FIND_FEEDBACK_EXCEPTION(-1,"根据条件查询反馈信息异常"),

    //添加楼栋信息
    INSERT_BUILDING_SUCCESS(1,"添加楼栋信息成功"),
    INSERT_BUILDING_FAILED(0,"添加楼栋信息失败"),
    INSERT_BUILDING_EXCEPTION(-1,"添加楼栋信息异常"),
    //更新楼栋信息
    UPDATE_BUILDING_SUCCESS(1,"更新楼栋信息成功"),
    UPDATE_BUILDING_FAILED(0,"更新楼栋信息失败"),
    UPDATE_BUILDING_EXCEPTION(-1,"更新楼栋信息异常"),
    //删除楼栋信息
    DELETE_BUILDING_SUCCESS(1,"删除楼栋信息成功"),
    DELETE_BUILDING_FAILED(0,"删除楼栋信息失败"),
    DELETE_BUILDING_EXCEPTION(-1,"删除楼栋信息异常"),
    //查询指定id的楼栋信息
    FIND_BUILDING_BY_ID_SUCCESS(1,"查询指定id的楼栋信息成功"),
    FIND_BUILDING_BY_ID_FAILED(0,"查询指定id的楼栋信息失败"),
    FIND_BUILDING_BY_ID_EXCEPTION(-1,"查询指定id的楼栋信息异常"),
    //根据条件查询楼栋信息
    FIND_BUILDING_SUCCESS(1,"根据条件查询楼栋信息成功"),
    FIND_BUILDING_FAILED(0,"根据条件查询楼栋信息失败"),
    FIND_BUILDING_EXCEPTION(-1,"根据条件查询楼栋信息异常"),

    //添加房间信息
    INSERT_ROOM_SUCCESS(1,"添加房间信息成功"),
    INSERT_ROOM_FAILED(0,"添加房间信息失败"),
    INSERT_ROOM_EXCEPTION(-1,"添加房间信息异常"),
    //更新房间信息
    UPDATE_ROOM_SUCCESS(1,"更新房间信息成功"),
    UPDATE_ROOM_FAILED(0,"更新房间信息失败"),
    UPDATE_ROOM_EXCEPTION(-1,"更新房间信息异常"),
    //删除房间信息
    DELETE_ROOM_SUCCESS(1,"删除房间信息成功"),
    DELETE_ROOM_FAILED(0,"删除房间信息失败"),
    DELETE_ROOM_EXCEPTION(-1,"删除房间信息异常"),
    //查询指定id的房间信息
    FIND_ROOM_BY_ID_SUCCESS(1,"查询指定id的房间信息成功"),
    FIND_ROOM_BY_ID_FAILED(0,"查询指定id的房间信息失败"),
    FIND_ROOM_BY_ID_EXCEPTION(-1,"查询指定id的房间信息异常"),
    //根据条件查询房间信息
    FIND_ROOM_SUCCESS(1,"根据条件查询房间信息成功"),
    FIND_ROOM_FAILED(0,"根据条件查询房间信息失败"),
    FIND_ROOM_EXCEPTION(-1,"根据条件查询房间信息异常"),

    //添加设施分类
    INSERT_FACILITY_CATEGORY_SUCCESS(1,"添加设施分类成功"),
    INSERT_FACILITY_CATEGORY_FAILED(0,"添加设施分类失败"),
    INSERT_FACILITY_CATEGORY_EXCEPTION(-1,"添加设施分类异常"),
    //更新设施分类
    UPDATE_FACILITY_CATEGORY_SUCCESS(1,"更新设施分类成功"),
    UPDATE_FACILITY_CATEGORY_FAILED(0,"更新设施分类失败"),
    UPDATE_FACILITY_CATEGORY_EXCEPTION(-1,"更新设施分类异常"),
    //删除设施分类
    DELETE_FACILITY_CATEGORY_SUCCESS(1,"删除设施分类成功"),
    DELETE_FACILITY_CATEGORY_FAILED(0,"删除设施分类失败"),
    DELETE_FACILITY_CATEGORY_EXCEPTION(-1,"删除设施分类异常"),
    //查询指定id的设施分类
    FIND_FACILITY_CATEGORY_BY_ID_SUCCESS(1,"查询指定id的设施分类成功"),
    FIND_FACILITY_CATEGORY_BY_ID_FAILED(0,"查询指定id的设施分类失败"),
    FIND_FACILITY_CATEGORY_BY_ID_EXCEPTION(-1,"查询指定id的设施分类异常"),
    //根据条件查询设施分类
    FIND_FACILITY_CATEGORY_SUCCESS(1,"根据条件查询设施分类成功"),
    FIND_FACILITY_CATEGORY_FAILED(0,"根据条件查询设施分类失败"),
    FIND_FACILITY_CATEGORY_EXCEPTION(-1,"根据条件查询设施分类异常"),

    //添加缴费项目
    INSERT_CHARGE_SUCCESS(1,"添加缴费项目成功"),
    INSERT_CHARGE_FAILED(0,"添加缴费项目失败"),
    INSERT_CHARGE_EXCEPTION(-1,"添加缴费项目异常"),
    //更新缴费项目
    UPDATE_CHARGE_SUCCESS(1,"更新缴费项目成功"),
    UPDATE_CHARGE_FAILED(0,"更新缴费项目失败"),
    UPDATE_CHARGE_EXCEPTION(-1,"更新缴费项目异常"),
    //删除缴费项目
    DELETE_CHARGE_SUCCESS(1,"删除缴费项目成功"),
    DELETE_CHARGE_FAILED(0,"删除缴费项目失败"),
    DELETE_CHARGE_EXCEPTION(-1,"删除缴费项目异常"),
    //查询指定id的缴费项目
    FIND_CHARGE_BY_ID_SUCCESS(1,"查询指定id的缴费项目成功"),
    FIND_CHARGE_BY_ID_FAILED(0,"查询指定id的缴费项目失败"),
    FIND_CHARGE_BY_ID_EXCEPTION(-1,"查询指定id的缴费项目异常"),
    //根据条件查询缴费项目
    FIND_CHARGE_SUCCESS(1,"根据条件查询缴费项目成功"),
    FIND_CHARGE_FAILED(0,"根据条件查询缴费项目失败"),
    FIND_CHARGE_EXCEPTION(-1,"根据条件查询缴费项目异常"),


    //添加新闻信息
    INSERT_NEWS_SUCCESS(1,"添加新闻信息成功"),
    INSERT_NEWS_FAILED(0,"添加新闻信息失败"),
    INSERT_NEWS_EXCEPTION(-1,"添加新闻信息异常"),
    //更新新闻信息
    UPDATE_NEWS_SUCCESS(1,"更新新闻信息成功"),
    UPDATE_NEWS_FAILED(0,"更新新闻信息失败"),
    UPDATE_NEWS_EXCEPTION(-1,"更新新闻信息异常"),
    //删除新闻信息
    DELETE_NEWS_SUCCESS(1,"删除新闻信息成功"),
    DELETE_NEWS_FAILED(0,"删除新闻信息失败"),
    DELETE_NEWS_EXCEPTION(-1,"删除新闻信息异常"),
    //查询指定id的新闻信息
    FIND_NEWS_BY_ID_SUCCESS(1,"查询指定id的新闻信息成功"),
    FIND_NEWS_BY_ID_FAILED(0,"查询指定id的新闻信息失败"),
    FIND_NEWS_BY_ID_EXCEPTION(-1,"查询指定id的新闻信息异常"),
    //根据条件查询新闻信息
    FIND_NEWS_SUCCESS(1,"根据条件查询新闻信息成功"),
    FIND_NEWS_FAILED(0,"根据条件查询新闻信息失败"),
    FIND_NEWS_EXCEPTION(-1,"根据条件查询新闻信息异常"),

    //添加活动报名信息
    INSERT_ACTIVITY_REGISTER_SUCCESS(1,"添加活动报名信息成功"),
    INSERT_ACTIVITY_REGISTER_FAILED(0,"添加活动报名信息失败"),
    INSERT_ACTIVITY_REGISTER_EXCEPTION(-1,"添加活动报名信息异常"),
    //更新活动报名信息
    UPDATE_ACTIVITY_REGISTER_SUCCESS(1,"更新活动报名信息成功"),
    UPDATE_ACTIVITY_REGISTER_FAILED(0,"更新活动报名信息失败"),
    UPDATE_ACTIVITY_REGISTER_EXCEPTION(-1,"更新活动报名信息异常"),
    //删除活动报名信息
    DELETE_ACTIVITY_REGISTER_SUCCESS(1,"删除活动报名信息成功"),
    DELETE_ACTIVITY_REGISTER_FAILED(0,"删除活动报名信息失败"),
    DELETE_ACTIVITY_REGISTER_EXCEPTION(-1,"删除活动报名信息异常"),
    //查询指定id的活动报名信息
    FIND_ACTIVITY_REGISTER_BY_ID_SUCCESS(1,"查询指定id的活动报名信息成功"),
    FIND_ACTIVITY_REGISTER_BY_ID_FAILED(0,"查询指定id的活动报名信息失败"),
    FIND_ACTIVITY_REGISTER_BY_ID_EXCEPTION(-1,"查询指定id的活动报名信息异常"),
    //根据条件查询活动报名信息
    FIND_ACTIVITY_REGISTER_SUCCESS(1,"根据条件查询活动报名信息成功"),
    FIND_ACTIVITY_REGISTER_FAILED(0,"根据条件查询活动报名信息失败"),
    FIND_ACTIVITY_REGISTER_EXCEPTION(-1,"根据条件查询活动报名信息异常"),

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
