package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/cmLogin")
    public Result cmLogin(@RequestParam("account") String account,
                          @RequestParam("password") String password){
        try {
            Result result = userService.cmLogin(account,password);
            if(result.getStatus() != ResultCode.LOGIN_USER_EXCEPTION.getStatus()){
                //用户登录无异常
                return result;
            }
            else{
                throw new Exception(ResultCode.LOGIN_USER_EXCEPTION.getMessage());
            }
        }catch (Exception e) {
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }
}
