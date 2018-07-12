package com.example.demo.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api_cl.CL_ReqInsertOrder;
import com.example.demo.api_cl.CL_ReqUpdateOrder;
import com.example.demo.entity.ClOrderbase;
import com.example.demo.entity.Stuser;
import com.example.demo.mapper.BankbatchMapper;
import com.example.demo.mapper.StuserMapper;
import com.example.demo.protocol.CL_ReqPaymentLoanData;
import com.example.demo.protocol.CL_ReqTellApplyResult;
import com.example.demo.protocol.CL_RtnPaymentLoanData;
import com.example.demo.protocol.CL_RtnTellApplyResult;
import com.example.demo.service.ClOrderService;
import com.example.demo.service.ClOrderbaseService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/ClService")
public class ClController extends BaseController{

	@Autowired
	StuserMapper stuserMaper;
	
	@Autowired
	BankbatchMapper bankbatchMaper;
	
	@Resource
	private UserService userService;

	@Resource
	CL_ReqInsertOrder reqInsertOrder;
	
	@Resource
	CL_ReqUpdateOrder reqUpdateOrder;
	
	@Resource
	ClOrderbaseService clOrderbaseService;
	
	@Resource
	ClOrderService clOrderService;
	
	@RequestMapping("/postTest1")
	public String postTest1(@RequestBody Map<String,String> map) {
		System.out.println(map.get("id"));
		return "test";
	}
	
	// 通知审核结果
	@RequestMapping("/Project!getResult.action")
	@ResponseBody
	public CL_RtnTellApplyResult tellApplyResult(@RequestBody CL_ReqTellApplyResult result) {
		CL_RtnTellApplyResult rtnData =new CL_RtnTellApplyResult();
		rtnData.setFlag(false);
		
		int proId =Integer.parseInt(result.getProId());
		
		ClOrderbase newOrderbase= new ClOrderbase();
		newOrderbase.setProid(proId);
		newOrderbase.setStatusid(result.getData().getStatus());
		int updateRtn =clOrderbaseService.updateOrderbase(newOrderbase);
		if(0 ==updateRtn)
		{
			rtnData.setMsg("订单状态更新失败");
			return rtnData;
		}
		rtnData.setFlag(true);
		rtnData.setMsg("操作成功");
		return rtnData;
	}
	//回传放款明细 主动推送到合作渠道
	@RequestMapping("/Project!toGetPaymentList.action")
	@ResponseBody
	public CL_RtnPaymentLoanData toGetPaymentList(@RequestBody CL_ReqPaymentLoanData result) {
		CL_RtnPaymentLoanData rtnData =new CL_RtnPaymentLoanData();
		rtnData.setFlag(true);
		int proId =-1;
		if(result.getData().getLoanData().size() !=0)
			proId =Integer.parseInt(result.getData().getLoanData().get(0).getProId());
		//存储放款信息
		
		//发送放款通知
		
		rtnData.setMsg("已接收消息");
		return rtnData;
	}
	
}