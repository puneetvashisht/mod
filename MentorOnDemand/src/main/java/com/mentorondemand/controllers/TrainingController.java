package com.mentorondemand.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.mentorondemand.service.TraningActiveUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class TrainingController {

	@Autowired
	TraningActiveUserService service;

	private static Logger logger = LogManager.getLogger(TrainingController.class);

	@PostMapping("/training")
	@ApiOperation(value = "create training", notes = "Enter the training details", response = String.class)
	public ResponseEntity<String> assignTrainer(@RequestBody TrainingDetails trainingDetails) throws NotFoundException {

		TrainingActiveUser t = new TrainingActiveUser(trainingDetails.getTrainingName(), null,
				trainingDetails.getSkillTitle(), null, 0, 0);

		String s = service.assignTrainer(t, trainingDetails.getMentorId(), trainingDetails.getUserId());
		ResponseEntity<String> re = null;
		if (s.equals("success")) {
			re = new ResponseEntity<>("successfully registered", HttpStatus.CREATED);
		}

		return re;
	}

	@PutMapping("/training/startTraining/{id}")
	@ApiOperation(value = "start training by id", notes = "Enter the training id", response = String.class)
	public ResponseEntity<String> startTraining(@PathVariable("id") int id) throws NotFoundException {

		boolean b = service.startTraining(id);
		ResponseEntity<String> re = null;
		if (b) {
			re = new ResponseEntity<>("started training", HttpStatus.OK);
		}
		return re;
	}

	@PutMapping("/training/endTraining/{id}")
	@ApiOperation(value = "end training by id", notes = "Enter the training id", response = String.class)
	public ResponseEntity<String> endTraining(@PathVariable("id") int id) throws NotFoundException {

		boolean b = service.endTraining(id);
		ResponseEntity<String> re = null;
		if (b)
			re = new ResponseEntity<>("ended training", HttpStatus.OK);

		return re;
	}

	@GetMapping("/training/previousTraining/{id}")
	@ApiOperation(value = "find previous training by id", notes = "Enter the mentor id", response = TrainingActiveUser.class)
	public ResponseEntity<List<TrainingActiveUser>> findPreviousTraining(@PathVariable("id") int id)
			throws NotFoundException {

		List<TrainingActiveUser> l = service.findPreviousTraining(id);
		logger.info(l);
		ResponseEntity<List<TrainingActiveUser>> re = new ResponseEntity<>(l, HttpStatus.OK);

		return re;

	}

	@PutMapping("/training/progress")
	@ApiOperation(value = "update progress of training", notes = "Enter the userid,traningname andprogress", response = TrainingActiveUser.class)
	public ResponseEntity<TrainingActiveUser> updateProgress(@RequestParam("userId") String userId,
			@RequestParam("trainingName") String trainingName, @RequestParam("progress") int progress)
			throws NotFoundException {

		TrainingActiveUser t = service.updateProgress(progress, new Integer(userId), trainingName);
		logger.info(t);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}

	@PutMapping("/training/rating")
	@ApiOperation(value = "add rating of training", notes = "Enter the trainingname,userid and rating", response = String.class)
	public ResponseEntity<String> addRating(@RequestParam("trainingName") String trainingName,
			@RequestParam("userId") String userId, @RequestParam("rating") int rating) throws NotFoundException {

		boolean b = service.addRating(trainingName, new Integer(userId), rating);
		ResponseEntity<String> re = null;
		if (b)
			re = new ResponseEntity<>("added rating", HttpStatus.OK);
		return re;
	}

	@GetMapping("/training/progress")
	public ResponseEntity<Integer> findProgress(@RequestParam("trainingName") String trainingName,
			@RequestParam("userId") String userId) throws NotFoundException {
		int progress = service.findProgress(trainingName, new Integer(userId));
		return new ResponseEntity<>(progress, HttpStatus.OK);
		
	}
}