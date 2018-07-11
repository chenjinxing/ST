package com.example.demo.action;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.api.ApiManager;
import com.example.demo.api.CI_ReqPartnertype;
import com.example.demo.api.CI_ReqUpdateOrderAll;
import com.example.demo.api_cl.CL_ReqInsertOrder;
import com.example.demo.api_cl.CL_ReqUpdateOrder;
import com.example.demo.entity.ClOrder;
import com.example.demo.entity.ClOrderData;
import com.example.demo.entity.ClOrderbase;
import com.example.demo.entity.Partner;
import com.example.demo.entity.Partnerfile;
import com.example.demo.entity.Partnertype;
import com.example.demo.entity.Stuser;
import com.example.demo.fdfs.FastDFSClientWrapper;
import com.example.demo.service.ClOrderService;
import com.example.demo.service.ClOrderbaseService;
import com.example.demo.service.PartnerService;
import com.example.demo.service.PartnerfileService;
import com.example.demo.service.PartnertypeService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/carLoan")
public class CarLoanController extends BaseController{
	

	@RequestMapping("/clOrderInsert")
	public String partnerType(HttpServletRequest request) {
		return "carLoan/clOrderInsert";
	}
	@RequestMapping("/clOrderbaseSelect")
	public String partnerFile(HttpServletRequest request) {
		return "carLoan/clOrderbaseSelect";
	}
}

@RestController
@RequestMapping("/CarLoan")
class CarLoanPostController extends BaseController{
	
	@Resource
	CL_ReqInsertOrder reqInsertOrder;
	@Resource
	CL_ReqUpdateOrder reqUpdateOrder;
	
	@Resource
	ClOrderbaseService clOrderbaseService;
	
	@Resource
	ClOrderService clOrderService;
	
	@Resource
	UserService stuserService;
	
	@RequestMapping("/clOrderInsert")
	@ResponseBody
	public String clOrderInsert(String req) {
		
		String username=(String)SecurityUtils.getSubject().getPrincipal();
    	Stuser user =stuserService.getByUsername(username);
    	if(null ==user)
    		return "{\"result\":false,\"code\":0,\"msg\":\"新增订单失败\",\"data\":null}";
    	int uploaduser =user.getId();
    	return reqInsertOrder.doActionByUser(uploaduser,"1","1",1, req);
	}
	
	@RequestMapping("/clOrderDelete")
	@ResponseBody
	public String clOrderDelete(Integer proId) {
		int rtn =clOrderbaseService.deleteOrderbaseById(proId);
		if(0 ==rtn)
			return "{\"result\":false,\"code\":0,\"msg\":\"删除订单失败\",\"data\":null}";
		try {
			clOrderService.deleteById(String.valueOf(proId));
		}catch(Exception e)
		{
			return "{\"result\":false,\"code\":0,\"msg\":\"删除订单异常，请联系管理员\",\"data\":null}";
		}
		return "{\"result\":true,\"code\":0,\"msg\":\"删除订单成功\",\"data\":null}";
	}
	//提交申请
	@RequestMapping("/clOrderApply")
	@ResponseBody
	public String clOrderApply(Integer proId) {
		ClOrder data = clOrderService.findById(String.valueOf(proId));
		if(null ==data)
			return "{\"result\":false,\"code\":0,\"msg\":\"加载订单异常\",\"data\":null}";
		
		return "{\"result\":true,\"code\":0,\"msg\":\"申请提交成功\",\"data\":null}";
	}
	
	
	@RequestMapping("/clOrderLoad")
	@ResponseBody
	public String clOrderLoad(Integer proId) {
		ClOrder data =clOrderService.findById(String.valueOf(proId));
		if(null ==data)
			return "{\"result\":false,\"code\":0,\"msg\":\"加载订单异常\",\"data\":null}";
		try {
			ObjectMapper mapper = new ObjectMapper();  
			String rtnStr =mapper.writeValueAsString(data);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
	}
	
	@RequestMapping("/clOrderUpdate")
	@ResponseBody
	public String clOrderUpdate(String req,Integer proId) {
		ClOrderData reqData;
		ObjectMapper mapper = new ObjectMapper(); 
		//忽略多余字段
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			reqData =mapper.readValue(req, ClOrderData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return "{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
		}
		return reqUpdateOrder.updateClOrderData(proId, reqData);
	}
	
	@RequestMapping("/clOrderbaseData")
	@ResponseBody
	public String clOrderbaseData(Integer limit, Integer offset, String search) {
		ClOrderbase orderbase =new ClOrderbase();
		return clOrderbaseService.selectByConditionJson(orderbase);
	}
	
	
}
	
	



