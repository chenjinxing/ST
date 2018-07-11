package com.example.demo.entity;

public class ClRepaymentPlan {
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getItemMoney() {
		return itemMoney;
	}
	public void setItemMoney(Long itemMoney) {
		this.itemMoney = itemMoney;
	}
	public Long getItemFlag() {
		return itemFlag;
	}
	public void setItemFlag(Long itemFlag) {
		this.itemFlag = itemFlag;
	}
	private String repaymentTerm;//" : "",
	private String payDate;//" : "",
	private String itemName;//" : "",
	private Long itemMoney;//" : 123,
	private Long itemFlag;//" : 12

}
