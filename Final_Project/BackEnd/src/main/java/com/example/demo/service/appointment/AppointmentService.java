package com.example.demo.service.appointment;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AppointmentDAOInterface;
import com.example.demo.entity.Appointment;




@Service
public class AppointmentService implements AppointmentServiceInterface{

	@Autowired
	AppointmentDAOInterface appointmentRepository ;
	

	@Override
	public void delAppointment (long id) {

			 appointmentRepository.deleteById(id);	 
	}
	 

	 @Override
	public Appointment addAppointment(Appointment a) {
		 
		 if(a.getTimeslot()==0) {
			 
			 return null;
		 }
		 else {
			 return appointmentRepository.save(a);	 } 
	}



	@Override
	public List<Appointment> findbydateandId(Date appointDate,long id) {
		
		return appointmentRepository.findByAppointDateAndDoctorId(appointDate,id);
	}
	 
	@Override
	public List<Appointment> getPatHistory(String email) {
		
		return appointmentRepository.findAllByPatientemail(email);
	}
	
	@Override
	public List<Appointment> showAllAppointment(){
		
		return appointmentRepository.findAll();
		
	}
	
	@Override
	public List<Appointment> getDocHistory(String email) {
		
		return appointmentRepository.findAllByDoctorAppointmentHistory(email);
	}
	
	@Override
	public List<Appointment> doctorappointmentlist(String email) {
		
		return appointmentRepository.findAllByDoctoremailAndStatus(email,2);
	}
	
	@Override
	public List<Appointment> appointmentlistbydoctoremail(String email) {
		
		return appointmentRepository.findAllByDoctoremail(email);
	}
	
	@Override
	public int Changeappointmnetstatus(long id,int status) {
		
		return appointmentRepository.Appointmentstatus(id,status);
	}
	
}