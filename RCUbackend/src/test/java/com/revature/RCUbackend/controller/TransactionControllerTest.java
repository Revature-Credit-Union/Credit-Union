package com.revature.RCUbackend.controller;


import com.revature.RCUbackend.controllers.TransactionController;
import com.revature.RCUbackend.services.TransactionService;



//import com.revature.RCUbackend.services.*;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
