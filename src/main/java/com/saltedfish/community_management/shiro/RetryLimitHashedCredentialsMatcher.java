package com.saltedfish.community_management.shiro;

import com.saltedfish.community_management.util.SHA256Util;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * @author Audient
 * @date 2020/6/2
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        EasyTypeToken tk = (EasyTypeToken) authcToken;
        //如果是免密登录直接返回true
        if(tk.getType().equals(LoginType.NOPASSWD)){
            return true;
        }
        //不是免密登录，调用父类的方法
        return super.doCredentialsMatch(tk, info);
    }

}
