package com.example.demo.controller;

import java.rmi.ServerException;
import java.util.Arrays;
import java.util.List;
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
import com.example.demo.entity.Doctor;
import com.example.demo.service.doctor.DoctorServiceInterface;



@RestController
@RequestMapping("/Doctor")
@CrossOrigin
public class DoctorController {
	
	@Autowired
	private DoctorServiceInterface doctorServiceInterface;
	
	 @Autowired
	    private JavaBase64 crypt;
	
	@PostMapping("/Doctor_Registration")
	public Doctor addResource(@RequestBody Doctor r)
	{	
		 String encoded = crypt.encodePassword(r.getPassword());
		 r.setPassword(encoded);
		 r.setEmail(r.getEmail().toLowerCase());
		 Doctor d= null;
		 if(!doctorServiceInterface.findByEmail((r.getEmail())))
		 {
	 		d= doctorServiceInterface.addDoctor(r);
		}  
				 
				System.out.println(d);
		 return d;  				
	}
	
	  @GetMapping("/findDoctorSpecial/{Special}")
			public List<Doctor> findDoctorBySpecial(@PathVariable String Special)
			{	
		  System.out.println(Special);
				return doctorServiceInterface.findDoctorBySpecial(Special);
			}
		    
	  @PostMapping("/signin")
		public ResponseEntity<?> authenticateDoctor(@RequestBody Doctor r) {
			System.out.println(r);
			 String encoded = crypt.encodePassword(r.getPassword());
			return new ResponseEntity<>(
					doctorServiceInterface.authenticateDoctor(r.getEmail().toLowerCase(),encoded), HttpStatus.OK);
		}
	  
	  @PatchMapping("/Doctorforgotpassword") 
		public ResponseEntity<?> forgotPasswordPatient(@RequestBody Doctor d) {
		
		 System.out.println(d.getEmail());
		 System.out.println(d.getDoctor_contact());
			return new ResponseEntity<>(
					doctorServiceInterface.authenticateDoctorPassword(d), HttpStatus.CREATED);
		}
	  
	  @GetMapping("/findDoctor/{email}")
		public Doctor finddoctoremail(@PathVariable String email)
		{	
			return doctorServiceInterface.findDoctor(email);
		}
	  
	  @GetMapping("/finddoctorbyemail/{email}")
		public List<Doctor> findDoctorbyemail(@PathVariable String email)
		{	
		 System.out.println(email);	 
		 List<Doctor> list= Arrays.asList(doctorServiceInterface.findDoctor(email));
			return list;
		}

	  @GetMapping("/doctorlist")
	  public List<Doctor> doctorlist() {	

	 		return doctorServiceInterface.showAllDoctor(1);
	  }
	  
	  @GetMapping("/doctorverificationlist")
	  public List<Doctor> doctorverificationlist() {	

	 		return doctorServiceInterface.showAllDoctor(0);
	  }
	  
	  @GetMapping("/doctorverificationlistbyemail/{email}")
	  public List<Doctor> doctorverificationlistbyemail(@PathVariable String email) {	

	 		return doctorServiceInterface.ShowVerificationlistbyemail(email);
	  }
	  
	  @PutMapping("/Update")
	  public ResponseEntity<Doctor> doctorupdate(@RequestBody Doctor d) throws ServerException {
	 	     System.out.println(d.getEmail());
	 	         
	  	return  new ResponseEntity<>( doctorServiceInterface.Doctorupdatedetails(d), HttpStatus.CREATED);
	  }
	  
	  @PatchMapping("/doctorverification/{id}")
	  public int doctorverification(@PathVariable long id) throws ServerException {
	 	
		  return doctorServiceInterface.Doctorverification(id);
	  }
	  
	  @DeleteMapping("/delete/{id}")
	  public int deletedoctor(@PathVariable long id)throws ServerException {
	      	
	      	return doctorServiceInterface.deletedoctor(id);
	  }
	  
	 @DeleteMapping("/deletedoctorverification/{id}")
	  public long deletedoctorvarification(@PathVariable long id)throws ServerException {
	      	
	      	return doctorServiceInterface.deletedoctorverification(id);
	  }	
}
