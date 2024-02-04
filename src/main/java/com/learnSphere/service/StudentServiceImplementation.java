package com.learnSphere.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lession;
import com.learnSphere.entity.Orders;
import com.learnSphere.repository.OrdersRepository;
import com.learnSphere.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentRepository srepo;
	
	@Autowired
	OrdersRepository orepo;
	
	@Override
	public Lession getLession(int lessionId) {
		Lession lession = srepo.findById(lessionId).get();
		return lession;
		
	}

	@Override
	public List<Course> findAllCourseByUserId(long id) {
		List<Orders> ords = orepo.findAll();
		List<Course> course=new ArrayList<Course>();
		for(Orders ord:ords) {
			Course crs = ord.getCourse();
			course.add(crs);
		}
		
		return course;
		
	}

}
