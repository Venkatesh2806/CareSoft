package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Contact;

public interface ContactDaoInterface extends JpaRepository<Contact, Integer > {

	List<Contact>findAllByProfilerole(String profilerole);
	
	List<Contact>findAllByEmailAndProfilerole(String email,String profilerole);
}
 