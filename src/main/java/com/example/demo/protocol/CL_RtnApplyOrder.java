package com.example.demo.protocol;

import com.example.demo.entity.ClOrderData;

public class CL_RtnApplyOrder {
	
	private boolean flag;
	private String msg;	// 其他平台分配的升通id
	private ClOrderData data;
	
	
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
	public ClOrderData getData() {
		return data;
	}
	public void setData(ClOrderData data) {
		this.data = data;
	}

}
