package com.example.demo.mapper;

import com.example.demo.entity.Permissiontype;

public interface PermissiontypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permissiontype
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    int deleteByPrimaryKey(Integer typeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permissiontype
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    int insert(Permissiontype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permissiontype
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    int insertSelective(Permissiontype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permissiontype
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    Permissiontype selectByPrimaryKey(Integer typeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permissiontype
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    int updateByPrimaryKeySelective(Permissiontype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permissiontype
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    int updateByPrimaryKey(Permissiontype record);
}