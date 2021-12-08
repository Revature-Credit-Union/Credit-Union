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
    void allTransactionsTest(){}

    @Test
    void saveTransactionTest(){}

    @Test
    void getallTest(){}

    @Test
    void findByUserTest(){}

    @Test
    void findByAccountTest(){}

    @Test
    void findDepositsTest(){}

    @Test
    void findWithdrawalsTest(){}

}
