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
		Mentor foundMentor = em.find(Mentor.class,2);
		User foundUser=em.find(User.class,1);
		TrainingActiveUser ta=new TrainingActiveUser("priyank",foundMentor,"angular",foundUser,null,null,0,0);
		trainingRepo.assignTrainer(ta);
	}
//	@Test
	public void testStartTraining() {
		trainingRepo.startTraining();
	}
	
//	@Test
	public void testEndTraining() {
		trainingRepo.endTraining();
	}
	
//	@Test
	public void testPreviousTraining() {
		trainingRepo.endTraining();
	}
}
