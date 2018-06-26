package com.example.demo.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Batch;
import com.example.demo.mongoDao.BatchDao;

@Service
public class BatchService{
	
	@Resource
	private BatchDao iBatchDao;
	
	public void insert(Batch user) {
		// TODO Auto-generated method stub
		iBatchDao.insert(user);
	}

	
	public void insertAll(List<Batch> users) {
		// TODO Auto-generated method stub
		iBatchDao.insertAll(users);
	}

	
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		iBatchDao.deleteById(id);
	}

	
	public void delete(Batch criteriaBatch) {
		// TODO Auto-generated method stub
		iBatchDao.delete(criteriaBatch);
	}

	
	public void deleteAll() {
		// TODO Auto-generated method stub
		iBatchDao.deleteAll();
	}

	
	public void updateById(Batch user) {
		// TODO Auto-generated method stub
		iBatchDao.updateById(user);
	}

	
	public void update(Batch criteriaBatch, Batch user) {
		// TODO Auto-generated method stub
		iBatchDao.update(criteriaBatch,user);
	}

	
	public Batch findById(String id) {
		// TODO Auto-generated method stub
		return iBatchDao.findById(id);
	}

	
	public List<Batch> findAll() {
		// TODO Auto-generated method stub
		return iBatchDao.findAll();
	}

	
	public List<Batch> find(Batch criteriaBatch, int skip, int limit) {
		// TODO Auto-generated method stub
		return iBatchDao.find(criteriaBatch,skip,limit);
	}

	
	public Batch findAndModify(Batch criteriaBatch, Batch updateBatch) {
		// TODO Auto-generated method stub
		return iBatchDao.findAndModify(criteriaBatch, updateBatch);
	}

	
	public Batch findAndRemove(Batch criteriaBatch) {
		// TODO Auto-generated method stub
		return iBatchDao.findAndRemove(criteriaBatch);
	}

	
	public long count(Batch criteriaBatch) {
		// TODO Auto-generated method stub
		return iBatchDao.count(criteriaBatch);
	}

}