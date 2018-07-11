package com.example.demo.api;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.example.demo.api_cl.CL_ReqInsertOrder;
import com.example.demo.entity.Partner;
import com.example.demo.service.PartnerService;
import com.example.demo.service.PermissionService;

@Service
public class ApiManager {
	
	public static org.slf4j.Logger log = LoggerFactory.getLogger(ApiBase.class);  
	
	@Autowired
	private ApiRtnInfo apiRtnInfo;
	
	//所有的 api 方法 
	private	Map<String,ApiBase> allApi =new HashMap<String,ApiBase>();
	
	@Resource
	private PartnerService partnerService;
	
	@Resource
	private PermissionService permissionService;
	
	@Resource
	private CI_ReqBatch cI_ReqBatch;
	@Resource
	private CI_ReqInsertBatch cI_ReqInsertBatch;
	@Resource
	private CI_ReqUpdateBatch cI_ReqUpdateBatch;
	@Resource
	private CI_ReqDeleteBatch cI_ReqDeleteBatch;
	@Resource
	private CI_ReqOrder cI_ReqOrder;
	@Resource
	private CI_ReqInsertOrder cI_ReqInsertOrder;
	@Resource
	private CI_ReqUpdateOrder cI_ReqUpdateOrder;
	@Resource
	private CI_ReqDeleteOrder cI_ReqDeleteOrder;
	
	@Resource
	private CI_ReqUpdateOrderAll cI_ReqUpdateOrderAll;
	@Resource
	private CI_ReqUpdateOrderInstallMent cI_ReqUpdateOrderInstallMent;
	
	@Resource
	private CL_ReqInsertOrder cL_ReqInsertOrder;
	
	@PostConstruct
	private void initApi()
	{
		allApi.put("CI_ReqBatch",cI_ReqBatch);
		allApi.put("CI_ReqInsertBatch",cI_ReqInsertBatch);
		allApi.put("CI_ReqUpdateBatch",cI_ReqUpdateBatch);
		allApi.put("CI_ReqDeleteBatch",cI_ReqDeleteBatch);
		
		allApi.put("CI_ReqOrder",cI_ReqOrder);
		allApi.put("CI_ReqInsertOrder",cI_ReqInsertOrder);
		allApi.put("CI_ReqUpdateOrder",cI_ReqUpdateOrder);
		allApi.put("CI_ReqUpdateOrderAll",cI_ReqUpdateOrderAll);
		allApi.put("CI_ReqUpdateOrderInstallMent",cI_ReqUpdateOrderInstallMent);
		allApi.put("CI_ReqDeleteOrder",cI_ReqDeleteOrder);
	}
	
	public ApiManager() {
	}

	//获取请求
	public String receivePost(String partnercode,String version,String action,int source,String req,String reqhash)
	{
		String permissionCode =action;
		//找到相应的api
		if(!allApi.containsKey(action))
			return apiRtnInfo.getUnrealize();
		//验证身份是否
		Partner partner =partnerService.selectByPartnerCode(partnercode);
		if(null ==partner)
			return apiRtnInfo.getAuthentication_failed();
		//验证权限
		if(!permissionService.hasPermission(partner.getPartnerid(), permissionCode,source))
			return apiRtnInfo.getNo_permission();
		//验证数据合法性
		String str =req + partner.getPartnerkey();
		String md5Str = DigestUtils.md5DigestAsHex(str.getBytes(Charset.forName("UTF-8")));
		if(0 != md5Str.compareTo(reqhash))
			return apiRtnInfo.getTransfer_error();
		//操作
		ApiBase api =allApi.get(action);
		if(null ==api)
			return apiRtnInfo.getFail_init_interface();
		return api.doAction(partner.getPartnerid(), version, action, source, req);		
	}
}
