package com.example.demo.entity;


//������Ϣ
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
	private String policyno; // null,//������
  private String policystartdate; // "2017-07-05",//��Ч����
  private String policyenddate; // "2018-07-04",//��ֹ����
  private Integer policystatus; // 1,//����״̬
  private String proposalno; // null,
  private Float insuredpremium; // 4021.03,//���ջ�ǿ�ܶ�
  private Float otherpremium; // 536.94,//����˰
  private String insurerpartnername; // "��ʢ��ƽ����",
  private Integer insurertype; // 1,//����:1-��ҵ��,2-��ǿ��
  private String insuredate; // "2017-07-04",//Ͷ������
  private String cityname; // "��ݸ��",//��
  private String insuredname; // "��Ҷ",//������
  private String insuredid; // "14222319850316063X",//���������֤
  private String insuredmobile; // "18515065805",//�������ֻ���
  private Integer insuredcertificatetype; // 0,//������֤������0-���֤
  private String beneficiaryname; // "",//������
  private String applicantname; // "����"//Ͷ����

}