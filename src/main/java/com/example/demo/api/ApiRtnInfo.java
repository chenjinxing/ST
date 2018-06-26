package com.example.demo.api;


import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ApiRtnInfo {

	@Value("{\"result\":\"1\",\"notice\":\"操作成功\"}")
	private String success;

	@Value("'{'\"result\":\"2\",\"notice\":\"操作失败！{0}\"'}'")
	private String fail;

	@Value("'{'\"result\":\"3\",\"notice\":\"部分成功：{0}成功,{1}失败\"'}'")
	private String partial_success;

	@Value("'{'\"result\":\"4\",\"notice\":\"操作异常：异常信息{0}\"'}'")
	private String exception;

	@Value("'{'\"result\":\"5\",\"notice\":\"{0}已经存在\"'}'")
	private String has_exist;

	@Value("'{'\"result\":\"6\",\"notice\":\"{0}不存在\"'}'")
	private String not_exist;

	@Value("{\"result\":\"7\",\"notice\":\"身份验证失败\"}")
	private String authentication_failed;

	@Value("{\"result\":\"8\",\"notice\":\"未提供实现\"}")
	private String unrealize;

	@Value("'{'\"result\":\"9\",\"notice\":\"参数{0}无效:{1}\"'}'")
	private String parma_invalid;

	@Value("{\"result\":\"10\",\"notice\":\"数据传输异常\"}")
	private String transfer_error;

	@Value("{\"result\":\"11\",\"notice\":\"无此权限\"}")
	private String no_permission;
	
	@Value("{\"result\":\"12\",\"notice\":\"接口初始化失败\"}")
	private String fail_init_interface;

	public String getFail_init_interface() {
		return fail_init_interface;
	}


	public void setFail_init_interface(String fail_init_interface) {
		this.fail_init_interface = fail_init_interface;
	}


	public String getSuccess() {
		return success;
	}


	public void setSuccess(String success) {
		this.success = success;
	}


	public String getFail() {
		return fail;
	}
	public String getFail(Object ...info) {
		String format =fail.replace("{0}", info.toString());
		format =MessageFormat.format(fail, info);
		return format;
	}

	public void setFail(String fail) {
		this.fail = fail;
	}


	public String getPartial_success() {
		return partial_success;
	}

	public String getPartial_success(Object ...objects) {
		return MessageFormat.format(partial_success, objects);
	}
	public void setPartial_success(String partial_success) {
		this.partial_success = partial_success;
	}


	public String getException() {
		return exception;
	}

	public String getException(Object ...objects) {
		return MessageFormat.format(exception, objects);
	}
	
	public void setException(String exception) {
		this.exception = exception;
	}


	public String getHas_exist() {
		return has_exist;
	}
	public String getHas_exist(Object ...objects) {
		return MessageFormat.format(has_exist, objects);
	}

	public void setHas_exist(String has_exist) {
		this.has_exist = has_exist;
	}


	public String getNot_exist() {
		return not_exist;
	}
	public String getNot_exist(Object ...objects) {
		return MessageFormat.format(not_exist, objects);
	}

	public void setNot_exist(String not_exist) {
		this.not_exist = not_exist;
	}


	public String getAuthentication_failed() {
		return authentication_failed;
	}


	public void setAuthentication_failed(String authentication_failed) {
		this.authentication_failed = authentication_failed;
	}


	public String getUnrealize() {
		return unrealize;
	}
	

	public void setUnrealize(String unrealize) {
		this.unrealize = unrealize;
	}


	public String getParma_invalid() {
		return parma_invalid;
	}
	public String getParma_invalid(Object ...objects) {
		return MessageFormat.format(parma_invalid, objects);
	}

	public void setParma_invalid(String parma_invalid) {
		this.parma_invalid = parma_invalid;
	}


	public String getTransfer_error() {
		return transfer_error;
	}


	public void setTransfer_error(String transfer_error) {
		this.transfer_error = transfer_error;
	}


	public String getNo_permission() {
		return no_permission;
	}


	public void setNo_permission(String no_permission) {
		this.no_permission = no_permission;
	}

}
//
//@Value("${info.success}")
//private String success;
//
//@Value("${info.fail}")
//private String fail;
//
//@Value("${info.partial_success}")
//private String partial_success;
//
//@Value("${info.exception}")
//private String exception;
//
//@Value("${info.has_exist}")
//private String has_exist;
//
//@Value("${info.not_exist}")
//private String not_exist;
//
//@Value("${info.authentication_failed}")
//private String authentication_failed;
//
//@Value("${info.unrealize}")
//private String unrealize;
//
//@Value("${info.parma_invalid}")
//private String parma_invalid;
//
//@Value("${info.transfer_error}")
//private String transfer_error;
//
//@Value("${info.no_permission}")
//private String no_permission;
//
//@Value("${info.fail_init_interface}")
//private String fail_init_interface;