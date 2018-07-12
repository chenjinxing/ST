package com.example.demo.protocol;

public class CL_ReqVinData {
	private String proId;
	private String companyCode;
	private VinData data;
	
	
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
	public VinData getData() {
		return data;
	}
	public void setData(VinData data) {
		this.data = data;
	}

}
