package com.sunbeam.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dto.ApiResponse;

@RestControllerAdvice // @RestControllerAdvice -> global exc handler class, common interceptor to
//intercept all exceptions + response body added in impl on ret types of all req handling methods
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ApiResponse handleResourceNotFoundException(ResourceNotFoundException e) {
		System.out.println("in res not found " + e);
		return new ApiResponse(e.getMessage());
	}
}
