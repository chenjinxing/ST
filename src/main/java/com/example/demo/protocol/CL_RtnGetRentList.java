package com.example.demo.protocol;

public class CL_RtnGetRentList {
	private boolean flag;
	private String msg;	// 其他平台分配的升通id
	private String startdate; //起租日期
	private GetRentListData data; //每期还款计划一组数据

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
	
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public GetRentListData getData() {
		return data;
	}
	public void setData(GetRentListData data) {
		this.data = data;
	}

}
