package com.sprint.repos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sprint.entities.Role;
import com.sprint.entities.User;

public class RoleRepo {
	private  EntityManager em;
//	Role r1=new Role("User");
//    Role r2=new Role("Admin");
    Role r3=new Role("Mentor");
	  public RoleRepo() {
		EntityManagerFactory emf = Persistence	.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	
	  }
	public  void addRole() {
	
		em.getTransaction().begin();
		
	    em.persist(r3);
		
		em.getTransaction().commit();
		
		
	}
}
