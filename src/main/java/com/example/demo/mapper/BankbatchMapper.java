package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Bankbatch;

public interface BankbatchMapper {
	
	//input bankid
	List<Integer> getBankBatchs(Integer id);
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankbatch
     *
     * @mbg.generated Wed May 02 16:29:24 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankbatch
     *
     * @mbg.generated Wed May 02 16:29:24 CST 2018
     */
    int insert(Bankbatch record);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankbatch
     *
     * @mbg.generated Wed May 02 16:29:24 CST 2018
     */
    int insertSelective(Bankbatch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankbatch
     *
     * @mbg.generated Wed May 02 16:29:24 CST 2018
     */
    Bankbatch selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankbatch
     *
     * @mbg.generated Wed May 02 16:29:24 CST 2018
     */
    int updateByPrimaryKeySelective(Bankbatch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankbatch
     *
     * @mbg.generated Wed May 02 16:29:24 CST 2018
     */
    int updateByPrimaryKey(Bankbatch record);
}