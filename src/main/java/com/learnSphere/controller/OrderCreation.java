package com.learnSphere.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnSphere.entity.Orders;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
@RequestMapping("/api/order")
public class OrderCreation {

	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestParam("amount") int amount) {
		
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
			System.out.println(order.toJson().getString("id"));
			
			
		} catch (RazorpayException e) {
			
			e.printStackTrace();
		}
		
		finally {
			return order.toString();
		}
		
		
	}
}
