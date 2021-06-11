package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.beans.ResponseMessage;
import com.example.demo.exceptions.DuplicateIdException;
import com.example.demo.exceptions.IdNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {		

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> handleException(HttpServletRequest request, Exception ex){
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(500);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	@ExceptionHandler(DuplicateIdException.class)
	public ResponseEntity<ResponseMessage> handleDuplicateIDException(HttpServletRequest request, Exception ex) {
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(500);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseMessage> handleIdNotFoundException(HttpServletRequest request, Exception ex) {
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(500);
		return new ResponseEntity<ResponseMessage>(rm, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}	
