package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 通过社区账号密码登录
     * @param account
     * @param password
     * @return
     */
    public User cmLogin(String account,String password);

    /**
     * 通过绑定的微信登录
     * @param openId
     * @return
     */
    public User wxLogin(String openId);

    /**
     * 绑定微信
     * @param openId
     * @param id
     * @return
     */
    public Integer bindWx(String openId,Integer id);

    /**
     * 根据id查询住户是否绑定微信
     * @param id
     * @return
     */
    public Integer isBind(Integer id);
}
