package com.sprint.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="mentor")
public class Mentor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	int id;
	String mentorName;
	String password;
	String email;
	String phoneNumber;
	int experience;
	int noOfCourseTeached;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<MentorSkills> mentorSkills;

	
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public int getNoOfCourseTeached() {
		return noOfCourseTeached;
	}
	public void setNoOfCourseTeached(int noOfCourseTeached) {
		this.noOfCourseTeached = noOfCourseTeached;
	}
	public List<MentorSkills> getMentorSkills() {
		return mentorSkills;
	}
	public void setMentorSkills(List<MentorSkills> mentorSkills) {
		this.mentorSkills = mentorSkills;

	}
	
	
	public Mentor() {
		// TODO Auto-generated constructor stub
	}
	public Mentor(String mentorName, String password, String email, String phoneNumber, int experience,
		int noOfCourseTeached, List<MentorSkills> mentorSkills) {
	super();
	this.mentorName = mentorName;
	this.password = password;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.experience = experience;
	this.noOfCourseTeached = noOfCourseTeached;
	this.mentorSkills = mentorSkills;
}
	@Override
	public String toString() {
		return "Mentor [id=" + id + ", mentorName=" + mentorName + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", experience=" + experience + ", noOfCourseTeached="
				+ noOfCourseTeached + ", mentorSkills=" + mentorSkills + "]";
	}
	

}
