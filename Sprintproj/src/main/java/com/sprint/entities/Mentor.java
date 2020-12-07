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

	int Mentor_Id;
	String Mentor_Name;
	String Password;
	String Email;
	long Phone_Number;
	int Experience;
	int No_Of_Course_Teached;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<MentorSkills> mentorskills;

	
	public String getMentor_Name() {
		return Mentor_Name;
	}
	public void setMentor_Name(String mentor_Name) {
		Mentor_Name = mentor_Name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(long phone_Number) {
		Phone_Number = phone_Number;
	}
	public int getExperience() {
		return Experience;
	}
	public void setExperience(int experience) {
		Experience = experience;
	}
	public int getNo_Of_Course_Teached() {
		return No_Of_Course_Teached;
	}
	public void setNo_Of_Course_Teached(int no_Of_Course_Teached) {
		No_Of_Course_Teached = no_Of_Course_Teached;
	}
	
	
	
	public List<MentorSkills> getMentorskills() {
		return mentorskills;
	}
	public void setMentorskills(List<MentorSkills> mentorskills) {
		this.mentorskills = mentorskills;
	}
	public Mentor(String mentor_Name, String password, String email, long phone_Number,
			int experience, int no_Of_Course_Teached,List<MentorSkills> mentorSkills) {
		super();
		Mentor_Name = mentor_Name;
		Password = password;
		Email = email;
		Phone_Number = phone_Number;
		Experience = experience;
		No_Of_Course_Teached = no_Of_Course_Teached;
		this.mentorskills=mentorSkills;
	}
	
	public Mentor() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Mentor [Mentor_Id=" + Mentor_Id + ", Mentor_Name=" + Mentor_Name + ", Password=" + Password + ", Email="
				+ Email + ", Phone_Number=" + Phone_Number + ", Experience=" + Experience + ", No_Of_Course_Teached=" + No_Of_Course_Teached + "]";
	}

}
