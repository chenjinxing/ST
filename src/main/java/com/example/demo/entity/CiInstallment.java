package com.example.demo.entity;

//分期信息
public class CiInstallment
{
	 public String getInstallmentid() {
		return installmentid;
	}
	public void setInstallmentid(String installmentid) {
		this.installmentid = installmentid;
	}
	public Float getInstallmentamount() {
		return installmentamount;
	}
	public void setInstallmentamount(Float installmentamount) {
		this.installmentamount = installmentamount;
	}
	public Integer getInstallmentno() {
		return installmentno;
	}
	public void setInstallmentno(Integer installmentno) {
		this.installmentno = installmentno;
	}
	public Float getPrincipal() {
		return principal;
	}
	public void setPrincipal(Float principal) {
		this.principal = principal;
	}
	public Float getInstallmentcurrentamount() {
		return installmentcurrentamount;
	}
	public void setInstallmentcurrentamount(Float installmentcurrentamount) {
		this.installmentcurrentamount = installmentcurrentamount;
	}
	public Float getInterest() {
		return interest;
	}
	public void setInterest(Float interest) {
		this.interest = interest;
	}
	public Float getLatefee() {
		return latefee;
	}
	public void setLatefee(Float latefee) {
		this.latefee = latefee;
	}
	public Float getUnlatefee() {
		return unlatefee;
	}
	public void setUnlatefee(Float unlatefee) {
		this.unlatefee = unlatefee;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getTradingday() {
		return tradingday;
	}
	public void setTradingday(String tradingday) {
		this.tradingday = tradingday;
	}
	public Integer getInstallmentstatus() {
		return installmentstatus;
	}
	public void setInstallmentstatus(Integer installmentstatus) {
		this.installmentstatus = installmentstatus;
	}
	public String getRepaymentdate() {
		return repaymentdate;
	}
	public void setRepaymentdate(String repaymentdate) {
		this.repaymentdate = repaymentdate;
	}
	public String getRepaymentperson() {
		return repaymentperson;
	}
	public void setRepaymentperson(String repaymentperson) {
		this.repaymentperson = repaymentperson;
	}
	public String getPaychannelname() {
		return paychannelname;
	}
	public void setPaychannelname(String paychannelname) {
		this.paychannelname = paychannelname;
	}
	public Float getRepaymentamount() {
		return repaymentamount;
	}
	public void setRepaymentamount(Float repaymentamount) {
		this.repaymentamount = repaymentamount;
	}
 private String installmentid; // 11548,//分期ID
 private Float installmentamount; // 4021.03,//分期总额
 private Integer installmentno; // 1,//分期期数
 private Float principal; // 326.0,//本期金额
 private Float installmentcurrentamount; // 326.0,//本金
 private Float interest; // 0.0,// 利息
 private Float latefee; // 0.0,// 滞纳金
 private Float unlatefee; // 0.0,// 减免滞纳金
 private String duedate; // "2017-08-10",//到期还款日
 private String tradingday; // "2017-07-04",//交易日期
 private Integer installmentstatus; // 1,// 还款状态 1-待还;2-已还
 private String repaymentdate; // "",//实际还款时间
 private String repaymentperson; // null,// 实际还款人姓名
 private String paychannelname; // null,// 实际还款支付通道
 private Float repaymentamount; // 0.0,// 实际还款金额
}
