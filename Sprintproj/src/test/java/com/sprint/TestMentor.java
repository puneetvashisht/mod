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
		Mentor m1 = new Mentor("krishna","krish","krishnaka@gmail.com",988282978,
				 5, 29);
		Mentor m2 = new Mentor("Ganesh","Prabhu","Prabhuganesh@gmail.com",92451718,
				 9, 30);
		Mentor m3 = new Mentor("punnet","sighn","punnet356@gmail.com",988892998,
				 6, 24);
		Mentor m4 = new Mentor("smita","krish","smitaraj@gmail.com",839298798,
				 3, 27);
		mentorRepo.addMentor(m1);
		mentorRepo.addMentor(m2);
		mentorRepo.addMentor(m3);
		mentorRepo.addMentor(m4);}

//@Test
public void removeMentorById() {
   	Mentor foundMentor = em.find(Mentor.class, 6);
	mentorRepo.removeMentorById( foundMentor);
   }

//@Test
public void UpdateMentorById() {
   	Mentor foundMentor = em.find(Mentor.class, 5);
   	foundMentor.setMentor_Name("arun");
   	mentorRepo.UpdateMentorById( foundMentor);
 }

//@Test
public void testFindUserByName() {
 
	mentorRepo.testFindUserByName();
	
}

}