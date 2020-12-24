package com.mentorondemand.repos;
import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mentorondemand.entities.TrainingActiveUser;




@Repository
public interface TrainingRepo extends JpaRepository<TrainingActiveUser,Integer> {

	
	
	@Query("select t from TrainingActiveUser t where t.mentor.id=:mentorId and t.progress=100")
	List<TrainingActiveUser> findPreviousTraining(int mentorId);

	@Query("SELECT t FROM TrainingActiveUser t where t.trainingName=:trainingName and t.user.id=:id")
	TrainingActiveUser updateProgress(String trainingName,int id);
	
	@Query("SELECT t FROM TrainingActiveUser t where t.trainingName=:trainingName and t.progress=100 and t.user.id=:userId")
	TrainingActiveUser addRating(String trainingName,int userId);
	
	@Query("SELECT t FROM TrainingActiveUser t where t.trainingName=:trainingName and t.user.id=:userId")
	TrainingActiveUser findTrainingProgress(String trainingName,int userId);
}
