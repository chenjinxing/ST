package com.example.demo.conf;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.shrio.MyRealm;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
@Configuration
public class ShiroConfig {

	@Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断
        //filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        
        //api相关服务开放
        filterChainDefinitionMap.put("/Services/**", "anon");
        //用户认证相关服务开放
        filterChainDefinitionMap.put("/user/**", "anon");
        
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/home/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/home/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/home/main");


        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
      //其他拦截器
//        Map<String, Filter> filters =new LinkedHashMap<String,Filter>();
//        filters.put("authc", loginFilter());
//        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }

//	@Bean
//    public Filter loginFilter(){
//		CaptchaFormAuthenticationFilter myLoginFilter = new CaptchaFormAuthenticationFilter();
//        return myLoginFilter;
//    }
//	@Bean  
//	public FilterRegistrationBean registrationBean(CaptchaFormAuthenticationFilter customFormAuthenticationFilter){  
//		System.out.println("AppcustomFormAuthenticationFilter()");  
//		FilterRegistrationBean registration = new FilterRegistrationBean(customFormAuthenticationFilter);  
//		registration.setEnabled(false);//怎么取消  Filter自动注册,不会添加到FilterChain中.  
//		return registration;  
//	}  

    @Bean
    public MyRealm myShiroRealm(){
    	MyRealm myShiroRealm = new MyRealm();
        return myShiroRealm;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
}