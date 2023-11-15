package com.learnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnSphere.entity.Lession;

@Repository
public interface LessionRepository extends JpaRepository<Lession, Integer> {

}
