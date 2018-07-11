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
import com.example.demo.entity.ClOrder;
import com.example.demo.entity.ClOrderData;
import com.example.demo.entity.ClOrderbase;
import com.example.demo.entity.Stuser;
import com.example.demo.protocol.RtnInsertOrderData;
import com.example.demo.service.ClOrderService;
import com.example.demo.service.ClOrderbaseService;
import com.example.demo.service.PartnerService;

@Service
public class CL_ReqUpdateOrder extends ApiBase {

	
	public void test()
	{
		System.out.print("test");
	}
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
		//解析插入条件
		return apiRtnInfo.getParma_invalid();
	}
	public String updateClOrderData(int proId,ClOrderData reqData)
	{
		
		//update time
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	String updatetime =df.format(new Date());// new Date()为获取当前系统时间
    	
    	ClOrderbase orderBase =new ClOrderbase();
    	orderBase.setProid(proId);
		orderBase.setCustname(reqData.getCustData().getCustName());
		orderBase.setIdcardtype(reqData.getCustData().getIdCardType());
		orderBase.setIdcardno(reqData.getCustData().getIdcardNo());
		orderBase.setLeaseterm(reqData.getProInfo().getLeaseTerm().intValue());
		orderBase.setLeaseperiod(reqData.getProInfo().getLeasePeriod().intValue());
		orderBase.setLeasetopric(reqData.getProInfo().getLeaseTopric());
		orderBase.setLoanmoney(reqData.getProInfo().getLoanMoney());
		orderBase.setUpdatetime(updatetime);
		
		int updateRtn =clOrderbaseService.updateOrderbase(orderBase);
		if(updateRtn == 0)
			return apiRtnInfo.getFail();
		
		//受影响的行数
		int insertId  =orderBase.getProid();
		reqData.getProInfo().setProId(Long.valueOf(insertId));
		reqData.getProInfo().setProCode(String.valueOf(insertId));
		
		ClOrder testOrder =new ClOrder();
		testOrder.setId(String.valueOf(insertId));
		testOrder.setProId(insertId);
		testOrder.setCompanyCode("shengtongCode");
		testOrder.setData(reqData);
		
		//更新操作
		clOrderService.deleteById(String.valueOf(proId));
		clOrderService.insert(testOrder);

		RtnInsertOrderData rtn =new RtnInsertOrderData();
		rtn.setResult(1);
		rtn.setNotice("更新订单成功");

		try {
			ObjectMapper mapper = new ObjectMapper();  
			String rtnStr =mapper.writeValueAsString(rtn);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apiRtnInfo.getFail();
	}
}
