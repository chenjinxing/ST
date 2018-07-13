package com.example.demo.action;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.api.ApiManager;
import com.example.demo.api.CI_ReqPartnertype;
import com.example.demo.api.CI_ReqUpdateOrderAll;
import com.example.demo.api_cl.CL_ReqInsertOrder;
import com.example.demo.api_cl.CL_ReqUpdateOrder;
import com.example.demo.entity.ClAssetapplyresult;
import com.example.demo.entity.ClCar;
import com.example.demo.entity.ClOrder;
import com.example.demo.entity.ClOrderData;
import com.example.demo.entity.ClOrderbase;
import com.example.demo.entity.Partner;
import com.example.demo.entity.Partnerfile;
import com.example.demo.entity.Partnertype;
import com.example.demo.entity.Stuser;
import com.example.demo.fdfs.FastDFSClientWrapper;
import com.example.demo.http.HBJZClient;
import com.example.demo.protocol.CL_ReqCheckedFourData;
import com.example.demo.protocol.CL_ReqVinData;
import com.example.demo.protocol.CL_RtnCheckedFourData;
import com.example.demo.protocol.CL_RtnGetCarVin;
import com.example.demo.protocol.CL_RtnGetOrderCheckFour;
import com.example.demo.protocol.CL_RtnVinData;
import com.example.demo.protocol.CheckedFour;
import com.example.demo.protocol.VinData;
import com.example.demo.service.ClAssetapplyresultService;
import com.example.demo.service.ClOrderService;
import com.example.demo.service.ClOrderbaseService;
import com.example.demo.service.PartnerService;
import com.example.demo.service.PartnerfileService;
import com.example.demo.service.PartnertypeService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/carLoan")
public class CarLoanController extends BaseController{
	

	@RequestMapping("/clOrderInsert")
	public String partnerType(HttpServletRequest request) {
		return "carLoan/clOrderInsert";
	}
	@RequestMapping("/clOrderbaseSelect")
	public String partnerFile(HttpServletRequest request) {
		return "carLoan/clOrderbaseSelect";
	}
	@RequestMapping("/clOrderApplyResult")
	public String clOrderApplyResult(HttpServletRequest request) {
		return "carLoan/clOrderApplyResult";
	}
	@RequestMapping("/clOrderCheckFour")
	public String clOrderCheckFour(HttpServletRequest request) {
		return "carLoan/clOrderCheckFour";
	}
	@RequestMapping("/clSendCarVin")
	public String clSendCarVin(HttpServletRequest request) {
		return "carLoan/clSendCarVin";
	}

}

@RestController
@RequestMapping("/CarLoan")
class CarLoanPostController extends BaseController{
	
	@Resource
	CL_ReqInsertOrder reqInsertOrder;
	@Resource
	CL_ReqUpdateOrder reqUpdateOrder;
	
	@Resource
	ClOrderbaseService clOrderbaseService;
	
	@Resource
	ClOrderService clOrderService;
	
	@Resource
	UserService stuserService;
	
	@Resource
	ClAssetapplyresultService applyresultService;
	
	
	@Resource
	HBJZClient hbjzClient;
	
	@RequestMapping("/clOrderInsert")
	@ResponseBody
	public String clOrderInsert(String req) {
		
		String username=(String)SecurityUtils.getSubject().getPrincipal();
    	Stuser user =stuserService.getByUsername(username);
    	if(null ==user)
    		return "{\"result\":false,\"code\":0,\"msg\":\"新增订单失败\",\"data\":null}";
    	int uploaduser =user.getId();
    	return reqInsertOrder.doActionByUser(uploaduser,"1","1",1, req);
	}
	
