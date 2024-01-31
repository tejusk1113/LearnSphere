package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learnSphere.entity.Comments;
import com.learnSphere.entity.Users;
import com.learnSphere.service.CommentsService;
import com.learnSphere.service.StudentService;
import com.learnSphere.service.UserService;

@Controller
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	UserService us;

	@Autowired
	StudentService ss;

	public UserController(UserService us) {
		super();
		this.us = us;
	}

	@PostMapping(value = "/add")
	public String addStudent(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("role") String role, @RequestParam("dob") String dob, @RequestParam("mobile") String mobile,
			Model model, RedirectAttributes redirectAttributes) {

		boolean status = us.validateEmail(email);
		if (status == true) {
			System.out.println("Email Already Exists!");
			model.addAttribute("message", "Email Already Exists!");
			return "register";
		} else {
			Users user = new Users();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			user.setDob(dob);
			user.setMobile(mobile);
			us.addStudent(user);
			redirectAttributes.addFlashAttribute("registrationMessage", "Registration Successful");
			String registrationMessage = (String) model.getAttribute("registrationMessage");
			if (registrationMessage != null) {
				model.addAttribute("message", registrationMessage);
			}
			// Other login page logic
			return "redirect:/login";
		}
	}

	@PostMapping(value = "/validateUser")
	public String validateUser(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {
		if (us.validateEmail(email) == true) {
			if (us.validatePassword(email, password) == true) {
				Users user = us.findByEmail(email);
				if (user.getRole().equals("Student")) {
					System.out.println("login successfull");
					return "redirect:/studentHome";
				} else {
					return "redirect:/trainerHome";
				}
			} else {
				System.out.println("please enter valid password");
				model.addAttribute("message", "please enter valid password..");
				return "login";
			}
		} else {
			System.out.println("Email does not exist");
			model.addAttribute("message", "Email does not exist..");
			return "login";
		}

	}

	@Autowired
	CommentsService cs;

	@PostMapping(value = "/addComments")
	public String addComments(@RequestParam("comments") String comments, Model model) {
		System.out.println(comments);

		// Add comments to the database or perform other necessary actions
		Comments cmts = new Comments();
		cmts.setCommentsStore(comments);
		cs.addComments(cmts);

		// Retrieve all comments
		List<Comments> allComments = cs.getAllComments();

		// Add comments to the model
		model.addAttribute("allComments", allComments);

		// Return the view name directly
		return "myLessions";
	}

//	@GetMapping(value="/getAllComments")
//	public String getAllComments(Model	 model) {
//		
//	}

}
