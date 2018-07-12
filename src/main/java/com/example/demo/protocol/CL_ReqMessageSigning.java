package com.example.demo.protocol;

public class CL_ReqMessageSigning {
	private Long proId;
	private String companyCode;
	private MessageSigning data;
	
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
	public MessageSigning getData() {
		return data;
	}
	public void setData(MessageSigning data) {
		this.data = data;
	}

}
