package com.example.demo.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.service.CIBatchService;

@Service
public class CI_ReqInsertBatch extends ApiBase {

	
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
		//解析查询条件
		CiBatch reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CiBatch.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		reqData.setPartnerid(partnerid);
		//判断是否已经存在
		if(null !=ciBatchService.selectBatchByUniqueKey(partnerid, reqData.getAppbatchid()))
			return apiRtnInfo.getFail("该批次已经存在");
		
		int insertRtn =ciBatchService.insertBatch(reqData);
		if(1 !=insertRtn)
			return apiRtnInfo.getFail("插入失败");
		CI_RtnBatchInsertData rtn =new CI_RtnBatchInsertData();
		rtn.setResult(1);
		rtn.setNotice("新增成功");
		CiBatch newBatch =ciBatchService.selectBatchByUniqueKey(partnerid, reqData.getAppbatchid());
		if(null ==newBatch)
			return apiRtnInfo.getFail("插入失败");
		rtn.setBatchid(newBatch.getBatchid());
		
		try {
			String rtnStr =mapper.writeValueAsString(rtn);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apiRtnInfo.getFail("插入成功 返回数据失败");
	}
}

class CI_RtnBatchInsertData
{
	public CI_RtnBatchInsertData()
	{}
	public CI_RtnBatchInsertData(int pagetotal, int result, String notice,
			List<CiBatch> data) {
		super();
		this.result = result;
		this.notice = notice;
	}
	private int batchid;
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
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
}