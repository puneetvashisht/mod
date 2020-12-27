package com.mentorondemand.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class TrainingException extends RuntimeException {
	
	String message;

	public TrainingException() {
		super();
	}

	public TrainingException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TrainingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TrainingException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
