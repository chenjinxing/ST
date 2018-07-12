package com.example.demo.protocol;

import java.util.List;

public class CL_RtnApiDataOne {
	private boolean flag;
	private String msg;	// 其他平台分配的升通id
	private List<ApiDataList> data;
	private Integer num;

	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
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
	public List<ApiDataList> getData() {
		return data;
	}
	public void setData(List<ApiDataList> data) {
		this.data = data;
	}
}
