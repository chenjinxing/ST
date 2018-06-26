package com.example.demo.mongoDao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AbstractBaseMongoTemplete implements ApplicationContextAware {  
    protected MongoTemplate mongoTemplate;  
      
    /**  
     * ����mongoTemplate  
     * @param mongoTemplate the mongoTemplate to set  
     */  
    public void setMongoTemplate(MongoTemplate mongoTemplate) {  
        this.mongoTemplate = mongoTemplate;  
    }  
      
    public void setApplicationContext(ApplicationContext applicationContext)  
            throws BeansException {  
        // TODO Auto-generated method stub  
        MongoTemplate mongoTemplate = applicationContext.getBean("mongoTemplate", MongoTemplate.class);  
        setMongoTemplate(mongoTemplate);  
    }  
  
}  