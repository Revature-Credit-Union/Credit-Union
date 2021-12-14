package com.revature.RCUbackend.services;

import static org.assertj.core.api.Assertions.*;

import com.revature.RCUbackend.models.User;
import com.revature.RCUbackend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;
    
    @Test
    public void testGetAllUsers() {
    	Mockito.when(userRepo.findAll()).thenReturn(new ArrayList<User>());
    	List<User> testList = userService.getAllUsers();
    	assertThat(testList).isNotNull();
    }
    
    @Test
    public void testGetUser() {
    	Optional<User> testOptional = Optional.of(new User());
    	Mockito.when(userRepo.findById(Mockito.anyInt())).thenReturn(testOptional);
    	User testUser = userService.getUser(Mockito.anyInt());
    	assertThat(testUser).isNotNull();
    }
    
    @Test
    public void testFindByEmail() {
    	Optional<User> testOptional = Optional.of(new User());
    	Mockito.when(userRepo.findByEmail(Mockito.anyString())).thenReturn(testOptional);
    	User testUser = userService.findByEmail(Mockito.anyString()).get();
    	assertThat(testUser).isNotNull();
    }
    
    @Test
    public void testFindByUsername() {
    	Optional<User> testOptional = Optional.of(new User());
    	Mockito.when(userRepo.findByUsername(Mockito.anyString())).thenReturn(testOptional);
    	User testUser = userService.findByUsername(Mockito.anyString()).get();
    	assertThat(testUser).isNotNull();
    }
}
