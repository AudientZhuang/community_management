package com.saltedfish.community_management.filter;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Audient
 * @date 2020/6/3
 */
public class StatelessAuthcFilter extends PassThruAuthenticationFilter {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    //获取请求方法，若为OPTIONS请求直接返回True放行
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            log.info("OPTIONS方法直接返回True");
            return true;
        }
        return super.onPreHandle(request, response, mappedValue);
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpResp = WebUtils.toHttp(response);
        HttpServletRequest httpReq = WebUtils.toHttp(request);

        /** 系统重定向会默认把请求头清空，这里通过拦截器重新设置请求头，解决跨域问题 */
        httpResp.addHeader("Access-Control-Allow-Origin", httpReq.getHeader("Origin"));
        httpResp.addHeader("Access-Control-Allow-Headers", "*");
        httpResp.addHeader("Access-Control-Allow-Methods", "*");
        httpResp.addHeader("Access-Control-Allow-Credentials", "true");

        if (isLoginRequest(request, response)) {
            return true;
        } else {
            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }

}
