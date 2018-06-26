package com.example.demo.entity;


public class Batch {
	public Batch() {
		// TODO Auto-generated constructor stub
	}
	public Batch(String id) {
		// TODO Auto-generated constructor stub
		this.setId(id);
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public int getAssetsid() {
		return assetsid;
	}
	public void setAssetsid(int assetsid) {
		this.assetsid = assetsid;
	}
	public String getAppBatchId() {
		return appBatchId;
	}
	public void setAppBatchId(String appBatchId) {
		this.appBatchId = appBatchId;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getPackingtime() {
		return packingtime;
	}
	public void setPackingtime(String packingtime) {
		this.packingtime = packingtime;
	}
	public int getAssetsstatus() {
		return assetsstatus;
	}
	public void setAssetsstatus(int assetsstatus) {
		this.assetsstatus = assetsstatus;
	}
	public int getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}
	public String getBinsuredpremium() {
		return binsuredpremium;
	}
	public void setBinsuredpremium(String binsuredpremium) {
		this.binsuredpremium = binsuredpremium;
	}
	public String getFirstterm() {
		return firstterm;
	}
	public void setFirstterm(String firstterm) {
		this.firstterm = firstterm;
	}
	public String getTenterms() {
		return tenterms;
	}
	public void setTenterms(String tenterms) {
		this.tenterms = tenterms;
	}
	public String getLastterm() {
		return lastterm;
	}
	public void setLastterm(String lastterm) {
		this.lastterm = lastterm;
	}
	public String getCautionmoney() {
		return cautionmoney;
	}
	public void setCautionmoney(String cautionmoney) {
		this.cautionmoney = cautionmoney;
	}
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private int appid;
	private int assetsid;
	private String appBatchId;
	private String addtime;
	private String packingtime;
	private int assetsstatus;
	private int ordercount;
	private String binsuredpremium;
	private String firstterm;
	private String tenterms;
	private String lastterm;
	private String cautionmoney;
}
