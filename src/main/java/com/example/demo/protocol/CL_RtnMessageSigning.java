package com.example.demo.protocol;


public class CL_RtnMessageSigning {
	
	private boolean Flag;
	private String msg;
	private MessageSigningRtn data;
	
	
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
	public MessageSigningRtn getData() {
		return data;
	}
	public void setData(MessageSigningRtn data) {
		this.data = data;
	}

}
