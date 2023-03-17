package com.example.demo.service.patient;

import java.util.List;

import com.example.demo.entity.Patient;



public interface PatientServiceInterface {

	Patient addPatient(Patient p);

	Patient save(Patient newUser);

	boolean findByEmail(String string);

	Patient authenticatePatient(String email, String password);
	
	Patient authenticatePassword(Patient p);
	
	List<Patient> showAllPatient();
	
	long deletepatient(long id);
	
	Patient findpatient (String email);
	
	Patient findpatientbyid (long id);
	
	Patient patientupdatedetails(Patient p);

}
