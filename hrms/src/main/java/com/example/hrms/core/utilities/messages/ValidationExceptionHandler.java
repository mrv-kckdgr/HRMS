package com.example.hrms.core.utilities.messages;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;

@ControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationErrorHandling(MethodArgumentNotValidException exception) {
		ValidationError error = new ValidationError(exception.getBindingResult().getFieldError().getDefaultMessage(), false);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
