package com.example.demo.protocol;

public class GetBatchNumberData {
	private boolean flag;
	private String msg;	// 其他平台分配的升通id
	private String num; //批次号

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
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

}
