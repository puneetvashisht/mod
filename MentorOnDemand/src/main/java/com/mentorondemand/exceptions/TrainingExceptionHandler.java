package com.mentorondemand.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class TrainingExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public ResponseEntity<?> handleNotFoundException(Exception e) {
		TrainingException t=new TrainingException(e.getLocalizedMessage());
		
		return new ResponseEntity(t,HttpStatus.NOT_FOUND);
		
		
	}
}
