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
import com.sprint.entities.MentorSkills;
import com.sprint.repos.MentorRepository;
import com.sprint.repos.MentorSkillsRepo;

import org.junit.Test;

public class TestSkill {
private EntityManager em;
	
MentorSkillsRepo mentorskillsRepo=new MentorSkillsRepo() ;
	
	@Before
	public void setUp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	}
	@Test
	public void testAddMentorSkills() {
		MentorSkills ms1 = new MentorSkills("java full stack");
		MentorSkills ms2 = new MentorSkills("React js");
		MentorSkills ms3 = new MentorSkills(".Net framework");
		MentorSkills ms4 = new MentorSkills("unix");
		mentorskillsRepo.addMentor(ms1);
		mentorskillsRepo.addMentor(ms2);
		mentorskillsRepo.addMentor(ms3);
		mentorskillsRepo.addMentor(ms4);
		}

	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	

}
