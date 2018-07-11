package com.example.demo.protocol;

import java.util.List;

import com.example.demo.entity.ClOrderbase;

public class CI_RtnClOrderbaseData {

	public CI_RtnClOrderbaseData()
	{}
	public CI_RtnClOrderbaseData(int count, int result, String notice,
			List<ClOrderbase> data) {
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
	private List<ClOrderbase> data;
	
	public List<ClOrderbase> getData() {
		return data;
	}
	public void setData(List<ClOrderbase> data) {
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