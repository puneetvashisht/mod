package com.mentorondemand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorondemand.entities.Role;
import com.mentorondemand.repos.RoleRepo;

@Service
public class RoleService {
	@Autowired
	RoleRepo roleRepo;
	
	public Role findByRoleName(String roleName){
		 return roleRepo.findByRoleName(roleName);
		 
	}
	

}

