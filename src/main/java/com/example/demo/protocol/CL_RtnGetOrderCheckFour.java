package com.example.demo.protocol;

public class CL_RtnGetOrderCheckFour {
	public CL_RtnGetOrderCheckFour()
	{}
	public CL_RtnGetOrderCheckFour(int count, int result, String notice,
			CheckedFour data) {
		super();
		this.count = count;
		this.result = result;
		this.notice = notice;
		this.data = data;
	}
	private int count;
	private int result;
	private String notice;
	private CheckedFour data;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	public CheckedFour getData() {
		return data;
	}
	public void setData(CheckedFour data) {
		this.data = data;
	}
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
