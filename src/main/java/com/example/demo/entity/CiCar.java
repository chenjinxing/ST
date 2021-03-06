package com.example.demo.entity;

//车辆信息
public class CiCar
{
  private String licenseNo; // "辽A12345", //车牌
  private String frameNo; // "", //车架号
  private String engineNo; // "", //发动机号
  private String vintageModels; // "", //年份款项
  private String standardName; // "", //车辆年份款项标准名称
  private String brandName; // "", //品牌
  private String familyName; // "", //车系
  private String engineDesc; // "", //排量
  private String gearBoxType; // "", //车挡类型
  private String ownerName; // "", //车主
  private Integer ownerCertificateType; // 0, //车主证件类型
  private String ownerID; // "", //车主证件号
  private String ownerMobile; // "", //联系电话
  private String firstRegisterDate; // "2015-01-07"//初登日期  
  
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
