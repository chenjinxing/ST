package com.example.demo.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.service.CIBatchService;

@Service
public class CI_ReqUpdateBatch extends ApiBase {

	
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
		CI_ReqBatchUpdateData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CI_ReqBatchUpdateData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		reqData.getFind().setPartnerid(partnerid);
		reqData.getBatch().setPartnerid(partnerid);
		
		List<CiBatch> batchs =ciBatchService.selectBatchSelective(reqData.getFind());
		if(1 !=batchs.size())
			return apiRtnInfo.getFail("batch不存在");
		reqData.getBatch().setBatchid(batchs.get(0).getBatchid());
		
		int updateRtn =ciBatchService.updateBatch(reqData.getBatch());
		if(1 !=updateRtn)
			return apiRtnInfo.getFail();
		CI_RtnBatchUpdateData rtn =new CI_RtnBatchUpdateData();
		rtn.setResult(1);
		rtn.setNotice("更新成功");
		try {
			String rtnStr =mapper.writeValueAsString(rtn);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apiRtnInfo.getFail("更新成功 返回数据失败");
	}
}
class CI_ReqBatchUpdateData
{
	public CI_ReqBatchUpdateData()
	{}
	public CI_ReqBatchUpdateData( CiBatch find, CiBatch batch) {
		super();
		this.find = find;
		this.batch = batch;
	}
	private CiBatch find;
	private CiBatch batch;
	
	public CiBatch getFind() {
		return find;
	}
	public void setFind(CiBatch find) {
		this.find = find;
	}
	public CiBatch getBatch() {
		return batch;
	}
	public void setBatch(CiBatch batch) {
		this.batch = batch;
	}

}

class CI_RtnBatchUpdateData
{
	public CI_RtnBatchUpdateData()
	{}
	public CI_RtnBatchUpdateData( int result, String notice) {
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