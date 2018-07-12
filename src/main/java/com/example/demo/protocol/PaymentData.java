package com.example.demo.protocol;

import java.util.Date;
import java.util.List;

public class PaymentData {
	private Float loanMoney;
	private Integer loanBum;
	private Date loanDate;
	private String bankName;
	private String bankAccount;
	private String num;
	private List<PaymentLoanData> loanData;	
	
	public Float getLoanMoney() {
		return loanMoney;
	}
	public void setLoanMoney(Float loanMoney) {
		this.loanMoney = loanMoney;
	}
	public Integer getLoanBum() {
		return loanBum;
	}
	public void setLoanBum(Integer loanBum) {
		this.loanBum = loanBum;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public List<PaymentLoanData> getLoanData() {
		return loanData;
	}
	public void setLoanData(List<PaymentLoanData> loanData) {
		this.loanData = loanData;
	}


}
