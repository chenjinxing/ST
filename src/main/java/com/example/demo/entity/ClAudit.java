package com.example.demo.entity;

public class ClAudit {
	
	private String proStage;//" : "",
	private String remark;//" : "",
	private String result;//" : "",
	private String auditTime;//" : "",
	private String op;//" : ""
	
	public String getProStage() {
		return proStage;
	}
	public void setProStage(String proStage) {
		this.proStage = proStage;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}

}
