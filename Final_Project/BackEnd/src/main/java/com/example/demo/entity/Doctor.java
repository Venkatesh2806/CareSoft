package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity   
public class Doctor   {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;
	
	 @Column(nullable = false, length = 50)
	private String doctorName;
	  @Column(nullable = false, length = 45)
	private String email;
	  @Column(nullable = false)
	private String password;
	  @Column(nullable = false)
	private String doctorSpecialization;
	  @Column(nullable = false)
	private String doctorDegree;
	  @Column(nullable = false,length=4)
	private long doctorFees;
	  @Column(nullable = false ,length=10)
	private long doctorContact;
	 
	@Column(nullable = false)
	private int isVerified=1;
	
	   //@OneToMany
	  // @JoinColumn(name="doctorId")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Appointment> dlst= new ArrayList<Appointment> ();

	 public List<Appointment> getDlst() {
			return dlst;
		}

		public void setDlst(List<Appointment> dlst) {
			this.dlst = dlst;
		}


	public long getDocotor_id() {
		return doctorId;
	}

	public void setDocotor_id(long docotor_id) {
		this.doctorId = docotor_id;
	}

	public String getDoctor_name() {
		return doctorName;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctorName = doctor_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoctor_speciel() {
		return doctorSpecialization;
	}

	public void setDoctor_speciel(String doctor_speciel) {
		this.doctorSpecialization = doctor_speciel;
	}

	public String getDoctor_degree() {
		return doctorDegree;
	}

	public void setDoctor_degree(String doctor_degree) {
		this.doctorDegree = doctor_degree;
	}

	public long getDoctor_fees() {
		return doctorFees;
	}

	public void setDoctor_fees(long doctor_fees) {
		this.doctorFees = doctor_fees;
	}

	public long getDoctor_contact() {
		return doctorContact;
	}

	public void setDoctor_contact(long doctor_contact) {
		this.doctorContact = doctor_contact;
	}


	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctor_id=" + doctorId + ", doctor_name=" + doctorName + ", email=" + email + ", password="
				+ password + ", doctor_speciel=" + doctorSpecialization + ", doctor_degree=" + doctorDegree
				+ ", doctor_fees=" + doctorFees + ", doctor_contact=" + doctorContact + "]";
	}


}
