package com.mentorondemand.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorondemand.entities.Mentor;
import com.mentorondemand.entities.TrainingActiveUser;
import com.mentorondemand.entities.User;
import com.mentorondemand.exceptions.NotFoundException;
import com.mentorondemand.repos.TrainingRepo;

@Service
public class TrainingActiveUserServiceImpl implements TraningActiveUserService {

	@Autowired
	TrainingRepo trainingRepo;

	@Autowired
	UserService userService;

	@Autowired
	MentorService mentorService;

	public String assignTrainer(TrainingActiveUser t, int mentorId, int userId) throws NotFoundException {
		Mentor foundMentor = mentorService.findById(mentorId);
		if (foundMentor == null) {
			throw new NotFoundException("Mentor not found");
		}

		User foundUser = userService.findUserById(userId);
		if (foundUser == null) {
			throw new NotFoundException("user not found");
		}

		t.setMentor(foundMentor);
		t.setUser(foundUser);
		trainingRepo.save(t);
		return "success";

	}

	public boolean startTraining(int id) throws NotFoundException {

		Optional<TrainingActiveUser> t = trainingRepo.findById(id);
		if (!t.isPresent()) {
			throw new NotFoundException("Training not found");
		}

		LocalDate d = LocalDate.now();
		TrainingActiveUser ta = t.get();
		ta.setStartDate(d);
		trainingRepo.save(ta);

		return true;
	}

	public boolean endTraining(int id) throws NotFoundException {
		Optional<TrainingActiveUser> t = trainingRepo.findById(id);
		if (!t.isPresent()) {
			throw new NotFoundException("Training not found");
		}
		LocalDate d = LocalDate.now();
		TrainingActiveUser ta = t.get();
		ta.setProgress(100);
		ta.setEndDate(d);
		trainingRepo.save(ta);
		return true;
	}

	public List<TrainingActiveUser> findPreviousTraining(int mentorId) throws NotFoundException {
		List<TrainingActiveUser> mentors = trainingRepo.findPreviousTraining(mentorId);
		if (mentors != null) {
			return mentors;
		} else {
			throw new NotFoundException("mentor not found");
		}

	}

	public TrainingActiveUser updateProgress(int progress, int userId, String trainingName) throws NotFoundException {

		TrainingActiveUser t = trainingRepo.updateProgress(trainingName, userId);
		if (t != null)
			t.setProgress(progress);
		else {
			throw new NotFoundException("user not found");

		}

		trainingRepo.save(t);
		return t;

	}

	public boolean addRating(String trainingName, int userId, int rating) throws NotFoundException {
		TrainingActiveUser t = trainingRepo.addRating(trainingName, userId);
		
		if (t != null)
			t.setRating(rating);
		else {
			throw new NotFoundException("user not found");

		}
		trainingRepo.save(t);
		return true;
	}

	public int findProgress(String trainingName, int userId) throws NotFoundException {
		TrainingActiveUser t = trainingRepo.findTrainingProgress(trainingName, userId);
		if (t != null)
			return t.getProgress();
		else {
			throw new NotFoundException("user not found");

		}

	}
}