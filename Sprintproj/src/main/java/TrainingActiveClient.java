import java.util.Scanner;

import com.sprint.entities.Mentor;
import com.sprint.entities.TrainingActiveUser;
import com.sprint.entities.User;
import com.sprint.repos.MentorRepository;
import com.sprint.repos.TrainingRepo;
import com.sprint.repos.UserRepo;

public class TrainingActiveClient {
	static Scanner sc=new Scanner(System.in);
	static UserRepo userRepo=new UserRepo();
	static MentorRepository mentorRepo=new MentorRepository() ;
	static TrainingRepo trainingRepo=new TrainingRepo() ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.Assign trainer \n 2.Start Training\n 3.end Training "
				+ " \n 4.Find previous trainings \n 5.find progress \n 6.Add rating");
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		int mentorId,userId,trainingId;
		sc.nextLine();
		switch(ch) {
		case 1:
			System.out.println("Enter training name:");
			String tname=sc.nextLine();
			System.out.println("enter mentor id:");
			mentorId=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter skill title");
			String title=sc.nextLine();
			System.out.println("Eneter user id");
			userId=sc.nextInt();
			
		
			TrainingActiveUser t=new TrainingActiveUser(tname,null,title,null,0,0);
			trainingRepo.assignTrainer(t, mentorId, userId);
			break;
			
		case 2:
			System.out.println("Enter the id of training");
			trainingId=sc.nextInt();
			trainingRepo.startTraining(trainingId);
			break;
		case 3:
			
			System.out.println("Enter the id of training");
			trainingId=sc.nextInt();
			trainingRepo.endTraining(trainingId);
			break;
		case 4:
			System.out.println("Enter mentor id:");
			mentorId=sc.nextInt();
			trainingRepo.findPreviousTraining(mentorId);
			break;
		case 5:
			System.out.println("Enter training name");
			String t_name=sc.nextLine();
			System.out.println("Enter user id:");
			userId=sc.nextInt();
			trainingRepo.findProgress(t_name, userId);
			break;
		case 6:
			System.out.println("Enter training name");
			String tr_name=sc.nextLine();
			System.out.println("Enter user id:");
			userId=sc.nextInt();
			System.out.println("enter rating");
			int rating=sc.nextInt();
			trainingRepo.addRating(tr_name, userId, rating);
			break;
			
		}
	}

}
