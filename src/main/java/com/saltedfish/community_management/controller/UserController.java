package com.saltedfish.community_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saltedfish.community_management.bean.OpenId;
import com.saltedfish.community_management.bean.User;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.config.WxConfig;
import com.saltedfish.community_management.service.UserService;
import com.saltedfish.community_management.shiro.EasyTypeToken;
import com.saltedfish.community_management.util.HttpUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户社区账号登录
     * @return
     */
    /*@PostMapping("/cmLogin")
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
    }*/

    @PostMapping("/wxLogin")
    public Result wxLogin(@RequestParam("code") String code, RedirectAttributes attributes) throws Exception {
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
        ObjectMapper mapper = new ObjectMapper();
        OpenId openId = mapper.readValue(httpRes, OpenId.class);
        Result result = userService.wxLogin(openId.getOpenid());
        //Result result = userService.wxLogin("123456");
        if(result.getStatus() == ResultCode.LOGIN_WX_EXCEPTION.getStatus()) {
            //有异常
            throw new Exception(ResultCode.LOGIN_WX_EXCEPTION.getMessage());
        }
        if(result.getStatus() == HttpStatus.UNAUTHORIZED.value()) {
            return  new Result(HttpStatus.UNAUTHORIZED.value(),"用户未绑定微信",null);
        }
        User user  = (User)result.getData();
        EasyTypeToken token = new EasyTypeToken(user.getUsername());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return new Result(HttpStatus.OK.value(),"登陆成功",user.getHh_id());

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
        OpenId openId = mapper.readValue(httpRes, OpenId.class);
        try {
            Result result = userService.bindWx(openId.getOpenid(), id);
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

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @PostMapping("/login/admin")
    public Result adminLogin(User user){
        // 进行身份验证
        try {
            Subject subject = SecurityUtils.getSubject();
            EasyTypeToken token = new EasyTypeToken(user.getUsername(),user.getPassword());
            subject.login(token);
            Result result = userService.findUserByUsername(user.getUsername());
            User u = (User) result.getData();
            return new Result(HttpStatus.OK.value(),"登录成功", user.getId());
        }catch (IncorrectCredentialsException e){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"用户不存在或者或者密码错误",null);
        }catch (AuthenticationException e){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"用户不存在",null);
        }

    }

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @PostMapping("/login/household")
    public Result householdLogin(User user){
        // 进行身份验证
        try {
            Subject subject = SecurityUtils.getSubject();
            EasyTypeToken token = new EasyTypeToken(user.getUsername(),user.getPassword());
            subject.login(token);
            Result result = userService.findUserByUsername(user.getUsername());
            User u = (User) result.getData();
            return new Result(HttpStatus.OK.value(),"登录成功", u.getHh_id());
        }catch (IncorrectCredentialsException e){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"用户不存在或者或者密码错误",null);
        }catch (AuthenticationException e){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"用户不存在",null);
        }

    }
    /**
     * 未登录
     * @return
     */
    @GetMapping("/login/unauth")
    public Result unauth(){
        return new Result(HttpStatus.FORBIDDEN.value(),"请先登录",null);
    }


    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return new Result(HttpStatus.OK.value(),"注销成功",null);
    }

}
