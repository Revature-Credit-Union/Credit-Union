package com.revature.RCUbackend.controller;

import com.revature.RCUbackend.controllers.AccountController;
import com.revature.RCUbackend.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class AccountControllerTest {
    AccountController accountController;

    @Mock
    AccountService accountService;

    @BeforeEach
    void setUp(){
        this.accountController = new AccountController(accountService);
    }

    @Test
    void depositTest(){}

    @Test
    void withdrawTest(){}

    @Test
    void transferTest(){}

}
