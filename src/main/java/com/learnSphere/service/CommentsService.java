package com.learnSphere.service;

import java.util.List;

import com.learnSphere.entity.Comments;

public interface CommentsService {

	public String addComments(Comments comments);
	
	public List<Comments> getAllComments();
}
