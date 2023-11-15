package com.learnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnSphere.entity.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer>{

}
