package com.revature.RCUbackend.controllers;


import com.revature.RCUbackend.services.TransactionService;



import com.revature.RCUbackend.service.*;
import org.junit.Test;
import org.mockito.Mock;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertNotNull;

public class TransactionControllerTest {

    TransactionController transactionController;

    @Mock
    TransactionService transactionService;

    @Mock
    TransactionService t1;

    @Mock
    TransactionService t2;

    @BeforeEach
    void setUp(){

        this.transactionController = new TransactionController(transactionService);

    }

    @Test
    void allTransactionsTest(){
        //transactionController.allTransactions();
    }

    @Test
    void saveTransactionTest(){
        //transactionController.saveTransaction();
    }

    @Test
    void getallTest(){
        assertNotNull(transactionController.getall());
    }

    @Test
    void findByUserTest(){
        //transactionController.findbyUser();
    }

    @Test
    void findByAccountTest(){
        //transactionController.findbyAccount()
    }

    @Test
    void findDepositsTest(){
        //transactionController.findDeposits()
    }

    @Test
    void findWithdrawalsTest(){}

}
