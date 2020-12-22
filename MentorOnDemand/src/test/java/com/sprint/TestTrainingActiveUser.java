package com.sprint;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.xml.bind.ValidationException;

import org.junit.Before;
import org.junit.Test;

import com.sprint.entities.Mentor;
import com.sprint.entities.TrainingActiveUser;
import com.sprint.entities.User;
import com.sprint.repos.TrainingRepo;

public class TestTrainingActiveUser {

	
private EntityManager em;
	
	TrainingRepo trainingRepo=new TrainingRepo() ;
	
	@Before
	public void setUp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	}
	
//	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//@Test
	public void testAssignTrainer() {
		
		TrainingActiveUser ta=new TrainingActiveUser("angular_basic",null,"angular",null,0,0);
		assertTrue(trainingRepo.assignTrainer(ta,2,11));
	}
//	@Test(expected=NullPointerException.class)
	public void testStartTraining(){
		assertTrue(trainingRepo.startTraining(12));
	}
	
//	@Test(expected=NullPointerException.class)
	public void testEndTraining() {
		assertTrue("training id not found",trainingRepo.endTraining(14));
		
	}
	
	//@Test
	public void testWrongIdEndTraining() {
		assertFalse("Training id found",trainingRepo.endTraining(14));
	}
//	@Test()
	public void testPreviousTraining() {
		trainingRepo.findPreviousTraining(2);
	}
	
//	@Test(expected=NoResultException.class)
	public void testAddRating() {
		assertTrue(trainingRepo.addRating("angular", 41, 5));
	}
	
//  @Test
	public void testProgress() {
		trainingRepo.updateProgress(50, 2, "angular");
	}
	
//	@Test
	public void testFindProgress() {
		trainingRepo.findProgress("angular",1);
	}
	
	
}
