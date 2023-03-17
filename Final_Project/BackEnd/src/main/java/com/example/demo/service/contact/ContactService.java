package com.example.demo.service.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContactDaoInterface;
import com.example.demo.entity.Contact;


@Service
public class ContactService implements ContactServiceInterface {

	@Autowired
	private ContactDaoInterface  contactDaoInterface;
	
	@Override
	public Contact saveContact(Contact contact) {
		
		 
		 return contactDaoInterface.save(contact);
		
	}
	
	@Override
	public List<Contact> getpatientcontact(String profilerole) {
		
		return contactDaoInterface.findAllByProfilerole(profilerole);
		
	}
	
	@Override
	public List<Contact> getcontactdetilsbyemailandrole(String email,String profilerole) {
		
		return contactDaoInterface.findAllByEmailAndProfilerole(email,profilerole);
		
	}

}
