package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.entity.CiCustomer;
import com.example.demo.entity.CiOrder;
import com.example.demo.service.CIBatchService;

@Service
public class CI_ReqAsset extends ApiBase {

	
	public void test()
	{
		System.out.print("test");
	}
	@Resource
	ApiRtnInfo apiRtnInfo;
	
	@Resource
	private CIBatchService ciBatchService;

	@Override
	public String doAction(int partnerid, String version, String action,
			int source, String req) {
		// TODO Auto-generated method stub
		System.out.println(action);
		System.out.println(req);
		//解析请求条件
		CI_ReqAssetData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CI_ReqAssetData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		
		
		//资产解析
		List<CiCustomer> customers= reqData.getCustomers();
		//请求核验
		//
		
		//打包数据
		CI_RtnAssetData rtn =new CI_RtnAssetData();
		
	
		rtn.setResult(1);
		rtn.setNotice("请求成功");
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

class CI_ReqAssetData
{
	public CI_ReqAssetData()
	{}
	public CI_ReqAssetData(List<CiOrder> orders,int orderCount) {
		super();
		
	}
	private List<CiOrder> orders;
	private int orderCount;
	
	public List<CiOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<CiOrder> orders) {
		this.orders = orders;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	
	public List<CiCustomer> getCustomers()
	{
		List<CiCustomer> customers=new ArrayList<CiCustomer>();
		for(CiOrder order: orders)
		{
			customers.add(order.getCustomer());
		}
		return customers;
	}
	

}
class CI_RtnAssetData
{
	public CI_RtnAssetData()
	{}
	public CI_RtnAssetData(int pagetotal, int result, String notice,
			List<CiBatch> data) {
		super();
		this.pagetotal = pagetotal;
		this.result = result;
		this.notice = notice;
		this.data = data;
	}
	private int pagetotal;
	private int result;
	private String notice;
	private List<CiBatch> data;
	
	public int getPagetotal() {
		return pagetotal;
	}
	public void setPagetotal(int pagetotal) {
		this.pagetotal = pagetotal;
	}
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
	public List<CiBatch> getData() {
		return data;
	}
	public void setData(List<CiBatch> data) {
		this.data = data;
	}

}