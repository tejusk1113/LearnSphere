package com.learnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnSphere.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

//	Users findOneByEmail(String email);

	boolean existsByEmail(String email);

	Users findByEmail(String email);

//	 Users findByEmail(String email);

}
