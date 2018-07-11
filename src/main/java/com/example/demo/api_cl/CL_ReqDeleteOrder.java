package com.example.demo.api_cl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.api.ApiBase;
import com.example.demo.api.ApiRtnInfo;
import com.example.demo.entity.ClOrder;
import com.example.demo.entity.ClOrderData;
import com.example.demo.entity.ClOrderbase;
import com.example.demo.entity.Stuser;
import com.example.demo.protocol.CL_ReqDeleteOrderData;
import com.example.demo.protocol.RtnDeleteData;
import com.example.demo.protocol.RtnInsertOrderData;
import com.example.demo.service.ClOrderService;
import com.example.demo.service.ClOrderbaseService;
import com.example.demo.service.PartnerService;

@Service
public class CL_ReqDeleteOrder extends ApiBase {

	
	public void test()
	{
		System.out.print("test");
	}
	@Resource
	ApiRtnInfo apiRtnInfo;
	
	@Resource
	private ClOrderService clOrderService;
	
	@Resource
	private ClOrderbaseService clOrderbaseService;
	
	@Resource
	private PartnerService partnerService;

	@Override
	public String doAction(int partnerid, String version, String action,
			int source, String req) {
		// TODO Auto-generated method stub
		//需要用到用户
		int mainUser =partnerService.selectMainUser(partnerid);
		return doActionByUser(mainUser,version,action,source,req);
	}
	public String doActionByUser(int userid, String version, String action,
			int source, String req) {
		// TODO Auto-generated method stub
		//解析插入条件
		CL_ReqDeleteOrderData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CL_ReqDeleteOrderData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		int orderId =reqData.getOrderid();
		int deleteRtn =clOrderbaseService.deleteOrderbaseById(orderId);
		if(1 != deleteRtn)
			return apiRtnInfo.getFail();
		clOrderService.deleteById(String.valueOf(orderId));
		
		RtnDeleteData rtn =new RtnDeleteData();
		rtn.setResult(1);
		rtn.setNotice("删除订单成功");

		try {
			String rtnStr =mapper.writeValueAsString(rtn);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apiRtnInfo.getFail();
	}
}
