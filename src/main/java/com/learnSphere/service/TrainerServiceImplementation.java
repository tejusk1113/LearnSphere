package com.learnSphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lession;
import com.learnSphere.repository.CourseRepository;
import com.learnSphere.repository.LessionRepository;

@Service
public class TrainerServiceImplementation implements TrainerService{

	@Autowired
	CourseRepository crepo;
	
	@Autowired
	LessionRepository lrepo;


	@Override
	public String addCourse(Course course) {
		crepo.save(course);
		return "course added Successfully";
	}


	@Override
	public Course getCourseById(int courseId) {
		return crepo.findById(courseId).get();
		
	}


	@Override
	public String addLession(Lession lession) {
		lrepo.save(lession);
		return "lession saved successfully";
	}


	@Override
	public List<Course> findAllCourse() {
		return crepo.findAll();
		
	}

	
}
