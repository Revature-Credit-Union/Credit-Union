package com.revature.RCUbackend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.revature.RCUbackend.services.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class EmailController {

	@Autowired
	public EmailService email = new EmailService();
	
	@GetMapping("/forgotPass")
	public  void resetPass(int id)
	{
		//email.resetPass(id);
	}
	@GetMapping("/Alert")
	public void alert(@RequestParam("id")int id)
	{
	//	email.alert(id);
	}
	
}
