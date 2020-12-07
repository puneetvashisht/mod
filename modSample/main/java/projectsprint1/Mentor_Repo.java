package projectsprint1;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Mentor_Repo {
	
		private EntityManager em;
		
		public Mentor_Repo()
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
			em = emf.createEntityManager();
		}

		
		public Mentor_User addMentor()
		{
			Mentor_User m = new Mentor_User("Akshaya", "achu1@gmail.com", "abc1", 984641246, 104, "Java", 3, 15);
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			
			return m;
		 }

		public void removeMentorById() {
			//Mentor_User foundMentor = em.find(Mentor_User.class, 2);
			em.getTransaction().begin();
			Mentor_User foundMentor = em.find(Mentor_User.class, 2);
			System.out.println(foundMentor);
			em.remove(foundMentor);
			em.getTransaction().commit();
			
//			return foundMentor;
//			return user;
			
		}
			
		public void updateMentorById() {
			em.getTransaction().begin();
		//	em.merge(user);
			Mentor_User foundMentor = em.find(Mentor_User.class, 3);
			foundMentor.setMentor_name("achu");
			em.getTransaction().commit();
		
		}
		public void testFindUserByName() {
			TypedQuery<Mentor_User> query = em.createQuery
					("SELECT u FROM Mentor_User u where u.Mentor_name=:nameparam",Mentor_User.class);
			query.setParameter("nameparam", "preet");
			
			List<Mentor_User> Mentors = query.getResultList();
			System.out.println(Mentors);
		}
	}
		
		
		
		

		

