package com.example.demo.action;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.ApiManager;


@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{
	
	@Resource
	ApiManager apiManager;
	
	@RequestMapping("/top")
	public String top(HttpServletRequest request) {
		return "/top";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "/login";
	}
	
	@RequestMapping("/main")
	public String loginPost(HttpServletRequest request) {
		
		return "/main";
	}
	
}

@RestController
@RequestMapping("/Home")
class HomePostController extends BaseController{
	
	@Resource
	ApiManager apiManager;
	
	
	@RequestMapping("/LoginPost")
	@ResponseBody
	public String loginPost(String userName,String password) {
		
		//return "{\"result\":true,\"code\":0,\"msg\":\"登陆成功\",\"data\":null}";
		return "{\"result\":false,\"code\":0,\"msg\":\"登陆失败\",\"data\":null}";
	}

}