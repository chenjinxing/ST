package com.example.demo.service;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Stuser;
import com.example.demo.entity.User;
import com.example.demo.mapper.StuserMapper;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService {

	@Resource
	private StuserMapper stuserMaper;

	public String findUserById(int id) {
		Stuser user =stuserMaper.selectByPrimaryKey(id);
		
		if(null ==user)
			return "error";
		return user.getName();

	}
	//shiro ��֤���
    public Stuser getByUsername(String username){  
        return stuserMaper.getByUsername(username);  
	}  
	public Set<String> getRoles(String username){  
	        return stuserMaper.getRoles(username);  
	}  
	public Set<String> getPermissions(String username){  
	       return stuserMaper.getPermissions(username);  
	}  
}
