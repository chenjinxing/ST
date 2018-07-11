package com.example.demo.entity;

import java.util.List;

public class ClOrderData {
	private ClCustomer custData;	 //客户基本信息
	private ClSpoust spoust;		//配偶信息
	private List<ClEmergency> emergencyInfo;	//联系人信息
	private ClProInfo proInfo;	//项目详情
	private List<ClFeeInfo> feeInfo;	//费用信息
	private List<ClCar> carInfo;		//车辆信息
	private List<ClRepaymentPlan> repaymentPlan;	//还款计划
	private List<ClAudit> audit;		//审批意见
	
	public ClCustomer getCustData() {
		return custData;
	}
	public void setCustData(ClCustomer custData) {
		this.custData = custData;
	}
	public ClSpoust getSpoust() {
		return spoust;
	}
	public void setSpoust(ClSpoust spoust) {
		this.spoust = spoust;
	}
	public List<ClEmergency> getEmergencyInfo() {
		return emergencyInfo;
	}
	public void setEmergencyInfo(List<ClEmergency> emergencyInfo) {
		this.emergencyInfo = emergencyInfo;
	}
	public ClProInfo getProInfo() {
		return proInfo;
	}
	public void setProInfo(ClProInfo proInfo) {
		this.proInfo = proInfo;
	}
	public List<ClFeeInfo> getFeeInfo() {
		return feeInfo;
	}
	public void setFeeInfo(List<ClFeeInfo> feeInfo) {
		this.feeInfo = feeInfo;
	}
	public List<ClCar> getCarInfo() {
		return carInfo;
	}
	public void setCarInfo(List<ClCar> carInfo) {
		this.carInfo = carInfo;
	}
	public List<ClRepaymentPlan> getRepaymentPlan() {
		return repaymentPlan;
	}
	public void setRepaymentPlan(List<ClRepaymentPlan> repaymentPlan) {
		this.repaymentPlan = repaymentPlan;
	}
	public List<ClAudit> getAudit() {
		return audit;
	}
	public void setAudit(List<ClAudit> audit) {
		this.audit = audit;
	}

}
