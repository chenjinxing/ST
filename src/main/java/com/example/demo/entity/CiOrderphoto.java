package com.example.demo.entity;

//ͼƬ��Ϣ
public class CiOrderphoto
{
	private Integer orderphotoid; // 1,//Id
    public Integer getOrderphotoid() {
		return orderphotoid;
	}
	public void setOrderphotoid(Integer orderphotoid) {
		this.orderphotoid = orderphotoid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public Integer getPhototype() {
		return phototype;
	}
	public void setPhototype(Integer phototype) {
		this.phototype = phototype;
	}
	private String orderid; // 10216,//�������
  private String orderno; // null,//������
  private String photourl; // "",//ͼƬURL
  private String photoname; // "",//ͼƬ����
  private Integer phototype; // 8//����
}