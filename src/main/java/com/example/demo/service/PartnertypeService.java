package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Partnertype;
import com.example.demo.mapper.PartnertypeMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class PartnertypeService {

	@Resource
	private PartnertypeMapper partnertypeMapper;

	public List<Partnertype> selectPartnertypeSelective(Partnertype record)
	{
		return partnertypeMapper.selectPartnertypeSelective(record);
	}
	
	public int insert(Partnertype record)
	{
		return partnertypeMapper.insert(record);
	}
	public int insertByTypeName(String name)
	{
		Partnertype record =new Partnertype();
		record.setTypename(name);
		return partnertypeMapper.insertSelective(record);
	}
	public int delete(int typeid)
	{
		return partnertypeMapper.deleteByPrimaryKey(typeid);
	}
	public int deleteByIds(String ids)
	{
		
		return 0;
	}
	public int update(int typeid,String name)
	{
		Partnertype record =new Partnertype();
		record.setTypeid(typeid);
		record.setTypename(name);
		return partnertypeMapper.updateByPrimaryKeySelective(record);
	}
}