package com.example.demo.entity;

import java.util.List;

public class CiOrder {

	private String id;
	private Integer appid; // 1,//平台id
    private Integer assetsid; // 2,//资产方id
    private String orderid; // 10216,//平台订单编号
    private String appBatchId; // "1",//平台订单所在批次
    
    private Integer batchId; // "1",//订单所在批次
    private String orderno; // "1439283951",//平台订单号

    private String ordergroupid; // 60187, //平台订单组号
    private String productid; // 10001,//产品ID
    private Integer producttype; // 1, //产品类型
    private Float repaidamount; // 0.0,//已还金额
    private Float unrepaidamount; // 4021.03,//未还金额
    private String currentduedate; // null,//当期还款日
    private Integer overduenum; // 0,// 逾期天数
    private Integer currentduenum; // 0,// 当前还款期数
    private Float currentamount; // 326.0,//当期应还金额
    private String installmentstartdate; // "2017-08-10",//分期起始日期
    private String installmentenddate; // "2018-07-10",//分期结束日期
    private String policystartdate; // "2017-07-05",//保单起始日期
    private Integer installmentnum; // 12,//分期期数
    private Float installmentamount; // 4021.03,//分期总额
    private Float downpaymentamount; // 1718.03,// 首付金额
    private Float cautionmoney; // 402.1,//保证金金额
    private Float discountfee; // 1005.0,//优惠金额
    private Integer discountinstallmentnum; // 3,//优惠期数
    private Float strongamount; // 950.0,//交强险金额
    private Float caramount; // 360.0,//车船税金额
    private Float businessamount; // 4021.03,//商业险总额 
    private Float orderamount; // 5331.03,// 订单金额
    private String productname; // "车险商业险0利息0手续一年期",
    private Boolean issubmitphoto; // true,//是否上传图片   
    private Integer status; // 4,//状态
    private Integer orderstep; // 0,//步骤
    private Integer source; // 1,//订单来源
    private Float shouldpay; // 1718.03,//应付金额
    private Float orderprice; // 5733.03,//订单总额 
    private String refundtime; // null,//退款时间
    private String canceltime; // null,//取消时间
    private String cancelreason; // "",//取消原因
    private String addtime; // "2017-07-04 19:38:51",//创建日期
    private String payvalidtime; // "2017-07-04 23:50:00", //支付/补齐资料有效期
    //其他数据
    private CiCustomer customer;
	private CiCar car;
    private List<CiCoverage> coveragelist;
    private List<CiPolicy> policylist;
    private List<CiInstallment> installmentlist;
    private List<CiOrderphoto> orderphotolist;
    //判断某批次是否存在
    public boolean isExistInstallment(int installmentNo)
    {
    	for(CiInstallment iter:installmentlist)
    	{
    		if(iter.getInstallmentno().intValue() ==installmentNo)
    			return true;
    	}
    	return false;
    }
    
    public CiCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(CiCustomer customer) {
		this.customer = customer;
	}
	public CiCar getCar() {
		return car;
	}
	public void setCar(CiCar car) {
		this.car = car;
	}
	public List<CiCoverage> getCoveragelist() {
		return coveragelist;
	}
	public void setCoveragelist(List<CiCoverage> coveragelist) {
		this.coveragelist = coveragelist;
	}
	public List<CiPolicy> getPolicylist() {
		return policylist;
	}
	public void setPolicylist(List<CiPolicy> policylist) {
		this.policylist = policylist;
	}
	public List<CiInstallment> getInstallmentlist() {
		return installmentlist;
	}
	public void setInstallmentlist(List<CiInstallment> installmentlist) {
		this.installmentlist = installmentlist;
	}
	public List<CiOrderphoto> getOrderphotolist() {
		return orderphotolist;
	}
	public void setOrderphotolist(List<CiOrderphoto> orderphotolist) {
		this.orderphotolist = orderphotolist;
	}


    
    public CiOrder(String id) {
		// TODO Auto-generated constructor stub
    	setId(id);
	}
	public CiOrder() {
		// TODO Auto-generated constructor stub
	}

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public Integer getAssetsid() {
		return assetsid;
	}

