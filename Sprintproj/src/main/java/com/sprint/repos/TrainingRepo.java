package com.sprint.repos;

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

	public void assignTrainer() {
		
		
		
		em.getTransaction().begin();
		
		Mentor foundMentor = em.find(Mentor.class,1);
		User foundUser=em.find(User.class,1);
	
		TrainingActiveUser ta=new TrainingActiveUser("priyank",foundMentor,"angular",foundUser,"20-12-2020","25-12-2020",0,0);
		
		
	}
}
