import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sprint.entities.Mentor;
import com.sprint.entities.MentorSkills;
import com.sprint.repos.MentorRepository;
import com.sprint.service.MentorService;

public class MentorClient {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		String role=null;
		System.out.println("----------MentorOnDemand ------");
		
		
		

			MentorService ser=new MentorService();
			MentorRepository mentorRepo=new MentorRepository();
			System.out.println("1.Add Mentor \n 2.Remove Mentor 3.View Mentor 4.Update Mentor");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			sc.nextLine();
			switch(ch) {
			case 1:
				System.out.println("Enter name:");
				String name=sc.nextLine();
				System.out.println("Enter email");
				String email=sc.nextLine();
				System.out.println("Enter password");
				String password=sc.nextLine();
				System.out.println("Enter phone no");
				String phoneNo=sc.nextLine();
				System.out.println("Enter the no of course teached");
				int course=sc.nextInt();
				System.out.println("Enter experience");
				int exp=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the skill");
				String skill=sc.nextLine();
				MentorSkills ms=new MentorSkills(skill);
				List<MentorSkills> l=new ArrayList<>();
				l.add(ms);
				Mentor m=new Mentor(name,password,email,phoneNo,exp,course,l);
			
				ser.add(m);
				break;
			
			case 2:
				System.out.println("Enter id of mentor:");
				int mentorid=sc.nextInt();
				mentorRepo.removeMentorById(mentorid);
				break;
				
			case 3:
				System.out.println("Enter id of mentor:");
				int id=sc.nextInt();
				mentorRepo.findMentorById(id);
				break;
			case 4:
				System.out.println("Enter id of mentor:");
				int mentor_id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the new name");
				String mentorName=sc.nextLine();
				mentorRepo.updateMentorName(mentor_id, mentorName);
				break;
				
			}
			
	}
}
