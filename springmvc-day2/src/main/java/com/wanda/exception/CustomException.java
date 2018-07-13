package com.wanda.exception;

import org.springframework.web.servlet.ModelAndView;

public class CustomException extends Exception{
	private String message;
	public String getMessage() {
		return this.message;
	}

	public CustomException(String message) {
		this.message=message;
	}
}
