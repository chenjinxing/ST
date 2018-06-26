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

	//���� ������id �� �������ڲ�idȷ��CiBatch
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
	//��ѯ�б�
	public List<CiBatch> selectBatchSelective(CiBatch batch) {
		return ciBatchMapper.selectBatchSelective(batch);
	}
	//����partnerId��ѯ�б�
	public List<CiBatch> selectBatchByPartnerId(int partnerid) {
		CiBatch batch =new CiBatch();
		batch.setPartnerid(partnerid);
		
		return ciBatchMapper.selectBatchSelective(batch);
	}
	public int selectBatchCountSelective(CiBatch batch,int pagesize)
	{
		//����Ŀ
		int allcount =ciBatchMapper.selectBatchCountSelective(batch);
		return (int) Math.ceil((double)allcount/pagesize);
	}
	//��ҳ��ѯ�б�
	public List<CiBatch> selectBatchSelective(CiBatch batch,int pagesize,int pageindex) {
		//��ʼ����
		int start = pagesize *(pageindex -1);
		return ciBatchMapper.selectBatchSelectivePaging(batch, start, pagesize);
	}
	//ɾ������
	public int deleteBatchById(int batchId)
	{
		return ciBatchMapper.deleteByPrimaryKey(batchId);
	}
	//��������
	public int insertBatch(CiBatch batch)
	{
		return ciBatchMapper.insertSelective(batch);
	}
	//��������
	public int updateBatch(CiBatch batch)
	{
		return ciBatchMapper.updateByPrimaryKeySelective(batch);
	}
}









