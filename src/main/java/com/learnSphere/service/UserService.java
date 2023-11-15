package com.learnSphere.service;

import com.learnSphere.entity.Users;

public interface UserService {
 
	public void addStudent(Users user);
//	public boolean validateUser(String email,String password);
	public boolean validateEmail(String email);
	public boolean validatepassword(String email, String password);
	public Users findByEmail(String email);
}
