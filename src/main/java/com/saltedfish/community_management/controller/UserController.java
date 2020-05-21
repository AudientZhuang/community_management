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
        return userService.cmLogin(account,password);
    }

    @PostMapping("/wxLogin")
    public Result wxLogin(@RequestParam("code") String code) throws Exception {
        String httpRes = "";
        //携带临时登录凭证code向微信服务器发送请求获取用户唯一标识openId
        httpRes = HttpUtil.doGet(
                "https://api.weixin.qq.com/sns/jscode2session?appid="
                        + WxConfig.AppID + "&secret="
                        + WxConfig.AppSecret + "&js_code="
                        + code + "&grant_type="
                        + WxConfig.grant_type, null);
        ObjectMapper mapper = new ObjectMapper();
        OpenIdJson openIdJson = mapper.readValue(httpRes, OpenIdJson.class);
        return userService.wxLogin(openIdJson.getOpenid());

    }

    @PostMapping("/bindWx")
    public Result bindWx(String code,Integer id) throws Exception {
        String httpRes = "";
        //携带临时登录凭证code向微信服务器发送请求获取用户唯一标识openId
        httpRes = HttpUtil.doGet(
                "https://api.weixin.qq.com/sns/jscode2session?appid="
                        + WxConfig.AppID + "&secret="
                        + WxConfig.AppSecret + "&js_code="
                        + code + "&grant_type="
                        + WxConfig.grant_type, null);
        ObjectMapper mapper = new ObjectMapper();
        OpenIdJson openIdJson = mapper.readValue(httpRes, OpenIdJson.class);
        return userService.bindWx(openIdJson.getOpenid(), id);
    }

    @GetMapping("/isBind/{hh_id}")
    public Result isBind(@PathVariable("hh_id") Integer hh_id){
        //在数据库中查找指定id的用户是否绑定微信
        return userService.findIsBindByHid(hh_id);
    }
}
