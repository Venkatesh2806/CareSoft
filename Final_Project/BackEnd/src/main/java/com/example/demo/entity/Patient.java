package com.example.demo.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table( name = "Patient")
public class Patient   {
 
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;
     
    @Column(nullable = false, length = 45)
    private String email;
     
    @Column(nullable = false)
    private String password;
    
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstName;
     
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastName;
    
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    
    @Column(name = "gender", nullable = false,length = 10)
    private String gender;
    
    @Column(name = "contact", nullable = false, length = 25)
    private String contact;
    
    @Column( nullable = false)
    private Date date;
    
    @Column(nullable = false)
	private boolean isVerified;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Appointment> lst =new ArrayList<Appointment> ();

	public List<Appointment> getLst() {
		return lst;
	}

	public void setLst(List<Appointment> lst) {
		this.lst = lst;
	}
	
	 public boolean  getIsVerified() {
			return isVerified;
		}

		public void setIsVerified(boolean isVerified) {
			this.isVerified = isVerified;
		}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return patientId;
	}

	public void setId(Long id) {
		this.patientId = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@Override
	public String toString() {
		return "Patient [id=" + patientId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + ", gender=" + gender + ", contact=" + contact
				+ ", date=" + date + "]";
	}
}
