package com.example.demo.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.entity.CiOrder;
import com.example.demo.service.CIBatchService;
import com.example.demo.service.CIOrderService;

@Service
public class CI_ReqOrder extends ApiBase {

	
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
		System.out.println(action);
		System.out.println(req);
		System.out.println();
		System.out.println();
		System.out.println();
		//解析查询条件
		CI_ReqOrderData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CI_ReqOrderData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		
		//查询数据
		int skip =(reqData.getPageindex() -1) * reqData.getPagesize();
		List<CiOrder> data =ciOrderService.find(reqData.getOrder(), skip , reqData.getPagesize());
		
		//查询总页数
		int pagetotal =ciOrderService.selectCountSelective(reqData.getOrder(), reqData.getPagesize());
		
		//打包数据
		CI_RtnOrderData rtn =new CI_RtnOrderData();
		rtn.setPagetotal(pagetotal);
		rtn.setResult(1);
		rtn.setNotice("查询成功");
		rtn.setData(data);
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

class CI_ReqOrderData
{
	public CI_ReqOrderData()
	{}
	public CI_ReqOrderData(CiOrder order, int pagesize, int pageindex) {
		super();
		this.order = order;
		this.pagesize = pagesize;
		this.pageindex = pageindex;
	}
	private CiOrder order;
	private int pagesize;
	private int pageindex =1;
	
	public CiOrder getOrder() {
		return order;
	}
	public void setOrder(CiOrder order) {
		this.order = order;
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
class CI_RtnOrderData
{
	public CI_RtnOrderData()
	{}
	public CI_RtnOrderData(int pagetotal, int result, String notice,
			List<CiOrder> orders) {
		super();
		this.pagetotal = pagetotal;
		this.result = result;
		this.notice = notice;
		this.orders = orders;
	}
	private int pagetotal;
	private int result;
	private String notice;
	private List<CiOrder> orders;
	
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
	public List<CiOrder> getData() {
		return orders;
	}
	public void setData(List<CiOrder> data) {
		this.orders = data;
	}

}