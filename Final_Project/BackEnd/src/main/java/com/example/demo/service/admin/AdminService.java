package com.example.demo.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminDAOInterface;
import com.example.demo.entity.Admin;


@Service
public class AdminService implements AdminServiceInterface{

	@Autowired
	AdminDAOInterface adminDAOInterface;
	

	@Override
	public Admin authenticateAdmin(String email,String contact, String password) {
		// TODO Auto-generated method stub
		Admin a=adminDAOInterface.findByEmailAndContactAndPassword(email,contact,password);
		System.out.println(a);
		return a;
	}

}
