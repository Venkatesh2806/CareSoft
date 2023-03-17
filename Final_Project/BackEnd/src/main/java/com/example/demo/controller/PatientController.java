package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.config.JavaBase64;
import com.example.demo.entity.Patient;
import com.example.demo.service.patient.PatientServiceInterface;
import java.rmi.ServerException;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/Patient")
@CrossOrigin
public class PatientController {
 
    @Autowired
    private PatientServiceInterface patientServiceInterface;
    @Autowired
    private JavaBase64 crypt; 
    
 
 @PostMapping("/register1")
 public Patient showRegistrationForm(@RequestBody Patient m) {
    
	 String encoded = crypt.encodePassword(m.getPassword());
	 System.out.println(m.getContact());
	m.setPassword(encoded);
	m.setEmail(m.getEmail().toLowerCase());
 	Patient p=null;    	
 	if(!patientServiceInterface.findByEmail((m.getEmail())))
      {
 		p=patientServiceInterface.addPatient(m);
               }  
 	 System.out.println(p);
          return p;           
 }
 
 @PostMapping("/signin") 
	public ResponseEntity<?> Patientlogin(@RequestBody Patient p) {
	
	 System.out.println(p.getEmail());
	 System.out.println(p.getPassword());
 	String encodedpass = crypt.encodePassword(p.getPassword());// Encoded form of original password
  	
		return new ResponseEntity<>(
				patientServiceInterface.authenticatePatient(p.getEmail().toLowerCase(), encodedpass), HttpStatus.OK);
	}
 
 @PatchMapping("/forgotpassword") 
	public ResponseEntity<?> forgotPasswordPatient(@RequestBody Patient p) {
	
	 System.out.println(p.getEmail());
	 System.out.println(p.getContact());
		return new ResponseEntity<>(
				patientServiceInterface.authenticatePassword(p), HttpStatus.CREATED);
	}
 
 @GetMapping("/patientlist")
 public List<Patient> patientlist() {	

		return patientServiceInterface.showAllPatient();
 }
 
 @GetMapping("/findpatientbyemail/{email}")
	public List<Patient> findPatientbyemail(@PathVariable String email)
	{	
	 System.out.println(email);	 
	 List<Patient> list= Arrays.asList(patientServiceInterface.findpatient(email));
		return list;
	}
 
 @GetMapping("/findpatientbyid/{id}")
	public Patient findpatientbyid(@PathVariable long id)
	{	
	 System.out.println(id);	 
		return patientServiceInterface.findpatientbyid(id);
	}
    
 @PutMapping("/Update")
 public ResponseEntity<Patient> patientupdate(@RequestBody Patient p) throws ServerException {
	     System.out.println(p.getEmail());
		 System.out.println(p.getContact());
	         
 	return  new ResponseEntity<>( patientServiceInterface.patientupdatedetails(p), HttpStatus.CREATED);
 }
    
 @DeleteMapping("/delete/{id}")
 public long deletepatient(@PathVariable long id)throws ServerException {
     	
     	return patientServiceInterface.deletepatient(id);
 }
   }
