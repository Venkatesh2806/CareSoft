package com.example.demo.service.doctor;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.JavaBase64;
import com.example.demo.dao.DoctorDaoInterface;
import com.example.demo.entity.Doctor;



@Service
public class DoctorService implements DoctorServiceInterface {
	
	
	@Autowired
	private DoctorDaoInterface doctorDaoInterface;
	
	@Autowired
    private JavaBase64 crypt; 



	@Override
	public Doctor addDoctor(Doctor r) {
		// TODO Auto-generated method stub
		Doctor d=null;
		try {
		 d=doctorDaoInterface.save(r);
		
		return d;
		}catch(Exception e){ 
			System.out.println(e.getMessage());
		}
	return d;
		
	}



	@Override
	public Doctor save(Doctor newUser) {
		return doctorDaoInterface.save(newUser);
		
	}



	@Override
	public boolean findByEmail(String email) {
		
		Doctor p=doctorDaoInterface.findByEmailAndIsVerified(email,1);
		if(p!=null)
			return true;
		
	return false;
		
	}
	
	@Override
	public List<Doctor> findDoctorBySpecial(String special) {
		// TODO Auto-generated method stub
		return doctorDaoInterface.findAllByDoctorSpecializationAndIsVerified(special,1);
	}
	
	@Override
	public Doctor authenticateDoctor(String email, String password) {
		// TODO Auto-generated method stub
		Doctor d=doctorDaoInterface.findByEmailAndPasswordAndIsVerified(email, password,1);
		System.out.println(d);
		return d;
	}
	
	@Override
	public Doctor authenticateDoctorPassword(Doctor d) {
		// TODO Auto-generated method stub
		String encodedPass = crypt.encodePassword(d.getPassword());
		Doctor d1= doctorDaoInterface.findByEmailAndDoctorContactAndIsVerified(d.getEmail().toLowerCase(),d.getDoctor_contact(),1);
		if(d1!=null) {
			d1.setPassword(encodedPass);
			doctorDaoInterface.save(d1);	
		return d1;
		}
		return null;
	}

	@Override
	public Doctor findDoctor(String email) {
		return doctorDaoInterface.findByEmailAndIsVerified(email,1);
	}
	
	@Override
	public List<Doctor> showAllDoctor(int verified) {
		
		return doctorDaoInterface.findAllByIsVerified(verified);
		
	}
	
	@Override
	public List<Doctor> ShowVerificationlistbyemail(String email){
		
		 List<Doctor> list= Arrays.asList(doctorDaoInterface.findByEmailAndIsVerified(email,1));
		 
		 return list;
	}
	
	@Override
	public int deletedoctor(long id) {
		try {
		 return doctorDaoInterface.deletedoctor(id);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
		}
		 
	}
	
	@Override
	public Doctor Doctorupdatedetails (Doctor d) {
	
       Doctor p1= findDoctor(d.getEmail());
		
       System.out.println(p1.getEmail());
       
		if(p1.getEmail().equalsIgnoreCase(d.getEmail().toLowerCase())){
			
			doctorDaoInterface.save(d);
		  return d;
		  
		}else if((doctorDaoInterface.findByEmailAndIsVerified(d.getEmail(),1)) != null) {
			return null;
			
		}else {	
			doctorDaoInterface.save(d);
			  return d;
		}
		
	}
	
	@Override
	public int Doctorverification(long id) {
		try {
			
			return doctorDaoInterface.doctorverified(id);
			
		 
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
		}
		 
	}
	
	@Override
	public long deletedoctorverification(long id) {
		try {
			doctorDaoInterface.deleteById(id);
		  return id;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return -1;
		}
		 
	}

}
