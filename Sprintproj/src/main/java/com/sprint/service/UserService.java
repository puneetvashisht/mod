package com.sprint.service;

import java.util.List;

import com.sprint.entities.User;
import com.sprint.exception.InvalidInputDataException;
import com.sprint.repos.UserRepo;

public class UserService {
        UserRepo userrepo=new UserRepo();
        public  User add(User user,String role) throws InvalidInputDataException {	
    		String name = user.getName();
    		if (name.trim().isEmpty() || name ==  null) {
    			throw new InvalidInputDataException("First Name cannot be empty");
    		}
    		
    		String email = user.getEmail();
    		
    		if ((UserService.validateEmail(email) == false) || email.trim().isEmpty()) {
    			throw new InvalidInputDataException("Please enter valid email");
    		}
    		
    		String password = user.getPassword();
    		if (password.trim().isEmpty() || password.length() < 3) {
    			throw new InvalidInputDataException("Password strength not enough");
    		}
    		String phno = user.getPhno();
    		if ( !(phno.matches("[0-9]{10}"))  || phno.trim().isEmpty()) {
    			throw new InvalidInputDataException("Please enter valid Phone number");
    		}
    	   User u=userrepo.addUser(user,role);
    	   return u;
        }
    		

        public static boolean validateEmail(String email) {
    		String pattern = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
    		if(email.matches(pattern))
    			return true;
    		return false;
    	}
    	public boolean validateUser(String name, String password) throws InvalidInputDataException{
    		if(userrepo.loginUser(name,password)) {
    		  return true;	
    		}
    		else {
    			throw new InvalidInputDataException("User Id and password do not match");
    		}
    	}
       public User findUserbyid(int id) throws InvalidInputDataException {
    			
    			User user = userrepo.findUserById(id);
    			if(user==null) {
    				throw new InvalidInputDataException("User not found with the given ID " + id);
    			}
    			return user;
    		}
       public  User register(User user) throws InvalidInputDataException {	
   		String name = user.getName();
   		if (name.trim().isEmpty() || name ==  null) {
   			throw new InvalidInputDataException("First Name cannot be empty");
   		}
   		
   		String email = user.getEmail();
   		
   		if ((UserService.validateEmail(email) == false) || email.trim().isEmpty()) {
   			throw new InvalidInputDataException("Please enter valid email");
   		}
   		
   		String password = user.getPassword();
   		if (password.trim().isEmpty() || password.length() < 3) {
   			throw new InvalidInputDataException("Password strength not enough");
   		}
   		String phno = user.getPhno();
   		if ( !(phno.matches("[0-9]{10}"))  || phno.trim().isEmpty()) {
   			throw new InvalidInputDataException("Please enter valid Phone number");
   		}
   	   User u=userrepo.userRegistration(user);
   	   return u;
       }
       
       public User removeById(int id) throws InvalidInputDataException {
			
			User user = userrepo.findUserById(id);
			if(user==null) {
				throw new InvalidInputDataException("User not found with the given ID so cannot delete " + id);
			}
			return user;
		}
       
   		
}

