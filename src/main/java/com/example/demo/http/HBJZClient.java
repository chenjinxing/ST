package com.example.demo.http;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.api.ApiBase;
import com.example.demo.entity.ClOrder;
import com.example.demo.protocol.CL_ReqAddInsurance;
import com.example.demo.protocol.CL_ReqApiDataList;
import com.example.demo.protocol.CL_ReqApiDataOne;
import com.example.demo.protocol.CL_ReqCheckedFourData;
import com.example.demo.protocol.CL_ReqDownLoadFile;
import com.example.demo.protocol.CL_ReqGetBatchNumber;
import com.example.demo.protocol.CL_ReqGetPaymentData;
import com.example.demo.protocol.CL_ReqMessageSigning;
import com.example.demo.protocol.CL_ReqSendEmail;
import com.example.demo.protocol.CL_ReqSingContract;
import com.example.demo.protocol.CL_ReqVinData;
import com.example.demo.protocol.CL_RtnAddInsurance;
import com.example.demo.protocol.CL_RtnApiDataList;
import com.example.demo.protocol.CL_RtnApiDataOne;
import com.example.demo.protocol.CL_RtnApplyOrder;
import com.example.demo.protocol.CL_RtnCheckedFourData;
import com.example.demo.protocol.CL_RtnGetBatchNumber;
import com.example.demo.protocol.CL_RtnGetPaymentData;
import com.example.demo.protocol.CL_RtnMessageSigning;
import com.example.demo.protocol.CL_RtnSendEmail;
import com.example.demo.protocol.CL_RtnSingContract;
import com.example.demo.protocol.CL_RtnVinData;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Service
public class HBJZClient {
	public static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ApiBase.class);
	//提交订单信息
	public boolean applyClOrder(ClOrder order)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/MavenSSM/user/orderTest.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(order),ClOrder.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        CL_RtnApplyOrder rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnApplyOrder.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//参数无效
			return false;
		}
		return rtnData.isFlag();
	}
	//四要素验证
	public CL_RtnCheckedFourData toCheckedFour(CL_ReqCheckedFourData checkData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/Project!/toCheckedFour.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(checkData),CL_ReqCheckedFourData.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        CL_RtnCheckedFourData rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnCheckedFourData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return rtnData;
	}
	//推送车辆vin
	public CL_RtnVinData toGetVin(CL_ReqVinData vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/Project!/toGetVin.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqVinData.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnVinData rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnVinData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return rtnData;
	}
	//合同附件获取
	public boolean toSendEmail(CL_ReqSendEmail vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiAgreement!/toSendEmail.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqSendEmail.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnSendEmail rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnSendEmail.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return rtnData.isFlag();
	}
	//下载文件附件
	public boolean toDownLoadFile(CL_ReqDownLoadFile vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiAgreement!/toSendEmail.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqDownLoadFile.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        //将下载的文件文件保存到本地(绑定项目订单)，然后提供给客户
        
        return false;
	}
	//协议支付短信 触发
	public boolean toMessageSigning(CL_ReqMessageSigning vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiAgreement!/toMessageSigning.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqMessageSigning.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnMessageSigning rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnMessageSigning.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return rtnData.isFlag();
	}
	
	//协议支付短信 签约
	public boolean toSingContract(CL_ReqSingContract vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiAgreement!/toMessageSigning.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqSingContract.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnSingContract rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnSingContract.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return rtnData.isFlag();
	}
	//放款结果同步发起  相当于在审核之后的请求放款
	public boolean toGetPaymentData(CL_ReqGetPaymentData vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiAgreement!/toGetPaymentData.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqGetPaymentData.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnGetPaymentData rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnGetPaymentData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return rtnData.isFlag();
	}
	//确认收款成功或者失败 提交的data数据中包括了批次号
	public boolean toGetBatchNumber(CL_ReqGetBatchNumber vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiAgreement!/toGetBatchNumber.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqGetBatchNumber.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnGetBatchNumber rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnGetBatchNumber.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return rtnData.isFlag();
	}
	//确认收款成功或者失败 提交的data数据中包括了批次号
	public boolean toGetRentList(CL_ReqGetBatchNumber vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiAgreement!/toGetRentList.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqGetBatchNumber.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnGetBatchNumber rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnGetBatchNumber.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return rtnData.isFlag();
	}

	//批量拉去资料清单
	public boolean getApiDataList(CL_ReqApiDataList vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiDataList.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqApiDataList.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnApiDataList rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnApiDataList.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return rtnData.isFlag();
	}
	//批量拉去资料清单
	public boolean getApiDataOne(CL_ReqApiDataOne vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiDataList.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqApiDataOne.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnApiDataOne rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnApiDataOne.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return rtnData.isFlag();
	}
	//保单创建
	public boolean addInsurance(CL_ReqAddInsurance vinData)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/api/ApiDataList.action")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(vinData),CL_ReqAddInsurance.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        String result =resp.block();
        
        CL_RtnAddInsurance rtnData;
        ObjectMapper mapper = new ObjectMapper();  
		try {
			rtnData =mapper.readValue(result, CL_RtnAddInsurance.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return rtnData.isFlag();
	}
}
