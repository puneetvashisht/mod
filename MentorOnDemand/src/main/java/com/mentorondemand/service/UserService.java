package com.mentorondemand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorondemand.entities.Role;
import com.mentorondemand.entities.User;
import com.mentorondemand.entities.UserDetails;
import com.mentorondemand.repos.RoleRepo;
import com.mentorondemand.repos.UserRepo;
@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findUserbyid(int id) {
		
		return userRepo.findById(id);
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userRepo.findByName(name);
	}

	public void add(UserDetails userDetails) {
		// TODO Auto-generated method stub
		String name = userDetails.getName();
		String email = userDetails.getEmail();
		String password = userDetails.getPassword();
		String phno= userDetails.getPhno();
		User user = new User(name, email, password, phno);
		Role role = roleRepo.findByRoleName(userDetails.getRole());
		System.out.println(role);
		user.setRole(role);
		System.out.println(user);
		userRepo.save(user);
	}

	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
		
	}

}
