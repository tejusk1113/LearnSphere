package com.learnSphere.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;
	int orderAmount;
	String currency;
	String orderStatus;
	@ManyToOne
	Course course;
	
	@ManyToOne
	Users users;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Orders(int orderId, int orderAmount, String currency, String orderStatus, Course course, Users users) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.currency = currency;
		this.orderStatus = orderStatus;
		this.course = course;
		this.users = users;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderAmount=" + orderAmount + ", currency=" + currency
				+ ", orderStatus=" + orderStatus + ", course=" + course + ", users=" + users + "]";
	}
	
	
	
	
	
	
	
	
	
}
