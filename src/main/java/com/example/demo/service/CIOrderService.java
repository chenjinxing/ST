package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CiBatch;
import com.example.demo.entity.CiInstallment;
import com.example.demo.entity.CiOrder;
import com.example.demo.mongoDao.CIOrderDao;

@Service
public class CIOrderService {
	
	@Resource
	private CIOrderDao iOrderDao;
	
	public void insert(CiOrder user) {
		// TODO Auto-generated method stub
		iOrderDao.insert(user);
	}

	
	public void insertAll(List<CiOrder> users) {
		// TODO Auto-generated method stub
		iOrderDao.insertAll(users);
	}

	
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		iOrderDao.deleteById(id);
	}

	
	public void delete(CiOrder criteriaOrder) {
		// TODO Auto-generated method stub
		iOrderDao.delete(criteriaOrder);
	}

	
	public void deleteAll() {
		// TODO Auto-generated method stub
		iOrderDao.deleteAll();
	}

	
	public void updateById(CiOrder user) {
		// TODO Auto-generated method stub
		iOrderDao.updateById(user);
	}

	
	public void update(CiOrder criteriaOrder, CiOrder user) {
		// TODO Auto-generated method stub
		iOrderDao.update(criteriaOrder,user);
	}
	public void updateInstallment(CiOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
		iOrderDao.updateInstallment(criteriaOrder, installment, installmentno);
    }
	public void insertInstallment(CiOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
		iOrderDao.insertInstallment(criteriaOrder, installment, installmentno);
    }
    public void deleteInstallment(CiOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
    	iOrderDao.deleteInstallment(criteriaOrder, installment, installmentno);
    }
	
	public CiOrder findById(String id) {
		// TODO Auto-generated method stub
		return iOrderDao.findById(id);
	}

	
	public List<CiOrder> findAll() {
		// TODO Auto-generated method stub
		return iOrderDao.findAll();
	}

	
	public List<CiOrder> find(CiOrder criteriaOrder, int skip, int limit) {
		// TODO Auto-generated method stub
		return iOrderDao.find(criteriaOrder,skip,limit);
	}

	
	public CiOrder findAndModify(CiOrder criteriaOrder, CiOrder updateOrder) {
		// TODO Auto-generated method stub
		return iOrderDao.findAndModify(criteriaOrder, updateOrder);
	}

	
	public CiOrder findAndRemove(CiOrder criteriaOrder) {
		// TODO Auto-generated method stub
		return iOrderDao.findAndRemove(criteriaOrder);
	}

	
	public long count(CiOrder criteriaOrder) {
		// TODO Auto-generated method stub
		return iOrderDao.count(criteriaOrder);
	}
	public int selectCountSelective(CiOrder order,int pagesize)
	{
		//����Ŀ
		long allcount =iOrderDao.count(order);
		return (int) Math.ceil((double)allcount/pagesize);
	}
}

