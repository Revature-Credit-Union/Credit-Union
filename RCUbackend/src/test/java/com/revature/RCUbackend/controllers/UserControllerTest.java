package com.revature.RCUbackend.controller;

import com.revature.RCUbackend.controllers.UserController;
import com.revature.RCUbackend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

public class UserControllerTest {

    UserController userController;

    @Mock
    UserService userService;

    @BeforeEach
    void setUp(){
        //this.userController = new UserController(userService);
    }
}