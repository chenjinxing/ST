package com.example.demo.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.entity.CiOrder;
import com.example.demo.service.CIOrderService;

@Service
public class CI_ReqInsertOrder extends ApiBase {

	
	public void test()
	{
		System.out.print("test");
	}
	@Resource
	ApiRtnInfo apiRtnInfo;
	
	@Resource
	private CIOrderService ciOrderService;

	@Override
	public String doAction(int partnerid, String version, String action,
			int source, String req) {
		// TODO Auto-generated method stub
		//解析插入条件
		CiOrder reqData;
		ObjectMapper mapper = new ObjectMapper();
		try {
			reqData =mapper.readValue(req, CiOrder.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		reqData.setAppid(partnerid);
		
		CiOrder testOrder =new CiOrder();
		testOrder.setAppid(partnerid);
		testOrder.setOrderid(reqData.getOrderid());
		List<CiOrder> testOrders =ciOrderService.find(testOrder, 0, 1);
		if(0 !=testOrders.size())
			return apiRtnInfo.getFail("订单已存在");
		//插入操作
		ciOrderService.insert(reqData);
		
		CI_RtnInsertOrderData rtn =new CI_RtnInsertOrderData();
		rtn.setResult(1);
		rtn.setNotice("新增订单成功");
		
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

class CI_ReqInsertOrderData
{
	public CI_ReqInsertOrderData()
	{}
	public CI_ReqInsertOrderData(int assetsid, int pagesize, int pageindex) {
		super();
		this.assetsid = assetsid;
		this.pagesize = pagesize;
		this.pageindex = pageindex;
	}
	private int assetsid;
	private int pagesize;
	private int pageindex =1;
	
	public int getAssetsid() {
		return assetsid;
	}
	public void setAssetsid(int assetsid) {
		this.assetsid = assetsid;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

}
class CI_RtnInsertOrderData
{
	public CI_RtnInsertOrderData()
	{}
	public CI_RtnInsertOrderData(int result, String notice) {
		super();
		this.result = result;
		this.notice = notice;
	}
	private int result;
	private String notice;
	
	
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
}