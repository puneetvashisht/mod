package com.mentorondemand.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.entities.TrainingActiveUser;
import com.mentorondemand.entities.TrainingDetails;
import com.mentorondemand.exceptions.NotFoundException;
import com.mentorondemand.service.TrainingActiveUserService;


@RestController
@RequestMapping("/api/training")
public class TrainingController {
	
	@Autowired
	TrainingActiveUserService service;
	
	@PostMapping("/assign")
	public ResponseEntity<String> assignTrainer(@RequestBody TrainingDetails trainingDetails) throws NotFoundException {
		
		TrainingActiveUser t=new TrainingActiveUser(trainingDetails.getTrainingName(),null,trainingDetails.getSkillTitle(),null,0,0);
		
		String s=service.assignTrainer(t, trainingDetails.getMentorId(), trainingDetails.getUserId());
		ResponseEntity<String> re=null;
		if(s.equals("Mentor")) {
			re=new ResponseEntity<>("Mentor id not found",HttpStatus.NOT_FOUND);
		}
		else if(s.equals("User")) {
			re=new ResponseEntity<>("User id not found",HttpStatus.NOT_FOUND);
		}
		else if(s.equals("success")) {
			re=new ResponseEntity<>("successfully registered",HttpStatus.CREATED);
		}
		return re;
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> getHello() {
		System.out.println("hello");
		ResponseEntity<String> re=new ResponseEntity<>("started training",HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/startTraining/{id}")
	public ResponseEntity<String> startTraining(@PathVariable("id") int id){
		
		boolean b=service.startTraining(id);
		ResponseEntity<String> re;
		if(b)
			re=new ResponseEntity<>("started training",HttpStatus.OK);
		else {
			System.out.println("not found");
			re=new ResponseEntity<>("training id not found",HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	@PutMapping("/endTraining/{id}")
	public ResponseEntity<String> endTraining(@PathVariable("id") int id){
		
		boolean b=service.endTraining(id);
		ResponseEntity re;
		if(b)
			re=new ResponseEntity<>("ended training",HttpStatus.OK);
		else
			re=new ResponseEntity<>("training id not found",HttpStatus.NOT_FOUND);
		return re;
	}
	
	@GetMapping("/previousTraining/{id}")
	public ResponseEntity<List<TrainingActiveUser>> findPreviousTraining(@PathVariable("id")int id){
		
		List<TrainingActiveUser> l=service.findPreviousTraining(id);
		
		ResponseEntity<List<TrainingActiveUser>> re=new ResponseEntity(l,HttpStatus.OK);
		return re;
		
	}
	
	@PutMapping("/updateProgress")
	public ResponseEntity<Integer> updateProgress(@RequestParam("userId") String userId,@RequestParam("trainingName") String trainingName,@RequestParam("progress")int progress){
		
		int p=service.updateProgress(progress, new Integer(userId), trainingName);
		
		ResponseEntity<Integer> re=new ResponseEntity(p,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/addRating")
	public ResponseEntity<String> addRating(@RequestParam("trainingName") String trainingName,@RequestParam("userId") String userId,@RequestParam("rating")int rating){
		
		boolean b=service.addRating(trainingName, new Integer(userId), rating);
		ResponseEntity<String> re;
		if(b)
			re=new ResponseEntity<>("added rating",HttpStatus.OK);
		else
			re=new ResponseEntity<>("not added rating",HttpStatus.NOT_FOUND);
		return re;
	}
	@GetMapping("/findProgress")
	public ResponseEntity<Integer> findProgress(@RequestParam("trainingName")String trainingName,@RequestParam("userId")String userId){
		int progress=service.findProgress(trainingName, new Integer(userId));
		ResponseEntity<Integer> re=new ResponseEntity<>(progress,HttpStatus.OK);
		return re;
	}
}
