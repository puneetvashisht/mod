package com.mentorondemand.controllers;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mentorondemand.entities.User;
import com.mentorondemand.entities.UserDetails;
import com.mentorondemand.exceptions.AlreadyExistsException;
import com.mentorondemand.exceptions.InvalidInputDataException;
import com.mentorondemand.exceptions.NotFoundException;
import com.mentorondemand.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	private static Logger logger = LogManager.getLogger(UserController.class);

	@GetMapping("/users")
	@ApiOperation(value = "Display all User", notes = "", response = User.class)
	public List<User> getAllUser() {
		return userService.findAll();

	}

	@GetMapping("/user/{id}")
	@ApiOperation(value = "Finding the User By Id", notes = "Enter the UserId", response = User.class)
	public ResponseEntity<User> getUserById(
			@ApiParam(value = "Enter the Id", required = true) @PathVariable("id") int id) throws NotFoundException {
		ResponseEntity<User> re;
		logger.info("Recieved id on path: " + id);
		User user = userService.findUserById(id);
		if (user != null) {
			re = new ResponseEntity<>(user, HttpStatus.OK);

		} else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;

	}

	@GetMapping("/user/email")
	@ApiOperation(value = "Finding the User By Email", notes = "Enter the Email", response = User.class)
	public ResponseEntity<User> getUserByEmail(
			@ApiParam(value = "Enter the Email", required = true) @RequestParam("email") String email)
			throws NotFoundException {
		ResponseEntity<User> re = null;
		logger.info(email);
		User existingUser = userService.findByEmail(email);
		if (existingUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(existingUser, HttpStatus.OK);

	}

	@GetMapping("/user/name")
	@ApiOperation(value = "Finding the User By Name", notes = "Enter the Name", response = User.class)
	public ResponseEntity<User> getUserByName(
			@ApiParam(value = "Enter the Name", required = true) @RequestParam("name") String name)
			throws NotFoundException {
		ResponseEntity<User> re = null;
		logger.info(name);
		User existingUser = userService.findByName(name);
		if (existingUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(existingUser, HttpStatus.OK);
	}

	@PostMapping("/user/login")
	@ApiOperation(value = "User Login", notes = "Enter your credentials", response = User.class)
	public ResponseEntity<String> login(
			@ApiParam(value = "Enter your Details", required = true) @RequestParam("name") String name,
			@RequestParam("password") String password) throws NotFoundException {

		boolean b = userService.login(name, password);
		if (b) {
			return new ResponseEntity<String>("Successfully Logged in", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Use correct email or password", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users")
	@ApiOperation(value = "Adding the User", notes = "Enter the details for adding user", response = User.class)
	public ResponseEntity<String> addUser(@RequestBody UserDetails userDetails)
			throws InvalidInputDataException, NotFoundException, AlreadyExistsException {

		User existingUser = userService.findByEmail(userDetails.getEmail());
		logger.info(userDetails);
		if (existingUser == null) {
			userService.addUser(userDetails);
			ResponseEntity<String> re = new ResponseEntity<>("successfully registered user!!", HttpStatus.CREATED);
			return re;
		}
		ResponseEntity<String> re = new ResponseEntity<>("Already Exixts!!", HttpStatus.CONFLICT);
		return re;
	}

	@PutMapping("/user/{id}")
	@ApiOperation(value = "Updating the User", notes = "Enter the values to update the user", response = User.class)
	public ResponseEntity<String> updateUser(
			@ApiParam(value = "Enter your Details", required = true) @PathVariable(value = "id") int userId,
			@RequestBody UserDetails userDetails) throws Exception {
		User user = userService.findUserById(userId);
		if (user == null) {
			return new ResponseEntity<String>("User not found :(", HttpStatus.NOT_FOUND);
		}

		user.setEmail(userDetails.getEmail());
		user.setName(userDetails.getName());
		user.setPassword(userDetails.getPassword());
		user.setPhno(userDetails.getPhno());
		userService.save(user);
		return new ResponseEntity<String>("Updated Successfully!!", HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "Enter id to be delete", notes = "Enter your id", response = User.class)
	public ResponseEntity<String> deleteUser(
			@ApiParam(value = "Enter your userId", required = true) @PathVariable("id") int id)
			throws NotFoundException {
		ResponseEntity<String> re;
		User user = userService.findUserById(id);
		if (user != null) {
			userService.deleteUser(id);
			re = new ResponseEntity<String>("Successfully  Deleted ", HttpStatus.OK);
		} else {
			re = new ResponseEntity<String>(" User Not Found", HttpStatus.NOT_FOUND);
		}
		return re;

	}
}