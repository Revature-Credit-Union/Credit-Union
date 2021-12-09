package com.revature.RCUbackend.controller;


import com.revature.RCUbackend.service.*;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;

public class TransactionControllerTest {

    TransactionController transactionController;

    @Mock
    TransactionService transactionService;

    @BeforeEach
    void setUp(){
        this.transactionController = new TransactionController(transactionService);
    }

    @Test
    void allTransactionsTest(){
        transactionController.allTransactions();
    }

    @Test
    void saveTransactionTest(){
        transactionController.saveTransaction();
    }

    @Test
    void getallTest(){
        transactionController.getall();
    }

    @Test
    void findByUserTest(){
        transactionController.findbyUser();
    }

    @Test
    void findByAccountTest(){
        transactionController.findbyAccount()
    }

    @Test
    void findDepositsTest(){
        transactionController.findDeposits()
    }

    @Test
    void findWithdrawalsTest(){}

}
