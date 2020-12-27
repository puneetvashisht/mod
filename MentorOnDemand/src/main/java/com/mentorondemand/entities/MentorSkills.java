package com.mentorondemand.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mentorSkills")
public class MentorSkills {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
		
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
	}

	@Override
	public boolean equals(Object obj) {
		boolean flag=true;
		MentorSkills other = (MentorSkills) obj;
		if (!title.equals(other.title))
			flag= false;
		return flag;
	}
	@Override
	public String toString() {
		return "MentorSkills [id=" + id + ", Title=" + title + "]";
	}
}

