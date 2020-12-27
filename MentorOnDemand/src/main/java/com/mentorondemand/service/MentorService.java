package com.mentorondemand.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

		public boolean register(MentorDetails mentorDetails)throws AlreadyExistsException, InvalidInputDataException {
			
			User users = userrepo.findByEmail(mentorDetails.getEmail());
			System.out.println(users);
			if (users != null) {
				throw new AlreadyExistsException("User Already Exists");
			
			} else {
				Role role = roleService.findByRoleName(mentorDetails.getRole());
				User u = new User(mentorDetails.getName(), mentorDetails.getEmail(), mentorDetails.getPassword(),
				mentorDetails.getPhno());
				u.setRole(role);
				userService.save(u);
				User u1 = userrepo.findByEmail(mentorDetails.getEmail());
				List<MentorSkills> a = new ArrayList<>();
				Mentor m = new Mentor(mentorDetails.getExperience(),mentorDetails.getCourseTeached(), u1);
				repo.save(m);
				
				a=skillrepo.findAll();
				 List<MentorSkills> b=new ArrayList<>();
				for (MentorSkills ms : mentorDetails.getMentorSkills()) {
					if (a.contains(ms)) {
						System.out.println(a.get(a.indexOf(ms)));
						b.add(a.get(a.indexOf(ms)));
					}
					else {
						b.add(ms);
					}
				}
				m.setMentorSkills(b);
				System.out.println(b);
				repo.save(m);
				return true;
			}					
		}
		
		
		
		public Mentor findById(int id) throws NotFoundException {
			
			Mentor existingUser = repo.findById(id);
			if (existingUser!=null) {
				throw new NotFoundException("Mentor does not exists!!");
			} else {
				repo.deleteById(id);
			}
			return existingUser;
		}
	

		public void deleteById(int id)throws NotFoundException {
			Mentor existingUser = repo.findById(id);
			if (existingUser!=null) {
				throw new NotFoundException("Mentor does not exists!!");
			} else {
				repo.deleteById(id);
			}
		}

		public Mentor save(Mentor mentor) {
			// TODO Auto-generated method stub
			return null;
		}


		public List<Mentor> findAll() {
			return repo.findAll();
		
		}
	
}