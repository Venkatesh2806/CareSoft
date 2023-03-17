package com.example.demo.service.appointment;

import java.sql.Date;
import java.util.List;

import com.example.demo.entity.Appointment;


public interface AppointmentServiceInterface {


	Appointment addAppointment(Appointment a);

	void delAppointment(long id);
	
	List<Appointment> findbydateandId(Date appointDate,long id);
	
	List<Appointment> getPatHistory(String email);
	
	List<Appointment> showAllAppointment();
	
	List<Appointment> getDocHistory(String email);
	
	List<Appointment> doctorappointmentlist(String email);
	
	List<Appointment> appointmentlistbydoctoremail(String email);

    int Changeappointmnetstatus(long id,int status);
}
