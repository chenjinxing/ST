package com.example.demo.protocol;

public class CL_ReqGetBatchNumber {
	private String companyCode;
	private GetBatchNumberData data;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public GetBatchNumberData getData() {
		return data;
	}
	public void setData(GetBatchNumberData data) {
		this.data = data;
	}

}
