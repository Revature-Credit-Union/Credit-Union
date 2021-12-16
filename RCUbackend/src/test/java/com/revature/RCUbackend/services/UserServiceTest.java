package com.revature.RCUbackend.services;

import com.revature.RCUbackend.Application;
import com.revature.RCUbackend.models.User;
import com.revature.RCUbackend.repositories.UserRepo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = Application.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@MockBean
	private UserRepo userRepo;

	// Sample users for test
	static User user1;
	static User user2;

	@BeforeAll
	static void setUpBeforeAll() {

		user1 = new User(1, "username1", "password1", "Fname1", "LastName1", "test@email.com", "1234567890", null, null,
				null);
		user2 = new User(2, "username2", "password2", "Fname2", "LastName2", "test2@email.com", "2234567890", null,
				null, null);
	}

	@Test
	/* Test to make sure that the repo layer is called */
	void addUserTest() {
		// repo layer method returns the object saved
		when(userRepo.save(user1)).thenReturn(user1); 
		userService.addUser(user1);
		verify(userRepo, times(1)).save(user1);
	}

	@Test
	/* Should get all users when method is called */
	public void getAllUsersTest() {
		
		List<User> userList = Lists.list(user1, user2);
		
		when(userRepo.findAll()).thenReturn(userList);
		assertEquals(userService.getAllUsers(), userList);
	}

	@Test
	/*Test to return user if user id is in database*/
	public void getUserFoundTest() {
		when(userRepo.findById(1)).thenReturn(Optional.of(user1));
		assertEquals(userService.getUser(1), user1);
	}

	@Test
	/*Test to return null if user id not in database*/
	public void getUserNotFoundTest() {
		when(userRepo.findById(3)).thenReturn(Optional.empty());
		assertEquals(userService.getUser(3), null);
	}
	
	@Test
	/* Test to make sure that the repo layer is called when updating */
	void updateUserTest() {
		
		when(userRepo.save(user1)).thenReturn(user1);
		userService.updateUser(user1);
		verify(userRepo, times(1)).save(user1);
	}
	
	@Test
	/* Test to make sure that the repo layer is called when deleting */
	void deleteUserTest() {
		
		doNothing().when(userRepo).delete(user1);
		userService.deleteUser(user1);
		verify(userRepo, times(1)).delete(user1);
	}
}
