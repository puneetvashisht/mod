package com.sprint;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.sprint.entities.Mentor;
import com.sprint.entities.MentorSkills;
import com.sprint.repos.MentorRepository;

public class TestMentor {

	private EntityManager em;
	
	MentorRepository mentorRepo=new MentorRepository() ;
	
	@Before
	public void setUp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	}
	
	//@Test
	public void testAddMentor() {



		
		List<MentorSkills> skills=new ArrayList<>();

		
		MentorSkills ms1 = new MentorSkills("java full stack");
		MentorSkills ms2 = new MentorSkills("React js");
//		MentorSkills ms3 = new MentorSkills(".Net framework");
//		MentorSkills ms4 = new MentorSkills("unix");
		
		skills.add(ms1);skills.add(ms2);
//		skills.add(ms3);skills.add(ms4);
		
		Mentor m2 = new Mentor("manish","rai","manishrai@gmail.com",1234567890,5, 29,skills);
		
		mentorRepo.addMentor(m2);


		
	}


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