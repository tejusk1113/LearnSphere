package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lession;
import com.learnSphere.entity.Users;
import com.learnSphere.service.StudentService;
import com.learnSphere.service.TrainerService;
import com.learnSphere.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/api/student")
public class StudentController {

	@Autowired
	StudentService sser;
	
	@Autowired
	TrainerService tser;
	
	@Autowired
	UserService us;
	
	@GetMapping(value = "/getLessions")
	public String getLession(@RequestParam("lessionId") int lessionId, Model model) {
	    Lession ls = sser.getLession(lessionId);
	        System.out.println("Lession ID: " + ls.getLessionId());
	    model.addAttribute("lession", ls);
	    return "lessions";
	}
	
	@GetMapping(value="/getAllCourse")
	public String getAllCourse(Model model){
		
		List<Course> cr = tser.findAllCourse();
		for(Course cr1:cr)
		{
			cr1.getCourseId();
		}
		model.addAttribute("courses", cr);
		return "forward:/purchase";
	}
	
	@GetMapping(value = "/getAllCourseByEmail")
	public String getAllCourseByEmail(Model model,HttpSession session) {
		String email=(String)session.getAttribute("userEmail");
		System.out.println(email);
		Users user = us.findByEmail(email);
		List<Course> course = sser.findAllCourseByUserId(user.getId());
		for(Course courses:course) {
			System.out.println(courses);
		}
		model.addAttribute("courses", course);
		return "myCourse";
	}
	
//	public String getAllLessionsByCourseId(@RequestParam("courseId") int courseId,Model model) {
//		
//		sser.getAllLessionsByCourseId(courseId);
//		
//		return null;
//		
//	}
	



}
