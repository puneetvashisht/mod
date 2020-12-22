package com.sprint.repos;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sprint.entities.Mentor;
import com.sprint.entities.MentorSkills;
import com.sprint.entities.User;
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
	
	   public void removeMentorById(int id) 
	   {
		Mentor foundMentor = findMentorById(id);
	   	em.getTransaction().begin();
	   	em.remove(foundMentor);
	   	em.getTransaction().commit();
	   }
	  
	   
	   public Mentor findMentorById(int id)
	   {
	   	    Mentor foundMentor = em.find(Mentor.class,id);
	   		System.out.println(foundMentor);
	   		return foundMentor;
	   }
	   
	   public void updateMentorName(int id,String name) {
			em.getTransaction().begin();
			Mentor foundMentor = findMentorById(id);
			foundMentor.setMentorName(name);
			em.getTransaction().commit();
			
		}
	   public void updateMentorEmail(int id,String email) {
			em.getTransaction().begin();
			Mentor foundMentor = findMentorById(id);
			foundMentor.setEmail(email);
			em.getTransaction().commit();
			
		}
	   
	   public void updateMentorPhno(int id,String phno) {
			em.getTransaction().begin();
			Mentor foundMentor = findMentorById(id);
			foundMentor.setPhoneNumber(phno);
			em.getTransaction().commit();
			
		}
	   
	  
	   public void findMentorByName(String name) {
	  
			TypedQuery<Mentor> query = em.createQuery
		   			("SELECT u FROM Mentor u where u.mentorName=:nameparam", Mentor.class);
		   	query.setParameter("nameparam",name);
	   	List<Mentor> Mentors = query.getResultList();
            System.out.println(Mentors);
	   	
	   	} 
	   public void addExistingSkill(String mentorName,String skillName) {
		   TypedQuery<MentorSkills> query = em.createQuery("SELECT ms FROM MentorSkills ms where ms.title=:skillName", MentorSkills.class);
		   query.setParameter("skillName", skillName);
		   MentorSkills ms=query.getSingleResult();
		   TypedQuery<Mentor> query2 = em.createQuery("SELECT m FROM Mentor m where m.mentorName=:mentorName", Mentor.class);
		   
		   query2.setParameter("mentorName", mentorName);
		   Mentor m=query2.getSingleResult();
		   List<MentorSkills> l=m.getMentorSkills();
		   l.add(ms);
		   em.getTransaction().commit();
		   
	   	
	   }
	   
	   public  boolean loginMentor(String name,String password)
	   {
	      try {	
	   	TypedQuery<Mentor> query=em.createQuery("select m from Mentor m where m.mentorName=:name",Mentor.class);
	   	query.setParameter("name",name);
	   	Mentor exist=query.getSingleResult();
	   	if(exist.getPassword().equals(password)&& (exist.getMentorName().equals(name)))
	   		System.out.println("Valid Access");
	   	return true;
	      }
	      catch(Exception e) {
	   	System.out.println("Invalid Access");
	   	return false;
	   	}
	   	
	      
	   }
	   public Mentor mentorRegistration(Mentor m)
	   {
	   		
	   	em.getTransaction().begin();
	   	
	       em.persist(m);
	   	
	   	em.getTransaction().commit();
	   	return m;
	   }
	   
}
