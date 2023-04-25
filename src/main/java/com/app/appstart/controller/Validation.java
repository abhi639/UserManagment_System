package com.app.appstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.appstart.service.Userservice;



@RestController
public class Validation {

	@Autowired
	private Userservice userservice;
	@GetMapping("/useremailvalid/{email}")
    public String emailvali(@PathVariable String email) {
  String emailval= userservice.validateuser(email);
//	String data=String.valueOf(emailval);
	System.out.println(emailval);
		
		return emailval;
    }

	@GetMapping("/useremailvalidmobile/{mobile_number}")
    public String mobilevali(@PathVariable String mobile_number) {
  String emailval= userservice.validateusermobile(mobile_number);
//	String data=String.valueOf(emailval);
	//System.out.println(emailval);
		
		return emailval;
    }
	@GetMapping()
	public String emailcheck() {
		
		
		return""		;
	}
	
	
	
}
