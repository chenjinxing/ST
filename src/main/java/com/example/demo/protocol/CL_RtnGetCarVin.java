package com.example.demo.protocol;

public class CL_RtnGetCarVin {
	public CL_RtnGetCarVin()
	{}
	public CL_RtnGetCarVin(int count, int result, String notice,
			VinData data) {
		super();
		this.count = count;
		this.result = result;
		this.notice = notice;
		this.data = data;
	}
	private int count;
	private int result;
	private String notice;
	private VinData data;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	public VinData getData() {
		return data;
	}
	public void setData(VinData data) {
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
