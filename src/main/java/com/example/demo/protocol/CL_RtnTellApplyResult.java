package com.example.demo.protocol;

public class CL_RtnTellApplyResult {
	
	private boolean Flag;
	private String Msg;	// 其他平台分配的升通id
	
	public boolean isFlag() {
		return Flag;
	}
	public void setFlag(boolean flag) {
		this.Flag = flag;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		this.Msg = msg;
	}
}
