package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CiBatch;
import com.example.demo.entity.ClOrderbase;
import com.example.demo.entity.Partner;
import com.example.demo.mapper.ClOrderbaseMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.protocol.CI_RtnClOrderbaseData;
import com.example.demo.protocol.CI_RtnPartnerData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClOrderbaseService {

	@Resource
	private ClOrderbaseMapper clOrderMapper;

	
	public List<ClOrderbase> selectSelective(ClOrderbase orderbase) {
		return clOrderMapper.selectSelective(orderbase);
	}
	
	public ClOrderbase selectByPrimaryKey(int proid) {
		return clOrderMapper.selectByPrimaryKey(proid);
	}

	public int deleteOrderbaseById(int orderbaseId)
	{
		return clOrderMapper.deleteByPrimaryKey(orderbaseId);
	}

	public int insertOrderbase(ClOrderbase orderbase)
	{
		return clOrderMapper.insertSelective(orderbase);
	}
	public int insertSelectiveReturnId(ClOrderbase orderbase)
	{
		return clOrderMapper.insertSelectiveReturnId(orderbase);
	}
	public int updateOrderbase(ClOrderbase orderbase)
	{
		return clOrderMapper.updateByPrimaryKeySelective(orderbase);
	}
	
	public int selectCountSelective(ClOrderbase batch,int pagesize)
	{
		//总数目
		int allcount =clOrderMapper.selectCountSelective(batch);
		return (int) Math.ceil((double)allcount/pagesize);
	}
	//分页查询列表
	public List<ClOrderbase> selectSelective(ClOrderbase batch,int pagesize,int pageindex) {
		//起始索引
		int start = pagesize *(pageindex -1);
		return clOrderMapper.selectSelectivePaging(batch, start, pagesize);
	}
	//根据查询条件查询 返回Json数据
	public String selectByConditionJson(ClOrderbase orderbase) {
		
		List<ClOrderbase> data =clOrderMapper.selectSelective(orderbase);
		//打包数据
		CI_RtnClOrderbaseData rtn =new CI_RtnClOrderbaseData();
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
}









