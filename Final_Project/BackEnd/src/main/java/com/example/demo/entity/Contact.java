package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int contactId;
  
  @Column(nullable = false)
 private String fullName;
 
  @Column(nullable = false)
 private String email;
 
  @Column(nullable = false)
 private String message;
  
  @Column(nullable = false)
  private String profilerole;

	public String getProfilerole() {
	return profilerole;
}

public void setProfilerole(String profilerole) {
	this.profilerole = profilerole;
}

	@Column(nullable = false)
	 private String mobileno;
	 
 public int getContactId() {
	return contactId;
}

public void setContactId(int contactId) {
	this.contactId = contactId;
}

 public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getMobileno() {
	return mobileno;
}

public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
}
