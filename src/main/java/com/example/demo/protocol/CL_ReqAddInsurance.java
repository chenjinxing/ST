package com.example.demo.protocol;

public class CL_ReqAddInsurance {
	private String companyCode;
	private AddInsurance data;
	
	
	public AddInsurance getData() {
		return data;
	}

	public void setData(AddInsurance data) {
		this.data = data;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	} 
}
