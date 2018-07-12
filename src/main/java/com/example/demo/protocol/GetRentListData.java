package com.example.demo.protocol;

public class GetRentListData {
	
	private String repaymentTerm;
	private String payDate;
	private Long rent;
	private Long principal;
	private Long interest;
	private Long residualPrincipal;
	
	
	public String getRepaymentTerm() {
		return repaymentTerm;
	}
	public void setRepaymentTerm(String repaymentTerm) {
		this.repaymentTerm = repaymentTerm;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public Long getRent() {
		return rent;
	}
	public void setRent(Long rent) {
		this.rent = rent;
	}
	public Long getPrincipal() {
		return principal;
	}
	public void setPrincipal(Long principal) {
		this.principal = principal;
	}
	public Long getInterest() {
		return interest;
	}
	public void setInterest(Long interest) {
		this.interest = interest;
	}
	public Long getResidualPrincipal() {
		return residualPrincipal;
	}
	public void setResidualPrincipal(Long residualPrincipal) {
		this.residualPrincipal = residualPrincipal;
	}

}
