package com.learnSphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Comments;
import com.learnSphere.repository.CommentsRepository;

@Service
public class CommentsServiceImplementation implements CommentsService {

	@Autowired
	CommentsRepository crepo;

	@Override
	public String addComments(Comments comments) {
		crepo.save(comments);
		return "comments added successfully";
	}

	@Override
	public List<Comments> getAllComments() {
		return  crepo.findAll();
	}

}
