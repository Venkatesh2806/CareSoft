package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Admin;
import com.example.demo.service.admin.AdminServiceInterface;

@RestController
@RequestMapping("/Admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminServiceInterface adminServiceInterface;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateAdmin(@RequestBody Admin r) {
		System.out.println(r);
		
		return new ResponseEntity<>(
				adminServiceInterface.authenticateAdmin(r.getEmail(),r.getContact(),r.getPassword()), HttpStatus.OK);
	}
}
