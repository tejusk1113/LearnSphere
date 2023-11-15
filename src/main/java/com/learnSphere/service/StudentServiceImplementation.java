package com.learnSphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Lession;
import com.learnSphere.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentRepository srepo;
	
	@Override
	public Lession getLession(int lessionId) {
		Lession lession = srepo.findById(lessionId).get();
		return lession;
		
	}

}
