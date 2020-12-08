package com.cpg.test;
import java.util.List;
import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cpg.entities.Role;
import com.cpg.entities.User;
import com.cpg.repo.UserRepo;
import com.cpg.service.*;
public class TestUser
{
	private EntityManager em;
	UserRepo obj =new UserRepo();
	UserService ser=new UserService();
    
	Role r1=new Role("User");
    Role r2=new Role("Admin");
    Role r3=new Role("Mentor");

	//@Test
	public void testAddUser()
	{
  
		User u=new User("priya","pri@gmail.com","96788","98989",r1);
		ser.add(u);
	}
//@Test 
	public void testFindUserById() {		
	   ser.findUserbyid(36);
	}
//  @Test
    public void testUpdateUserName()
    {
     obj.updateUserName(35,"Prasanna");
}
  // @Test
    public void testFindUserByName()
    {
    	  obj.findUserByName("Logu");
    }
 //@Test
    public void testUpdateUserEmail()
    {
     obj.updateUserEmail(35,"prasanna@gmail.com");
}
  //@Test
    public void testUpdateUserPhno()
    {
     obj.updateUserPhno(35,"9988770066");
}
   @Test
    public void testRemoveUseById()
    {
        ser.removeById(56);   
    }

  //  @Test
    public void testUserRegistration()
    {

		User u=new User("Ani","ani@gmail.com","aniss","97706690",r3);
		ser.register(u);
    }
  // @Test
    public void testLoginUser()
    {
    	ser.validateUser("priyaa","9976");
    }

    
    
}