	@RequestMapping("/clOrderDelete")
	@ResponseBody
	public String clOrderDelete(Integer proId) {
		int rtn =clOrderbaseService.deleteOrderbaseById(proId);
		if(0 ==rtn)
			return "{\"result\":false,\"code\":0,\"msg\":\"删除订单失败\",\"data\":null}";
		try {
			clOrderService.deleteById(String.valueOf(proId));
		}catch(Exception e)
		{
			return "{\"result\":false,\"code\":0,\"msg\":\"删除订单异常，请联系管理员\",\"data\":null}";
		}
		return "{\"result\":true,\"code\":0,\"msg\":\"删除订单成功\",\"data\":null}";
	}
	//提交申请
	@RequestMapping("/clOrderApply")
	@ResponseBody
	public String clOrderApply(Integer proId) {
		ClOrder data = clOrderService.findById(String.valueOf(proId));
		if(null ==data)
			return "{\"result\":false,\"code\":0,\"msg\":\"加载订单异常\",\"data\":null}";
		if(hbjzClient.applyClOrder(data))
			return "{\"result\":true,\"code\":0,\"msg\":\"申请提交成功\",\"data\":null}";
		
		return "{\"result\":false,\"code\":0,\"msg\":\"申请提交失败\",\"data\":null}";
	}
	
