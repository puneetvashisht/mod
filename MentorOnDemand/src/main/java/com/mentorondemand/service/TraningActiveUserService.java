package com.mentorondemand.service;

import java.util.List;

import com.mentorondemand.entities.TrainingActiveUser;
import com.mentorondemand.exceptions.NotFoundException;

public interface TraningActiveUserService {
	public String assignTrainer(TrainingActiveUser t, int mentorId, int userId) throws NotFoundException;
	public boolean startTraining(int id) throws NotFoundException;
	public boolean endTraining(int id) throws NotFoundException;
	public List<TrainingActiveUser> findPreviousTraining(int mentorId) throws NotFoundException;
	public TrainingActiveUser updateProgress(int progress, int userId, String trainingName) throws NotFoundException;
	public boolean addRating(String trainingName, int userId, int rating) throws NotFoundException;
	public int findProgress(String trainingName, int userId) throws NotFoundException;
}
