package com.sprint.repos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.sprint.entities.MentorSkills;
public class MentorSkillsRepo {
	
	private EntityManager em;
	public MentorSkillsRepo()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	}
	public MentorSkills addMentor(MentorSkills ms)
	{
		
		em.getTransaction().begin();
		em.persist(ms);
		em.getTransaction().commit();
		return ms;
}
}

	
	