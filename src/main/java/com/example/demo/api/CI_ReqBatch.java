package com.example.demo.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.service.CIBatchService;

@Service
public class CI_ReqBatch extends ApiBase {

	
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
		//解析查询条件
		CI_ReqBatchData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CI_ReqBatchData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		reqData.getBatch().setPartnerid(partnerid);
		//查询总页数
		int pagetotal =ciBatchService.selectBatchCountSelective(reqData.getBatch(), reqData.getPagesize());
		//查询数据
		List<CiBatch> data =ciBatchService.selectBatchSelective(reqData.getBatch(), reqData.getPagesize(), reqData.getPageindex());
		//打包数据
		CI_RtnBatchData rtn =new CI_RtnBatchData();
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

class CI_ReqBatchData
{
	public CI_ReqBatchData()
	{}
	public CI_ReqBatchData(CiBatch batch, int pagesize, int pageindex) {
		super();
		this.batch = batch;
		this.pagesize = pagesize;
		this.pageindex = pageindex;
	}
	private CiBatch batch;
	private int pagesize;
	private int pageindex =1;
	
	public CiBatch getBatch() {
		return batch;
	}
	public void setBatch(CiBatch batch) {
		this.batch = batch;
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
class CI_RtnBatchData
{
	public CI_RtnBatchData()
	{}
	public CI_RtnBatchData(int pagetotal, int result, String notice,
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