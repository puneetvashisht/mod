package com.mentorondemand.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.entities.User;
import com.mentorondemand.entities.UserDetails;
import com.mentorondemand.service.UserService;

@RestController
//@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getAllUser() {
		return userService.findAll();

	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id)  {
		ResponseEntity<User> re;
		System.out.println("Recieved id on path: " + id);
		// code here to fetch user by id
		User user = userService.findUserbyid(id);
		if (user != null) {
			re = new ResponseEntity<>( user,HttpStatus.OK);
			
		} else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;

	}

	@GetMapping("/findUserEmail")
	public ResponseEntity<User> getUserByEmail(@RequestParam("Email") String email) {
		ResponseEntity<User> re = null;
		System.out.println(email);
		User existingUser = userService.findByEmail(email);
		if (existingUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(existingUser, HttpStatus.OK);

	}

	@GetMapping("/findUserName")
	public ResponseEntity<User> getUserByName(@RequestParam("Name") String name) {
		ResponseEntity<User> re = null;
		System.out.println(name);
		User existingUser = userService.findByName(name);
		if (existingUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(existingUser, HttpStatus.OK);
	}

	@GetMapping("/loginUser")
	public ResponseEntity<String> UserLogin(@RequestParam("name") String name,
			@RequestParam("password") String password) {
		User existingUser = userService.findByName(name);
		if (existingUser.getName().equals(name) && existingUser.getPassword().equals(password)) {
			return new ResponseEntity<String>("Successfully logged in!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Enter valid details!!", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<String> addUser(@RequestBody UserDetails userDetails){

		User existingUser = userService.findByEmail(userDetails.getEmail());
		System.out.println(userDetails);
		if (existingUser != null) {
			return new ResponseEntity<String>("User already exists!!", HttpStatus.CONFLICT);
		}
		userService.add(userDetails);
		ResponseEntity<String> re = new ResponseEntity<>("successfully registered user!!", HttpStatus.CREATED);
		return re;
	}

	@PutMapping("/userupdate/{id}")
	public ResponseEntity<String> updateUser(@PathVariable(value = "id") int userId, @RequestBody UserDetails userDetails)
			throws Exception {
		User user = userService.findUserbyid(userId);
		if (user == null) {
			return new ResponseEntity<String>("User not found :(",HttpStatus.NOT_FOUND);
		}
		user.setEmail(userDetails.getEmail());
		user.setName(userDetails.getName());
		user.setPassword(userDetails.getPassword());
		user.setPhno(userDetails.getPhno());
		User updatedUser = userService.save(user);
		return new ResponseEntity<String>("Updated Successfully!!",HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		ResponseEntity<String> re;
		User user = userService.findUserbyid(id);
		if (user != null) {
			userService.delete(id);
			re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} else {
			re = new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}
		return re;

	}
}