package com.learnSphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Users;
import com.learnSphere.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository urepo;


	public UserServiceImplementation(UserRepository urepo) {
		super();
		this.urepo = urepo;
	}


	@Override
	public void addStudent(Users user) {
		urepo.save(user);
	}

	

	@Override
	public boolean validateEmail(String email) {
		return urepo.existsByEmail(email);
	}


	@Override
	public boolean validatePassword(String email, String password) {
		Users user = urepo.findByEmail(email);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				System.out.println("Valid User!");
				return true;
			}
			else {
				System.out.println("Invalid User!");
				return false;
			}
		}
		return false;
	}


	@Override
	public Users findByEmail(String email) {
		Users user = urepo.findByEmail(email);
		return user;
	}
}
