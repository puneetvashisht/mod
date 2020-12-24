package com.mentorondemand.entities;

import java.util.List;

public class MentorDetails {
	private String name;
	private String email;
	private String password;
    private String phno;
    private String role;
	private int experience;
	private int courseTeached;
	private List<MentorSkills> mentorSkills;

	public String getRole() {
	return role;
	}
	public void setRole(String role) {
	this.role = role;
	}
	public  String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public  String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public  String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public  String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public void  mentorDetails(int experience) {
		this.experience = experience;
	}
	public int getCourseTeached() {
		return courseTeached;
	}
	public void setCourseTeached(int courseTeached) {
		this.courseTeached = courseTeached;
	}
	public List<MentorSkills> getMentorSkills() {
		return mentorSkills;
	}
	public void setMentorSkills(List<MentorSkills> mentorSkills) {
		this.mentorSkills = mentorSkills;
	}
	@Override
	public String toString() {
		return "MentorDetails [name=" + name + ", email=" + email + ", role=" + role+", password=" + password + ", phno=" + phno
				+ ", experience=" + experience + ", courseTeached=" + courseTeached + ", mentorSkills=" + mentorSkills
				+ "]";
	}
	
	}
	
	
