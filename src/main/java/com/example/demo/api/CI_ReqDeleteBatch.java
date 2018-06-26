package com.example.demo.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.service.CIBatchService;

@Service
public class CI_ReqDeleteBatch extends ApiBase {

	
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
		//解析删除条件
		CI_ReqBatchDeleteData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CI_ReqBatchDeleteData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		//打包数据
				
		int deleteRtn =ciBatchService.deleteBatchById(reqData.getBatchid());
		if(1 !=deleteRtn)
			return apiRtnInfo.getFail("要删除的batch数据不存在");
		CI_RtnBatchDeleteData rtn =new CI_RtnBatchDeleteData();
		rtn.setResult(1);
		rtn.setNotice("删除成功");
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

class CI_ReqBatchDeleteData
{
	public CI_ReqBatchDeleteData()
	{}
	public CI_ReqBatchDeleteData(int batchid) {
		super();
		this.batchid = batchid;

	}
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	private int batchid;

}
class CI_RtnBatchDeleteData
{
	public CI_RtnBatchDeleteData()
	{}
	public CI_RtnBatchDeleteData(int result, String notice) {
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