package com.example.demo.entity;

//������Ϣ
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
   private String installmentid; // 11548,//����ID
   private Float installmentamount; // 4021.03,//�����ܶ�
   private Integer installmentno; // 1,//��������
   private Float principal; // 326.0,//���ڽ��
   private Float installmentcurrentamount; // 326.0,//����
   private Float interest; // 0.0,// ��Ϣ
   private Float latefee; // 0.0,// ���ɽ�
   private Float unlatefee; // 0.0,// �������ɽ�
   private String duedate; // "2017-08-10",//���ڻ�����
   private String tradingday; // "2017-07-04",//��������
   private Integer installmentstatus; // 1,// ����״̬ 1-����;2-�ѻ�
   private String repaymentdate; // "",//ʵ�ʻ���ʱ��
   private String repaymentperson; // null,// ʵ�ʻ���������
   private String paychannelname; // null,// ʵ�ʻ���֧��ͨ��
   private Float repaymentamount; // 0.0,// ʵ�ʻ�����
}
