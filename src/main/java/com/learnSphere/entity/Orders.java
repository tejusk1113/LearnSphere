package com.learnSphere.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderNo;
	int orderId;
	int orderAmount;
	String currency;
	String orderStatus;
	
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
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
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int orderNo, int orderId, int orderAmount, String currency, String orderStatus) {
		super();
		this.orderNo = orderNo;
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.currency = currency;
		this.orderStatus = orderStatus;
	}
	
	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo + ", orderId=" + orderId + ", orderAmount=" + orderAmount + ", currency="
				+ currency + ", orderStatus=" + orderStatus + "]";
	}
	
	
	
	
	
}
