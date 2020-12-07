package com.sprint;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MentorSkills {
	@Id
	int Skill_id;
	String Skill_title;
	public int getSkill_id() {
		return Skill_id;
	}
	public void setSkill_id(int skill_id) {
		Skill_id = skill_id;
	}
	public String getSkill_title() {
		return Skill_title;
	}
	public void setSkill_title(String skill_title) {
		Skill_title = skill_title;
	}
	public MentorSkills(int skill_id, String skill_title) {
		super();
		Skill_id = skill_id;
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
