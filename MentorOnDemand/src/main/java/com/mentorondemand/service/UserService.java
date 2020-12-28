package com.mentorondemand.service;

import java.util.List;

import com.mentorondemand.entities.User;
import com.mentorondemand.entities.UserDetails;
import com.mentorondemand.exceptions.AlreadyExistsException;
import com.mentorondemand.exceptions.InvalidInputDataException;
import com.mentorondemand.exceptions.NotFoundException;

public interface UserService {
	public List<User> findAll();
	public User findUserById(int id) throws NotFoundException;
	public User findByEmail(String email);
	public User findByName(String name) throws NotFoundException ;
	public void addUser(UserDetails userDetails) throws InvalidInputDataException, AlreadyExistsException ;
	public User save(User user) throws InvalidInputDataException;
	public boolean login(String name, String password) throws NotFoundException;
	public void deleteUser(int id) throws NotFoundException;

}
