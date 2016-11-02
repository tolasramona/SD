package persistance;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.User;

public class UserDaoTest {

	@Before
	public void setUp() {
		
		
	}
	
	@Test
	public void testAddNEwUser(){
		User user = new User( );
		user.setId(1);
		user.setUsername("user1");
		user.setPassword("pass");
		user.setIsAdmin(false);
		UserDao userDao = new UserDao(new Configuration().configure().buildSessionFactory());
//		userDao.addUser(user);
//		//userDao.deleteUser(user);
//		List<User> users =userDao.findUsers();
//		for (User u:users){
//			System.out.println(u.getUsername()+u.getPassword());
//		}
		user=userDao.findUser("user1");
		System.out.println(user.getPassword());
		
		
	}

}
