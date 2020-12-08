package com.sprint.repos;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sprint.entities.Mentor;
import com.sprint.entities.MentorSkills;
public class MentorRepository {
	private EntityManager em;
	public MentorRepository()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	}
	public Mentor addMentor(Mentor m)
	{
		
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		return m;
	}
	   public void removeMentorById(Mentor foundMentor) 
	   {
	   	em.getTransaction().begin();
	   	em.remove(foundMentor);
	   	em.getTransaction().commit();
	   }
	   
	   
	   public void UpdateMentorById(Mentor  foundMentor) {
		   	em.getTransaction().begin();
		   	em.getTransaction().commit();
		   	
		   }

	   public void testFindUserByName() {
	  
			TypedQuery<Mentor> query = em.createQuery
		   			("SELECT u FROM Mentor u where u.Mentor_Name=:nameparam", Mentor.class);
		   	query.setParameter("nameparam","arun");
	   	List<Mentor> Mentors = query.getResultList();
            System.out.println(Mentors);
	   	
	   	} 

	   	
	   }
