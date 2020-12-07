package com.sprint;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
public class MentorRepository {
	private EntityManager em;
	public MentorRepository()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	}
	public Mentor AddMentor()
	{
		Mentor m = new Mentor("gaja","lakshmi","gajalakshmi@gmail.com",857569373,
				 3, 27);
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		return m;
	}
	   public void removeMentorById() {
	   	
	   	Mentor foundMentor = em.find(Mentor.class, 6);
	   	em.getTransaction().begin();
	   	em.remove(foundMentor);
	   	em.getTransaction().commit();
	   }
	   
	   
	   public void UpdateMentorById() {
		   	em.getTransaction().begin();
		   	Mentor foundMentor = em.find(Mentor.class, 5);
		   	foundMentor.setMentor_Name("arun");
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
