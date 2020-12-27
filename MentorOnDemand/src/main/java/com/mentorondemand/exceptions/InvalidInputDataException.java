package com.mentorondemand.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidInputDataException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidInputDataException(String message) {
		super(message);
	}

}
