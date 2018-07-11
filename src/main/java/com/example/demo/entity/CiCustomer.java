package com.example.demo.entity;


//客户信息
public class CiCustomer
{
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCredentialTypeId() {
		return credentialTypeId;
	}
	public void setCredentialTypeId(Integer credentialTypeId) {
		this.credentialTypeId = credentialTypeId;
	}
	public String getCredentialId() {
		return credentialId;
	}
	public void setCredentialId(String credentialId) {
		this.credentialId = credentialId;
	}
	public String getCelphone() {
		return celphone;
	}
	public void setCelphone(String celphone) {
		this.celphone = celphone;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public Integer getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Integer loginTime) {
		this.loginTime = loginTime;
	}
	public String getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public String getLastloginIp() {
		return lastloginIp;
	}
	public void setLastloginIp(String lastloginIp) {
		this.lastloginIp = lastloginIp;
	}
private String name;//: "张三", //姓名
private Integer credentialTypeId;//: 1, //证件类型  1 身份证
private String credentialId;//: "343131316643136436", //证件号
private String celphone;//: "13820080808", //手机号码
private String appid;//: "123456789987465412",//用户在平台的唯一标识	   
private Integer typeId;//: 1, // 客户类型 1 个人客户 ，2 企业客户
private Integer statusId;//: 1, //状态 1正常
private String sex;//: "", //性别
private String birthday;//: "1995-01-01", //生日
private String mail;//: "12322333@gmail.com", //邮箱
private String weixin;//: "12332121", //微信号
private Integer loginTime;//: 12, //登录次数
private String lastlogintime;//: "2017-07-04 19;//:38;//:51",//最后登录时间
private String lastloginIp;//: "180.134.11.112", //最后登录Ip
}
