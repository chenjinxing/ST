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
public class CI_ReqUpdateOrderAll extends ApiBase {

	
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
		CI_ReqUpdateOrderData reqData;
		ObjectMapper mapper = new ObjectMapper();  
		try {
			reqData =mapper.readValue(req, CI_ReqUpdateOrderData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return apiRtnInfo.getParma_invalid();
		}
		reqData.getFind().setAppid(partnerid);
		reqData.getOrder().setAppid(partnerid);
		
		
		List<CiOrder> testOrders =ciOrderService.find(reqData.getFind(), 0, 1);
		if(0 ==testOrders.size())
			return apiRtnInfo.getFail("订单不存在");
		//整个替换操作
		ciOrderService.delete(reqData.getFind());
		ciOrderService.insert(reqData.getOrder());
		
		CI_RtnUpdateOrderData rtn =new CI_RtnUpdateOrderData();
		rtn.setResult(1);
		rtn.setNotice("修改订单成功");
		
		try {
			String rtnStr =mapper.writeValueAsString(rtn);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apiRtnInfo.getFail("修改订单成功 返回失败");
	}
}
