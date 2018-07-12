package com.example.demo.protocol;

public class CL_RtnSendEmail {
	private boolean flag;
	private String msg;	// 其他平台分配的升通id
	private SendEmailRtnData data;

	public SendEmailRtnData getData() {
		return data;
	}
	public void setData(SendEmailRtnData data) {
		this.data = data;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
