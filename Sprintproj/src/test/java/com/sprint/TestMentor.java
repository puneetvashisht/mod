package com.sprint;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.sprint.entities.Mentor;
import com.sprint.repos.MentorRepository;

public class TestMentor {

	private EntityManager em;
	
	MentorRepository mentorRepo=new MentorRepository() ;
	
	@Before
	public void setUp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	}
	
	@Test
	public void testAddMentor() {
//		Mentor mentor = new Mentor();
		Mentor m = new Mentor("gaja","lakshmi","gajalakshmi@gmail.com",857569373,
				 3, 27);
		mentorRepo.addMentor(m);	}

//@Test
public void removeMentorById() {
   	
	Mentor mentor = new Mentor();
	mentorRepo.removeMentorById();
   }

//@Test
public void UpdateMentorById() {
 	
	Mentor mentor = new Mentor();
	mentorRepo.UpdateMentorById();
 }

//@Test
public void testFindUserByName() {
	Mentor mentor = new Mentor();
	mentorRepo.testFindUserByName();
	
}

}