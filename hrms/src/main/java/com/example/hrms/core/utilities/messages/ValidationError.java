package com.example.hrms.core.utilities.messages;

public class ValidationError {
	private String message;
	private boolean success;
	
	public ValidationError(String message, boolean success) {
		super();
		this.message=message;
		this.success=success;
	}
}
