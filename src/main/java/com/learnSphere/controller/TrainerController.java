package com.learnSphere.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lession;
import com.learnSphere.service.TrainerService;

@Controller
@RequestMapping(value = "/api/trainer")
public class TrainerController {

	@Autowired
	TrainerService tser;
	
	public TrainerController(TrainerService tser) {
		super();
		this.tser = tser;
	}

	@PostMapping(value = "/addCourse")
	public String addCourse(@RequestParam("courseId") int courseId,
	        @RequestParam("courseName") String courseName,
	        @RequestParam("courseDescription") String courseDescription,
	        @RequestParam("coursePrice") int coursePrice,
	        @RequestParam("courseImage") MultipartFile courseImage) {

	    Course course = new Course();
	    course.setCourseId(courseId);
	    course.setCourseName(courseName);
	    course.setCourseDescription(courseDescription);
	    course.setCoursePrice(coursePrice);

	    try {
	        // Set the course image as a byte array
	        course.setCourseImage(Base64.getEncoder().encodeToString(courseImage.getBytes()));
	    } catch (IOException e) {
	        e.printStackTrace();
	        // Handle the exception appropriately
	    }

	    String msg = tser.addCourse(course);
	    System.out.println(msg);
	    return "addLession";
	}
	
	@PostMapping(value="/addLession")
	public String addLession(@RequestParam("courseId") int courseId,
			@RequestParam("lessionId") int lessionId,
			@RequestParam("lessionName") String lessionName,
			@RequestParam("topics") String topics,
			@RequestParam("link") String link) {
		System.out.println(courseId+lessionId);
		Course course = tser.getCourseById(courseId);
		Lession lession=new Lession(lessionId, lessionName, topics, link, course);
		String msg = tser.addLession(lession);
		System.out.println(msg);
		
		course.getLession().add(lession);
		String msg1 = tser.addCourse(course);
		System.out.println("Lession successfully added to the course");
		return "addLession";
		
	}
	
	@GetMapping(value="/findAll")
	public String findAllCourse(Model model) {
		System.out.println("Hello world");
		List<Course> cr = tser.findAllCourse();
		System.out.println("Hello world");
		model.addAttribute("courses", cr);
		System.out.println("Hello world");
		return "forward:/courses";
	}
}
