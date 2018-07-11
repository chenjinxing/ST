package com.example.demo.entity;


//保单信息
public class CiPolicy
{

public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getPolicystartdate() {
		return policystartdate;
	}
	public void setPolicystartdate(String policystartdate) {
		this.policystartdate = policystartdate;
	}
	public String getPolicyenddate() {
		return policyenddate;
	}
	public void setPolicyenddate(String policyenddate) {
		this.policyenddate = policyenddate;
	}
	public Integer getPolicystatus() {
		return policystatus;
	}
	public void setPolicystatus(Integer policystatus) {
		this.policystatus = policystatus;
	}
	public String getProposalno() {
		return proposalno;
	}
	public void setProposalno(String proposalno) {
		this.proposalno = proposalno;
	}
	public Float getInsuredpremium() {
		return insuredpremium;
	}
	public void setInsuredpremium(Float insuredpremium) {
		this.insuredpremium = insuredpremium;
	}
	public Float getOtherpremium() {
		return otherpremium;
	}
	public void setOtherpremium(Float otherpremium) {
		this.otherpremium = otherpremium;
	}
	public String getInsurerpartnername() {
		return insurerpartnername;
	}
	public void setInsurerpartnername(String insurerpartnername) {
		this.insurerpartnername = insurerpartnername;
	}
	public Integer getInsurertype() {
		return insurertype;
	}
	public void setInsurertype(Integer insurertype) {
		this.insurertype = insurertype;
	}
	public String getInsuredate() {
		return insuredate;
	}
	public void setInsuredate(String insuredate) {
		this.insuredate = insuredate;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getInsuredname() {
		return insuredname;
	}
	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}
	public String getInsuredid() {
		return insuredid;
	}
	public void setInsuredid(String insuredid) {
		this.insuredid = insuredid;
	}
	public String getInsuredmobile() {
		return insuredmobile;
	}
	public void setInsuredmobile(String insuredmobile) {
		this.insuredmobile = insuredmobile;
	}
	public Integer getInsuredcertificatetype() {
		return insuredcertificatetype;
	}
	public void setInsuredcertificatetype(Integer insuredcertificatetype) {
		this.insuredcertificatetype = insuredcertificatetype;
	}
	public String getBeneficiaryname() {
		return beneficiaryname;
	}
	public void setBeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}
	public String getApplicantname() {
		return applicantname;
	}
	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}
	private String policyno; // null,//保单号
private String policystartdate; // "2017-07-05",//生效日期
private String policyenddate; // "2018-07-04",//截止日期
private Integer policystatus; // 1,//保单状态
private String proposalno; // null,
private Float insuredpremium; // 4021.03,//商险或交强总额
private Float otherpremium; // 536.94,//车船税
private String insurerpartnername; // "安盛天平财险",
private Integer insurertype; // 1,//险种:1-商业险,2-交强险
private String insuredate; // "2017-07-04",//投保日期
private String cityname; // "东莞市",//市
private String insuredname; // "郝叶",//被保人
private String insuredid; // "14222319850316063X",//被保人身份证
private String insuredmobile; // "18515065805",//被保人手机号
private Integer insuredcertificatetype; // 0,//被保人证件类型0-身份证
private String beneficiaryname; // "",//受益人
private String applicantname; // "张三"//投保人

}