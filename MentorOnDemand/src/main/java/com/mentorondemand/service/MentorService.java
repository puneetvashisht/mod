package com.mentorondemand.service;

import java.util.ArrayList;
import java.util.List;
import com.mentorondemand.entities.Mentor;
import com.mentorondemand.entities.MentorDetails;
import com.mentorondemand.entities.MentorSkills;
import com.mentorondemand.entities.User;
import com.mentorondemand.exceptions.AlreadyExistsException;
import com.mentorondemand.exceptions.InvalidInputDataException;
import com.mentorondemand.exceptions.NotFoundException;

public interface MentorService {
	public boolean register(MentorDetails mentorDetails) throws AlreadyExistsException, 
	InvalidInputDataException;
	public Mentor deleteMentorid(int id) throws NotFoundException;
	public void save(Mentor mentor);
	public List<Mentor> findAll(); 
	public Mentor findById(int id) throws NotFoundException;
	public Mentor updateMentorDetails(int mentorId, MentorDetails mentorDetails);
	public Mentor findMentorByEmail(String email) throws NotFoundException;
	public Mentor findByUser(User found) throws NotFoundException;
		

}
