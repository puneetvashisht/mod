package com.mentorondemand.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mentorondemand.entities.Mentor;
import com.mentorondemand.entities.MentorDetails;
import com.mentorondemand.entities.MentorSkills;
import com.mentorondemand.entities.Role;
import com.mentorondemand.entities.User;
import com.mentorondemand.exceptions.AlreadyExistsException;
import com.mentorondemand.exceptions.InvalidInputDataException;
import com.mentorondemand.exceptions.NotFoundException;
import com.mentorondemand.repos.MentorRepo;
import com.mentorondemand.repos.MentorSkillsRepo;
import com.mentorondemand.repos.RoleRepo;
import com.mentorondemand.repos.UserRepo;

@Service
public class MentorServiceImpl implements MentorService{

	@Autowired
	MentorRepo repo;
	@Autowired
	MentorSkillsRepo skillRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	public boolean register(MentorDetails mentorDetails) throws AlreadyExistsException, InvalidInputDataException {

		User users = userRepo.findByEmail(mentorDetails.getEmail());
		if (users != null) {
			throw new AlreadyExistsException("User Already Exists");

		} else {
			Role role = roleService.findByRoleName(mentorDetails.getRole());
			User u = new User(mentorDetails.getName(), mentorDetails.getEmail(), mentorDetails.getPassword(),
					mentorDetails.getPhno());
			u.setRole(role);
			userService.save(u);
			User u1 = userRepo.findByEmail(mentorDetails.getEmail());
			List<MentorSkills> a = new ArrayList<>();
			Mentor m = new Mentor(mentorDetails.getExperience(), mentorDetails.getCourseTeached(), u1);
			repo.save(m);

			a = skillRepo.findAll();
			List<MentorSkills> b = new ArrayList<>();
			for (MentorSkills ms : mentorDetails.getMentorSkills()) {
				if (a.contains(ms)) {
					System.out.println(a.get(a.indexOf(ms)));
					b.add(a.get(a.indexOf(ms)));
				} else {
					b.add(ms);
				}
			}
			m.setMentorSkills(b);
			System.out.println(b);
			repo.save(m);
			return true;
		}
	}

	public Mentor deleteMentorid(int id) throws NotFoundException {

		Mentor existingUser = repo.findById(id);
		if (existingUser != null) {
			repo.deleteById(id);

		} else {
			throw new NotFoundException("Mentor does not exists!!");
		}
		return existingUser;
	}

	public void save(Mentor mentor) {
		repo.save(mentor);
	}

	public List<Mentor> findAll() {
		return repo.findAll();

	}

	public Mentor findById(int id) throws NotFoundException {

		Mentor existingUser = repo.findById(id);
		if (existingUser != null) {
			return existingUser;
		} else {
			throw new NotFoundException("mentor not found");
		}

	}

	public Mentor updateMentorDetails(int mentorId, MentorDetails mentorDetails) {
		Mentor mentor = repo.findById(mentorId);
		System.out.println(mentor);
		mentor.setExperience(mentorDetails.getExperience());
		mentor.setCourseTeached(mentorDetails.getCourseTeached());
		List<MentorSkills> a = new ArrayList<>();
		a = skillRepo.findAll();
		List<MentorSkills> b = new ArrayList<>();
		List<MentorSkills> c = new ArrayList<>();
		c = mentor.getMentorSkills();
		b.addAll(c);
		for (MentorSkills ms : mentorDetails.getMentorSkills()) {
			if (a.contains(ms) && !(b.contains(ms))) {
				System.out.println(a.get(a.indexOf(ms)));
				System.out.println("hello");
				b.add(a.get(a.indexOf(ms)));
			} else if (!b.contains(ms)) {
				System.out.println("b.contains");
				b.add(ms);
			}
		}
		System.out.println(b);
		mentor.setMentorSkills(b);
		System.out.println(b);
		repo.save(mentor);
		return mentor;
	}

	public Mentor findMentorByEmail(String email) throws NotFoundException {
		User user = userService.findByEmail(email);
		Mentor mentor = repo.findByUser(user);
		if (mentor != null) {
			return mentor;
		} else {
			throw new NotFoundException("mentor not found");
		}
	}

	public Mentor findByUser(User found) throws NotFoundException {
		Mentor existingUser = repo.findByUser(found);
		if (existingUser != null) {
			return existingUser;
		} else {
			throw new NotFoundException("mentor not found");
		}
	}

}