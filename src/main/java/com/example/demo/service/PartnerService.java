package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Partner;
import com.example.demo.mapper.PartnerMapper;


@Service
public class PartnerService {

	@Resource
	private PartnerMapper partnerMapper;

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
}