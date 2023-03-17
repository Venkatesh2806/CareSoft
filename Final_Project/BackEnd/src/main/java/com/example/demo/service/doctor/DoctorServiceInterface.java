package com.example.demo.service.doctor;

import java.util.List;

import com.example.demo.entity.Doctor;



public interface DoctorServiceInterface {

	public Doctor addDoctor(Doctor r);
	
	Doctor save(Doctor newUser);

	boolean findByEmail(String string);

	
	public List<Doctor> findDoctorBySpecial(String special);
	
	Doctor authenticateDoctor(String email, String password);

	public Doctor authenticateDoctorPassword(Doctor d);

	public Doctor findDoctor(String email);
	
	int deletedoctor(long id);
	
	List<Doctor> showAllDoctor(int verified);
	
	Doctor Doctorupdatedetails(Doctor d);
	
	int Doctorverification(long id);
	
	long deletedoctorverification(long id);
	
	List<Doctor> ShowVerificationlistbyemail(String email);
	
}
