package com.mentorondemand.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mentorondemand.entities.*;
import com.mentorondemand.exceptions.*;
import com.mentorondemand.repos.MentorRepo;
import com.mentorondemand.repos.MentorSkillsRepo;
import com.mentorondemand.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class MentorController {

	@Autowired
	MentorRepo mentorRepo;
	@Autowired
	MentorService mentorService;
	@Autowired
	UserService userService;
	@Autowired
	MentorSkillsRepo skillRepo;

	@PostMapping("/mentor")
	@ApiOperation(value = "Registering mentor", notes = "Enter your user id ")
	public ResponseEntity<String> add(@RequestBody MentorDetails mentordetails) throws AlreadyExistsException, InvalidInputDataException {
		boolean flag = mentorService.register(mentordetails);
		ResponseEntity<String> re = null;
		if (flag)
			re = new ResponseEntity<String>("mentor successfully created", HttpStatus.CREATED);
		else
			re = new ResponseEntity<String>("mentor already exists", HttpStatus.CONFLICT);
		System.out.println(mentordetails);
		return re;
	}
	
	@GetMapping("/mentors")
	@ApiOperation(value = "displaying all the mentor details", notes = "enter path to display", response = Mentor.class)
	public List<Mentor> getAllUser() {
		return mentorService.findAll();
	}

	@GetMapping("/mentor/Email")
	@ApiOperation(value = "Get details by id", notes = "Enter the id",response = Mentor.class)
	public ResponseEntity<User> getByEmail(@RequestParam("email") String email) throws NotFoundException {
		ResponseEntity<User> re;
		User found = userService.findByEmail(email);
		if (found == null) {

			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			re = new ResponseEntity<>(found, HttpStatus.OK);
		}
		return re;
	}

	@GetMapping("/mentor/{id}")
	public ResponseEntity<Mentor> getUserById(@PathVariable("id") int id) throws NotFoundException {
		ResponseEntity<Mentor> re;
		System.out.println("Recieved id on path: " + id);
		Mentor mentor = mentorService.findById(id);
		if (mentor!=null) {

			re = new ResponseEntity<>(mentor, HttpStatus.OK);
		} else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}

	@DeleteMapping("/mentors/{id}")
	@ApiOperation(value = "Delete by Id", notes = "Enter the Mentor id", response = Mentor.class)
	public ResponseEntity<Mentor> deleteUserById(@PathVariable("id") int id) throws NotFoundException {
		ResponseEntity<Mentor> re;
		System.out.println("Recieved id on path: " + id);
		Mentor mentor = mentorService.findById(id);
		if (mentor!=null) {
			mentorService.deleteById(id);
			re = new ResponseEntity<>(mentor, HttpStatus.OK);
		} else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}
	

	@PutMapping("/mentor/update/{id}")
	@ApiOperation(value = "Updating the User", notes = "Enter the values to update the user", response = Mentor.class)
	public ResponseEntity<String> updateUser(@ApiParam(value = "Enter your Details", required = true)@PathVariable(value = "id") int mentorId,
			@RequestBody MentorDetails mentorDetails) throws Exception {
		Mentor mentor = mentorService.findById(mentorId);
		if (mentor==null) {
			return new ResponseEntity<String>("User not found :(", HttpStatus.NOT_FOUND);
		}
	
		mentor.setExperience(mentorDetails.getExperience());
		mentor.setCourseTeached(mentorDetails.getCourseTeached());
		List<MentorSkills> a = new ArrayList<>();
		a=skillRepo.findAll();
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
		mentor.setMentorSkills(b);
		System.out.println(b);
		mentorRepo.save(mentor);
		return new ResponseEntity<String>("Updated Successfully!!", HttpStatus.OK);
	}
	

}
