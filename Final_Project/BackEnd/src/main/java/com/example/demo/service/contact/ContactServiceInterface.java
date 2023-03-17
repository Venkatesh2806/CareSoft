package com.example.demo.service.contact;

import java.util.List;

import com.example.demo.entity.Contact;

public interface ContactServiceInterface {

	
	public Contact saveContact(Contact contact);
	
	
	public List<Contact> getpatientcontact(String profilerole);
	
	public List<Contact> getcontactdetilsbyemailandrole(String email,String profilerole);
	
	
}