	@RequestMapping("/clOrderLoad")
	@ResponseBody
	public String clOrderLoad(Integer proId) {
		ClOrder data =clOrderService.findById(String.valueOf(proId));
		if(null ==data)
			return "{\"result\":false,\"code\":0,\"msg\":\"加载订单异常\",\"data\":null}";
		try {
			ObjectMapper mapper = new ObjectMapper();  
			String rtnStr =mapper.writeValueAsString(data);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
	}
	
	@RequestMapping("/clOrderUpdate")
	@ResponseBody
	public String clOrderUpdate(String req,Integer proId) {
		ClOrderData reqData;
		ObjectMapper mapper = new ObjectMapper(); 
		//忽略多余字段
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			reqData =mapper.readValue(req, ClOrderData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return "{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
		}
		return reqUpdateOrder.updateClOrderData(proId, reqData);
	}
	
	@RequestMapping("/clOrderbaseData")
	@ResponseBody
	public String clOrderbaseData(Integer limit, Integer offset, String search) {
		ClOrderbase orderbase =new ClOrderbase();
		return clOrderbaseService.selectByConditionJson(orderbase);
	}
	
	//查询一个订单的所有历史审核结果
	@RequestMapping("/clOrderApplyResult")
	@ResponseBody
	public String clOrderApplyResult(Integer limit, Integer offset, String search,String proid) {
		if(proid.isEmpty() ||proid.compareTo("") ==0 )
			proid="-1";
		return applyresultService.selectResultByProidJson(Integer.parseInt(proid));
	}
	
	//获取订单四要素
	@RequestMapping("/clOrderGetCheckFour")
	@ResponseBody
	public String clOrderGetCheckFour(String proid) {
		ClOrder data =clOrderService.findById(proid);
		if(null ==data)
			return "{\"result\":false,\"code\":0,\"msg\":\"加载订单异常\",\"data\":null}";
		CheckedFour four= new CheckedFour();
		four.setBankCardMobile(data.getData().getProInfo().getBankCardMobile());
		four.setBankCardNo(data.getData().getProInfo().getBankCardNo());
		four.setBankName(data.getData().getProInfo().getBankName());
		four.setCustName(data.getData().getCustData().getCustName());
		four.setIdCard(data.getData().getCustData().getIdcardNo());
		CL_RtnGetOrderCheckFour rtnGetFour =new CL_RtnGetOrderCheckFour();
		rtnGetFour.setCount(1);
		rtnGetFour.setData(four);
		rtnGetFour.setResult(1);
		rtnGetFour.setNotice("查询成功");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String rtnStr =mapper.writeValueAsString(rtnGetFour);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
	}
	//四要素认证
	@RequestMapping("/clOrderCheckFour")
	@ResponseBody
	public String clOrderCheckFour(String proid,String bankCardNo,String bankName,String bankCardMobile,String idCard,String custName) {
		String failRtn ="{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
		if(null ==proid||null ==bankCardNo||null ==bankName||null ==bankCardMobile||null ==idCard||null ==custName)
			return failRtn;
		if(proid.isEmpty() ||bankCardNo.isEmpty() ||bankName.isEmpty() ||bankCardMobile.isEmpty() ||idCard.isEmpty() ||custName.isEmpty())
			return failRtn;
		CL_ReqCheckedFourData checkFour =new CL_ReqCheckedFourData();
		checkFour.setCompanyCode("shengtongCode");
		checkFour.setProId(Long.parseLong(proid));
		CheckedFour checkFourData =new CheckedFour();
		checkFourData.setBankCardMobile(bankCardMobile);
		checkFourData.setBankCardNo(bankCardNo);
		checkFourData.setBankName(bankName);
		checkFourData.setCustName(custName);
		checkFourData.setIdCard(idCard);
		checkFour.setData(checkFourData);
		
		
		CL_RtnCheckedFourData rtnData= hbjzClient.toCheckedFour(checkFour);
		if(null ==rtnData)
			return failRtn;
		String result ="-1";
		if(rtnData.isFlag())
			result ="1";
		String notice =rtnData.getMsg();
		return "{\"result\":"+result+",\"count\":0,\"notice\":"+notice+",\"data\":[]}";
	}
	
	//获取现有订单中的VIN
	@RequestMapping("/clGetCarVin")
	@ResponseBody
	public String clGetCarVin(String proid) {
		ClOrder data =clOrderService.findById(proid);
		if(null ==data)
			return "{\"result\":false,\"code\":0,\"msg\":\"加载订单异常\",\"data\":null}";
		VinData vinData =new VinData();
		
		List<ClCar> cars =data.getData().getCarInfo();
		if(cars.size() !=0)
		{
			ClCar car =cars.get(0);
			//vinData.setCarColor();
			vinData.setCarEngine(car.getEngineNo());
			vinData.setCarId(car.getCarId());
			//vinData.setCarNum(); //车牌号
			vinData.setCarType(car.getSeries());
			vinData.setVin(car.getVIN());
		}
		
		CL_RtnGetCarVin rtnGetVin =new CL_RtnGetCarVin();
		rtnGetVin.setCount(1);
		rtnGetVin.setData(vinData);
		rtnGetVin.setResult(1);
		rtnGetVin.setNotice("查询成功");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String rtnStr =mapper.writeValueAsString(rtnGetVin);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
	}
	//发送Vin信息到资金方
	@RequestMapping("/clSendCarVin")
	@ResponseBody
	public String clSendCarVin(String proid,String carColor,String carEngine,String carId,String carNum,String carType,String vin) {
		String failRtn ="{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
		if(null ==proid||null ==carColor||null ==carEngine||null ==carId||null ==carNum||null ==carType||null ==vin)
			return failRtn;
		if(proid.isEmpty()||carColor.isEmpty()||carEngine.isEmpty()||carId.isEmpty()||carNum.isEmpty()||carType.isEmpty()||vin.isEmpty())
			return failRtn;
		
		VinData vinData =new VinData();
		vinData.setCarColor(carColor);
		vinData.setCarEngine(carEngine);
		vinData.setCarId(Long.parseLong(carId));
		vinData.setCarNum(carNum);
		vinData.setCarType(carType);
		vinData.setVin(vin);
		
		CL_ReqVinData reqVinData =new CL_ReqVinData(); 
		reqVinData.setCompanyCode("shengtongCode");
		reqVinData.setProId(proid);
		reqVinData.setData(vinData);
		
		CL_RtnVinData rtnData= hbjzClient.toGetVin(reqVinData);
		if(null ==rtnData)
			return failRtn;
		String result ="-1";
		if(rtnData.isFlag())
			result ="1";
		String notice =rtnData.getMsg();
		return "{\"result\":"+result+",\"count\":0,\"notice\":"+notice+",\"data\":[]}";
	}
}



