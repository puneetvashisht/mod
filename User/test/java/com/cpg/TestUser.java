package com.cpg;
import java.util.List;
import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TestUser
{
	private EntityManager em;
	UserRepo obj =new UserRepo();

	

	@Test
	public void addUser()
	{
		User user = new User();
		obj.addUser(null);
	}
//@Test 
	public void findUserById() {		
	   obj.FindUserById();
	}
  //  @Test
    public void UpdateUserName()
    {
     User user=new User();
     obj.UpdateUserName();
}
   // @Test
    public void FindUserByName()
    {
    	  obj.FindUserByName();
    }
 //@Test
    public void UpdateUserEmail()
    {
     User user=new User();
     obj.UpdateUserEmail();
}
 //   @Test
    public void UpdateUserPhno()
    {
     User user=new User();
     obj.UpdateUserPhno();
}
  // @Test
    public void removeUseById()
    {

        User user=new User();
        obj.removeUserById();   
    }

   // @Test
    public void UserRegistration()
    {
    	User use=new User();
    	obj.UserRegistration(null);
    }

    
    
}