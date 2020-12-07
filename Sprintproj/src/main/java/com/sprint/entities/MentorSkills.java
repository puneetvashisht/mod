package com.sprint.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MentorSkills {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Skill_id;
	String Skill_title;
	

	public String getSkill_title() {
		return Skill_title;
	}
	public void setSkill_title(String skill_title) {
		Skill_title = skill_title;
	}
	public MentorSkills( String skill_title) {
		super();

		Skill_title = skill_title;
	}
	
	public MentorSkills() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MentorSkills [Skill_id=" + Skill_id + ", Skill_title=" + Skill_title + "]";
	}
	
	
	
}
