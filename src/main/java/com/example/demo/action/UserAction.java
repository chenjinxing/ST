package com.example.demo.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user0")
public class UserAction extends BaseController{

	@Resource
	private UserService userService;

	@RequestMapping("/findUserById")
	public String findUserById(int id, Model model) {
		System.out.println(id);
		String username = userService.findUserById(id);
		if (username != null) {
			model.addAttribute("username", username);
		} else {
			model.addAttribute("username", "δ�ҵ�");
		}
		return "test";
	}
	
	@RequestMapping("/hello")
    public String redirect() {  
		System.out.println("hello");
       return "redirect:/static/hello.html";
    }
}
