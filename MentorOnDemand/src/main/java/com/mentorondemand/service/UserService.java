package com.mentorondemand.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mentorondemand.entities.Mentor;
import com.mentorondemand.entities.Role;
import com.mentorondemand.entities.User;
import com.mentorondemand.entities.UserDetails;
import com.mentorondemand.exceptions.AlreadyExistsException;
import com.mentorondemand.exceptions.InvalidInputDataException;
import com.mentorondemand.exceptions.NotFoundException;
import com.mentorondemand.repos.MentorRepo;
import com.mentorondemand.repos.RoleRepo;
import com.mentorondemand.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	MentorRepo mentorRepo;

	public List<User> findAll() {

		return userRepo.findAll();
	}

	public User findUserById(int id) throws NotFoundException {
		User existingUser = userRepo.findById(id);
		if (existingUser != null) {
			return existingUser;
		} else {
			throw new NotFoundException("User Not Found :(");
		}
	}

	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public User findByName(String name) throws NotFoundException {
		User existingUser = userRepo.findByName(name);
		if (existingUser != null) {
			return existingUser;
		} else {
			throw new NotFoundException("User Not Found :(");
		}
	}

	public void addUser(UserDetails userDetails) throws InvalidInputDataException, AlreadyExistsException {

		String name = userDetails.getName();
		if (name.trim().isEmpty() || name == null) {
			throw new InvalidInputDataException(" Name cannot be empty");
		}

		String email = userDetails.getEmail();

		if ((UserService.validateEmail(email) == false) || email.trim().isEmpty()) {
			throw new InvalidInputDataException("Please enter valid email");
		}

		String password = userDetails.getPassword();
		if (password.trim().isEmpty() || password.length() < 3) {
			throw new InvalidInputDataException("Password strength not enough");
		}
		String phno = userDetails.getPhno();
		if (!(phno.matches("[0-9]{10}")) || phno.trim().isEmpty()) {
			throw new InvalidInputDataException("Please enter valid Phone number");
		}

		User user = new User(name, email, password, phno);
		Role role = roleRepo.findByRoleName(userDetails.getRole());
		user.setRole(role);
		userRepo.save(user);
		if (userDetails.getRole().equals("Mentor")) {
			Mentor m = new Mentor(0, 0, user);
			mentorRepo.save(m);
		}
	}

	public static boolean validateEmail(String email) {
		String pattern = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		if (email.matches(pattern))
			return true;
		return false;
	}

	public User save(User user) throws InvalidInputDataException {

		return userRepo.save(user);
	}

	public boolean login(String name, String password) throws NotFoundException {
		boolean flag = false;
		User user = userRepo.findByName(name);
		if (user != null) {
			if (user.getName().equals(name) && user.getPassword().equals(password)) {
				flag = true;
			}
		} else {
			throw new NotFoundException("Enter Valid details!!!");
		}
		return flag;
	}

	public void deleteUser(int id) throws NotFoundException {

		User existingUser = userRepo.findById(id);
		if (existingUser != null) {
			userRepo.deleteById(id);
		} else {
			throw new NotFoundException("User Not Found :(");
		}
	}

}