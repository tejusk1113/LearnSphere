package com.learnSphere.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int commentId;
	String commentsStore;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentsStore() {
		return commentsStore;
	}
	public void setCommentsStore(String commentsStore) {
		this.commentsStore = commentsStore;
	}
	public Comments(int commentId, String commentsStore) {
		super();
		this.commentId = commentId;
		this.commentsStore = commentsStore;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", commentsStore=" + commentsStore + "]";
	}
	
	
}
