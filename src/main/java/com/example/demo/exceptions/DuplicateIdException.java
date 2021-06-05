package com.example.demo.exceptions;

public class DuplicateIdException extends Exception{// checked
	private final String msg;
	
	public DuplicateIdException(String msg) {
		this.msg=msg;
	}
	@Override
	public String getMessage() {
        return this.msg;
    }

	
}
