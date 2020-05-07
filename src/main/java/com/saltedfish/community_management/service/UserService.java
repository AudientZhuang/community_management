package com.saltedfish.community_management.service;

import com.saltedfish.community_management.common.Result;

public interface UserService {
    /**
     * 社区账号登录
     * @param account
     * @param password
     * @return
     */
    public Result cmLogin(String account,String password);
}
