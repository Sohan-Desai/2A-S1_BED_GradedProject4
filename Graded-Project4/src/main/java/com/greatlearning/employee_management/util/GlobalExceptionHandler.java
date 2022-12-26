package com.greatlearning.employee_management.util;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(NOT_FOUND)
	public Error handleInvalidOrderId(IllegalArgumentException exception) {
		return new Error(100, exception.getMessage());
	}
}

@Getter
@AllArgsConstructor
class Error {
	private int id;
	private String message;
}