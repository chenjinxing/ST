package com.example.demo.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.CiBatch;
import com.example.demo.service.CIBatchService;

@Service
public class CI_ReqDeleteOrder extends ApiBase {

	
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
		return defaultRtnInfo;
	}
}

class CI_ReqOrderDeleteData
{
	public CI_ReqOrderDeleteData()
	{}
	public CI_ReqOrderDeleteData(int assetsid, int pagesize, int pageindex) {
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
class CI_RtnOrderDeleteData
{
	public CI_RtnOrderDeleteData()
	{}
	public CI_RtnOrderDeleteData(int pagetotal, int result, String notice,
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