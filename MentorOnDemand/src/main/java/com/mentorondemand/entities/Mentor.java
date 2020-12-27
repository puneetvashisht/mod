package com.mentorondemand.entities;
import java.util.*;
import javax.persistence.*;

import com.mentorondemand.entities.MentorSkills;
import com.mentorondemand.entities.User;
@Entity
@Table(name="mentor")
public class Mentor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int experience;
	private int courseTeached;
	@OneToOne
	private User user;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<MentorSkills> mentorSkills;

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getCourseTeached() {
		return courseTeached;
	}

	public void setCourseTeached(int courseTeached) {
		this.courseTeached = courseTeached;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<MentorSkills> getMentorSkills() {
		return mentorSkills;
	}

	public void setMentorSkills(List<MentorSkills> mentorSkills) {
		this.mentorSkills = mentorSkills;
	}

	public Mentor(int experience, int courseTeached,  User user) {
		super();
		this.experience = experience;
		this.courseTeached = courseTeached;	
		this.user = user;
	}

	public Mentor() {
		super();
	}

	@Override
	public String toString() {
		return "Mentor [ experience=" + experience + ", courseTeached=" + courseTeached
				+  ", user=" + user +  "]";
	}

	
}	
	
