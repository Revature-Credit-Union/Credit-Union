package com.revature.RCUbackend.controller;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.repository.AccountRepository;
import com.revature.RCUbackend.service.*;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccountControllerTest {
    AccountController accountController;

    @Mock
    AccountRepository accountRepository;

    @Mock
    AccountService accountService;

    @Mock
    Account testUser1;

    @Mock
    Account testUser2;

    @BeforeEach
    void setUp(){
        this.accountService = new AccountService(accountRepository);
        this.accountController = new AccountController(accountService);
        testUser1.setBalance(200);
        testUser2.setBalance(200);
    }

    @Test
    void depositTest(){
        int newAmount = testUser1.getBalance() + 200;
        accountController.deposit(200, testUser1);
        assertEquals(testUser1.getBalance(), newAmount);
    }

    @Test
    void withdrawTest(){
        int newAmount = testUser1.getBalance() - 200;
        accountController.withdraw(200, testUser1);
        assertEquals(testUser1.getBalance(), newAmount);
    }

    @Test
    void transferTest(){
        int newAmount1 = testUser1.getBalance() - 200;
        int newAmount2 = testUser2.getBalance() + 200;
        accountController.transfer(200, testUser1, testUser2);
        assertEquals(testUser1.getBalance(), newAmount1);
        assertEquals(testUser2.getBalance(), newAmount2);
    }

    @Test
    void findAllTest(){
        assertNotNull(accountController.findAll());
    }

}
