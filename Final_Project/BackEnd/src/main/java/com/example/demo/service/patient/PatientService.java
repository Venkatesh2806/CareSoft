package com.example.demo.service.patient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.JavaBase64;
import com.example.demo.dao.PatientDaoInterface;
import com.example.demo.entity.Patient;



@Service
public class PatientService implements PatientServiceInterface {

	
	@Autowired
	private PatientDaoInterface patientDaoInterface;

	 @Autowired
	    private JavaBase64 crypt; 
	
	@Override
	public Patient addPatient(Patient p) {
		// TODO Auto-generated method stub
		
		Patient patient = null;
			try
			{
				patient=patientDaoInterface.save(p);
				return patient;
			}
			catch(Exception e){ 
				System.out.println(e.getMessage());
			}
		return patient;
	}
	

	@Override
	public Patient save(Patient newUser) {
		
		return patientDaoInterface.save(newUser);
	}

	@Override
	public boolean findByEmail(String email) {
	
			Patient p=patientDaoInterface.findByEmailAndIsVerified(email,true);
			if(p!=null)
				return true;
			
		return false;
	}

	@Override
	public Patient authenticatePatient(String email, String password) {
		// TODO Auto-generated method stub
		
		return patientDaoInterface.findByEmailAndPasswordAndIsVerified(email, password,true);
	}

	@Override
	public Patient authenticatePassword(Patient p) {
		// TODO Auto-generated method stub
		String encodedPass = crypt.encodePassword(p.getPassword());
		Patient p1= patientDaoInterface.findByEmailAndContactAndIsVerified(p.getEmail().toLowerCase(),p.getContact(),true);
		if(p1!=null) {
			p1.setPassword(encodedPass);
			patientDaoInterface.save(p1);	
		return p1;
		}
		return null;
	}

	@Override
	public List<Patient> showAllPatient() {
		
		return patientDaoInterface.findAllByIsVerified(true);
		
	}
	
	@Override
	public Patient findpatient(String email) {
		
		//List<Patient> list= Arrays.asList(patientDaoInterface.findByEmail(email));
		
		return patientDaoInterface.findByEmailAndIsVerified(email,true);
		
	}
	

	@Override
	public Patient findpatientbyid (long id) {
		
		//List<Patient> list= Arrays.asList(patientDaoInterface.findByEmail(email));
		
		return patientDaoInterface.findById(id);
		
	}
	
	@Override
	public Patient patientupdatedetails (Patient p) {
	
       Patient p1= findpatientbyid(p.getId());
		
       System.out.println(p1.getEmail());
       
		if(p1.getEmail().equalsIgnoreCase(p.getEmail().toLowerCase())){
			
		            patientDaoInterface.save(p);
		  return p;
		  
		}else if((patientDaoInterface.findByEmailAndIsVerified(p.getEmail(),true)) != null) {
			return null;
			
		}else {	
			  patientDaoInterface.save(p);
			  return p;
		}
		
	}
	
	@Override
	public long deletepatient(long id) {
		try {
			patientDaoInterface.deleteById(id);
		 return id;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
}