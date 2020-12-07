package com.sprint.repos;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.sprint.entities.TrainingActiveUser;

import com.sprint.entities.Mentor;
import com.sprint.entities.User;
public class TrainingRepo {
	private EntityManager em;
	public TrainingRepo() {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test");
	
//		Create EntityManager
		em = emf.createEntityManager();
		
		
	}

	public void assignTrainer(TrainingActiveUser t) {
		
		
		
		em.getTransaction().begin();
		
		em.persist(t);
	
		em.getTransaction().commit();
	}
	
	public void startTraining() {
		
		TrainingActiveUser t=em.find(TrainingActiveUser.class, 7);
		em.getTransaction().begin();
		LocalDate d=LocalDate.now();
		t.setStartDate(d);
		em.getTransaction().commit();
		
	}
	
	public void endTraining() {
		TrainingActiveUser t=em.find(TrainingActiveUser.class, 7);
		em.getTransaction().begin();
		LocalDate d=LocalDate.now();
		t.setEndDate(d);
		em.getTransaction().commit();
	}
	
	public void findPreviousTraining() {
		TypedQuery<TrainingActiveUser> query=em.createQuery("SELECT t FROM TrainingActiveUser t where t.Mentor=:1", TrainingActiveUser.class);
		List<TrainingActiveUser> mentors=query.getResultList();
		System.out.println(mentors);
	}
}
