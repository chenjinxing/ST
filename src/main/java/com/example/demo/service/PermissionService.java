package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Partnerpermission;
import com.example.demo.entity.Permission;
import com.example.demo.mapper.PartnerpermissionMapper;
import com.example.demo.mapper.PermissionMapper;

@Service
public class PermissionService {

	@Resource
	private PartnerpermissionMapper partnerpermissionMapper;
	
	@Resource
	private PermissionMapper permissionMapper;
	
	public boolean hasPermission(int partnerId,String permissionCode,int source) {
		//�ҵ�Ȩ��
		Permission permission =permissionMapper.selectByUniqueCode(permissionCode);
		if(null ==permission)
			return false;
		//ƽ̨������
		if(1 ==source){
			//�ҵ�������
			Partnerpermission partnerpermission =partnerpermissionMapper.selectByUniqueKey(partnerId, permission.getPermissionid());
			if(null ==partnerpermission)
				return false;
			return true;
		}
		//�ʽ�
		else if(2 ==source)
		{
			return false; //Ĭ��Ϊ��Ȩ�� �������ʽ𷽽ӿ�
		}
		return false;
	}

}