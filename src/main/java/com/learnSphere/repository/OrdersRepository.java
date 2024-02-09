package com.learnSphere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnSphere.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	List<Orders> findByUsersId(long id);


//  List<Orders> findByUserId(long id);

}
