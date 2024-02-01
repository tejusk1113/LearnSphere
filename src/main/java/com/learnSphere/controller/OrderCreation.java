package com.learnSphere.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Orders;
import com.learnSphere.entity.Users;
import com.learnSphere.service.OrdersService;
import com.learnSphere.service.TrainerService;
import com.learnSphere.service.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
@RequestMapping("/api/order")
public class OrderCreation {
	
	@Autowired
	TrainerService tser;
	
	@Autowired
	OrdersService  oser;
	
	@Autowired
	UserService user;

	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestParam(name="email") String email,
							  @RequestParam(name="courseID") int courseID,
							  @RequestParam(name="amount") int amount) {
		
		System.out.println("Hello world!");
		Order  order=null;
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_2atyh4iOGNhFr1", "FdqAMBzY4hW73LeTgHB55Je9");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount",amount*100);
			orderRequest.put("currency","INR");
			orderRequest.put("receipt", "receipt#1");
//			JSONObject notes = new JSONObject();
//			notes.put("notes_key_1","Tea, Earl Grey, Hot");
//			orderRequest.put("notes",notes);

			order = razorpay.orders.create(orderRequest);	
			System.out.println(order);
			System.out.println(order.toJson().getString("id"));
			
			Users us = user.findByEmail(email);
			
			Course course = tser.getCourseById(courseID);
			System.out.println("control=0");
			Orders ord=new Orders();
			
			ord.setOrderAmount(amount);
			System.out.println("control=1");
			ord.setCurrency("INR");
			ord.setOrderStatus("created");
			ord.setCourse(course);
			ord.setUsers(us);
			
			System.out.println("control=2");
			String msg = oser.saveOrder(ord);
			System.out.println(msg);
			
			
			
			
		} catch (RazorpayException e) {
			
			e.printStackTrace();
		}
		
		finally {
			return order.toString();
		}
		
		
	}
}
