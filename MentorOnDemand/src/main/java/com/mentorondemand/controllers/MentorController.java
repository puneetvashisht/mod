package com.mentorondemand.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.entities.Mentor;
import com.mentorondemand.entities.MentorDetails;
import com.mentorondemand.repos.MentorRepo;
import com.mentorondemand.service.MentorService;

@RestController
public class MentorController {
	
	@Autowired
	MentorRepo mentorRepo;
	
	@Autowired
	MentorService mentorService;
	
	@PostMapping("/mentor")
	public ResponseEntity<String> add(@RequestBody MentorDetails mentordetails) {
		mentorService.register(mentordetails);
		System.out.println(mentordetails);
		return new ResponseEntity<String>("user successfully created",HttpStatus.CREATED);
	}
	
	@GetMapping("/mentors")
	public List<Mentor> getAllUser() {
		return mentorService.findAll();	
	}
	
	@GetMapping("/mentor/{id}")
	public ResponseEntity<Mentor> getUserById(@PathVariable("id") int id)  {
		ResponseEntity<Mentor>  re ;
		System.out.println("Recieved id on path: "+ id);
		// code here to fetch user by id
		Optional<Mentor> mentor = mentorService.findById(id);
		if(mentor.isPresent()) {
			Mentor mentorFound = mentor.get();
			re = new ResponseEntity<>(mentorFound, HttpStatus.OK);
		}
		else {
			re = new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	@DeleteMapping("/mentors/{id}")
	public ResponseEntity<Mentor> deleteUserById(@PathVariable("id") int id) {
		ResponseEntity<Mentor>  re ;
		System.out.println("Recieved id on path: "+ id);
		// code here to fetch user by id
		Optional<Mentor> Mentor = mentorService.findById(id);
		if(Mentor.isPresent()) {
			Mentor Mentordeleted= Mentor.get();
			mentorService.deleteById(id);
			re = new ResponseEntity<>(Mentordeleted, HttpStatus.OK);
		}
		else {
			re = new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
}
