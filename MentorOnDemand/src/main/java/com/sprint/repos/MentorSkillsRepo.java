package com.sprint.repos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import com.sprint.entities.MentorSkills;
import com.sprint.entities.Role;

public class MentorSkillsRepo {
	
	private EntityManager em;
	public MentorSkillsRepo()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	}
	public void addMentorSkill(MentorSkills ms)
	{
		
		em.getTransaction().begin();
		em.persist(ms);
		em.getTransaction().commit();
		
	}
	
	public void removeMentorSkillByName(String name) {
		em.getTransaction().begin();
		TypedQuery<MentorSkills> query = em.createQuery("SELECT ms FROM MentorSkills ms where ms.title=:name", MentorSkills.class);
		query.setParameter("name", name);
		MentorSkills ms=query.getSingleResult();
		em.remove(ms);
		em.getTransaction().commit();
	}
	
}
