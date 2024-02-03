package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.learnSphere.service.CommentsService;
import com.learnSphere.service.StudentService;

@Controller
public class NavController {
	
	@Autowired
	CommentsService cs;
	
	@Autowired
	StudentService ss;

	@GetMapping(value="/")
	public String index() {
		return "index";
	}

	@GetMapping(value="/register")
	public String register() {
		return "register";
	}
	
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value="/homepage")
	public String homepage() {
		return "homepage";
	}
	
	@GetMapping(value="/createCourse")
	public String createCourse() {
		return "createCourse";
	}
	
	@GetMapping(value="/addLession")
	public String addLession() {
		return "addLession";
	}
	
	@GetMapping(value="/studentHome")
	public String studentHome() {
		return "studentHome";
	}
	
	@GetMapping(value="/trainerHome")
	public String trainerHome() {
		return "trainerHome";
	}
	
	@GetMapping(value="/courses")
	public String courses() {
		return "courses";
	}
	
	@GetMapping(value="/myCourses")
	public String myCourses() {	
		return "myCourse";
	}
	@GetMapping(value="/purchase")
	public String purchase() {
		System.out.println("control comes to mapping");
		return "purchase";
	}
	
	@GetMapping(value="/demoLession")
	public String demoLession() {
		return "demoLession";
	}
	
	@GetMapping(value="/lessions")
	public String lessions() {
		System.out.println("Reached to the navigation");
		return "lessions";
	}
	
	@GetMapping(value="/payment")
	public String payment() {
		return "payment";
	}
	
	@GetMapping(value="/termsandconditions")
	public String termsandconditions() {
		return "termsandconditions";
	}
}
