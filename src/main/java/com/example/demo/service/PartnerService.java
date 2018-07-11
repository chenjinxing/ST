package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Partner;
import com.example.demo.entity.Partnertype;
import com.example.demo.mapper.PartnerMapper;
import com.example.demo.protocol.CI_RtnPartnerData;
import com.example.demo.protocol.CI_RtnPartnertypeData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class PartnerService {

	@Resource
	private PartnerMapper partnerMapper;
	
	public Integer selectMainUser(Integer partnerId)
	{
		return partnerMapper.selectMainUser(partnerId);
	}

	public Partner selectByPartnerCode(String partnercode)
	{
		return partnerMapper.selectByUniqueKey(partnercode);
	}
	public String getPartnerKey(int partnerid)
	{
		Partner parnter =partnerMapper.selectByPrimaryKey(partnerid);
		if(null ==parnter)
			return "";
		return parnter.getPartnerkey();
	}
	public String getPartnerKey(String partnercode)
	{
		Partner parnter =partnerMapper.selectByUniqueKey(partnercode);
		if(null ==parnter)
			return "";
		return parnter.getPartnerkey();
	}
	//根据查询条件查询 返回Json数据
	public String selectByConditionJson(Partner record, String search, Integer start, Integer size) {
		
		List<Partner> data =partnerMapper.selectSelectivePaging(record, search,start, size);
		int countAll =partnerMapper.selectCountSelective(record,search);
		//打包数据
		CI_RtnPartnerData rtn =new CI_RtnPartnerData();
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
	public int insertSelective(Partner record)
	{
		return partnerMapper.insertSelective(record);
	}
	//delete
	public int delete(int partnerId)
	{
		return partnerMapper.deleteByPrimaryKey(partnerId);
	}
	public int updateByPrimaryKey(Partner record)
	{
		return partnerMapper.updateByPrimaryKeySelective(record);
	}
}