package com.example.demo.entity;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long appointId ;

	@Column(nullable = false, length = 50)
	private Date appointDate;
	
	@Column(nullable = false, length = 50)
	private String patientemail ;
	
	@Column(nullable = false, length = 50)
	private String doctoremail ;

	@Column(nullable = false)
	private int timeslot;

	@Column(nullable = false)
	private int status;

	@Column(nullable = false, length = 50)
	private String doctorSpecialization ;
	
	@ManyToOne
    private Patient patient;
	
	@ManyToOne
    private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public long getAppointId() {
		return appointId;
	}
	public void setAppointId(long appointId) {
		this.appointId = appointId;
	}
		
		public String getPatientemail() {
		return patientemail;
	}
	public void setPatientemail(String patientemail) {
		this.patientemail = patientemail;
	}
	
	public Patient getPatient() {
		return patient;
	}
		public void setPatient(Patient patient) {
			this.patient =patient;
		}
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	public int getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
	}
	
	public Date getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	
	public String getDoctoremail() {
		return doctoremail;
	}
	public void setDoctoremail(String doctoremail) {
		this.doctoremail = doctoremail;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Appointment [appointId=" + appointId + ", appointDate=" + appointDate 
				+ ", doctorId=" + doctoremail + ", status=" + status + "]";
	}
}
