package com.example.demo.protocol;

public class GetPaymentData {
	private Long proId;
	private String loanTime;
	private String loanNum;
	private Float loanMoney;
	private Float carMoney;
	private Long lendingType;
	private String intStart;
	private Long loanCode;
	
	public Long getProId() {
		return proId;
	}
	public void setProId(Long proId) {
		this.proId = proId;
	}
	public String getLoanTime() {
		return loanTime;
	}
	public void setLoanTime(String loanTime) {
		this.loanTime = loanTime;
	}
	public String getLoanNum() {
		return loanNum;
	}
	public void setLoanNum(String loanNum) {
		this.loanNum = loanNum;
	}
	public Float getLoanMoney() {
		return loanMoney;
	}
	public void setLoanMoney(Float loanMoney) {
		this.loanMoney = loanMoney;
	}
	public Float getCarMoney() {
		return carMoney;
	}
	public void setCarMoney(Float carMoney) {
		this.carMoney = carMoney;
	}
	public Long getLendingType() {
		return lendingType;
	}
	public void setLendingType(Long lendingType) {
		this.lendingType = lendingType;
	}
	public String getIntStart() {
		return intStart;
	}
	public void setIntStart(String intStart) {
		this.intStart = intStart;
	}
	public Long getLoanCode() {
		return loanCode;
	}
	public void setLoanCode(Long loanCode) {
		this.loanCode = loanCode;
	}

}