	public void setAssetsid(Integer assetsid) {
		this.assetsid = assetsid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getAppBatchId() {
		return appBatchId;
	}

	public void setAppBatchId(String appBatchId) {
		this.appBatchId = appBatchId;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getOrdergroupid() {
		return ordergroupid;
	}

	public void setOrdergroupid(String ordergroupid) {
		this.ordergroupid = ordergroupid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public Integer getProducttype() {
		return producttype;
	}

	public void setProducttype(Integer producttype) {
		this.producttype = producttype;
	}

	public Float getRepaidamount() {
		return repaidamount;
	}

	public void setRepaidamount(Float repaidamount) {
		this.repaidamount = repaidamount;
	}

	public Float getUnrepaidamount() {
		return unrepaidamount;
	}

	public void setUnrepaidamount(Float unrepaidamount) {
		this.unrepaidamount = unrepaidamount;
	}

	public String getCurrentduedate() {
		return currentduedate;
	}

	public void setCurrentduedate(String currentduedate) {
		this.currentduedate = currentduedate;
	}

	public Integer getOverduenum() {
		return overduenum;
	}

	public void setOverduenum(Integer overduenum) {
		this.overduenum = overduenum;
	}

	public Integer getCurrentduenum() {
		return currentduenum;
	}

	public void setCurrentduenum(Integer currentduenum) {
		this.currentduenum = currentduenum;
	}

	public Float getCurrentamount() {
		return currentamount;
	}

	public void setCurrentamount(Float currentamount) {
		this.currentamount = currentamount;
	}

	public String getInstallmentstartdate() {
		return installmentstartdate;
	}

	public void setInstallmentstartdate(String installmentstartdate) {
		this.installmentstartdate = installmentstartdate;
	}

	public String getInstallmentenddate() {
		return installmentenddate;
	}

	public void setInstallmentenddate(String installmentenddate) {
		this.installmentenddate = installmentenddate;
	}

	public String getPolicystartdate() {
		return policystartdate;
	}

	public void setPolicystartdate(String policystartdate) {
		this.policystartdate = policystartdate;
	}

	public Integer getInstallmentnum() {
		return installmentnum;
	}

	public void setInstallmentnum(Integer installmentnum) {
		this.installmentnum = installmentnum;
	}

	public Float getInstallmentamount() {
		return installmentamount;
	}

	public void setInstallmentamount(Float installmentamount) {
		this.installmentamount = installmentamount;
	}

	public Float getDownpaymentamount() {
		return downpaymentamount;
	}

	public void setDownpaymentamount(Float downpaymentamount) {
		this.downpaymentamount = downpaymentamount;
	}

	public Float getCautionmoney() {
		return cautionmoney;
	}

	public void setCautionmoney(Float cautionmoney) {
		this.cautionmoney = cautionmoney;
	}

	public Float getDiscountfee() {
		return discountfee;
	}

	public void setDiscountfee(Float discountfee) {
		this.discountfee = discountfee;
	}

	public Integer getDiscountinstallmentnum() {
		return discountinstallmentnum;
	}

	public void setDiscountinstallmentnum(Integer discountinstallmentnum) {
		this.discountinstallmentnum = discountinstallmentnum;
	}

	public Float getStrongamount() {
		return strongamount;
	}

	public void setStrongamount(Float strongamount) {
		this.strongamount = strongamount;
	}

	public Float getCaramount() {
		return caramount;
	}

	public void setCaramount(Float caramount) {
		this.caramount = caramount;
	}

	public Float getBusinessamount() {
		return businessamount;
	}

	public void setBusinessamount(Float businessamount) {
		this.businessamount = businessamount;
	}

	public Float getOrderamount() {
		return orderamount;
	}

	public void setOrderamount(Float orderamount) {
		this.orderamount = orderamount;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Boolean isIssubmitphoto() {
		return issubmitphoto;
	}

	public void setIssubmitphoto(Boolean issubmitphoto) {
		this.issubmitphoto = issubmitphoto;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrderstep() {
		return orderstep;
	}

	public void setOrderstep(Integer orderstep) {
		this.orderstep = orderstep;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Float getShouldpay() {
		return shouldpay;
	}

	public void setShouldpay(Float shouldpay) {
		this.shouldpay = shouldpay;
	}

	public Float getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(Float orderprice) {
		this.orderprice = orderprice;
	}

	public String getRefundtime() {
		return refundtime;
	}

	public void setRefundtime(String refundtime) {
		this.refundtime = refundtime;
	}

	public String getCanceltime() {
		return canceltime;
	}

	public void setCanceltime(String canceltime) {
		this.canceltime = canceltime;
	}

	public String getCancelreason() {
		return cancelreason;
	}

	public void setCancelreason(String cancelreason) {
		this.cancelreason = cancelreason;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getPayvalidtime() {
		return payvalidtime;
	}

	public void setPayvalidtime(String payvalidtime) {
		this.payvalidtime = payvalidtime;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
