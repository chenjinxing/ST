package com.example.demo.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.entity.CiInstallment;
import com.example.demo.entity.CiOrder;
import com.example.demo.service.CIBatchService;
import com.example.demo.service.CIOrderService;

@Service
public class CI_ReqUpdateOrderInstallMent extends ApiBase {

	
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
		//解析更新条件
		CI_ReqUpdateInstallMentData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CI_ReqUpdateInstallMentData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		reqData.getFind().setAppid(partnerid);
		
		List<CiOrder> testOrders =ciOrderService.find(reqData.getFind(), 0, 1);
		if(1 !=testOrders.size())
			return apiRtnInfo.getFail();
		//testOrders.get(0).getInstallmentlist();
		//修改操作
		if(0 ==reqData.getAction().compareTo("insert"))
		{
			//判断该批次是否存在
			if(testOrders.get(0).isExistInstallment(reqData.getInstallmentno()))
				return apiRtnInfo.getFail();
			ciOrderService.insertInstallment(reqData.getFind(), reqData.getData(), reqData.getInstallmentno());
		}
		else if(0 ==reqData.getAction().compareTo("delete"))
			ciOrderService.deleteInstallment(reqData.getFind(), reqData.getData(), reqData.getInstallmentno());
		else if(0 ==reqData.getAction().compareTo("update"))
			ciOrderService.updateInstallment(reqData.getFind(), reqData.getData(), reqData.getInstallmentno());
		else
			return apiRtnInfo.getNot_exist(reqData.getAction());
		
		CI_RtnUpdateOrderData rtn =new CI_RtnUpdateOrderData();
		rtn.setResult(1);
		rtn.setNotice("修改命令发出");
		
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

class CI_ReqUpdateInstallMentData
{
	public CI_ReqUpdateInstallMentData()
	{}
	public CI_ReqUpdateInstallMentData(CiOrder find,int installmentno,String action, CiInstallment data) {
		super();
		this.find = find;
		this.data = data;
		this.installmentno = installmentno;
		this.action = action;
	}
	private CiOrder find;
	private int installmentno;
	private String action;
	private CiInstallment data;
	
	public CiInstallment getData() {
		return data;
	}
	public void setData(CiInstallment data) {
		this.data = data;
	}
	public int getInstallmentno() {
		return installmentno;
	}
	public void setInstallmentno(int installmentno) {
		this.installmentno = installmentno;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public CiOrder getFind() {
		return find;
	}
	public void setFind(CiOrder find) {
		this.find = find;
	}
	
}
class CI_RtnUpdateInstallMentData
{
	public CI_RtnUpdateInstallMentData()
	{}
	public CI_RtnUpdateInstallMentData(int result, String notice) {
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