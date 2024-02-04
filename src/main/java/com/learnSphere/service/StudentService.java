package com.learnSphere.service;

import java.util.List;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lession;

public interface StudentService {

	public Lession getLession(int lessionId);

	public List<Course> findAllCourseByUserId(long id);
}
