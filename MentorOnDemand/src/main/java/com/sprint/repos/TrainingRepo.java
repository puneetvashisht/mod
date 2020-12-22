package com.sprint.repos;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.xml.bind.ValidationException;

import com.sprint.entities.TrainingActiveUser;

import com.sprint.entities.Mentor;
import com.sprint.entities.User;
public class TrainingRepo {
	private EntityManager em;
	UserRepo userRepo=new UserRepo();
	MentorRepository mentorRepo=new MentorRepository();
	public TrainingRepo() {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test");
	
//		Create EntityManager
		em = emf.createEntityManager();
		
		
	}

	public boolean assignTrainer(TrainingActiveUser t,int mentorId,int userId) {
		
		Mentor foundMentor = mentorRepo.findMentorById(mentorId);
		User foundUser=userRepo.findUserById(userId);
		t.setMentor(foundMentor);
		t.setUser(foundUser);
		em.getTransaction().begin();
		
		em.persist(t);
	
		em.getTransaction().commit();
		return true;
	}
	
	public boolean startTraining(int id){
		
		TrainingActiveUser t=em.find(TrainingActiveUser.class, id);
		if(t==null) {
			return false;
		}
		em.getTransaction().begin();
		LocalDate d=LocalDate.now();
		t.setStartDate(d);
		em.getTransaction().commit();
		
		return true;
	}
	
	public boolean endTraining(int id) {
		TrainingActiveUser t=em.find(TrainingActiveUser.class, id);
		if(t==null) {
			return false;
		}
		em.getTransaction().begin();
		LocalDate d=LocalDate.now();
		t.setProgress(100);
		t.setEndDate(d);
		em.getTransaction().commit();
		return true;
	}
	
	public List<TrainingActiveUser> findPreviousTraining(int mentorId) {
		TypedQuery<TrainingActiveUser> query=em.createQuery("SELECT t FROM TrainingActiveUser t where t.mentor.id=:id and t.progress=100", TrainingActiveUser.class);
		query.setParameter("id", mentorId);
		List<TrainingActiveUser> mentors=query.getResultList();
		System.out.println(mentors);
		return mentors;
	}
	public int updateProgress(int progress,int mentorId,String trainingName) {
		em.getTransaction().begin();
		TypedQuery<TrainingActiveUser> query=em.createQuery("SELECT t FROM TrainingActiveUser t where t.trainingName=:trainingName and t.mentor.id=:id", TrainingActiveUser.class);
		query.setParameter("trainingName", trainingName);
		query.setParameter("id", mentorId);
		TrainingActiveUser obj=query.getSingleResult();
		
		obj.setProgress(progress);
		
		em.getTransaction().commit();
		return obj.getProgress();
		
	}
	public boolean addRating(String trainingName,int userId,int rating) {
		
		em.getTransaction().begin();
		TypedQuery<TrainingActiveUser> query=em.createQuery("SELECT t FROM TrainingActiveUser t where t.trainingName=:trainingName and t.user.id=:user_id", TrainingActiveUser.class);
		query.setParameter("trainingName", trainingName);
		query.setParameter("user_id", userId);
		
		TrainingActiveUser obj=query.getSingleResult();
		if(obj.getProgress()==100) {
			obj.setRating(rating);
		}
		else {
			System.out.println("training is incomplete " +"\n" +"progress: "+obj.getProgress());
		}
		
		em.getTransaction().commit();
		return true;
	}

	public int findProgress(String trainingName,int user_id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		TypedQuery<TrainingActiveUser> query=em.createQuery("SELECT t FROM TrainingActiveUser t where t.trainingName=:trainingName and t.user.id=:user_id", TrainingActiveUser.class);
		query.setParameter("trainingName", trainingName);
		query.setParameter("user_id", user_id);
		TrainingActiveUser obj=query.getSingleResult();
		System.out.println("Progress = "+obj.getProgress());
		return obj.getProgress();
	}
}
