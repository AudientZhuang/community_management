package com.saltedfish.community_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saltedfish.community_management.bean.AccessToken;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.config.WxConfig;
import com.saltedfish.community_management.util.HttpUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class InviteController {

    @PostMapping("/getAccessToken")
    public Result getAccessToken() throws IOException {
        String httpRes  = "";
        try{
            httpRes = HttpUtil.doGet(
                    "https://api.weixin.qq.com/cgi-bin/token?appid="
                            + WxConfig.AppID + "&secret="
                            + WxConfig.AppSecret + "&grant_type=client_credential", null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            Result result = new Result();
            AccessToken accessToken = mapper.readValue(httpRes, AccessToken.class);
            if(accessToken != null) {
                //获取成功
                result.setStatus(ResultCode.GET_ACCESSTOKEN_SUCCESS.getStatus());
                result.setMessage(ResultCode.GET_ACCESSTOKEN_SUCCESS.getMessage());
                result.setData(accessToken);
            }else{
                //获取失败
                result.setStatus(ResultCode.GET_ACCESSTOKEN_FAILED.getStatus());
                result.setMessage(ResultCode.GET_ACCESSTOKEN_FAILED.getMessage());
            }
            return result;
        }catch (Exception e) {
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(), ResultCode.SYSTEM_BUSY.getMessage(), null);
        }
    }
}
