package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClCustomer {
	private String custName;
	private String createName;
	
	@JsonProperty(value = "Type")
	private String Type;
	
	private String industryFication;
	private String idCardType;
	private String idcardNo;
	
	@JsonProperty(value = "Birthday")
	private String Birthday;
	
	@JsonProperty(value = "Phone")
	private String Phone;
	private String telephone;
	
	@JsonProperty(value = "Sex")
	private Integer Sex;
	
	@JsonProperty(value = "Age")
	private Integer Age;
	private Long degreeEdu;
	private Long isMarry;
	private String companyAddrProvince;
	private String companyAddrCity;
	private String companyAddrCounty;
	private String companyAddr;
	private Long houseAddressProvince;
	private Long houseAddressCity;
	private Long houseAddressCounty;
	private String houseAddress;
	private String workUnit;
	private Long custStatus;
	private String messegeZipCd;
	private String maxDegreeCd;
	private Long sqshnsrGr;
	
	@JsonProperty(value = "Email")
	private String Email;
	private String profession;
	private String duties;
	private String position;

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getIndustryFication() {
		return industryFication;
	}
	public void setIndustryFication(String industryFication) {
		this.industryFication = industryFication;
	}
	public String getIdCardType() {
		return idCardType;
	}
	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getSex() {
		return Sex;
	}
	public void setSex(Integer sex) {
		Sex = sex;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public Long getDegreeEdu() {
		return degreeEdu;
	}
	public void setDegreeEdu(Long degreeEdu) {
		this.degreeEdu = degreeEdu;
	}
	public Long getIsMarry() {
		return isMarry;
	}
	public void setIsMarry(Long isMarry) {
		this.isMarry = isMarry;
	}
	public String getCompanyAddrProvince() {
		return companyAddrProvince;
	}
	public void setCompanyAddrProvince(String companyAddrProvince) {
		this.companyAddrProvince = companyAddrProvince;
	}
	public String getCompanyAddrCity() {
		return companyAddrCity;
	}
	public void setCompanyAddrCity(String companyAddrCity) {
		this.companyAddrCity = companyAddrCity;
	}
	public String getCompanyAddrCounty() {
		return companyAddrCounty;
	}
	public void setCompanyAddrCounty(String companyAddrCounty) {
		this.companyAddrCounty = companyAddrCounty;
	}
	public String getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	public Long getHouseAddressProvince() {
		return houseAddressProvince;
	}
	public void setHouseAddressProvince(Long houseAddressProvince) {
		this.houseAddressProvince = houseAddressProvince;
	}
	public Long getHouseAddressCity() {
		return houseAddressCity;
	}
	public void setHouseAddressCity(Long houseAddressCity) {
		this.houseAddressCity = houseAddressCity;
	}
	public Long getHouseAddressCounty() {
		return houseAddressCounty;
	}
	public void setHouseAddressCounty(Long houseAddressCounty) {
		this.houseAddressCounty = houseAddressCounty;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public Long getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(Long custStatus) {
		this.custStatus = custStatus;
	}
	public String getMessegeZipCd() {
		return messegeZipCd;
	}
	public void setMessegeZipCd(String messegeZipCd) {
		this.messegeZipCd = messegeZipCd;
	}
	public String getMaxDegreeCd() {
		return maxDegreeCd;
	}
	public void setMaxDegreeCd(String maxDegreeCd) {
		this.maxDegreeCd = maxDegreeCd;
	}
	public Long getSqshnsrGr() {
		return sqshnsrGr;
	}
	public void setSqshnsrGr(Long sqshnsrGr) {
		this.sqshnsrGr = sqshnsrGr;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getDuties() {
		return duties;
	}
	public void setDuties(String duties) {
		this.duties = duties;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
