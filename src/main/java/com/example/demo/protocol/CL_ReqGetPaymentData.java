package com.example.demo.protocol;

public class CL_ReqGetPaymentData {
	
	private Long proId;
	private String companyCode;
	private GetPaymentData data; 

	public Long getProId() {
		return proId;
	}
	public void setProId(Long proId) {
		this.proId = proId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public GetPaymentData getData() {
		return data;
	}
	public void setData(GetPaymentData data) {
		this.data = data;
	}
}
