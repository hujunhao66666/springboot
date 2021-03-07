package com.kuang.config;

import com.kuang.Service.UserServiceImpl;
import com.kuang.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Security;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
        info.setCredentials("user:add");




        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");

        UsernamePasswordToken token1 = (UsernamePasswordToken) token;

        //连接数据库
        User user = userService.queryUserByName(token1.getUsername());
        System.out.println(user);

        if(user==null){
            return null;
        }

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser",user);

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
