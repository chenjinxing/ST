package com.example.demo.protocol;

public class ApplyResult {
	private Integer Status;
	private String leaseCode;
	private String Msg;


	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public String getLeaseCode() {
		return leaseCode;
	}
	public void setLeaseCode(String leaseCode) {
		this.leaseCode = leaseCode;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}

}
