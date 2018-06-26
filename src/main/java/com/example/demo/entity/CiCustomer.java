package com.example.demo.entity;


//�ͻ���Ϣ
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
  private String name;//: "����", //����
  private Integer credentialTypeId;//: 1, //֤������  1 ���֤
  private String credentialId;//: "343131316643136436", //֤����
  private String celphone;//: "13820080808", //�ֻ�����
  private String appid;//: "123456789987465412",//�û���ƽ̨��Ψһ��ʶ	   
  private Integer typeId;//: 1, // �ͻ����� 1 ���˿ͻ� ��2 ��ҵ�ͻ�
  private Integer statusId;//: 1, //״̬ 1����
  private String sex;//: "", //�Ա�
  private String birthday;//: "1995-01-01", //����
  private String mail;//: "12322333@gmail.com", //����
  private String weixin;//: "12332121", //΢�ź�
  private Integer loginTime;//: 12, //��¼����
  private String lastlogintime;//: "2017-07-04 19;//:38;//:51",//����¼ʱ��
  private String lastloginIp;//: "180.134.11.112", //����¼Ip
}
