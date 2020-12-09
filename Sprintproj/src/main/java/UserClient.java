
import java.util.Scanner;
import com.sprint.entities.User;
import com.sprint.exception.InvalidInputDataException;
import com.sprint.repos.UserRepo;
import com.sprint.service.UserService;

public class UserClient {


	public static void main(String[] args) throws InvalidInputDataException {

		UserRepo objrepo = new UserRepo();
		UserService ser=new UserService();

		Scanner inp= new Scanner(System.in);
		System.out.println("1).Add User \n2).Login User \n3).Update User Name \n4).Update User Email \n5).Update User phno \n5).Delete UserById \n6).Find UserById \n7).Find UserById \n8).Exit");
		int value = inp.nextInt();
		inp.nextLine();
		switch (value) {
		case 1:
			System.out.println("Enter your Name:");
			String name = inp.nextLine();
			System.out.println("Enter your email:");
			String email = inp.nextLine();
			System.out.println("Enter your password:");
			String password = inp.nextLine();
			System.out.println("Enter your Phone Number:");
			String phno = inp.nextLine();
			User userobj = new User(name,email, password, phno);
			ser.add(userobj, "User");
			break;

		case 2:
			System.out.println("Enter your Email:");
			String email1 = inp.nextLine();
			
			System.out.println("Enter your Password");
			String password1 = inp.nextLine();
			
			objrepo.loginUser(email1, password1);
			break;
		case 3:
			System.out.println("Enter new Name you want to update");
			String st = inp.nextLine();
			
			objrepo.updateUserName(67,st);
			break;
		case 4:
			System.out.println("Enter new Email you want to update");
			String newemail= inp.nextLine();
			
			objrepo.updateUserEmail(67,newemail);
			break;
		case 5:
			System.out.println("Enter new Phone  number you want to update");
			String newphno= inp.nextLine();
			
			objrepo.updateUserEmail(67,newphno);
			break;
		case 6:
			System.out.println("Enter the user id to be deleted");
			int id = inp.nextInt();
			
			objrepo.removeUserById(id);
			break;
		case 7:
			System.out.println("Enter the user id to be Found");
			int id1 = inp.nextInt();
			
			objrepo.findUserById(id1);
			break;
		case 8:
			System.out.println("Enter the user name to be Found");
			String fname= inp.nextLine();
			
			objrepo.findUserByName(fname);
			break;
		case 9:
			System.exit(0);

		default:
			break;
		}
	}
}
