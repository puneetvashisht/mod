package com.sprint.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.ValidationException;

import com.sprint.entities.Mentor;
import com.sprint.repos.MentorRepository;

import com.sprint.exception.InvalidInputDataException;

public class MentorService {

	MentorRepository mentorRepo = new MentorRepository();
	public Mentor add(Mentor mentor) throws InvalidInputDataException{
		
		String mentorName = mentor.getMentorName();
		if (mentorName.trim().isEmpty() || mentorName ==  null) {
			throw new InvalidInputDataException("First Name cannot be empty");
		}
		
		String email = mentor.getEmail();
		
		if ((MentorService.validateEmail(email) == false) || email.trim().isEmpty()) {
			throw new InvalidInputDataException("Please enter valid email");
		}
		
		String password = mentor.getPassword();
		if (password.trim().isEmpty() || password.length() < 3) {
			throw new InvalidInputDataException("Password strength not enough");
		}
		String phoneNumber = mentor.getPhoneNumber();
		if ( !(phoneNumber.matches("[0-9]{10}"))  || phoneNumber.trim().isEmpty()) {
			throw new InvalidInputDataException("Please enter valid Phone number");
		}
	   Mentor m=mentorRepo.addMentor(mentor);
	   return m;
    }
		
	
	 public static boolean validateEmail(String email) {
 		String pattern = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
 		if(email.matches(pattern))
 			return true;
 		return false;
 	}
	

//		//String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
//		String str = mentor.getPassword();
//		String str1=mentor.getEmail();
//	//	String regex1 = "^(.+)@(.+)$";
//


	 public boolean validateMentor(String mentorName, String password) throws InvalidInputDataException{
 		if(mentorRepo.loginMentor(mentorName,password)) {
 		  return true;	
 		}
 		else {
 			throw new InvalidInputDataException("Mentor Id and password do not match");
 		}
 	}
    public Mentor findMentorById(int id) throws InvalidInputDataException {
 			
    	Mentor mentor = mentorRepo.findMentorById(id);
 			if(mentor==null) {
 				throw new InvalidInputDataException("Mentor not found with the given ID " + id);
 			}
 			return mentor;
 		}
    
    public  Mentor register(Mentor mentor) throws InvalidInputDataException {	
		String mentorName =  mentor.getMentorName();
		if (mentorName.trim().isEmpty() || mentorName ==  null) {
			throw new InvalidInputDataException("First Name cannot be empty");
		}
		
		
		String email =  mentor.getEmail();
		if ((MentorService.validateEmail(email) == false) || email.trim().isEmpty()) {
			throw new InvalidInputDataException("Please enter valid email");
		}
		
		
		String password = mentor.getPassword();
		if (password.trim().isEmpty() || password.length() < 3) {
			throw new InvalidInputDataException("Password strength not enough");
		}
		
		
		String phoneNumber = mentor.getPhoneNumber();
		if ( !(phoneNumber.matches("[0-9]{10}"))  || phoneNumber.trim().isEmpty()) {
			throw new InvalidInputDataException("Please enter valid Phone number");
		}
		Mentor m=mentorRepo.mentorRegistration(mentor);
	   return m;
    }
    
    public Mentor removeMentorById(int id) throws InvalidInputDataException {
			
    	Mentor mentor = mentorRepo.findMentorById(id);
			if(mentor==null) {
				throw new InvalidInputDataException("No mentor found with the given ID so cannot delete " + id);
			}
			return mentor;
		}
}   
		
	

