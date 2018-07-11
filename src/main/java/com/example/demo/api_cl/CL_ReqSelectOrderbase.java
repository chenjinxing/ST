package com.example.demo.api_cl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.api.ApiBase;
import com.example.demo.api.ApiRtnInfo;
import com.example.demo.entity.CiBatch;
import com.example.demo.entity.ClOrder;
import com.example.demo.entity.ClOrderData;
import com.example.demo.entity.ClOrderbase;
import com.example.demo.entity.Stuser;
import com.example.demo.protocol.RtnInsertOrderData;
import com.example.demo.service.ClOrderService;
import com.example.demo.service.ClOrderbaseService;
import com.example.demo.service.PartnerService;

@Service
public class CL_ReqSelectOrderbase extends ApiBase {

	@Resource
	ApiRtnInfo apiRtnInfo;
	
	@Resource
	private ClOrderService clOrderService;
	
	@Resource
	private ClOrderbaseService clOrderbaseService;
	
	@Resource
	private PartnerService partnerService;

	@Override
	public String doAction(int partnerid, String version, String action,
			int source, String req) {
		// TODO Auto-generated method stub
		//需要用到用户
		int mainUser =partnerService.selectMainUser(partnerid);
		return doActionByUser(mainUser,version,action,source,req);
	}
	public String doActionByUser(int userid, String version, String action,
			int source, String req) {
		// TODO Auto-generated method stub
		//解析查询条件
		CL_ReqOrderbaseData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CL_ReqOrderbaseData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		//查询总页数
		int pagetotal =clOrderbaseService.selectCountSelective(reqData.getOrder(), reqData.getPagesize());
		//查询数据
		List<ClOrderbase> data =clOrderbaseService.selectSelective(reqData.getOrder(), reqData.getPagesize(), reqData.getPageindex());
		//打包数据
		CL_RtnOrderbaseData rtn =new CL_RtnOrderbaseData();
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

class CL_ReqOrderbaseData
{
	public CL_ReqOrderbaseData()
	{}
	public CL_ReqOrderbaseData(ClOrderbase order, int pagesize, int pageindex) {
		super();
		this.order = order;
		this.pagesize = pagesize;
		this.pageindex = pageindex;
	}
	private ClOrderbase order;
	private int pagesize;
	private int pageindex =1;
	
	public ClOrderbase getOrder() {
		return order;
	}
	public void setOrder(ClOrderbase order) {
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

class CL_RtnOrderbaseData
{
	public CL_RtnOrderbaseData()
	{}
	public CL_RtnOrderbaseData(int pagetotal, int result, String notice,
			List<ClOrderbase> data) {
		super();
		this.pagetotal = pagetotal;
		this.result = result;
		this.notice = notice;
		this.data = data;
	}
	private int pagetotal;
	private int result;
	private String notice;
	private List<ClOrderbase> data;
	
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
	public List<ClOrderbase> getData() {
		return data;
	}
	public void setData(List<ClOrderbase> data) {
		this.data = data;
	}

}