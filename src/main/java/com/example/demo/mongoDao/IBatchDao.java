package com.example.demo.mongoDao;

import java.util.List;

import com.example.demo.entity.Batch;


public interface IBatchDao {
	/**
	 * ����
	 * <br>------------------------------<br>
	 * @param Batch
	 */
	void insert(Batch batch);
	
	/**
	 * ����
	 * <br>------------------------------<br>
	 * @param Batchs
	 */
	void insertAll(List<Batch> batchs);
	
	/**
	 * ɾ��,����id, ���������ֵΪnull,ɾ����ʧ��
	 * <br>------------------------------<br>
	 * @param id
	 */
	void deleteById(String id);
	
	/**
	 * ������ɾ��
	 * <br>------------------------------<br>
	 * @param criteriaBatch
	 */
	void delete(Batch criteriaBatch);
	
	/**
	 * ɾ��ȫ��
	 * <br>------------------------------<br>
	 */
	void deleteAll();
	
	/**
	 * �޸�
	 * <br>------------------------------<br>
	 * @param Batch
	 */
	void updateById(Batch batch);
	
	/**
	 * ���¶���
	 * <br>------------------------------<br>
	 * @param criteriaBatch
	 * @param Batch
	 */
	void update(Batch criteriaBatch, Batch batch);
	
	/**
	 * ����������ѯ
	 * <br>------------------------------<br>
	 * @param id
	 * @return
	 */
	Batch findById(String id);
	
	/**
	 * ��ѯȫ��
	 * <br>------------------------------<br>
	 * @return
	 */
	List<Batch> findAll();
	
	/**
	 * ��������ѯ
	 * <br>------------------------------<br>
	 * @param criteriaBatch
	 * @param skip
	 * @param limit
	 * @return
	 */
	List<Batch> find(Batch criteriaBatch, int skip, int limit);
	
	/**
	 * ����������ѯ������ ��ȥ�޸�
	 * <br>------------------------------<br>
	 * @param criteriaBatch  ��ѯ����
	 * @param updateBatch    �޸ĵ�ֵ����
	 * @return
	 */
	Batch findAndModify(Batch criteriaBatch, Batch updateBatch);
	
	/**
	 * ��ѯ������ ɾ��
	 * <br>------------------------------<br>
	 * @param criteriaBatch
	 * @return
	 */
	Batch findAndRemove(Batch criteriaBatch);
	
	/**
	 * count
	 * <br>------------------------------<br>
	 * @param criteriaBatch
	 * @return
	 */
	long count(Batch criteriaBatch);
}