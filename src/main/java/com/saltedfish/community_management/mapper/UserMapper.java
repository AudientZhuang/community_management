package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 根据指定的hh_id查询住户信息是否绑定微信
     * @param hh_id
     * @return
     */
    public User findIsBindByHid(@RequestParam("hh_id") Integer hh_id);
}
