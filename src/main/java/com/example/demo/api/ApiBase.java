package com.example.demo.api;

import org.slf4j.LoggerFactory;

public abstract class ApiBase {

	public ApiBase()
	{
		defaultRtnInfo ="";
	}
	
	public static org.slf4j.Logger log = LoggerFactory.getLogger(ApiBase.class);  
	
	public String defaultRtnInfo;
	//默认返回操作失败
	public abstract String doAction(int partner,String version,String action,int source,String req);
}
