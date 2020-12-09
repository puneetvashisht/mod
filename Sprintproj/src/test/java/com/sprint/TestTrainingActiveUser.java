package com.sprint;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
//	@Test
	public void testAssignTrainer() {
		
		TrainingActiveUser ta=new TrainingActiveUser("angular_basic",null,"angular",null,0,0);
		trainingRepo.assignTrainer(ta,2,11);
	}
//	@Test
	public void testStartTraining() {
		trainingRepo.startTraining(7);
	}
	
//	@Test
	public void testEndTraining() {
		trainingRepo.endTraining(7);
	}
	
//	@Test
	public void testPreviousTraining() {
		trainingRepo.findPreviousTraining(2);
	}
	
//	@Test
	public void testAddRating() {
		trainingRepo.addRating("angular", 1, 5);
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
