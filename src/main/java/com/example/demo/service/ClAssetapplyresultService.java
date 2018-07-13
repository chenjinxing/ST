package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ClAssetapplyresult;
import com.example.demo.entity.ClOrderbase;
import com.example.demo.mapper.ClAssetapplyresultMapper;
import com.example.demo.protocol.CI_RtnApplyResultData;
import com.example.demo.protocol.CI_RtnClOrderbaseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClAssetapplyresultService {
	
	@Resource
	ClAssetapplyresultMapper assetapplyresultMapper;
	
	public int insertSelective(ClAssetapplyresult result)
	{
		return assetapplyresultMapper.insertSelective(result);
	}
	public List<ClAssetapplyresult> selectResultByProid(int proId)
	{
		return assetapplyresultMapper.selectResultByProId(proId);
	}
	//根据查询条件查询 返回Json数据
	public String selectResultByProidJson(Integer proId) {
		
		List<ClAssetapplyresult> data =assetapplyresultMapper.selectResultByProId(proId);
		//打包数据
		CI_RtnApplyResultData rtn =new CI_RtnApplyResultData();
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
