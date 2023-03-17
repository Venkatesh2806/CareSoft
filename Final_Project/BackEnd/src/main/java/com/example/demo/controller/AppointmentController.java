package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.service.appointment.AppointmentServiceInterface;
import com.example.demo.service.doctor.DoctorServiceInterface;
import com.example.demo.service.patient.PatientServiceInterface;


@RestController
@RequestMapping("/Appointment")
@CrossOrigin
public class AppointmentController {

	@Autowired
	private AppointmentServiceInterface appointmentService;
	
	@Autowired
    private PatientServiceInterface patientServiceInterface;
	
	@Autowired
	private DoctorServiceInterface doctorServiceInterface;
	 
	   @PostMapping("/bookApp")
	    public Appointment showRegistrationForm(@RequestBody Appointment a) {   
		   System.out.println(a+"Line no 31");
                 System.out.println(a.getTimeslot()+"Line no 31");
                 
                 Patient p= patientServiceInterface.findpatient(a.getPatientemail());
                 a.setPatient(p);
                 Doctor d=doctorServiceInterface.findDoctor(a.getDoctoremail());
                 a.setDoctor(d);
                 
                 return  appointmentService.addAppointment(a);                   	
	    }

		@DeleteMapping("/delAppointment/{id}")
		public void delAppointment (@PathVariable("id") int id) {
			appointmentService.delAppointment(id);	             	 
	    }
  
	   @GetMapping("/showdateandtimeslot/{appointDate}/{id}")
	    List<Appointment> findtimeslot(@PathVariable Date appointDate,@PathVariable long id ) {
	        return appointmentService.findbydateandId(appointDate,id);
	    }
	   
	   @GetMapping("/PatientHistory/{email}")
	    public List<Appointment> getPatHistory(@PathVariable String email ) {
		 
	        return appointmentService.getPatHistory(email);
	    }
	   
	   @GetMapping("/Appointmenthistory")
	    public List<Appointment> Appointmenthistory() {
		 
	        return appointmentService.showAllAppointment();
	    }
	   
	   @GetMapping("/Doctorappointmentlist/{email}")
	    public List<Appointment> doctorappointmentlist(@PathVariable String email ) {
		 
	        return appointmentService.doctorappointmentlist(email);
	    }
	   
	   @GetMapping("/appointmentlistbydoctoremail/{email}")
	    public List<Appointment> appointmentlistbydoctoremail(@PathVariable String email ) {
		 
		   System.out.println("hiii doctor");
		   System.out.println("hiii doctor"+email);
	        return appointmentService.appointmentlistbydoctoremail(email);
	    }
	   
	   @GetMapping("/DoctorHistory/{email}")
	    public List<Appointment> getDocHistory(@PathVariable String email ) {
		 
	        return appointmentService.getDocHistory(email);
	    }
	   
	   @PatchMapping("/Appointmentstatus/{id}/{status}")
	    public int Appointmentstatus(@PathVariable long id,@PathVariable int status) {
		 
	        return appointmentService.Changeappointmnetstatus(id,status);
	    }
}
