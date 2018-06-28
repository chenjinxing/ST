package com.example.demo.action;



import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
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
	
//	@RequestMapping("/login")
//	public String login(HttpServletRequest request) {
//		return "/login";
//	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request) throws Exception{
	    System.out.println("HomeController.login()");
	    // 登录失败从request中获取shiro处理的异常信息。
	    // shiroLoginFailure:就是shiro异常类的全类名.
	    String exception = (String) request.getAttribute("shiroLoginFailure");
	    System.out.println("exception=" + exception);
	    String msg = "";
	    if (exception != null) {
	        if (UnknownAccountException.class.getName().equals(exception)) {
	            System.out.println("UnknownAccountException -- > 账号不存在：");
	            msg = "UnknownAccountException -- > 账号不存在：";
	        } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
	            System.out.println("IncorrectCredentialsException -- > 密码不正确：");
	            msg = "IncorrectCredentialsException -- > 密码不正确：";
	        } else if ("kaptchaValidateFailed".equals(exception)) {
	            System.out.println("kaptchaValidateFailed -- > 验证码错误");
	            msg = "kaptchaValidateFailed -- > 验证码错误";
	        } else {
	            msg = "else >> "+exception;
	            System.out.println("else -- >" + exception);
	        }
	    }
	    request.getSession().setAttribute("msg", msg);
	    // 此方法不处理登录成功,由shiro进行处理 return "{\"result\":false,\"code\":0,\"msg\":\"登陆失败\",\"data\":null}";
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