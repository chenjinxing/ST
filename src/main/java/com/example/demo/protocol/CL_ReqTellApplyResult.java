package com.example.demo.protocol;


public class CL_ReqTellApplyResult {
	private String proId;
	private String companyCode;
	private ApplyResult Data;
	
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public ApplyResult getData() {
		return Data;
	}
	public void setData(ApplyResult data) {
		Data = data;
	}

}
