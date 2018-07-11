package com.example.demo.protocol;


public class CL_ReqDeleteOrderData
{
	public CL_ReqDeleteOrderData()
	{}
	public CL_ReqDeleteOrderData(int orderid) {
		super();
		this.orderid =orderid;
	}
	private int orderid;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

}