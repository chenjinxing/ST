package com.example.demo.entity;

import java.util.List;

public class CiOrder {

	private String id;
	private Integer appid; // 1,//ƽ̨id
    private Integer assetsid; // 2,//�ʲ���id
    private String orderid; // 10216,//ƽ̨�������
    private String appBatchId; // "1",//ƽ̨������������
    
    private Integer batchId; // "1",//������������
    private String orderno; // "1439283951",//ƽ̨������

    private String ordergroupid; // 60187, //ƽ̨�������
    private String productid; // 10001,//��ƷID
    private Integer producttype; // 1, //��Ʒ����
    private Float repaidamount; // 0.0,//�ѻ����
    private Float unrepaidamount; // 4021.03,//δ�����
    private String currentduedate; // null,//���ڻ�����
    private Integer overduenum; // 0,// ��������
    private Integer currentduenum; // 0,// ��ǰ��������
    private Float currentamount; // 326.0,//����Ӧ�����
    private String installmentstartdate; // "2017-08-10",//������ʼ����
    private String installmentenddate; // "2018-07-10",//���ڽ�������
    private String policystartdate; // "2017-07-05",//������ʼ����
    private Integer installmentnum; // 12,//��������
    private Float installmentamount; // 4021.03,//�����ܶ�
    private Float downpaymentamount; // 1718.03,// �׸����
    private Float cautionmoney; // 402.1,//��֤����
    private Float discountfee; // 1005.0,//�Żݽ��
    private Integer discountinstallmentnum; // 3,//�Ż�����
    private Float strongamount; // 950.0,//��ǿ�ս��
    private Float caramount; // 360.0,//����˰���
    private Float businessamount; // 4021.03,//��ҵ���ܶ� 
    private Float orderamount; // 5331.03,// �������
    private String productname; // "������ҵ��0��Ϣ0����һ����",
    private Boolean issubmitphoto; // true,//�Ƿ��ϴ�ͼƬ   
    private Integer status; // 4,//״̬
    private Integer orderstep; // 0,//����
    private Integer source; // 1,//������Դ
    private Float shouldpay; // 1718.03,//Ӧ�����
    private Float orderprice; // 5733.03,//�����ܶ� 
    private String refundtime; // null,//�˿�ʱ��
    private String canceltime; // null,//ȡ��ʱ��
    private String cancelreason; // "",//ȡ��ԭ��
    private String addtime; // "2017-07-04 19:38:51",//��������
    private String payvalidtime; // "2017-07-04 23:50:00", //֧��/����������Ч��
    //��������
    private CiCustomer customer;
	private CiCar car;
    private List<CiCoverage> coveragelist;
    private List<CiPolicy> policylist;
    private List<CiInstallment> installmentlist;
    private List<CiOrderphoto> orderphotolist;
    //�ж�ĳ�����Ƿ����
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
