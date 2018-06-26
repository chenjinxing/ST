package com.example.demo.mongoDao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Batch;


@Repository("batchDao")
public class BatchDao extends AbstractBaseMongoTemplete  implements IBatchDao{
    
    /**  
     * ����  
     * <br>------------------------------<br>  
     * @param Batch  
     */   
    public void insert(Batch batch) {  
        // TODO Auto-generated method stub  
        mongoTemplate.insert(batch,"Batch");  
    }
    /**  
     * ��������  
     * <br>------------------------------<br>  
     * @param Batchs  
     */  
    public void insertAll(List<Batch> batchs) {  
        // TODO Auto-generated method stub  
        mongoTemplate.insertAll(batchs);  
    }  
    /**  
     * ɾ��,������id, ���������ֵΪnull,ɾ����ʧ��  
     * <br>------------------------------<br>  
     * @param id  
     */  
    public void deleteById(String id) {  
        // TODO Auto-generated method stub  
        Batch batch = new Batch(id);  
        mongoTemplate.remove(batch);  
    }
    /**  
     * ������ɾ��  
     * <br>------------------------------<br>  
     * @param criteriaBatch  
     */  
    public void delete(Batch criteriaBatch) {  
        // TODO Auto-generated method stub  
//        Criteria criteria = Criteria.where("age").gt(criteriaBatch.getAge());;  
//        Query query = new Query(criteria);  
//        mongoTemplate.remove(query, Batch.class);  
    }  
    /**  
     * ɾ��ȫ��  
     * <br>------------------------------<br>  
     */  
    public void deleteAll() {  
        // TODO Auto-generated method stub  
        mongoTemplate.dropCollection(Batch.class);  
    }  
    /**  
     * �������޸�,  
     * ����ĵ���û�����key ������ ʹ��$set�޸���  
     * <br>------------------------------<br>  
     * @param Batch  
     */  
    public void updateById(Batch batch) {  
        // TODO Auto-generated method stub  
//        Criteria criteria = Criteria.where("id").is(batch.getId());  
//        Query query = new Query(criteria);  
//        Update update = Update.update("age", batch.getAge()).set("name", batch.getName());  
//        mongoTemplate.updateFirst(query, update, Batch.class);  
    }  
    /**  
     * �޸Ķ���  
     * <br>------------------------------<br>  
     * @param criteriaBatch  
     * @param Batch  
     */  
    public void update(Batch criteriaBatch, Batch batch) {  
        // TODO Auto-generated method stub  
//        Criteria criteria = Criteria.where("age").gt(criteriaBatch.getAge());;  
//        Query query = new Query(criteria);  
//        Update update = Update.update("name", batch.getName()).set("age", batch.getAge());  
//        mongoTemplate.updateMulti(query, update, Batch.class);  
    }  
    /**  
     * ����������ѯ  
     * <br>------------------------------<br>  
     * @param id  
     * @return  
     */  
    public Batch findById(String id) {  
        // TODO Auto-generated method stub  
        return mongoTemplate.findById(id, Batch.class);  
    }  
    /**  
     * ��ѯȫ��  
     * <br>------------------------------<br>  
     * @return  
     */  
    public List<Batch> findAll() {  
        // TODO Auto-generated method stub  
        return mongoTemplate.findAll(Batch.class);  
    }  
    /**  
     * ��������ѯ, ��ҳ  
     * <br>------------------------------<br>  
     * @param criteriaBatch  
     * @param skip  
     * @param limit  
     * @return  
     */  
    public List<Batch> find(Batch criteriaBatch, int skip, int limit) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaBatch);  
        query.skip(skip);  
        query.limit(limit);  
        return mongoTemplate.find(query, Batch.class);  
    }  
    /**  
     * ����������ѯ������ ��ȥ�޸�  
     * <br>------------------------------<br>  
     * @param criteriaBatch  ��ѯ����  
     * @param updateBatch    �޸ĵ�ֵ����  
     * @return  
     */  
    public Batch findAndModify(Batch criteriaBatch, Batch updateBatch) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaBatch);  
        Update update = Update.update("appid", updateBatch.getAppid()).set("assetsid", updateBatch.getAssetsid());  
        return mongoTemplate.findAndModify(query, update, Batch.class);  
    }  
    /**  
     * ��ѯ������ ɾ��  
     * <br>------------------------------<br>  
     * @param criteriaBatch  
     * @return  
     */  
    public Batch findAndRemove(Batch criteriaBatch) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaBatch);  
        return mongoTemplate.findAndRemove(query, Batch.class);  
    }  
    /**  
     * count  
     * <br>------------------------------<br>  
     * @param criteriaBatch  
     * @return  
     */  
    public long count(Batch criteriaBatch) {  
        // TODO Auto-generated method stub  
        Query query = getQuery(criteriaBatch);  
        return mongoTemplate.count(query, Batch.class);  
    }  
    /**  
     *  
     * <br>------------------------------<br>  
     * @param criteriaBatch  
     * @return  
     */  
    private Query getQuery(Batch criteriaBatch) {  
        if (criteriaBatch == null) {  
            criteriaBatch = new Batch();  
        }  
        Query query = new Query();  
        if (criteriaBatch.getId() != null) {  
            Criteria criteria = Criteria.where("id").is(criteriaBatch.getId());  
            query.addCriteria(criteria);  
        }  
        if (criteriaBatch.getAppid() > 0) {  
            Criteria criteria = Criteria.where("appid").gt(criteriaBatch.getAppid());  
            query.addCriteria(criteria);  
        }  
        if (criteriaBatch.getAssetsid()  >0) {  
            Criteria criteria = Criteria.where("assetsid").regex("^" + criteriaBatch.getAssetsid());  
            query.addCriteria(criteria);  
        }  
        return query;  
    }  
}