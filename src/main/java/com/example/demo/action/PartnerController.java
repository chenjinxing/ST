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
import com.example.demo.api.CI_ReqPartnertype;
import com.example.demo.api.CI_ReqUpdateOrderAll;
import com.example.demo.service.PartnertypeService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/partner")
public class PartnerController extends BaseController{
	
	@Resource
	ApiManager apiManager;
	
	@RequestMapping("/partnerType")
	public String partnerType(HttpServletRequest request) {
		return "partner/partnerType";
	}

	
}

@RestController
@RequestMapping("/Partner")
class PartnerPostController extends BaseController{
	
	@Resource
	ApiManager apiManager;
	
	@Resource
	private CI_ReqPartnertype cI_ReqPartnertype;
	
	@Resource
	PartnertypeService partnertypeService;
	
	@RequestMapping("/data")
	@ResponseBody
	public String data() {
		return cI_ReqPartnertype.doAction(1,"1", "CI_ReqPartnertype", 1, "{}");
	}
	
	@RequestMapping("/partnerTypeAdd")
	@ResponseBody
	public String partnerTypeAdd(String typename) {
		// change row count
		int rtn =partnertypeService.insertByTypeName(typename);
		if(0 ==rtn)
			return "add partnerType fail";
		return "add partnerType success";
	}
	@RequestMapping("/partnerTypeUpdate")
	@ResponseBody
	public String partnerTypeUpdate(int typeid,String typename) {
		// change row count
		int rtn =partnertypeService.update(typeid, typename);
		if(0 ==rtn)
			return "update partnerType fail";
		return "update partnerType success";
	}
	@RequestMapping("/partnerTypeDelete")
	@ResponseBody
	public String partnerTypeDelete(int id) {
		// change row count [{"0":true,"typeid":2,"typename":"银行"},{"0":true,"typeid":3,"typename":"银行2"}]
		int rtn =partnertypeService.delete(id);
		if(0 ==rtn)
			return "delete partnerType fail";
		return "delete partnerType success";
	}
}
class PartnerTypeReq
{}