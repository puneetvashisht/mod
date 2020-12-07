package com.cpg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UserRepo {
	
	private EntityManager em;
	  public UserRepo() {
		EntityManagerFactory emf = Persistence	.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	
	  }
	public User addUser(User user){
		User u1 = new User("Pri", "P@gmail", "at", "1230");	
	
		em.getTransaction().begin();
		
	    em.persist(u1);
		
		em.getTransaction().commit();
		return u1;
		
	}
	public void UpdateUserName() {
		em.getTransaction().begin();
		User foundUser = em.find(User.class,32);
		foundUser.setName("Suba");
		em.getTransaction().commit();
		
	}
	public void UpdateUserEmail() {
		em.getTransaction().begin();
		User found = em.find(User.class,32);
		found.setEmail("arun@gmail.com");
		em.getTransaction().commit();
		
	}
	public void UpdateUserPhno() {
		em.getTransaction().begin();
		User found = em.find(User.class,32);
		found.setPhno("9988776655");
		em.getTransaction().commit();
		
	}
	
	public void removeUserById() {
		em.getTransaction().begin();
		User foundUser = em.find(User.class, 31);
		em.remove(foundUser);
		em.getTransaction().commit();
		}

public User FindUserById()
{
	    User foundUser = em.find(User.class,30);
		System.out.println(foundUser);
		return foundUser;
}
public void FindUserByName() {
	TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.name=:nameparam", User.class);
	query.setParameter("nameparam", "Pri");
//	User user = query.getSingleResult();
	
	List<User> users = query.getResultList();
	System.out.println(users);
	
}


public User UserRegistration(User user)
{
	User u1 = new User("Priyanka", "Pridev@gmail", "ssap","9976453718");	
	em.getTransaction().begin();
	
    em.persist(u1);
	
	em.getTransaction().commit();
	return u1;
}

	public void destroy() {
		em.close();
	}
	

}
