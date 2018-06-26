package com.example.demo.entity;


//������Ϣ
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
	private Integer insurertype; // 1,//��������1-��ҵ��,2-��ǿ��
    private String coveragecode; // "VehicleDemageIns",//���ִ���
    private String coveragename; // "��������ʧ����",//��������
    private Float insuredpremium; // 1231.65,//����
    private Float amount; // 33966.4,//����
    private String notdeductible; // true ,//�Ƿ񲻼�����
    private Float ncfPremium; // 3.00 //����������
}