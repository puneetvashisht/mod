package com.mentorondemand.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorondemand.entities.Mentor;
import com.mentorondemand.entities.MentorDetails;
import com.mentorondemand.entities.Role;
import com.mentorondemand.entities.User;
import com.mentorondemand.repos.MentorRepo;
import com.mentorondemand.repos.MentorSkillsRepo;
import com.mentorondemand.repos.RoleRepo;
import com.mentorondemand.repos.UserRepo;

@Service
public class MentorService {

		@Autowired
		MentorRepo repo;

		@Autowired
		MentorSkillsRepo skillrepo;
		
		@Autowired
		UserRepo userrepo;
		
		@Autowired
		RoleRepo rolerepo;
		
		@Autowired
		UserService userService;
		
		
		@Autowired
		RoleService roleService;
		

		


		public void register(MentorDetails mentorDetails) {
			
			Role role= roleService.findByRoleName(mentorDetails.getRole());
			User u =new User(mentorDetails.getName(),mentorDetails.getEmail(),mentorDetails.getPassword(),mentorDetails.getPhno());
			u.setRole(role);
			userService.save(u);
			User u1 = userService.findByName(mentorDetails.getName());	
		
			Mentor m=new Mentor(mentorDetails.getExperience(),mentorDetails.getCourseTeached(),u1,mentorDetails.getMentorSkills());
			repo.save(m);
		
		}


		public Mentor save(Mentor mentor) {
			// TODO Auto-generated method stub
			return null;
		}


		public List<Mentor> findAll() {
			return repo.findAll();
		
		}


		public Optional<Mentor> findById(int id) {
			
			return repo.findById(id);
		}


		public void deleteById(int id) {
			 repo.deleteById(id);
			
		}
		
	}

