package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class HospitalNotFoundException extends Exception {

	public HospitalNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
