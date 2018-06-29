package com.example.demo.protocol;

import java.util.List;

import com.example.demo.entity.Partnertype;

public class CI_RtnPartnertypeData {

	public CI_RtnPartnertypeData()
	{}
	public CI_RtnPartnertypeData(int count, int result, String notice,
			List<Partnertype> data) {
		super();
		this.count = count;
		this.result = result;
		this.notice = notice;
		this.data = data;
	}
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	private int result;
	private String notice;
	private List<Partnertype> data;
	
	public List<Partnertype> getData() {
		return data;
	}
	public void setData(List<Partnertype> data) {
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