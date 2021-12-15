package com.revature.RCUbackend.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.RCUbackend.Application;
import com.revature.RCUbackend.controllers.UserController;
import com.revature.RCUbackend.models.User;
import com.revature.RCUbackend.services.UserService;

import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(classes = Application.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTest {

	@Autowired
	@InjectMocks
	UserController userController;

	@MockBean
	UserService userService;

	private MockMvc mockMvc;

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

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	/*
	 * This method will test if the POST request is successful and the service layer
	 * method is called.
	 */
	void addUserOKTest() throws Exception {

		doNothing().when(userService).addUser(user1); // service layer method returns void

		mockMvc.perform(post("/users/addUser").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(user1))).andExpect(status().isOk());

		verify(userService, times(1)).addUser(user1);
	}

	@Test
	/*
	 * This method will test if the GET request is successful, i.e. all users are
	 * returned, and the service layer method is called.
	 */
	void getAllUsersOKTest() throws Exception {

		List<User> userList = Lists.list(user1, user2);

		when(userService.getAllUsers()).thenReturn(userList);

		mockMvc.perform(get("/users/find")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.*", isA(List.class)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("username1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].username").value("username2"));

		verify(userService, times(1)).getAllUsers();
	}

	@Test
	/*
	 * This method will test if the GET request is successful, i.e. all user with
	 * the specified id is returned, and the service layer method is called.
	 */
	void getUserOKTest() throws Exception {
		when(userService.getUser(1)).thenReturn(user1);

		mockMvc.perform(get("/users/find/1")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.username").value("username1"));

		verify(userService, times(1)).getUser(1);
	}
}
