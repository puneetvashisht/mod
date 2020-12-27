package com.mentorondemand.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorondemand.entities.Mentor;
import com.mentorondemand.entities.TrainingActiveUser;
import com.mentorondemand.entities.User;
import com.mentorondemand.exceptions.NotFoundException;
import com.mentorondemand.repos.MentorRepo;
import com.mentorondemand.repos.TrainingRepo;
import com.mentorondemand.repos.UserRepo;

@Service
public class TrainingActiveUserService {
	
	@Autowired
	TrainingRepo trainingRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MentorService mentorService;
	
	public String assignTrainer(TrainingActiveUser t,int mentorId,int userId) throws NotFoundException {
		Mentor foundMentor = mentorService.findById(mentorId);
		if(foundMentor==null) {
			return "Mentor";
		}
		
		User foundUser=userService.findUserById(userId);
		if(foundUser==null) {
			return "User";
		}
		
		t.setMentor(foundMentor);
		t.setUser(foundUser);
		trainingRepo.save(t);
		return "success";
		
	}
	
	public boolean startTraining(int id){
		
		Optional<TrainingActiveUser> t=trainingRepo.findById(id);
		if(!t.isPresent()) {
			return false;
		}
		
		LocalDate d=LocalDate.now();
		TrainingActiveUser ta=t.get();
		ta.setStartDate(d);
		trainingRepo.save(ta);
		
		return true;
	}
	public boolean endTraining(int id) {
		Optional<TrainingActiveUser> t=trainingRepo.findById(id);
		if(!t.isPresent()) {
			return false;
		}
		LocalDate d=LocalDate.now();
		TrainingActiveUser ta=t.get();
		ta.setProgress(100);
		ta.setEndDate(d);
		trainingRepo.save(ta);
		return true;
	}
	
	public List<TrainingActiveUser> findPreviousTraining(int mentorId) {
		List<TrainingActiveUser> mentors=trainingRepo.findPreviousTraining(mentorId);
		
		System.out.println(mentors);
		return mentors;
	}
	
	public int updateProgress(int progress,int userId,String trainingName) {
		
		TrainingActiveUser t=trainingRepo.updateProgress(trainingName, userId);
		
		t.setProgress(progress);
		
		trainingRepo.save(t);
		return t.getProgress();
		
	}
	
	public boolean addRating(String trainingName,int userId,int rating) {
		TrainingActiveUser t=trainingRepo.addRating(trainingName, userId);
		System.out.println("error in addrating");
		System.out.println(t);
		if(t!=null) 
			t.setRating(rating);
		else if(t==null) {
			throw new NullPointerException("user not found");
			
		}
		trainingRepo.save(t);
		return true;
	}
	
	public int findProgress(String trainingName,int userId) {
		// TODO Auto-generated method stub
		
		TrainingActiveUser t=trainingRepo.findTrainingProgress(trainingName, userId);
		
		System.out.println("Progress = "+t.getProgress());
		return t.getProgress();
	}
}
