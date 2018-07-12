package com.example.demo.protocol;

public class CL_ReqSendEmail {
	private String proId;
	private String companyCode;
	private SendEmail data;
	

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
	public SendEmail getData() {
		return data;
	}
	public void setData(SendEmail data) {
		this.data = data;
	}
}
