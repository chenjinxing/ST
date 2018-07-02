package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Partnertype;
import com.example.demo.mapper.PartnertypeMapper;
import com.example.demo.protocol.CI_RtnPartnertypeData;
import com.fasterxml.jackson.core.JsonProcessingException;
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
	//根据查询条件查询
	public List<Partnertype> selectByCondition(Partnertype record)
	{
		return partnertypeMapper.selectPartnertypeSelective(record);
	}
	//根据查询条件查询 返回Json数据
	public String selectByConditionJson(Partnertype record)
	{
		List<Partnertype> data =selectByCondition(record);
		//打包数据
		CI_RtnPartnertypeData rtn =new CI_RtnPartnertypeData();
		rtn.setResult(1);
		rtn.setNotice("查询成功");
		rtn.setData(data);
		rtn.setCount(data.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String rtnStr =mapper.writeValueAsString(rtn);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
	}
	//根据查询条件查询 返回Json数据
	public String selectByConditionJson(Partnertype record,String search,int start,int size)
	{
		List<Partnertype> data =partnertypeMapper.selectSelectivePaging(record, search,start, size);
		int countAll =partnertypeMapper.selectCountSelective(record,search);
		//打包数据
		CI_RtnPartnertypeData rtn =new CI_RtnPartnertypeData();
		rtn.setResult(1);
		rtn.setNotice("查询成功");
		rtn.setData(data);
		rtn.setCount(countAll);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String rtnStr =mapper.writeValueAsString(rtn);
			return rtnStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":-1,\"count\":0,\"notice\":\"error\",\"data\":[]}";
	}
}