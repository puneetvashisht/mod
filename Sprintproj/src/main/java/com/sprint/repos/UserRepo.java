package com.sprint.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.sprint.entities.User;
public class UserRepo {
	
	private EntityManager em;
	  public UserRepo() {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test");
	
//		Create EntityManager
		em = emf.createEntityManager();
	
	  }
	public void addUser(){
		User u1 = new User("Pri", "P@gmail", "at", "1230","Admin");	
		//em.persist
		em.getTransaction().begin();
		
	    em.persist(u1);
		
		em.getTransaction().commit();
		
	}
	public void UpdateUserName() {
		em.getTransaction().begin();
		User foundUser = em.find(User.class,32);
		foundUser.setName("arun");
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
		User foundUser = em.find(User.class, 30);
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
	User u1 = new User("Priyanka", "Pridev@gmail", "ssap","9976453718","User");	
	em.getTransaction().begin();
	
    em.persist(u1);
	
	em.getTransaction().commit();
	return u1;
}
public void login(String username, String password)
{
   try{
        EntityTransaction entr=em.getTransaction();
        entr.begin();

       TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name =:name AND u.password =:pass", User.class);        
       query.setParameter("name", username);
       query.setParameter("pass", password); 
       
        User u = query.getSingleResult();
        System.out.println("login successful");
        
    }catch(javax.persistence.NoResultException e){
    	System.out.println("login failed");
    }

}


	public void destroy() {
		em.close();
	}

}
