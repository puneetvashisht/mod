package projectsprint1;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	@Entity
	public class Mentor_User {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		 int Mentor_id;
		 String Mentor_name;
		 String Email;
		 String Password;
		 long Mentor_phone;
		 int Skill_id;
		 String Skill_title;
		 int Experience;
		 int No_of_courses_taught;
		 
		public Mentor_User() {
			//super();
		}
		
			
		public Mentor_User(String mentor_name, String email, String password, long mentor_phone, int skill_id,
				String skill_title, int experience, int no_of_courses_taught) {
			super();
			Mentor_name = mentor_name;
			Email = email;
			Password = password;
			Mentor_phone = mentor_phone;
			Skill_id = skill_id;
			Skill_title = skill_title;
			Experience = experience;
			No_of_courses_taught = no_of_courses_taught;
		}



		public String getMentor_name() {
			return Mentor_name;
		}
		public void setMentor_name(String mentor_name) {
			Mentor_name = mentor_name;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public long getMentor_phone() {
			return Mentor_phone;
		}
		public void setMentor_phone(long mentor_phone) {
			Mentor_phone = mentor_phone;
		}
		public int getSkill_id() {
			return Skill_id;
		}
		public void setSkill_id(int skill_id) {
			Skill_id = skill_id;
		}
		public String getSkill_title() {
			return Skill_title;
		}
		public void setSkill_title(String skill_title) {
			Skill_title = skill_title;
		}
		public int getExperience() {
			return Experience;
		}
		public void setExperience(int experience) {
			Experience = experience;
		}
		public int getNo_of_courses_taught() {
			return No_of_courses_taught;
		}
		public void setNo_of_courses_taught(int no_of_courses_taught) {
			No_of_courses_taught = no_of_courses_taught;
		}
//		@Override
//		public String toString() {
//			return "Mentor_User [Mentor_id=" + Mentor_id + ", Mentor_name=" + Mentor_name + ", email=" + Email
//					+ ", password=" + Password + ", mentor_phone=" + Mentor_phone + ", Skill_id=" + Skill_id
//					+ ", Skill_title=" + Skill_title + ", experience=" + Experience + ", No_of_courses_taught="
//					+ No_of_courses_taught + "]";
//		}
	//	
	//	
		
		
	}


