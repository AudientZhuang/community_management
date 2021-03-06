package com.saltedfish.community_management.service;

import com.saltedfish.community_management.common.Result;

public interface UserService {
    /**
     * 社区账号登录
     * @param account
     * @param password
     * @return
     */
    Result cmLogin(String account,String password);

    /**
     * 微信登录(验证唯一标识openId)
     * @param openId
     * @return
     */
    Result wxLogin(String openId);

    /**
     * 根据用户id绑定微信（唯一标识）
     * @param openId
     * @param id
     * @return
     */
    Result bindWx(String openId, Integer id);


    /**
     * 根据用户id解除微信绑定
     * @param id
     * @return
     */
    Result unbindWx(Integer id);

    /**
     * 查询指定hh_id的用户是否绑定微信
     * @param hh_id
     * @return
     */
    Result findIsBindByHid(Integer hh_id);

    /**
     * 根据用户账号查找用户信息
     * @param account
     * @return
     */
    Result findUserByUsername(String account);

    /**
     * 验证用户密码
     * @param hh_id
     * @param password
     * @return
     */
    Result verifyPassword(Integer hh_id, String password);

    /**
     * 修改用户密码
     * @param hh_id
     * @param passsword
     * @return
     */
    Result modifyPassword(Integer hh_id, String passsword);
}
