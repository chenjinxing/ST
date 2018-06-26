package com.example.demo.shrio;


import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.example.demo.entity.Stuser;
import com.example.demo.service.UserService;

public class MyRealm extends AuthorizingRealm {  
    @Resource  
	private UserService userService;
  
    //授权 为当前登录成功的用户授予权限和角色，已经登录成功了。  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
        String username=(String) principals.getPrimaryPrincipal();  
        SimpleAuthorizationInfo  authorizationInfo=new SimpleAuthorizationInfo();  
        authorizationInfo.setRoles(userService.getRoles(username));  
        authorizationInfo.setStringPermissions(userService.getPermissions(username));  
        return authorizationInfo;  
    }  
    //登录 验证当前登录的用户，获取认证信息。  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {  
        String username=(String) token.getPrincipal();//获取用户名
        String password = new String((char[])token.getCredentials()); //得到密码 
        Stuser user=userService.getByUsername(username);  
        if(user!=null){  
            AuthenticationInfo authcInfo =new SimpleAuthenticationInfo(user.getName(),user.getPassword(),"myRealm");  
            return authcInfo;  
        }else{  
            return null;  
        }  
    }  
}  