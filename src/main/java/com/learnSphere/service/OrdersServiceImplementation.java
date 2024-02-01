package com.learnSphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Orders;
import com.learnSphere.repository.OrdersRepository;

@Service
public class OrdersServiceImplementation implements OrdersService {

	@Autowired
	OrdersRepository orepo;
	
	@Override
	public String saveOrder(Orders ord) {
		System.out.println("Service called");
		orepo.save(ord);
		return "ordered successfully!";
	}

}
