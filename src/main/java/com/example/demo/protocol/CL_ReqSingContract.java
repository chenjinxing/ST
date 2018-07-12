package com.example.demo.protocol;

public class CL_ReqSingContract {
	private Long proId;
	private String companyCode;
	private SingContract data;
	
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
	public SingContract getData() {
		return data;
	}
	public void setData(SingContract data) {
		this.data = data;
	}

}
