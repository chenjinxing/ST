package com.example.demo.mapper;

import com.example.demo.entity.ClOrderstatus;

public interface ClOrderstatusMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_orderstatus
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    int deleteByPrimaryKey(Integer statusid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_orderstatus
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    int insert(ClOrderstatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_orderstatus
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    int insertSelective(ClOrderstatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_orderstatus
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    ClOrderstatus selectByPrimaryKey(Integer statusid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_orderstatus
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    int updateByPrimaryKeySelective(ClOrderstatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_orderstatus
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    int updateByPrimaryKey(ClOrderstatus record);
}