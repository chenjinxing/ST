package com.example.demo.mongoDao;


import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.example.demo.entity.CiCar;
import com.example.demo.entity.CiCustomer;
import com.example.demo.entity.CiInstallment;
import com.example.demo.entity.CiOrder;

@Repository("iOrderDao")
public class CIOrderDao extends AbstractBaseMongoTemplete  implements ICIOrderDao{
    
    /**  
     * 新增  
     * <br>------------------------------<br>  
     * @param Order  
     */   
    public void insert(CiOrder order) {  
        // TODO Auto-generated method stub  
        mongoTemplate.insert(order);  
    }
    /**  
     * 批量新增  
     * <br>------------------------------<br>  
     * @param Orders  
     */  
    public void insertAll(List<CiOrder> orders) {  
        // TODO Auto-generated method stub  
        mongoTemplate.insertAll(orders);  
    }  
    /**  
     * 删除,按主键id, 如果主键的值为null,删除会失败  
     * <br>------------------------------<br>  
     * @param id  
     */  
    public void deleteById(String id) {  
        // TODO Auto-generated method stub  
    	CiOrder order = new CiOrder(id);  
        mongoTemplate.remove(order);  
    }  
    /**  
     * 按条件删除  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     */  
    public void delete(CiOrder criteriaOrder) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaOrder);
        mongoTemplate.remove(query, CiOrder.class);  
    }  
    /**  
     * 删除全部  
     * <br>------------------------------<br>  
     */  
    public void deleteAll() {  
        // TODO Auto-generated method stub  
        mongoTemplate.dropCollection(CiOrder.class);  
    }  
    /**  
     * 按主键修改,  
     * 如果文档中没有相关key 会新增 使用$set修改器  
     * <br>------------------------------<br>  
     * @param Order  
     */  
    public void updateById(CiOrder order) {  
        // TODO Auto-generated method stub  
        Criteria criteria = Criteria.where("id").is(order.getId());  
        Query query = new Query(criteria);  
        Update update =getUpdate(order);
        mongoTemplate.updateFirst(query, update, CiOrder.class);
    }  
    /**  
     * 修改多条  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @param Order  
     */  
    public void update(CiOrder criteriaOrder, CiOrder order) {  
        // TODO Auto-generated method stub  
    	Query query =getQuery(criteriaOrder);
    	Update update =getUpdate(order);
    	mongoTemplate.updateMulti(query, update, CiOrder.class);
    }  
    public void updateInstallment(CiOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
		//先删除
    	deleteInstallment(criteriaOrder, installment, installmentno);
		//后增加
		insertInstallment(criteriaOrder, installment, installmentno);
    }
    public void insertInstallment(CiOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
    	Query query =getQuery(criteriaOrder);
    	Update update =new Update();
		update.push("installmentlist", installment);
		mongoTemplate.updateFirst(query, update, CiOrder.class);
    }
    public void deleteInstallment(CiOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
    	Query query =getQuery(criteriaOrder);
    	Update noUpdate =new Update();
    	noUpdate.pull("installmentno", installmentno);
    	//String str =noUpdate.getUpdateObject().get("$pull").toString();
    	
    	Update update =new Update();
		update.pull("installmentlist", noUpdate.getUpdateObject().get("$pull"));
		mongoTemplate.updateFirst(query, update, CiOrder.class);
    }
    /**  
     * 根据主键查询  
     * <br>------------------------------<br>  
     * @param id  
     * @return  
     */  
    public CiOrder findById(String id) {  
        // TODO Auto-generated method stub  
        return mongoTemplate.findById(id, CiOrder.class);  
    }  
    /**  
     * 查询全部  
     * <br>------------------------------<br>  
     * @return  
     */  
    public List<CiOrder> findAll() {  
        // TODO Auto-generated method stub  
        return mongoTemplate.findAll(CiOrder.class);  
    }  
    /**  
     * 按条件查询, 分页  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @param skip  
     * @param limit  
     * @return  
     */  
    public List<CiOrder> find(CiOrder criteriaOrder, int skip, int limit) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaOrder);  
        query.skip(skip);  
        query.limit(limit);  
        return mongoTemplate.find(query, CiOrder.class);  
    }  
    /**  
     * 根据条件查询出来后 再去修改  
     * <br>------------------------------<br>  
     * @param criteriaOrder  查询条件  
     * @param updateOrder    修改的值对象  
     * @return  
     */  
    public CiOrder findAndModify(CiOrder criteriaOrder, CiOrder updateOrder) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaOrder);  
        Update update = Update.update("appid", updateOrder.getAppid()).set("assetsid", updateOrder.getAssetsid());  
        return mongoTemplate.findAndModify(query, update, CiOrder.class);  
    }  
    /**  
     * 查询出来后 删除  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @return  
     */  
    public CiOrder findAndRemove(CiOrder criteriaOrder) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaOrder);  
        return mongoTemplate.findAndRemove(query, CiOrder.class);  
    }  
    /**  
     * count  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @return  
     */  
    public long count(CiOrder criteriaOrder) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaOrder);  
        return mongoTemplate.count(query, CiOrder.class);  
    }  
    /**  
     *  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @return  
     */  
    private Query getQuery(CiOrder object) {  
        if (object == null) {  
            object = new CiOrder();  
        }  
        //Criteria criteria = Criteria.where("0").is(0);
        Criteria criteria = new Criteria(); 
        if (object.getId()  != null)
            criteria.and("id").is(object.getId());
        if (object.getAppid()  != null)
            criteria.and("appid").is(object.getAppid());
        if (object.getAssetsid()  != null)
            criteria.and("assetsid").is(object.getAssetsid());
        if (object.getOrderid()  != null)
            criteria.and("orderid").is(object.getOrderid());
        if (object.getAppBatchId()  != null)
            criteria.and("appBatchId").is(object.getAppBatchId());
        if (object.getBatchId()  != null)
            criteria.and("batchId").is(object.getBatchId());
        if (object.getOrderno()  != null)
            criteria.and("orderno").is(object.getOrderno());
        if (object.getOrdergroupid()  != null)
            criteria.and("ordergroupid").is(object.getOrdergroupid());
        if (object.getProductid()  != null)
            criteria.and("productid").is(object.getProductid());
        if (object.getProducttype()  != null)
            criteria.and("producttype").is(object.getProducttype());
        if (object.getRepaidamount()  != null)
            criteria.and("repaidamount").is(object.getRepaidamount());
        if (object.getUnrepaidamount()  != null)
            criteria.and("unrepaidamount").is(object.getUnrepaidamount());
        if (object.getCurrentduedate()  != null)
            criteria.and("currentduedate").is(object.getCurrentduedate());
        if (object.getOverduenum()  != null)
            criteria.and("overduenum").is(object.getOverduenum());
        if (object.getCurrentduenum()  != null)
            criteria.and("currentduenum").is(object.getCurrentduenum());
        if (object.getCurrentamount()  != null)
            criteria.and("currentamount").is(object.getCurrentamount());
        if (object.getInstallmentstartdate()  != null)
            criteria.and("installmentstartdate").is(object.getInstallmentstartdate());
        if (object.getInstallmentenddate()  != null)
            criteria.and("installmentenddate").is(object.getInstallmentenddate());
        if (object.getPolicystartdate()  != null)
            criteria.and("policystartdate").is(object.getPolicystartdate());
        if (object.getInstallmentnum()  != null)
            criteria.and("installmentnum").is(object.getInstallmentnum());
        if (object.getInstallmentamount()  != null)
            criteria.and("installmentamount").is(object.getInstallmentamount());
        if (object.getDownpaymentamount()  != null)
            criteria.and("downpaymentamount").is(object.getDownpaymentamount());
        if (object.getCautionmoney()  != null)
            criteria.and("cautionmoney").is(object.getCautionmoney());
        if (object.getDiscountfee()  != null)
            criteria.and("discountfee").is(object.getDiscountfee());
        if (object.getDiscountinstallmentnum()  != null)
            criteria.and("discountinstallmentnum").is(object.getDiscountinstallmentnum());
        if (object.getStrongamount()  != null)
            criteria.and("strongamount").is(object.getStrongamount());
        if (object.getCaramount()  != null)
            criteria.and("caramount").is(object.getCaramount());
        if (object.getBusinessamount()  != null)
            criteria.and("businessamount").is(object.getBusinessamount());
        if (object.getOrderamount()  != null)
            criteria.and("orderamount").is(object.getOrderamount());
        if (object.getProductname()  != null)
            criteria.and("productname").is(object.getProductname());
        if (object.isIssubmitphoto()  != null)
            criteria.and("issubmitphoto").is(object.isIssubmitphoto());
        if (object.getStatus()  != null)
            criteria.and("status").is(object.getStatus());
        if (object.getOrderstep()  != null)
            criteria.and("orderstep").is(object.getOrderstep());
        if (object.getSource()  != null)
            criteria.and("source").is(object.getSource());
        if (object.getShouldpay()  != null)
            criteria.and("shouldpay").is(object.getShouldpay());
        if (object.getOrderprice()  != null)
            criteria.and("orderprice").is(object.getOrderprice());
        if (object.getRefundtime()  != null)
            criteria.and("refundtime").is(object.getRefundtime());
        if (object.getCanceltime()  != null)
            criteria.and("canceltime").is(object.getCanceltime());
        if (object.getCancelreason()  != null)
            criteria.and("cancelreason").is(object.getCancelreason());
        if (object.getAddtime()  != null)
            criteria.and("addtime").is(object.getAddtime());
        if (object.getPayvalidtime()  != null)
            criteria.and("payvalidtime").is(object.getPayvalidtime());
        if (object.getCustomer()  != null)
        {
        	CiCustomer customer =object.getCustomer();
            if (customer.getName()  != null)
                criteria.and("customer.name").is(customer.getName());
            if (customer.getCredentialTypeId()  != null)
                criteria.and("customer.credentialTypeId").is(customer.getCredentialTypeId());
            if (customer.getCredentialId()  != null)
                criteria.and("customer.credentialId").is(customer.getCredentialId());
            if (customer.getCelphone()  != null)
                criteria.and("customer.celphone").is(customer.getCelphone());
            if (customer.getAppid()  != null)
                criteria.and("customer.appid").is(customer.getAppid());
            if (customer.getTypeId()  != null)
                criteria.and("customer.typeId").is(customer.getTypeId());
            if (customer.getStatusId()  != null)
                criteria.and("customer.statusId").is(customer.getStatusId());
            if (customer.getSex()  != null)
                criteria.and("customer.sex").is(customer.getSex());
            if (customer.getBirthday()  != null)
                criteria.and("customer.birthday").is(customer.getBirthday());
            if (customer.getMail()  != null)
                criteria.and("customer.mail").is(customer.getMail());
            if (customer.getWeixin()  != null)
                criteria.and("customer.weixin").is(customer.getWeixin());
            if (customer.getLoginTime()  != null)
                criteria.and("customer.loginTime").is(customer.getLoginTime());
            if (customer.getLastlogintime()  != null)
                criteria.and("customer.lastlogintime").is(customer.getLastlogintime());
            if (customer.getLastloginIp()  != null)
                criteria.and("customer.lastloginIp").is(customer.getLastloginIp());
        }
        if (object.getCar()  != null)
        {
        	CiCar car =object.getCar();
            if (car.getLicenseNo()  != null)
                criteria.and("car.licenseNo").is(car.getLicenseNo());
            if (car.getFrameNo()  != null)
                criteria.and("car.frameNo").is(car.getFrameNo());
            if (car.getEngineNo()  != null)
                criteria.and("car.engineNo").is(car.getEngineNo());
            if (car.getVintageModels()  != null)
                criteria.and("car.vintageModels").is(car.getVintageModels());
            if (car.getStandardName()  != null)
                criteria.and("car.standardName").is(car.getStandardName());
            if (car.getBrandName()  != null)
                criteria.and("car.brandName").is(car.getBrandName());
            if (car.getFamilyName()  != null)
                criteria.and("car.familyName").is(car.getFamilyName());
            if (car.getEngineDesc()  != null)
                criteria.and("car.engineDesc").is(car.getEngineDesc());
            if (car.getGearBoxType()  != null)
                criteria.and("car.gearBoxType").is(car.getGearBoxType());
            if (car.getOwnerName()  != null)
                criteria.and("car.ownerName").is(car.getOwnerName());
            if (car.getOwnerCertificateType()  != null)
                criteria.and("car.ownerCertificateType").is(car.getOwnerCertificateType());
            if (car.getOwnerID()  != null)
                criteria.and("car.ownerID").is(car.getOwnerID());
            if (car.getOwnerMobile()  != null)
                criteria.and("car.ownerMobile").is(car.getOwnerMobile());
            if (car.getFirstRegisterDate()  != null)
                criteria.and("car.firstRegisterDate").is(car.getFirstRegisterDate());
        }
        Query query = new Query(); 
        query.addCriteria(criteria);  
        return query;  
    }
    private Update getUpdate(CiOrder object) {
        if (object == null) {  
            object = new CiOrder();  
        }  
        Update update =new Update();
        if (object.getId()  != null)
            update.set("id",object.getId());
        if (object.getAppid()  != null)
            update.set("appid",object.getAppid());
        if (object.getAssetsid()  != null)
            update.set("assetsid",object.getAssetsid());
        if (object.getOrderid()  != null)
            update.set("orderid",object.getOrderid());
        if (object.getAppBatchId()  != null)
            update.set("appbatchid",object.getAppBatchId());
        if (object.getBatchId()  != null)
            update.set("batchid",object.getBatchId());
        if (object.getOrderno()  != null)
            update.set("orderno",object.getOrderno());
        if (object.getOrdergroupid()  != null)
            update.set("ordergroupid",object.getOrdergroupid());
        if (object.getProductid()  != null)
            update.set("productid",object.getProductid());
        if (object.getProducttype()  != null)
            update.set("producttype",object.getProducttype());
        if (object.getRepaidamount()  != null)
            update.set("repaidamount",object.getRepaidamount());
        if (object.getUnrepaidamount()  != null)
            update.set("unrepaidamount",object.getUnrepaidamount());
        if (object.getCurrentduedate()  != null)
            update.set("currentduedate",object.getCurrentduedate());
        if (object.getOverduenum()  != null)
            update.set("overduenum",object.getOverduenum());
        if (object.getCurrentduenum()  != null)
            update.set("currentduenum",object.getCurrentduenum());
        if (object.getCurrentamount()  != null)
            update.set("currentamount",object.getCurrentamount());
        if (object.getInstallmentstartdate()  != null)
            update.set("installmentstartdate",object.getInstallmentstartdate());
        if (object.getInstallmentenddate()  != null)
            update.set("installmentenddate",object.getInstallmentenddate());
        if (object.getPolicystartdate()  != null)
            update.set("policystartdate",object.getPolicystartdate());
        if (object.getInstallmentnum()  != null)
            update.set("installmentnum",object.getInstallmentnum());
        if (object.getInstallmentamount()  != null)
            update.set("installmentamount",object.getInstallmentamount());
        if (object.getDownpaymentamount()  != null)
            update.set("downpaymentamount",object.getDownpaymentamount());
        if (object.getCautionmoney()  != null)
            update.set("cautionmoney",object.getCautionmoney());
        if (object.getDiscountfee()  != null)
            update.set("discountfee",object.getDiscountfee());
        if (object.getDiscountinstallmentnum()  != null)
            update.set("discountinstallmentnum",object.getDiscountinstallmentnum());
        if (object.getStrongamount()  != null)
            update.set("strongamount",object.getStrongamount());
        if (object.getCaramount()  != null)
            update.set("caramount",object.getCaramount());
        if (object.getBusinessamount()  != null)
            update.set("businessamount",object.getBusinessamount());
        if (object.getOrderamount()  != null)
            update.set("orderamount",object.getOrderamount());
        if (object.getProductname()  != null)
            update.set("productname",object.getProductname());
        if (object.isIssubmitphoto()  != null)
            update.set("issubmitphoto",object.isIssubmitphoto());
        if (object.getStatus()  != null)
            update.set("status",object.getStatus());
        if (object.getOrderstep()  != null)
            update.set("orderstep",object.getOrderstep());
        if (object.getSource()  != null)
            update.set("source",object.getSource());
        if (object.getShouldpay()  != null)
            update.set("shouldpay",object.getShouldpay());
        if (object.getOrderprice()  != null)
            update.set("orderprice",object.getOrderprice());
        if (object.getRefundtime()  != null)
            update.set("refundtime",object.getRefundtime());
        if (object.getCanceltime()  != null)
            update.set("canceltime",object.getCanceltime());
        if (object.getCancelreason()  != null)
            update.set("cancelreason",object.getCancelreason());
        if (object.getAddtime()  != null)
            update.set("addtime",object.getAddtime());
        if (object.getPayvalidtime()  != null)
            update.set("payvalidtime",object.getPayvalidtime());
        if (object.getCustomer()  != null)
        {
        	CiCustomer customer =object.getCustomer();
        	if (customer.getName()  != null)
                update.set("customer.name",customer.getName());
            if (customer.getCredentialTypeId()  != null)
                update.set("customer.credentialtypeid",customer.getCredentialTypeId());
            if (customer.getCredentialId()  != null)
                update.set("customer.credentialid",customer.getCredentialId());
            if (customer.getCelphone()  != null)
                update.set("customer.celphone",customer.getCelphone());
            if (customer.getAppid()  != null)
                update.set("customer.appid",customer.getAppid());
            if (customer.getTypeId()  != null)
                update.set("customer.typeid",customer.getTypeId());
            if (customer.getStatusId()  != null)
                update.set("customer.statusid",customer.getStatusId());
            if (customer.getSex()  != null)
                update.set("customer.sex",customer.getSex());
            if (customer.getBirthday()  != null)
                update.set("customer.birthday",customer.getBirthday());
            if (customer.getMail()  != null)
                update.set("customer.mail",customer.getMail());
            if (customer.getWeixin()  != null)
                update.set("customer.weixin",customer.getWeixin());
            if (customer.getLoginTime()  != null)
                update.set("customer.logintime",customer.getLoginTime());
            if (customer.getLastlogintime()  != null)
                update.set("customer.lastlogintime",customer.getLastlogintime());
            if (customer.getLastloginIp()  != null)
                update.set("customer.lastloginip",customer.getLastloginIp());
        }
        if (object.getCar()  != null)
        {
        	CiCar car =object.getCar();
            if (car.getLicenseNo()  != null)
                update.set("car.licenseno",car.getLicenseNo());
            if (car.getFrameNo()  != null)
                update.set("car.frameno",car.getFrameNo());
            if (car.getEngineNo()  != null)
                update.set("car.engineno",car.getEngineNo());
            if (car.getVintageModels()  != null)
                update.set("car.vintagemodels",car.getVintageModels());
            if (car.getStandardName()  != null)
                update.set("car.standardname",car.getStandardName());
            if (car.getBrandName()  != null)
                update.set("car.brandname",car.getBrandName());
            if (car.getFamilyName()  != null)
                update.set("car.familyname",car.getFamilyName());
            if (car.getEngineDesc()  != null)
                update.set("car.enginedesc",car.getEngineDesc());
            if (car.getGearBoxType()  != null)
                update.set("car.gearboxtype",car.getGearBoxType());
            if (car.getOwnerName()  != null)
                update.set("car.ownername",car.getOwnerName());
            if (car.getOwnerCertificateType()  != null)
                update.set("car.ownercertificatetype",car.getOwnerCertificateType());
            if (car.getOwnerID()  != null)
                update.set("car.ownerid",car.getOwnerID());
            if (car.getOwnerMobile()  != null)
                update.set("car.ownermobile",car.getOwnerMobile());
            if (car.getFirstRegisterDate()  != null)
                update.set("car.firstregisterdate",car.getFirstRegisterDate());
        }
        return update;
    }

}