//package com.revature.RCUbackend.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.revature.RCUbackend.models.Account;
//import com.revature.RCUbackend.models.Role;
//import com.revature.RCUbackend.models.Transaction;
//import com.revature.RCUbackend.models.User;
//import com.revature.RCUbackend.repositories.RoleRepo;
//import com.revature.RCUbackend.repositories.UserRepo;
//import com.revature.RCUbackend.security.JwtUtils;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.List;
//
//@RunWith(MockitoJUnitRunner.class)
//public class LoginControllerTest {
//
//    private MockMvc mockMvc;
//
//    ObjectMapper objectMapper = new ObjectMapper();
//    ObjectWriter objectWriter = objectMapper.writer();
//
//    @Mock
//    private UserRepo userRepo;
//
//    @Mock
//    private RoleRepo roleRepo;
//
//    @Mock
//    private AuthenticationManager authenticationManager;
//
//    @Mock
//    private PasswordEncoder encoder;
//
//    @Mock
//    private JwtUtils jwtUtils;
//
//    @InjectMocks
//    private LoginController loginController;
//
//    List<Account> accounts;
//    List<Transaction> transactions;
//    Set<Role> h = new HashSet<>();
//    User user1 = new User(1, "user1", "user1pass", "User", "One", "user1@email.com", "999-999-9999", accounts, transactions, h);
//    User user2 = new User(2, "user2", "user2pass", "User", "Two", "user2@email.com", "999-999-9999", accounts, transactions, h);
//    User user3 = new User(3, "user3", "user3pass", "User", "Three", "user3@email.com", "999-999-9999", accounts, transactions, h);
//    User user4 = new User(4, "user4", "user4pass", "User", "Four", "user4@email.com", "999-999-9999", accounts, transactions, h);
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
//    }
//}
