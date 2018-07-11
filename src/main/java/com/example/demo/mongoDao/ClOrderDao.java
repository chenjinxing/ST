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
import com.example.demo.entity.ClOrder;

@Repository("lOrderDao")
public class ClOrderDao extends AbstractBaseMongoTemplete  implements IClOrderDao{
    
    /**  
     * 新增  
     * <br>------------------------------<br>  
     * @param Order  
     */   
    public void insert(ClOrder order) {  
        // TODO Auto-generated method stub  
        mongoTemplate.insert(order);  
    }
    /**  
     * 批量新增  
     * <br>------------------------------<br>  
     * @param Orders  
     */  
    public void insertAll(List<ClOrder> orders) {  
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
    	ClOrder order = new ClOrder(id);  
        mongoTemplate.remove(order);  
    }  
    /**  
     * 按条件删除  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     */  
    public void delete(ClOrder criteriaOrder) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaOrder);
        mongoTemplate.remove(query, ClOrder.class);  
    }  
    /**  
     * 删除全部  
     * <br>------------------------------<br>  
     */  
    public void deleteAll() {  
        // TODO Auto-generated method stub  
        mongoTemplate.dropCollection(ClOrder.class);  
    }  
    /**  
     * 按主键修改,  
     * 如果文档中没有相关key 会新增 使用$set修改器  
     * <br>------------------------------<br>  
     * @param Order  
     */  
    public void updateById(ClOrder order) {  
        // TODO Auto-generated method stub  
        Criteria criteria = Criteria.where("id").is(order.getId());  
        Query query = new Query(criteria);  
        Update update =getUpdate(order);
        mongoTemplate.updateFirst(query, update, ClOrder.class);
    }  
    /**  
     * 修改多条  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @param Order  
     */  
    public void update(ClOrder criteriaOrder, ClOrder order) {  
        // TODO Auto-generated method stub  
    	Query query =getQuery(criteriaOrder);
    	Update update =getUpdate(order);
    	mongoTemplate.updateMulti(query, update, ClOrder.class);
    }  
    public void updateInstallment(ClOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
		//先删除
    	deleteInstallment(criteriaOrder, installment, installmentno);
		//后增加
		insertInstallment(criteriaOrder, installment, installmentno);
    }
    public void insertInstallment(ClOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
    	Query query =getQuery(criteriaOrder);
    	Update update =new Update();
		update.push("installmentlist", installment);
		mongoTemplate.updateFirst(query, update, ClOrder.class);
    }
    public void deleteInstallment(ClOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
    	Query query =getQuery(criteriaOrder);
    	Update noUpdate =new Update();
    	noUpdate.pull("installmentno", installmentno);
    	//String str =noUpdate.getUpdateObject().get("$pull").toString();
    	
    	Update update =new Update();
		update.pull("installmentlist", noUpdate.getUpdateObject().get("$pull"));
		mongoTemplate.updateFirst(query, update, ClOrder.class);
    }
    /**  
     * 根据主键查询  
     * <br>------------------------------<br>  
     * @param id  
     * @return  
     */  
    public ClOrder findById(String id) {  
        // TODO Auto-generated method stub  
        return mongoTemplate.findById(id, ClOrder.class);  
    }  
    /**  
     * 查询全部  
     * <br>------------------------------<br>  
     * @return  
     */  
    public List<ClOrder> findAll() {  
        // TODO Auto-generated method stub  
        return mongoTemplate.findAll(ClOrder.class);  
    }  
    /**  
     * 按条件查询, 分页  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @param skip  
     * @param limit  
     * @return  
     */  
    public List<ClOrder> find(ClOrder criteriaOrder, int skip, int limit) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaOrder);  
        query.skip(skip);  
        query.limit(limit);  
        return mongoTemplate.find(query, ClOrder.class);  
    }  
    /**  
     * 根据条件查询出来后 再去修改  
     * <br>------------------------------<br>  
     * @param criteriaOrder  查询条件  
     * @param updateOrder    修改的值对象  
     * @return  
     */  
    public ClOrder findAndModify(ClOrder criteriaOrder, ClOrder updateOrder) {  
        // TODO Auto-generated method stub  
//        Query query = getQuery(criteriaOrder);  
//        Update update = Update.update("appid", updateOrder.getAppid()).set("assetsid", updateOrder.getAssetsid());  
//        return mongoTemplate.findAndModify(query, update, ClOrder.class);
    	return null;
    }  
    /**  
     * 查询出来后 删除  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @return  
     */  
    public ClOrder findAndRemove(ClOrder criteriaOrder) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaOrder);  
        return mongoTemplate.findAndRemove(query, ClOrder.class);  
    }  
    /**  
     * count  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @return  
     */  
    public long count(ClOrder criteriaOrder) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaOrder);  
        return mongoTemplate.count(query, ClOrder.class);  
    }  
    /**  
     *  
     * <br>------------------------------<br>  
     * @param criteriaOrder  
     * @return  
     */  
    private Query getQuery(ClOrder object) {  
        
        Query query = new Query(); 
        return query;  
    }
    private Update getUpdate(ClOrder object) {
    	Update update =new Update();
        return update;
    }

}