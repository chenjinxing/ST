package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CiInstallment;
import com.example.demo.entity.ClOrder;
import com.example.demo.mongoDao.ClOrderDao;

@Service
public class ClOrderService {
	
	@Resource
	private ClOrderDao lOrderDao;
	
	public void insert(ClOrder user) {
		// TODO Auto-generated method stub
		lOrderDao.insert(user);
	}

	
	public void insertAll(List<ClOrder> users) {
		// TODO Auto-generated method stub
		lOrderDao.insertAll(users);
	}

	
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		lOrderDao.deleteById(id);
	}

	
	public void delete(ClOrder criteriaOrder) {
		// TODO Auto-generated method stub
		lOrderDao.delete(criteriaOrder);
	}

	
	public void deleteAll() {
		// TODO Auto-generated method stub
		lOrderDao.deleteAll();
	}

	
	public void updateById(ClOrder user) {
		// TODO Auto-generated method stub
		lOrderDao.updateById(user);
	}

	
	public void update(ClOrder criteriaOrder, ClOrder user) {
		// TODO Auto-generated method stub
		lOrderDao.update(criteriaOrder,user);
	}
	public void updateInstallment(ClOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
		lOrderDao.updateInstallment(criteriaOrder, installment, installmentno);
    }
	public void insertInstallment(ClOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
		lOrderDao.insertInstallment(criteriaOrder, installment, installmentno);
    }
    public void deleteInstallment(ClOrder criteriaOrder, CiInstallment installment,int installmentno)
    {
    	lOrderDao.deleteInstallment(criteriaOrder, installment, installmentno);
    }
	
	public ClOrder findById(String id) {
		// TODO Auto-generated method stub
		return lOrderDao.findById(id);
	}

	
	public List<ClOrder> findAll() {
		// TODO Auto-generated method stub
		return lOrderDao.findAll();
	}

	
	public List<ClOrder> find(ClOrder criteriaOrder, int skip, int limit) {
		// TODO Auto-generated method stub
		return lOrderDao.find(criteriaOrder,skip,limit);
	}

	
	public ClOrder findAndModify(ClOrder criteriaOrder, ClOrder updateOrder) {
		// TODO Auto-generated method stub
		return lOrderDao.findAndModify(criteriaOrder, updateOrder);
	}

	
	public ClOrder findAndRemove(ClOrder criteriaOrder) {
		// TODO Auto-generated method stub
		return lOrderDao.findAndRemove(criteriaOrder);
	}

	
	public long count(ClOrder criteriaOrder) {
		// TODO Auto-generated method stub
		return lOrderDao.count(criteriaOrder);
	}
	public int selectCountSelective(ClOrder order,int pagesize)
	{
		//����Ŀ
		long allcount =lOrderDao.count(order);
		return (int) Math.ceil((double)allcount/pagesize);
	}
}

