package com.example.demo.protocol;

public class CL_ReqPaymentLoanData {
	private String companyCode;
	private PaymentData data;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public PaymentData getData() {
		return data;
	}
	public void setData(PaymentData data) {
		this.data = data;
	}

}
