package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Partnerfile;
import com.example.demo.entity.Partnertype;
import com.example.demo.mapper.PartnerfileMapper;
import com.example.demo.mapper.PartnertypeMapper;
import com.example.demo.protocol.CI_RtnPartnerfileData;
import com.example.demo.protocol.CI_RtnPartnertypeData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class PartnerfileService {

	@Resource
	private PartnerfileMapper partnerfileMapper;

	//根据查询条件查询 返回Json数据
	public String selectByConditionJson(Partnerfile record,String search,int start,int size)
	{
		List<Partnerfile> data =partnerfileMapper.selectSelectivePaging(record, search,start, size);
		int countAll =partnerfileMapper.selectCountSelective(record,search);
		//打包数据
		CI_RtnPartnerfileData rtn =new CI_RtnPartnerfileData();
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