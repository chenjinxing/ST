package com.example.demo.entity;

//险种信息
public class CiCoverage
{
	 public Integer getInsurertype() {
		return insurertype;
	}
	public void setInsurertype(Integer insurertype) {
		this.insurertype = insurertype;
	}
	public String getCoveragecode() {
		return coveragecode;
	}
	public void setCoveragecode(String coveragecode) {
		this.coveragecode = coveragecode;
	}
	public String getCoveragename() {
		return coveragename;
	}
	public void setCoveragename(String coveragename) {
		this.coveragename = coveragename;
	}
	public Float getInsuredpremium() {
		return insuredpremium;
	}
	public void setInsuredpremium(Float insuredpremium) {
		this.insuredpremium = insuredpremium;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getNotdeductible() {
		return notdeductible;
	}
	public void setNotdeductible(String notdeductible) {
		this.notdeductible = notdeductible;
	}
	public Float getNcfPremium() {
		return ncfPremium;
	}
	public void setNcfPremium(Float ncfPremium) {
		this.ncfPremium = ncfPremium;
	}
	private Integer insurertype; // 1,//险种类型1-商业险,2-交强险
  private String coveragecode; // "VehicleDemageIns",//险种代码
  private String coveragename; // "机动车损失保险",//险种名称
  private Float insuredpremium; // 1231.65,//保费
  private Float amount; // 33966.4,//保额
  private String notdeductible; // true ,//是否不计免赔
  private Float ncfPremium; // 3.00 //不计免赔金额
}