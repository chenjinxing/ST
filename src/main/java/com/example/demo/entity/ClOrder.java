package com.example.demo.entity;

public class ClOrder {
	private String id;
	private Integer proId;
	private String companyCode;	// 其他平台分配的升通id
	private ClOrderData data;
	
	public ClOrder() {
	}
	public ClOrder(String id2) {
		// TODO Auto-generated constructor stub
		this.id=id2;
	}
	
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public ClOrderData getData() {
		return data;
	}
	public void setData(ClOrderData data) {
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
