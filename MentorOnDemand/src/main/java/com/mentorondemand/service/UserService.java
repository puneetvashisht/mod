package com.mentorondemand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mentorondemand.entities.User;
import com.mentorondemand.repos.UserRepo;

public class UserService {
	@Autowired
	UserRepo userRepo;
	public User save(User u) {
		  return userRepo.save(u);
		
	}
	public User findByName(String name) {

		return userRepo.findByName(name);
	}

}	
