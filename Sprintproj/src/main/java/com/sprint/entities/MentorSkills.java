package com.sprint.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MentorSkills {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String title;
	

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	public MentorSkills(String title) {
		super();
		this.title = title;
	}

	public MentorSkills() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MentorSkills [id=" + id + ", Title=" + title + "]";
	}
	
	
	
	
}
