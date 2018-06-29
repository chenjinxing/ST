package com.example.demo.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.ApiManager;


@RestController
@RequestMapping("/data")
public class DataController extends BaseController{
	
	@Resource
	ApiManager apiManager;
	
	@RequestMapping("/test")
	public String test(int id, Model model) {
		System.out.println(id);
		return "{\"hehe\":1234}";
	}
	
	@RequestMapping("/api")
	@ResponseBody
	public String receivePost(String partnercode,String version,String action,int source,
			String req,String reqhash) {
		String apiReqStr ="partnercode:"+
			partnercode+"version:"+
			version+"action:"+
			action+"source:"+
			source+"req:"+
			req+"reqhash:"+
			reqhash;
		String apiRtnStr =apiManager.receivePost(partnercode, version, action, source, req, reqhash);
		log.info("apiReqStr"+apiReqStr+"\n"+"apiRtnStr"+apiRtnStr);
		return apiRtnStr;
	}
	
	
}
