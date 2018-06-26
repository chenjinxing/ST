package com.example.demo.entity;

//������Ϣ
public class CiCar
{
  private String licenseNo; // "��A12345", //����
  private String frameNo; // "", //���ܺ�
  private String engineNo; // "", //��������
  private String vintageModels; // "", //��ݿ���
  private String standardName; // "", //������ݿ����׼����
  private String brandName; // "", //Ʒ��
  private String familyName; // "", //��ϵ
  private String engineDesc; // "", //����
  private String gearBoxType; // "", //��������
  private String ownerName; // "", //����
  private Integer ownerCertificateType; // 0, //����֤������
  private String ownerID; // "", //����֤����
  private String ownerMobile; // "", //��ϵ�绰
  private String firstRegisterDate; // "2015-01-07"//��������  
  
  public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getFrameNo() {
		return this.frameNo;
	}
	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}
	public String getEngineNo() {
		return this.engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getVintageModels() {
		return this.vintageModels;
	}
	public void setVintageModels(String vintageModels) {
		this.vintageModels = vintageModels;
	}
	public String getStandardName() {
		return this.standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	public String getBrandName() {
		return this.brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getFamilyName() {
		return this.familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getEngineDesc() {
		return this.engineDesc;
	}
	public void setEngineDesc(String engineDesc) {
		this.engineDesc = engineDesc;
	}
	public String getGearBoxType() {
		return this.gearBoxType;
	}
	public void setGearBoxType(String gearBoxType) {
		this.gearBoxType = gearBoxType;
	}
	public String getOwnerName() {
		return this.ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Integer getOwnerCertificateType() {
		return this.ownerCertificateType;
	}
	public void setOwnerCertificateType(Integer ownerCertificateType) {
		this.ownerCertificateType = ownerCertificateType;
	}
	public String getOwnerID() {
		return this.ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	public String getOwnerMobile() {
		return this.ownerMobile;
	}
	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}
	public String getFirstRegisterDate() {
		return this.firstRegisterDate;
	}
	public void setFirstRegisterDate(String firstRegisterDate) {
		this.firstRegisterDate = firstRegisterDate;
	}
	
}
