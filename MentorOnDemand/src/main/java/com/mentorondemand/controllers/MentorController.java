package com.mentorondemand.controllers;

import java.util.List;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	private static Logger logger = LogManager.getLogger(MentorController.class);

	@PostMapping("/mentor")
	@ApiOperation(value = "Registering mentor", notes = "Enter your mentor id ")
	public ResponseEntity<String> add(@RequestBody MentorDetails mentorDetails)
			throws AlreadyExistsException, InvalidInputDataException {
		boolean flag = mentorService.register(mentorDetails);
		ResponseEntity<String> re = null;
		if (flag) {
			re = new ResponseEntity<String>("mentor successfully created", HttpStatus.CREATED);
		} else {
			re = new ResponseEntity<String>("mentor already exists", HttpStatus.CONFLICT);
		}
		logger.info(mentorDetails);
		return re;
	}

	@GetMapping("/mentors")
	@ApiOperation(value = "displaying all the mentor details", notes = "enter path to display", response = Mentor.class)
	public List<Mentor> getAllMentor() {
		return mentorService.findAll();
	}

	@GetMapping("/mentor/email")
	@ApiOperation(value = "Get details by email", notes = "Enter the email", response = Mentor.class)
	public ResponseEntity<Mentor> getByEmail(@RequestParam("email") String email) throws NotFoundException {
		ResponseEntity<Mentor> re = null;
		Mentor mentor = mentorService.findMentorByEmail(email);
		if (mentor != null) {
			re = new ResponseEntity<>(mentor, HttpStatus.OK);
		}
		return re;
	}

	@GetMapping("/mentor/{id}")
	public ResponseEntity<Mentor> getMentorById(@PathVariable("id") int id) throws NotFoundException {
		ResponseEntity<Mentor> re;
		logger.info("Recieved id on path: " + id);
		Mentor mentor = mentorService.findById(id);
		if (mentor != null) {

			re = new ResponseEntity<>(mentor, HttpStatus.OK);
		} else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}

	@DeleteMapping("/mentors/{id}")
	@ApiOperation(value = "Delete by Id", notes = "Enter the Mentor id", response = Mentor.class)
	public ResponseEntity<Mentor> deleteMentors(@PathVariable("id") int id) throws NotFoundException {
		ResponseEntity<Mentor> re;
		logger.info("Recieved id on path: " + id);
		Mentor mentor = mentorService.findById(id);
		if (mentor != null) {
			mentorService.deleteMentorid(id);
			re = new ResponseEntity<>(mentor, HttpStatus.OK);
		} else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}

	@PutMapping("/mentors/{id}")
	@ApiOperation(value = "Updating the Mentor", notes = "Enter the values to update the mentor", response = Mentor.class)
	public ResponseEntity<String> updateMentor(
			@ApiParam(value = "Enter your Details", required = true) @PathVariable(value = "id") int mentorId,
			@RequestBody MentorDetails mentorDetails) throws Exception {
		ResponseEntity<String> re = null;
		Mentor mentor = mentorService.updateMentorDetails(mentorId, mentorDetails);
		if (mentor != null)
			re = new ResponseEntity<String>("Updated Successfully!!", HttpStatus.OK);
		return re;
	}

}
