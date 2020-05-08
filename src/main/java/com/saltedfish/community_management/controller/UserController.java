package com.saltedfish.community_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saltedfish.community_management.bean.OpenIdJson;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.config.WxConfig;
import com.saltedfish.community_management.service.UserService;
import com.saltedfish.community_management.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户社区账号登录
     * @param account
     * @param password
     * @return
     */
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

    @PostMapping("/wxLogin")
    public Result wxLogin(@RequestParam("code") String code) throws IOException {
        String httpRes = "";
        //携带临时登录凭证code向微信服务器发送请求获取用户唯一标识openId
        try{
            httpRes = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + WxConfig.AppID + "&secret="
                            + WxConfig.AppSecret + "&js_code="
                            + code + "&grant_type="
                            + WxConfig.grant_type, null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper =new ObjectMapper();
        OpenIdJson openIdJson = mapper.readValue(httpRes, OpenIdJson.class);
        try {
            Result result = userService.wxLogin(openIdJson.getOpenid());
            if(result.getStatus() != ResultCode.LOGIN_WX_EXCEPTION.getStatus()) {
                //无异常
                return result;
            }
            else {
                throw new Exception(ResultCode.LOGIN_WX_EXCEPTION.getMessage());
            }
        }catch (Exception e) {
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    @PostMapping("/bindWx")
    public Result bindWx(String code,Integer id) throws IOException {
        String httpRes = "";
        //携带临时登录凭证code向微信服务器发送请求获取用户唯一标识openId
        try{
            httpRes = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + WxConfig.AppID + "&secret="
                            + WxConfig.AppSecret + "&js_code="
                            + code + "&grant_type="
                            + WxConfig.grant_type, null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper =new ObjectMapper();
        OpenIdJson openIdJson = mapper.readValue(httpRes, OpenIdJson.class);
        try {
            Result result = userService.bindWx(openIdJson.getOpenid(), id);
            if(result.getStatus() != ResultCode.BIND_WX_EXCEPTION.getStatus()) {
                //无异常
                return result;
            }
            else {
               throw new Exception(ResultCode.BIND_WX_EXCEPTION.getMessage());
            }
        }catch (Exception e) {
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    @GetMapping("/isBind/{hh_id}")
    public Result isBind(@PathVariable("hh_id") Integer hh_id){
        try {
            //在数据库中查找指定id的用户是否绑定微信
            Result result = userService.findIsBindByHid(hh_id);
            if (result.getStatus() != ResultCode.FIND_USER_ISBIND_BY_ID_EXCEPTION.getStatus()) {
                //无异常
                return result;
            }
            else {
                //异常
                throw new Exception(ResultCode.FIND_USER_ISBIND_BY_ID_EXCEPTION.getMessage());
            }
        }catch (Exception e) {
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }
}
