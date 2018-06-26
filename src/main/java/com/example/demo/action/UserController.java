package com.example.demo.action;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.Stuser;
import com.example.demo.mapper.BankbatchMapper;
import com.example.demo.mapper.StuserMapper;
import com.example.demo.service.UserService;



/** 
 * @describe: 读取一个用户下的所有订单
 * @author: Yiibai 
 * @version: V1.0
 * @copyright http://www.yiibai.com
 */ 

// http://localhost:8080/mybatis07-spring-mvc/user/orders
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	StuserMapper stuserMaper;
	
	@Autowired
	BankbatchMapper bankbatchMaper;
	
	@Resource
	private UserService userService;

	
	@RequestMapping("/postTest1")
	public String postTest1(@RequestBody Map<String,String> map) {
		System.out.println(map.get("id"));
		return "test";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String postTest2(@RequestBody Stuser stuser) {
		Stuser user;
		ObjectMapper mapper = new ObjectMapper();  
		user =stuserMaper.selectByNamePassword(stuser.getName(),stuser.getPassword());
		if(null ==user)
			return "wrong";
		try {
			//设置登录次数
			user.setLogintime(user.getLogintime()+1);
			stuserMaper.updateByPrimaryKeySelective(user);
			List<Integer> batchs =bankbatchMaper.getBankBatchs(user.getBankid());
			user.setBatchs(batchs);
			return mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return "wrong";
		}
	}
	@RequestMapping("/checklogin")
	@ResponseBody
	public String checklogin(@RequestBody Stuser stuser){
		Stuser user;
		ObjectMapper mapper = new ObjectMapper();  
		user =stuserMaper.selectByNamePassword(stuser.getName(),stuser.getPassword());
		if(null ==user)
			return "wrong";
		try {
			//不修改登录次数 直接返回
			return mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return "wrong";
		}
	}
	//shrio 认证
	@RequestMapping("/shrioLogin")  
    public String login(Stuser user, HttpServletRequest request){  
  
        Subject subject=SecurityUtils.getSubject();  
        UsernamePasswordToken token=new UsernamePasswordToken(user.getName(),user.getPassword());  
        try {  
            //调用subject.login(token)进行登录，会自动委托给securityManager,调用之前  
            subject.login(token);//会跳到我们自定义的realm中  
            request.getSession().setAttribute("user",user);  
            return "success";  
        }catch (Exception e){  
            e.printStackTrace();  
            request.getSession().setAttribute("user",user);  
            request.setAttribute("error","用户名或密码错误");  
            return "login";  
        }  
    }  
  
    @RequestMapping("/logout")  
    public String logout(HttpServletRequest request){  
        request.getSession().invalidate();  
        return "index";  
    }  
  
    @RequestMapping("/admin")  
    public String admin(HttpServletRequest request){  
        return "success";  
    }  
  
    @RequestMapping("/student")  
    public String student(HttpServletRequest request){  
        return "success";  
    }  
  
    @RequestMapping("/teacher")  
    public String teacher(HttpServletRequest request){  
        return "success";  
    }  
}
