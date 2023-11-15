package com.learnSphere.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Lession {

	@Id
	int lessionId;
	String lessionName;
	String topics;
	String link;
	@ManyToOne
	Course course;
	public int getLessionId() {
		return lessionId;
	}
	public void setLessionId(int lessionId) {
		this.lessionId = lessionId;
	}
	public String getLessionName() {
		return lessionName;
	}
	public void setLessionName(String lessionName) {
		this.lessionName = lessionName;
	}
	public String getTopics() {
		return topics;
	}
	public void setTopics(String topics) {
		this.topics = topics;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Lession(int lessionId, String lessionName, String topics, String link, Course course) {
		super();
		this.lessionId = lessionId;
		this.lessionName = lessionName;
		this.topics = topics;
		this.link = link;
		this.course = course;
	}
	public Lession() {
		super();
		
	}
	@Override
	public String toString() {
		return "Lession [lessionId=" + lessionId + ", lessionName=" + lessionName + ", topics=" + topics + ", link="
				+ link + "]";
	}
	
	
}
