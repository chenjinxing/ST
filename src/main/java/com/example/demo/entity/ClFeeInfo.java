package com.example.demo.entity;

public class ClFeeInfo {
	private Integer feeType;//" : 1,
    private Integer feePercent;//" : 1,
    private Long money;//" : 1,
    private String isIncludeLoan;//" : "",
    private Integer type;//" : 1
    
    public Integer getFeeType() {
		return feeType;
	}
	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}
	public Integer getFeePercent() {
		return feePercent;
	}
	public void setFeePercent(Integer feePercent) {
		this.feePercent = feePercent;
	}
	public Long getMoney() {
		return money;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
	public String getIsIncludeLoan() {
		return isIncludeLoan;
	}
	public void setIsIncludeLoan(String isIncludeLoan) {
		this.isIncludeLoan = isIncludeLoan;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

}
