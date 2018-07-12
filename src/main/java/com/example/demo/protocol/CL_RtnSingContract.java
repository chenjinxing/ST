package com.example.demo.protocol;

public class CL_RtnSingContract {
	private boolean Flag;
	private String msg;
	private SingContractRtn data;
	
	
	public boolean isFlag() {
		return Flag;
	}
	public void setFlag(boolean flag) {
		Flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public SingContractRtn getData() {
		return data;
	}
	public void setData(SingContractRtn data) {
		this.data = data;
	}

}
