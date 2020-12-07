package com.sprint.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TrainingActiveUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String trainingName;
	@ManyToOne
	private Mentor mentor;
	private String skillTitle;
	@OneToOne
	private User user;
//	@OneToOne
//	String user_email;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int progress;
	private int rating;
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public Mentor getMentor() {
		return mentor;
	}
	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}
	public String getSkillTitle() {
		return skillTitle;
	}
	public void setSkillTitle(String skillTitle) {
		this.skillTitle = skillTitle;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public TrainingActiveUser() {
		
	}
	public TrainingActiveUser(String trainingName, Mentor mentor, String skillTitle, User user,
			 LocalDate startDate, LocalDate endDate, int progress, int rating) {
		super();
		this.trainingName = trainingName;
		this.mentor = mentor;
		this.skillTitle = skillTitle;
		this.user = user;
//		this.user_email = user_email;
		this.startDate = startDate;
		this.endDate = endDate;
		this.progress = progress;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "TrainingActiveUser [id=" + id + ", trainingName=" + trainingName + ", mentor_id=" + mentor
				+ ", skillTitle=" + skillTitle + ", user_id=" + user
				+ ", startDatetime=" + startDate + ", endDatetime=" + endDate + ", progress=" + progress
				+ ", rating=" + rating + "]";
	}
	
	
	
	
}
