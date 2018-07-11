package com.example.demo.protocol;

public class RtnInsertOrderData
{
	public RtnInsertOrderData()
	{}
	public RtnInsertOrderData(int result, String notice) {
		super();
		this.result = result;
		this.notice = notice;
	}
	private int result;
	private String notice;
	
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
}