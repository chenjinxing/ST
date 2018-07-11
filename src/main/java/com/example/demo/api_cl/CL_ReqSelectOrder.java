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
import com.example.demo.entity.CiBatch;
import com.example.demo.entity.ClOrder;
import com.example.demo.entity.ClOrderData;
import com.example.demo.entity.ClOrderbase;
import com.example.demo.entity.Stuser;
import com.example.demo.protocol.RtnInsertOrderData;
import com.example.demo.service.ClOrderService;
import com.example.demo.service.ClOrderbaseService;
import com.example.demo.service.PartnerService;

@Service
public class CL_ReqSelectOrder extends ApiBase {

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
		//解析查询条件
		CL_ReqOrderData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CL_ReqOrderData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		int orderid =reqData.getOrderid();
		ClOrder clOrder =clOrderService.findById(String.valueOf(orderid));
		if(null ==clOrder)
			return apiRtnInfo.getParma_invalid();
		//打包数据
		CL_RtnOrderData rtn =new CL_RtnOrderData();
		rtn.setResult(1);
		rtn.setNotice("查询成功");
		rtn.setData(clOrder);
		try {
			String rtnStr =mapper.writeValueAsString(rtn);
			System.out.println(rtnStr);
			System.out.println();
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return defaultRtnInfo;
	}
}


class CL_ReqOrderData
{
	public CL_ReqOrderData()
	{}
	public CL_ReqOrderData(int order) {
		super();
		this.orderid = order;
	}
	private int orderid;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int order) {
		this.orderid = order;
	}
}

class CL_RtnOrderData
{
	public CL_RtnOrderData()
	{}
	public CL_RtnOrderData(int result, String notice,
			ClOrder data) {
		super();
		this.result = result;
		this.notice = notice;
		this.data = data;
	}
	private int result;
	private String notice;
	private ClOrder data;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public ClOrder getData() {
		return data;
	}
	public void setData(ClOrder data) {
		this.data = data;
	}
}
