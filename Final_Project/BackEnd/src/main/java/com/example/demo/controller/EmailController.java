package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.EmailDetails;
import com.example.demo.service.email.EmailService;


@RestController
@RequestMapping("/Email")
@CrossOrigin
public class EmailController {
	
	 @Autowired 
	 private EmailService emailService;

	    @PostMapping("/sendMail")
	    public String
	    sendMail(@RequestBody EmailDetails details)
	    {
	    	System.out.println(details.toString());
	    	System.out.println(details.getRecipient());
	        String status = emailService.sendSimpleMail(details);
	 
	        return status;
	    }
}
