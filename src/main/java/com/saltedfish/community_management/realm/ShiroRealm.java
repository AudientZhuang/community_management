package com.saltedfish.community_management.realm;

import com.saltedfish.community_management.bean.User;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Audient
 * @date 2020/6/1
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     * 授权权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User)principalCollection.getPrimaryPrincipal();
        // 授权处理
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();

        //进行数据库查询,查询用户对应的权限
        roleSet.add("admin");
        permissionSet.add("getEmployee");
        //将角色和权限传入authorizationInfo
        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户输入的账号
        String username = (String)authenticationToken.getPrincipal();
        // 通过username从数据库中查找user对象,如果找到进行验证
        Result result = userService.findUserByUsername(username);
        // 判断账号是否存在
        if (result.getStatus() == HttpStatus.UNAUTHORIZED.value()){
            throw new AuthenticationException();
        }
        User user = (User)result.getData();
        // 进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, // 用户名
                user.getPassword(), // 密码
                ByteSource.Util.bytes(user.getSalt()), // 设置盐值
                getName()
        );

        return authenticationInfo;
    }
}