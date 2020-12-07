package projectsprint1;
	import static org.junit.Assert.*;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;

	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.Test;

	import projectsprint1.Mentor_Repo;
	import projectsprint1.Mentor_User;

	public class TestMentor {

			private EntityManager em;
			Mentor_Repo mentor = new Mentor_Repo();
			
			@Before
			public void setup() {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
				em = emf.createEntityManager();
			}

			@Test
			public void addMentor() {
				Mentor_User user = new Mentor_User();
				mentor.addMentor();
				}
			

		//	@Test
			public void removeMentorById() {
				Mentor_User user = new Mentor_User();
				mentor.removeMentorById();
				}
		//	@Test
			public void updateMentorById() {
				Mentor_User user = new Mentor_User();
				mentor.updateMentorById();
				}
			@Test
			public void testFindUserByName() {
				Mentor_User user = new Mentor_User();
				mentor.testFindUserByName();
				}
			@After
			public void destroy() {
				em.close();
			}
		

	

}
