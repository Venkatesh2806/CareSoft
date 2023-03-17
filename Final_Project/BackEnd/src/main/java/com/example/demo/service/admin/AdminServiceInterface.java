package com.example.demo.service.admin;

import com.example.demo.entity.Admin;



public interface AdminServiceInterface {

	public Admin authenticateAdmin(String email,String contact,String password);


}
