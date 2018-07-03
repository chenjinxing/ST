package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Partnerfile;

public interface PartnerfileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table partnerfile
     *
     * @mbg.generated Tue Jul 03 14:58:55 CST 2018
     */
    int deleteByPrimaryKey(Integer fileid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table partnerfile
     *
     * @mbg.generated Tue Jul 03 14:58:55 CST 2018
     */
    int insert(Partnerfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table partnerfile
     *
     * @mbg.generated Tue Jul 03 14:58:55 CST 2018
     */
    int insertSelective(Partnerfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table partnerfile
     *
     * @mbg.generated Tue Jul 03 14:58:55 CST 2018
     */
    Partnerfile selectByPrimaryKey(Integer fileid);
    List<Partnerfile> selectSelectivePaging(@Param("record")Partnerfile record,@Param("search")String search,@Param("start")Integer start,@Param("size")Integer size);
    int selectCountSelective(@Param("record")Partnerfile record,@Param("search")String search);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table partnerfile
     *
     * @mbg.generated Tue Jul 03 14:58:55 CST 2018
     */
    int updateByPrimaryKeySelective(Partnerfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table partnerfile
     *
     * @mbg.generated Tue Jul 03 14:58:55 CST 2018
     */
    int updateByPrimaryKey(Partnerfile record);
}