package com.example.demo.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CiBatch;
import com.example.demo.mapper.CiBatchMapper;
import com.example.demo.mapper.UserMapper;

@Service
public class CIBatchService {

	@Resource
	private CiBatchMapper ciBatchMapper;

	//根据 合作者id 和 合作者内部id确定CiBatch
	public CiBatch selectBatchByUniqueKey(int partnerid,String appbatchid)
	{
		CiBatch batch =new CiBatch();
		batch.setPartnerid(partnerid);
		batch.setAppbatchid(appbatchid);
		List<CiBatch> batchs =selectBatchSelective(batch);
		if(1 !=batchs.size())
			return null;
		return batchs.get(0);
	}
	//查询列表
	public List<CiBatch> selectBatchSelective(CiBatch batch) {
		return ciBatchMapper.selectBatchSelective(batch);
	}
	//根据partnerId查询列表
	public List<CiBatch> selectBatchByPartnerId(int partnerid) {
		CiBatch batch =new CiBatch();
		batch.setPartnerid(partnerid);
		
		return ciBatchMapper.selectBatchSelective(batch);
	}
	public int selectBatchCountSelective(CiBatch batch,int pagesize)
	{
		//总数目
		int allcount =ciBatchMapper.selectBatchCountSelective(batch);
		return (int) Math.ceil((double)allcount/pagesize);
	}
	//分页查询列表
	public List<CiBatch> selectBatchSelective(CiBatch batch,int pagesize,int pageindex) {
		//起始索引
		int start = pagesize *(pageindex -1);
		return ciBatchMapper.selectBatchSelectivePaging(batch, start, pagesize);
	}
	//删除批次
	public int deleteBatchById(int batchId)
	{
		return ciBatchMapper.deleteByPrimaryKey(batchId);
	}
	//新增批次
	public int insertBatch(CiBatch batch)
	{
		return ciBatchMapper.insertSelective(batch);
	}
	//更新批次
	public int updateBatch(CiBatch batch)
	{
		return ciBatchMapper.updateByPrimaryKeySelective(batch);
	}
}









