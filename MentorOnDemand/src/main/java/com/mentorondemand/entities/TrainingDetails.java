package com.mentorondemand.entities;

public class TrainingDetails {
	private String trainingName;
	private String skillTitle;
	private int mentorId;
	private int userId;
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getSkillTitle() {
		return skillTitle;
	}
	public void setSkillTitle(String skillTitle) {
		this.skillTitle = skillTitle;
	}
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public TrainingDetails(String trainingName, String skillTitle, int mentorId, int userId) {
		super();
		this.trainingName = trainingName;
		this.skillTitle = skillTitle;
		this.mentorId = mentorId;
		this.userId = userId;
	}
	
	
}
