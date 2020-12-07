import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.sprint.Mentor;
import com.sprint.MentorRepository;

public class TestMentor {

	private EntityManager em;
	
	MentorRepository mentorRepo=new MentorRepository() ;
	
	@Before
	public void setUp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    em = emf.createEntityManager();
	}
	
	@Test
	public void AddMentor() {
		Mentor mentor = new Mentor();
		mentorRepo.AddMentor();	}

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