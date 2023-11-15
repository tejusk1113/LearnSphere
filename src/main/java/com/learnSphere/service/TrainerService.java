package com.learnSphere.service;

import java.util.List;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lession;

public interface TrainerService {

	public String addCourse(Course course);

	public Course getCourseById(int courseId);

	public String addLession(Lession lession);

	public List<Course> findAllCourse();
}
