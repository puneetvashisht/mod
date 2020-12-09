package com.sprint.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sprint.entities.Role;
import com.sprint.entities.User;
import com.sprint.service.*;
public class UserRepo {
	
	private  EntityManager em;
	  public UserRepo() {
		EntityManagerFactory emf = Persistence	.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	
	  }
	public  User addUser(User u1,String role) {
		
		em.getTransaction().begin();
		TypedQuery<Role> query = em.createQuery("SELECT r FROM Role r where r.rolename=:role", Role.class);
		query.setParameter("role", role);
		Role r=query.getSingleResult();
		System.out.println(r);
		u1.setRole(r);
		System.out.println(u1);
	    em.persist(u1);
		
		em.getTransaction().commit();
		return u1;
		
	}
	public void updateUserName(int id,String name) {
		em.getTransaction().begin();
		User foundUser = em.find(User.class,id);
		foundUser.setName(name);
		em.getTransaction().commit();
		
	}
	public void updateUserEmail(int id,String email) {
		em.getTransaction().begin();
		User found = em.find(User.class,id);
		found.setEmail(email);
		em.getTransaction().commit();
		
	}
	public void updateUserPhno(int id,String phno) {
		em.getTransaction().begin();
		User found = em.find(User.class,id);
		found.setPhno(phno);
		em.getTransaction().commit();
		
	}
	
	public User removeUserById(int id) {
		em.getTransaction().begin();
		User foundUser = em.find(User.class, id);
		em.remove(foundUser);
		em.getTransaction().commit();
		return foundUser;
		}

public User findUserById(int id)
{
	    User foundUser = em.find(User.class,id);
		System.out.println(foundUser);
		return foundUser;
}
public User findUserByName(String name) {
	TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.name=:nameparam", User.class);
	query.setParameter("nameparam", name);
	User u = query.getSingleResult();
	System.out.println(u);
	return u;
}


public User userRegistration(User u)
{
		
	em.getTransaction().begin();
	
    em.persist(u);
	
	em.getTransaction().commit();
	return u;
}

public  boolean loginUser(String name,String password)
{
   try {	
	TypedQuery<User> query=em.createQuery("select u from User u where u.name=:name",User.class);
	query.setParameter("name",name);
	User exist=query.getSingleResult();
	if(exist.getPassword().equals(password)&& (exist.getName().equals(name)))
		System.out.println("Valid Access");
	return true;
   }
   catch(Exception e) {
	System.out.println("Invalid Access");
	return false;
	}
	
}
	public void destroy() {
		em.close();
	}
	

}
