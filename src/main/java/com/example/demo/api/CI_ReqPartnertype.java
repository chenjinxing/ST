package com.example.demo.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.entity.Partnertype;
import com.example.demo.service.CIBatchService;
import com.example.demo.service.PartnertypeService;

@Service
public class CI_ReqPartnertype extends ApiBase {

	
	public void test()
	{
		System.out.print("test");
	}
	@Resource
	ApiRtnInfo apiRtnInfo;
	
	@Resource
	private PartnertypeService partnertypeService;

	@Override
	public String doAction(int partnerid, String version, String action,
			int source, String req) {
		// TODO Auto-generated method stub
		System.out.println(action);
		System.out.println(req);
		//解析查询条件
		Partnertype reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, Partnertype.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		//查询数据
		List<Partnertype> data =partnertypeService.selectPartnertypeSelective(reqData);
		//打包数据
		CI_RtnPartnertypeData rtn =new CI_RtnPartnertypeData();
		rtn.setResult(1);
		rtn.setNotice("查询成功");
		rtn.setData(data);
		rtn.setCount(data.size());
		
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

class CI_RtnPartnertypeData
{
	public CI_RtnPartnertypeData()
	{}
	public CI_RtnPartnertypeData(int count, int result, String notice,
			List<Partnertype> data) {
		super();
		this.count = count;
		this.result = result;
		this.notice = notice;
		this.data = data;
	}
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	private int result;
	private String notice;
	private List<Partnertype> data;
	
	public List<Partnertype> getData() {
		return data;
	}
	public void setData(List<Partnertype> data) {
		this.data = data;
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

}